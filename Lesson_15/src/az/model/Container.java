package az.model;

import az.domain.Person;
import az.domain.User;
import az.annotations.Autowired;

public class Container {

    @Autowired
    private User user;

    private Person person;


    public User getUser() {
        return user;
    }

    public Person getPerson() {
        return person;
    }

    @Autowired
    public void setPerson(Person person) {
        this.person = person;
    }
}
