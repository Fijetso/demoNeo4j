package com.example.demoNeo4j.relational.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoNeo4j.relational.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
}
