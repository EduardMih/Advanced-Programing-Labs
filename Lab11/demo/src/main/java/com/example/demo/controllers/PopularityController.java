package com.example.demo.controllers;

import com.example.demo.model.Person;
import com.example.demo.repositories.PersonRepository;
import com.example.demo.repositories.RelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/popularity")
public class PopularityController {

    @Autowired
    private final PersonRepository personRepository;

    @Autowired
    private final RelationshipRepository relationshipRepository;

    public PopularityController(PersonRepository personRepository, RelationshipRepository relationshipRepository) {
        this.personRepository = personRepository;
        this.relationshipRepository = relationshipRepository;
    }

    @GetMapping(path = "most")
    public List<Person> getMostPopular()
    {
        List<Person> persons = personRepository.findAll();
        List<Person> mostPopularPersons = new ArrayList<>();
        Integer maxPopularity = Integer.MIN_VALUE;
        Integer currentPersonPopularity;

        for(Person person : persons)
        {
            currentPersonPopularity = relationshipRepository.getNumberOfFriends(person.getId());
            if(currentPersonPopularity == maxPopularity)
            {
                mostPopularPersons.add(person);
            }
            if(currentPersonPopularity > maxPopularity)
            {
                maxPopularity = currentPersonPopularity;
                mostPopularPersons.clear();
                mostPopularPersons.add(person);
            }
        }

        return mostPopularPersons;

    }


    @GetMapping(path = "least")
    public List<Person> getLeastPopular()
    {
        List<Person> persons = personRepository.findAll();
        List<Person> leastPopularPersons = new ArrayList<>();
        Integer minPopularity = Integer.MAX_VALUE;
        Integer currentPersonPopularity;

        for(Person person : persons)
        {
            currentPersonPopularity = relationshipRepository.getNumberOfFriends(person.getId());
            if(currentPersonPopularity == minPopularity)
            {
                leastPopularPersons.add(person);
            }
            if(currentPersonPopularity < minPopularity)
            {
                minPopularity = currentPersonPopularity;
                leastPopularPersons.clear();
                leastPopularPersons.add(person);
            }
        }

        return leastPopularPersons;

    }
}
