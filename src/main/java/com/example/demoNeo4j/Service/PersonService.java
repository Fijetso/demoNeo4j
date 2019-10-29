package com.example.demoNeo4j.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoNeo4j.domain.Person;
import com.example.demoNeo4j.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public List<Person> getAll() {
		return personRepository.getAllPeople();
	}
}
