package event_not_saving

// saving this class triggers the first postupdateevent
class ClassA {

    Date someDate

    static constraints = {
        someDate nullable: true
    }
}
