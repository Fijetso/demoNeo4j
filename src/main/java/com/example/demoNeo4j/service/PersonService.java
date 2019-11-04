package com.example.demoNeo4j.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoNeo4j.graph.domain.GraphPerson;
import com.example.demoNeo4j.graph.repository.GraphPersonRepository;
import com.example.demoNeo4j.relational.domain.Person;
import com.example.demoNeo4j.relational.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private GraphPersonRepository graphPersonRepository;

	public List<GraphPerson> graphGetAll() {
		return graphPersonRepository.getAllPeople();
	}

	@Autowired
	private PersonRepository personRepository;

	public List<Person> relationalGetAll() {
		return personRepository.findAll();
	}
}
