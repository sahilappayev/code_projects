package org.example;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.example.dao.PersonDAO;
import org.example.domain.Person;

public class Main {

    public static void main(String[] args) {


        // Driver, Connection, Statement, PreparedStatement, CallableStatement


        PersonDAO personDAO = new PersonDAO();
        List<Person> personList = personDAO.findAll();

//        personList.forEach(System.out::println);


        Person person = personDAO.findById(8).orElseThrow(() -> new RuntimeException("Person not found!"));
        System.out.println(person);

        person.setName("Kamran");
        person.setSurname("Movsumov");
        person.setCreatedAt(new Date());

        Person updated = personDAO.update(8, person);

        System.out.println(updated);

//        if (personOptional.isPresent()) {
//            Person person = personOptional.get();
//            System.out.println(person);
//        }
    }

}
