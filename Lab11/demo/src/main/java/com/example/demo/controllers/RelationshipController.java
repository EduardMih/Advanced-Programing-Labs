package com.example.demo.controllers;

import com.example.demo.model.Relationship;
import com.example.demo.repositories.RelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/relationships")
public class RelationshipController {
    @Autowired
    private final RelationshipRepository relationshipRepository;

    public RelationshipController(RelationshipRepository relationshipRepository) {
        this.relationshipRepository = relationshipRepository;
    }


    @PostMapping
    public ResponseEntity addRelationship(@RequestBody Relationship relationship)
    {
        Relationship newRelationship = new Relationship(relationship.getPerson1Id(), relationship.getPerson2Id());

        //System.out.println(newRelationship);

        try
        {
            relationshipRepository.save(relationship);
        }
        catch(Exception e)
        {

            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);

        }

        return new ResponseEntity(HttpStatus.OK);

    }

    @GetMapping
    public List<Relationship> getAllRelationships()
    {
        List<Relationship> relationships = new ArrayList<>();

        relationships.addAll(relationshipRepository.findAll());

        return relationships;

    }

    @GetMapping(path = "{id}")
    public List<Relationship> getFriends(@PathVariable Integer id)
    {
        List<Relationship> friends = new ArrayList<>();

        friends.addAll(relationshipRepository.findAllFriends(id));

        return friends;

    }

}
