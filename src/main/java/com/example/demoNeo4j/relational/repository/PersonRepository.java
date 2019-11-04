package com.example.demoNeo4j.relational.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.example.demoNeo4j.relational.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
}
