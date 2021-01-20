package event_not_saving

import grails.events.annotation.gorm.Listener
import grails.gorm.transactions.Transactional
import groovy.util.logging.Slf4j
import org.grails.datastore.mapping.engine.event.PostUpdateEvent

@Slf4j
@Transactional
class ClassCEventHandlerService {

    @Listener(ClassC)
    def ClassCPostUpdate(PostUpdateEvent event) {
        log.debug "ClassCPostUpdate Fired"

        ClassC classCInstance = event.entityObject

        // assume we've done processing based on the Class C data.

        // now we want to update Class B
        classCInstance.classB.state = "PROCESSED"
        classCInstance.classB.save(flush:true)

    }
}
