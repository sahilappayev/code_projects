package com.example.spring_jdbc.spring_jdbc.service;

import com.example.spring_jdbc.spring_jdbc.domain.Person;
import java.util.List;

public interface PersonService {

    public List<Person> findAll();

    public Person findById(int id) ;

    public Person create(Person person);

    public Person update(int id, Person person);

    public void delete(int id);

}
