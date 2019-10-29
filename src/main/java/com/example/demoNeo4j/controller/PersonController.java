package com.example.demoNeo4j.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoNeo4j.Service.PersonService;
import com.example.demoNeo4j.domain.Person;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping()
	public List<Person> getPerson() {
		return personService.getAll();
	}
}
