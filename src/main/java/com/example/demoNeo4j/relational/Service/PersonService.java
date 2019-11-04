package com.example.demoNeo4j.relational.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoNeo4j.relational.domain.Person;
import com.example.demoNeo4j.relational.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public List<Person> getAll() {
		return personRepository.findAll();
	}
}
