package event_not_saving

import grails.events.annotation.gorm.Listener
import grails.gorm.transactions.Transactional
import groovy.util.logging.Slf4j
import org.grails.datastore.mapping.engine.event.PostUpdateEvent

@Slf4j
@Transactional
class ClassAEventHandlerService {

    @Listener(ClassA)
    def ClassAPostUpdate(PostUpdateEvent event) {
        log.debug "ClassAPostUpdate Fired"

        log.debug "Getting and updating Class C"

        ClassC classC = ClassC.first()
        classC.someDate = new Date()
        classC.save()

    }
}
