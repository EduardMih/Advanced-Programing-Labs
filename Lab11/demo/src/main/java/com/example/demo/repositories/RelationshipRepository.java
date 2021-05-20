package com.example.demo.repositories;

import com.example.demo.model.Relationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationshipRepository extends JpaRepository<Relationship, Integer> {
    List<Relationship> findByPerson1Id(Integer id);

    @Query("SELECT r FROM Relationship r WHERE r.person1Id = :id " +
            "OR r.person2Id = :id")
    List<Relationship> findAllFriends(Integer id);

    @Query("SELECT COUNT(r) FROM Relationship r WHERE r.person1Id = :id " +
            "OR r.person2Id = :id")
    Integer getNumberOfFriends(Integer id);

}
