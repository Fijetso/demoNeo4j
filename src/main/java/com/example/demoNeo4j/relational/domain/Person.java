package com.example.demoNeo4j.relational.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Person {
	@Id @GeneratedValue
	private Long id;
	private String name;
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "person_movie", 
        joinColumns = { @JoinColumn(table = "person", name = "personId", referencedColumnName = "id") }, 
        inverseJoinColumns = { @JoinColumn(table = "movie", name = "movieId", referencedColumnName = "id") }
    )
	List<Movie> movies = new ArrayList<>();
	
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
