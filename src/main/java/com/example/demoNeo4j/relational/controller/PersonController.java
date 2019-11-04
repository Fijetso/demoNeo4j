package com.example.demoNeo4j.relational.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoNeo4j.graph.Service.GraphPersonService;
import com.example.demoNeo4j.graph.domain.GraphPerson;

@RestController
@RequestMapping(path = "/relational")
public class PersonController {

	@Autowired
	private GraphPersonService graphPersonService;
	
	@GetMapping()
	public List<GraphPerson> getPerson() {
		return graphPersonService.getAll();
	}
}
