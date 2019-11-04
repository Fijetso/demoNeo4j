package com.example.demoNeo4j.relational.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Movie {
	
	@Id @GeneratedValue
	private Long id;
	private String name;
	@OneToMany(mappedBy="movie")
	private  List<Person> persons = new ArrayList<>();
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
