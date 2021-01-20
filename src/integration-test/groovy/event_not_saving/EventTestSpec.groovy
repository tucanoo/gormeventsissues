package event_not_saving

import grails.gorm.transactions.Transactional
import grails.testing.mixin.integration.Integration
import groovy.util.logging.Slf4j
import spock.lang.Specification

@Slf4j
@Integration
class EventTestSpec extends Specification{

    @Transactional
    def setup() {
        log.debug "setting test data"
        ClassB classB = new ClassB().save()
        ClassC classC = new ClassC(classB: classB).save()
        ClassA classA = new ClassA().save(flush:true)
    }

    @Transactional
    def "saving the event doesn't commit"() {
        when: "we update Class A"
            ClassA classA = ClassA.first()
            classA.someDate = new Date()
            classA.save(flush:true) // without flush:true,  then the PostUpdateEvent is NOT fired
        then: "class B is eventually updated"
            ClassB.first().refresh().state == 'PROCESSED'
    }
}
