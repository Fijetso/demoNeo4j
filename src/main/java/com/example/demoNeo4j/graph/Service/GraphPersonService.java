package com.example.demoNeo4j.graph.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoNeo4j.graph.domain.GraphPerson;
import com.example.demoNeo4j.graph.repository.GraphPersonRepository;

@Service
public class GraphPersonService {

	@Autowired
	private GraphPersonRepository graphPersonRepository;

	public List<GraphPerson> getAll() {
		return graphPersonRepository.getAllPeople();
	}
}
