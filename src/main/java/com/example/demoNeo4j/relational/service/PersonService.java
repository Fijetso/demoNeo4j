package com.example.demoNeo4j.relational.service;

import com.example.demoNeo4j.relational.domain.Person;


public interface PersonService {

  Person create(Person person);

  Person findOne(Long id);
}
