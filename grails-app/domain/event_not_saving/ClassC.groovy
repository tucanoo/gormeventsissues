package event_not_saving

class ClassC {

    Date someDate

    static belongsTo = [classB:ClassB]

    static constraints = {
        someDate nullable: true
    }
}
