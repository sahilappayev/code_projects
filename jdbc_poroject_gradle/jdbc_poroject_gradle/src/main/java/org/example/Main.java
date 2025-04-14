package org.example;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.example.dao.PersonDAO;
import org.example.domain.Person;

public class Main {

    public static void main(String[] args) {


        // Driver, Connection, Statement, PreparedStatement, CallableStatement


        PersonDAO personDAO = new PersonDAO();
//        List<Person> personList = personDAO.findAll();

//        personList.sort(Comparator.comparing(Person::getId).thenComparing(Person::getName));

//        personList.forEach(System.out::println);


//        Person person = personDAO.findById(8).orElseThrow(() -> new RuntimeException("Person not found!"));
//        System.out.println(person);
//
//        person.setName("Kamran");
//        person.setSurname("Movsumov");
//        person.setCreatedAt(new Date());

//        Person updated = personDAO.update(8, person);

//        System.out.println(updated);

//        if (personOptional.isPresent()) {
//            Person person = personOptional.get();
//            System.out.println(person);
//        }


        Person person = new Person();
        person.setName("Test Name 6");
        person.setSalary(BigDecimal.TEN);
        person.setEmail("test@example.com 6");
        person.setSurname("Test Surname 6");
        person.setAddress("Test Address 6");

        System.out.println(personDAO.create(person));


    }

}
