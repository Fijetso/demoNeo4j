package com.example.demoNeo4j.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoNeo4j.graph.domain.GraphPerson;
import com.example.demoNeo4j.relational.domain.Person;
import com.example.demoNeo4j.service.PersonService;
@RestController
@RequestMapping("/main")
public class PersonController {
	@Autowired
	private PersonService personService;

	@GetMapping("/graph")
	public List<GraphPerson> graphGetPerson() {
		return personService.graphGetAll();
	}

	@GetMapping("/relational")
	public List<Person> relationalGetPerson() {
		return personService.relationalGetAll();
	}
}
