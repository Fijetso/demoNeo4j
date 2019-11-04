package com.example.demoNeo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(value = {"com.example.demoNeo4j"})
//@EnableAutoConfiguration(exclude = {Neo4jDataAutoConfiguration.class, DataSourceAutoConfiguration.class})

//@EnableNeo4jRepositories(basePackages = "com.example.demoNeo4j.graph")
//@EnableJpaRepositories(basePackages = "com.example.demoNeo4j.relational", transactionManagerRef = "mysqlTransactionManager")
//@EnableTransactionManagement
public class DemoNeo4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoNeo4jApplication.class, args);
	}

}
