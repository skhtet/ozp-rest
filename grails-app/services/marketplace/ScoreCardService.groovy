package marketplace

import org.springframework.transaction.annotation.Transactional
import static org.codehaus.groovy.grails.commons.ConfigurationHolder.config

class ScoreCardService {

    def accountService
    def profileService
    def serviceItemActivityInternalService

    // Score Card Question Section

    @Transactional(readOnly=true)
    def getScorecard(id){
        return Scorecard.get(id)
    }

    @Transactional(readOnly=false)
    def saveScoreCardQuestion(Scorecard scoreCardQuestion){
        try {
            log.info "${scoreCardQuestion.createdDate}"
            scoreCardQuestion.save(failOnError: true)
        } catch (Exception e) {
            log.error "Error saving scorecard question with id " + scoreCardQuestion.id + ": " + e
            throw new Exception(e)
        }
    }

    // Delete an existing ScoreCardQuestion
    @Transactional(readOnly=false)
    def deleteScoreCardQuestion(Scorecard scoreCardQuestion){
        try {
            scoreCardQuestion.delete(failOnError: true)
        } catch (Exception e){
            log.error "Error deleting scoreCardItem with id " + scoreCardQuestion.id + ": " + e
            throw e
        }
    }
}
