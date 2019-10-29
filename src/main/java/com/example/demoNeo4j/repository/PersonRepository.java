package com.example.demoNeo4j.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.example.demoNeo4j.domain.Person;

public interface PersonRepository extends Neo4jRepository<Person, Long>{

	@Query("MATCH (p:Person)<-[r:RATED]-(m:Movie) RETURN p,r,m")
	public List<Person> getAllPeople();
}
