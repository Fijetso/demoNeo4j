package com.example.demoNeo4j.relational.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoNeo4j.relational.Service.PersonService;
import com.example.demoNeo4j.relational.domain.Person;

@RestController
@RequestMapping(path = "/relational")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping()
	public List<Person> getPerson() {
		return personService.getAll();
	}
}
