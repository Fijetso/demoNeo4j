package com.example.demoNeo4j.graph.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.example.demoNeo4j.graph.domain.GraphMovie;

public interface GraphMovieRepository extends Neo4jRepository<GraphMovie, Long>{

}
