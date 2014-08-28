package marketplace

import org.apache.commons.lang.exception.ExceptionUtils
import org.hibernate.FlushMode
import org.springframework.transaction.annotation.Transactional

import ozone.marketplace.domain.ValidationException

class ImportTaskService {

    def transactional = false
    def sessionFactory
    def importService;

    /**
     * There are three cases to consider:
     * 1. State with no listing associated with it. Just delete it
     * 2. State with active listing associated with it. Throw error, don't delete it
     * 3. State with soft deleted listing associated with it. Throw error, don't delete it
     */
    @Transactional(readOnly = true)
    def getLatestSuccessfulImportTaskResult(def importTaskId) {
        ImportTask task
        ImportTaskResult result
        try {
            task = ImportTask.get(importTaskId)
            if (!task) {
                throw new ValidationException(message: "ImportTask Not Found", args: [importTaskId])
            }
            // Trying the criteria method for performance?
            def criteria = ImportTaskResult.createCriteria()
            def results = criteria {
                and {
                    eq('task', task)
                    eq('result', true)
                }
                order('runDate', 'desc')
                order('id', 'desc') // secondary sort order in case sorting by date is inconclusive
            }

            /* Alternative approach
            def results = ImportTaskResult.findAllByTaskAndResult(task, true, [sort:"runDate", order:"desc"])
            */

            if (results?.size() > 0) {
                // Pull off just the top result, will be the latest based on the sort
                result = results[0]
            } else {
                log.debug "No ImportTaskResults found for ImportTask $importTaskId"
            }
        }
        catch (ValidationException ve) {
            throw ve
        }
        catch (Exception e) {
            String message = "Error retrieving last successful import result for ImportTask $importTaskId:: "
            message += ExceptionUtils.getRootCauseMessage(e)
            log.error message

            // Need this to prevent flush exception. See http://jira.codehaus.org/browse/GRAILS-5865
            def session = sessionFactory.currentSession
            session.setFlushMode(FlushMode.MANUAL)

            throw new ValidationException(message)
        }

        return result
    }

    @Transactional
    def save(ImportTask importTask, def originalName = null) {
        if (importTask) {
            log.debug "Saving ImportTask [$importTask.id]"
            importTask.save()
        }
        return importTask
    }


    @Transactional
    def delete(ImportTask importTask) {
        if (importTask) {
            log.debug "Deleting ImportTask [$importTask.id]"
            importService.unscheduleTask(importTask)
            importTask.delete()
        }
    }

    @Transactional
    def delete(ImportTaskResult importTaskResult) {
        if (importTaskResult) {
            log.debug "Deleting ImportTaskResult [$importTaskResult.id]"
            importTaskResult.delete()
        }
    }

    @Transactional(readOnly = true)
    def getFileImportTask() {
        return ImportTask.findByName(Constants.FILE_BASED_IMPORT_TASK)
    }


    @Transactional
    def deleteFileImportResultsSince(Date cutoff) {
        deleteImportResultsSince(cutoff, getFileImportTask()?.id)
    }

    @Transactional
    def deleteScheduledImportResultsSince(Date cutoff, Long importTaskId = null) {
        deleteImportResultsSince(cutoff, importTaskId)
    }

    @Transactional
    def deleteImportResultsSince(Date cutoff, Long importTaskId = null) {
        log.debug "Deleting ImportTaskResults for ImportTask [$importTaskId] since [$cutoff]"
        def issues = []
        def c = ImportTaskResult.createCriteria()
        def results = c.list {
            lt("runDate", cutoff)
            if (importTaskId) {
                eq("task", ImportTask.get(importTaskId))
            }
        }

        while (results.size()) {
            try {
                if (results[0]?.task?.lastRunResult?.id != results[0]?.id) {
                    delete(results[0])
                }
                results.remove(0)
            } catch (e) {
                issues << e
            }
        }
        return issues
    }

}
