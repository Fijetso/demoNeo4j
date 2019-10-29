package com.example.demoNeo4j.graph.service;

import com.example.demoNeo4j.graph.domain.GraphPerson;

public interface GraphPersonService {

  GraphPerson create(GraphPerson graphPerson);

  GraphPerson findOne(Long id);
}
