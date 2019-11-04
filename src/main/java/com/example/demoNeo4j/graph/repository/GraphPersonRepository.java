package com.example.demoNeo4j.graph.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.example.demoNeo4j.graph.domain.GraphPerson;

public interface GraphPersonRepository extends Neo4jRepository<GraphPerson, Long>{

	@Query("MATCH (p:Person)<-[r:RATED]-(m:Movie) RETURN p,r,m")
	public List<GraphPerson> getAllPeople();
}
