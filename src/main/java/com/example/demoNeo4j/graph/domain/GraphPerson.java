package com.example.demoNeo4j.graph.domain;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.io.Serializable;

@NodeEntity
public class GraphPerson implements Serializable {

  private static final long serialVersionUID = 3052327829901249416L;

  @Id
  private Long id;

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }
}
