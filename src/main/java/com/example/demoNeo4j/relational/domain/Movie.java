package com.example.demoNeo4j.relational.domain;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Movie {
	
	@Id @GeneratedValue
	private Long id;
	private String name;
	@ManyToMany(mappedBy="movies")
	private  List<Person> persons;
	public Movie() {
		super();
	}
	public Movie(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
