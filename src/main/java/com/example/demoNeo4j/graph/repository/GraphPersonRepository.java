package com.example.demoNeo4j.graph.repository;

import com.example.demoNeo4j.graph.domain.GraphPerson;

import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * Created by tbobella on 1/31/17.
 */
public interface GraphPersonRepository extends Neo4jRepository<GraphPerson, Long> {
}
