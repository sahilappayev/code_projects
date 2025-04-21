package com.example.spring_jdbc.spring_jdbc.controller;

import com.example.spring_jdbc.spring_jdbc.domain.Person;
import com.example.spring_jdbc.spring_jdbc.service.PersonService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPersons() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable int id) {
        return personService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(personService.create(person));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> createPerson(@PathVariable int id,
                                               @RequestBody Person person) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(personService.update(id, person));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable int id) {
        personService.delete(id);
    }


}
