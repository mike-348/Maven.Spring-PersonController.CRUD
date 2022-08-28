package io.zipcoder.crudapp.controllers;

import io.zipcoder.crudapp.models.Person;
import io.zipcoder.crudapp.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Endpoints:
 *
 * POST /people - create a new person
 * Response: 201 Created
 * GET /people - get the list of all people
 * Response: 200 OK
 * GET /people/{id} - Get the person with id number {id}
 * Response: 200 OK if found, else 404 Not Found
 * PUT /people/{id} - Update the person with id number {id}
 * Response: 200 OK if updated, 201 Created if a new entity was created
 * DELETE /people/{id} - delete the person with id number {id}
 * Response: 204 No Content
 */

@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personService.addPerson(person), HttpStatus.CREATED);
    }

    @GetMapping("/people")
    public ResponseEntity<Iterable<Person>> getAllPeople() {
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        return new ResponseEntity<>(personService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/people/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person, @PathVariable Long id) {
        return new ResponseEntity<>(personService.updatePerson(person, id), HttpStatus.OK);
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<Boolean> deletePerson(@PathVariable Long id) {
        return new ResponseEntity<>(personService.removePerson(id), HttpStatus.NO_CONTENT);
    }

}
