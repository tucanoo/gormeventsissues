package event_not_saving

class ClassB {

    Date someDate

    String state = "NOT_PROCESSED"

    static hasMany = [classCs: ClassC]

    static constraints = {
        someDate nullable: true
    }
}
