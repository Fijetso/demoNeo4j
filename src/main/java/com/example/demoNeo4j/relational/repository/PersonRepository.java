package com.example.demoNeo4j.relational.repository;

import com.example.demoNeo4j.relational.domain.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>  {
}
