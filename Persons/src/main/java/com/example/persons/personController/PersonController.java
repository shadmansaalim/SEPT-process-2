package com.example.persons.personController;

import com.example.persons.personModel.Person;
import com.example.persons.personRepository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/person")
public class PersonController {
    @Autowired
    PersonRepository repository;

    @GetMapping(path = "/", produces = "application/json")
    public List<Person> getPerson() {
        return repository.findAll();
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public Person addPerson(@RequestBody Person Person) {
        return repository.save(Person);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Optional<Person> getPerson(@PathVariable String id) {
        return repository.findById(Long.valueOf(id));
    }

    @PutMapping("/{id}")
    Optional<Person> updatePerson(@RequestBody Person newPerson, @PathVariable String id) {
        Optional<Person> person = repository.findById(Long.valueOf(id));

        if (person.isPresent()) {
            String personName = person.get().getName();
            String personAddress = person.get().getAddress();
            String personPostcode = person.get().getPostcode();
            String personAge = person.get().getAge();
            String personJob = person.get().getJob();
            String personEmail = person.get().getEmail();
            String personPhoneno = person.get().getPhoneno();

            if (!newPerson.getName().equals(personName)){
                person.get().setName(newPerson.getName());
            }
            else if (!newPerson.getAddress().equals(personAddress)){
                person.get().setAddress(newPerson.getAddress());
            }
            else if (!newPerson.getPostcode().equals(personPostcode)){
                person.get().setPostcode(newPerson.getPostcode());
            }
            else if (!newPerson.getAge().equals(personAge)){
                person.get().setAge(newPerson.getAge());
            }
            else if (!newPerson.getJob().equals(personJob)){
                person.get().setJob(newPerson.getJob());
            }
            else if (!newPerson.getEmail().equals(personEmail)){
                person.get().setEmail(newPerson.getEmail());
            }
            else if (!newPerson.getPhoneno().equals(personPhoneno)){
                person.get().setPhoneno(newPerson.getPhoneno());
            }

            repository.save(person.get());
        }

        return Optional.of(new Person());
    }

    @DeleteMapping("/{id}")
    Optional<Person> deletePerson(@PathVariable String id) {
        Optional<Person> Person = repository.findById(Long.valueOf(id));

        if (Person.isPresent())
            repository.deleteById(Long.valueOf(id));

        return Person;
    }
}