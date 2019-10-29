package com.example.demoNeo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(value = { "com.example.demoNeo4j" })
@EnableAutoConfiguration(exclude = { Neo4jDataAutoConfiguration.class, DataSourceAutoConfiguration.class })
public class DemoNeo4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoNeo4jApplication.class, args);
	}

}
