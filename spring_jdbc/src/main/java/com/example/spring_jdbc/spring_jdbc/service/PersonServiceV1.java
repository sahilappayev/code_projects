package com.example.spring_jdbc.spring_jdbc.service;

import com.example.spring_jdbc.spring_jdbc.repository.PersonRepository;
import com.example.spring_jdbc.spring_jdbc.domain.Person;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceV1 implements PersonService {

    private final PersonRepository personRepository;

    public List<Person> findAll() {

        System.out.println("PersonServiceV1 is calling findAll");

        return personRepository.findAll();
    }

    public Person findById(int id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id: " + id));
    }

    public Person create(Person person) {
        return personRepository.create(person);
    }

    public Person update(int id, Person person) {
        return personRepository.update(id, person);
    }

    public void delete(int id) {
        personRepository.delete(id);
    }
}
