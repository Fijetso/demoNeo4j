package com.example.demoNeo4j.relational.service;

import com.example.demoNeo4j.relational.domain.Person;
import com.example.demoNeo4j.relational.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

  @Autowired
  private PersonRepository personRepository;

  @Override
  public Person create(Person person) {
    return personRepository.save(person);
  }

  @Override
  public Person findOne(Long id) {
    return personRepository.findById(id).get();
  }
}
