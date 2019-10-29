package com.example.demoNeo4j.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.example.demoNeo4j.domain.Movie;

public interface MovieRepository extends Neo4jRepository<Movie, Long>{

}
