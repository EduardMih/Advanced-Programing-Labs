package com.example.demo.controllers;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repositories.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public List<Person> getAllPersons()
    {

        return personRepository.findAll();

    }

   @PostMapping
    public void addPerson(@RequestBody Person person)
    {

        personRepository.save(person);

    }

    @PutMapping(path = "/{id}")
    public void updateName(@PathVariable Integer id, @RequestBody Person person)
    {
        Person newPerson = personRepository.findById(id).orElse(null);


        if(newPerson != null)
        {
            newPerson.setName(person.getName());
            personRepository.save(newPerson);
        }
    }

    @DeleteMapping(path = "{id}")
    public void deletePerson(@PathVariable Integer id)
    {
        Person person = personRepository.findById(id).orElse(null);

        if(person != null)
            personRepository.delete(person);

    }
}
