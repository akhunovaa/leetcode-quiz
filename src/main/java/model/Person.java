package model;

import java.time.LocalDate;
import java.util.Objects;

public class Person {

//    private final PersonId personId;
//    private final EventLog changeLog;
//
//    private PersonName name;
//    private LocalDate birthDate;
//    private StreetAddress address;
//    private EmailAddress email;
//    private PhoneNumber phoneNumber;
//
//    public Person(PersonId personId, PersonName name) {
//        this.personId = Objects.requireNonNull(personId);
//        this.changeLog = new EventLog();
//        changeName(name, "initial name");
//    }
//
//    public void changeName(PersonName name, String reason) {
//        Objects.requireNonNull(name);
//        this.name = name;
//        this.changeLog.register(new NameChangeEvent(name), reason);
//    }
//
//    public Stream<PersonName> getNameHistory() {
//        return this.changeLog.eventsOfType(NameChangeEvent.class).map(NameChangeEvent::getNewName);
//    }
//
//    // Other getters omitted
//
//    public boolean equals(Object o) {
//        if (o == this) {
//            return true;
//        }
//        if (o == null || o.getClass() != getClass()) {
//            return false;
//        }
//        return personId.equals(((Person) o).personId);
//    }
//
//    public int hashCode() {
//        return personId.hashCode();
//    }
}
