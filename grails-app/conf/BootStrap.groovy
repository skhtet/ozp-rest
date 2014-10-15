import grails.converters.JSON
import grails.util.*

import marketplace.*
import marketplace.rest.ItemCommentServiceItemDto
import marketplace.rest.ApplicationDto
import org.apache.log4j.helpers.*
import org.apache.log4j.xml.*
import com.fasterxml.jackson.databind.SerializationFeature
import org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes
import org.springframework.context.ApplicationContext

class BootStrap {
    def profileRestService
    def grailsApplication
    def sessionFactory
    def objectMapper

    def init = { servletContext ->

        // setting it to a million clauses by default
        // http://stackoverflow.com/questions/1534789/help-needed-figuring-out-reason-for-maxclausecount-is-set-to-1024-error
        org.apache.lucene.search.BooleanQuery.setMaxClauseCount(10 ** 6);

        ApplicationContext apc = servletContext.getAttribute(GrailsApplicationAttributes.APPLICATION_CONTEXT)

        if (GrailsUtil.environment == 'production') {
            def log4jConfigure
            URL url = Loader.getResource('mp-override-log4j.xml')
            String fileName = url.toString()
            if (fileName.startsWith('file:/')) {

                File file;
                try {
                    file = new File(url.toURI());
                } catch (URISyntaxException e) {
                    file = new File(url.getPath());
                }

                //if the file does not exist -- this really shouldn't happen
                //set url to null thus causing the default log4j file to be loaded
                if (!file.exists()) {
                    url = null
                }
                log4jConfigure = {
                    def watchTime = apc?.getBean('OzoneConfiguration')?.getLog4jWatchTime();
                    println "########## Found mp-override-log4j.xml at: ${file.getAbsolutePath()} ${watchTime}"
                    DOMConfigurator.configureAndWatch(file.getAbsolutePath(), watchTime ? watchTime : 180000)
                }
            } else
                url = null
            if (!url) {
                url = Loader.getResource('mp-log4j.xml')
                log4jConfigure = {
                    println "########## Found mp-log4j.xml at: ${url.toString()}"
                    DOMConfigurator.configure(url)
                }
            }
            if (url) {

                try {
                    log4jConfigure()
                } catch (Throwable t) {
                    println "########## ${t.getMessage()}"
                }
            }
        }

        profileRestService.createRequired()

		log.info "BootStrap init; GrailsUtil.environment: ${GrailsUtil.environment}"
        if (GrailsUtil.environment == "test" || GrailsUtil.environment.startsWith('with_')) {
			def username = System.properties.user ?: "testUser1"
			//Create the user for integration tests since no one will physically log in
			new Profile(username:username).save()
		}

        [ApplicationLibraryEntry].each { Class ->
            JSON.registerObjectMarshaller(Class, { it.asJSON() })
        }

        configureJackson()
    }

    private void configureJackson() {
        //use ISO-8601 date format
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    def destroy = { servletContext ->
        log.info "Bootstrap destroy"
        ApplicationContext apc = servletContext?.getAttribute(GrailsApplicationAttributes.APPLICATION_CONTEXT)
        def quartzScheduler = apc?.getBean('quartzScheduler')
        quartzScheduler?.shutdown()
    }
}
