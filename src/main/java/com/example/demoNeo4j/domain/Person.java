package com.example.demoNeo4j.domain;

import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Person {
	@Id @GeneratedValue
	private Long id;
	private String name;
	@Relationship(type = "LIKES", direction = Relationship.INCOMING)
	List<Movie> movies;
	
	public Person(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Person() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
