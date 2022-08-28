package io.zipcoder.crudapp.services;

import io.zipcoder.crudapp.models.Person;
import io.zipcoder.crudapp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    public Person getById(Long id) {
        return personRepository.findOne(id);
    }

    public Person updatePerson(Person person, Long id) {
        Person existingPerson = personRepository.findOne(id);
        if (existingPerson == null) {
            return null;
        }
        return personRepository.save(person);
    }

    public Boolean removePerson(Long id) {
        personRepository.delete(id);
        return true;
    }
}
