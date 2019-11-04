package com.example.demoNeo4j;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.example.demoNeo4j.graph")
@EnableJpaRepositories(basePackages = "com.example.demoNeo4j.relational", transactionManagerRef = "mysqlTransactionManager")
@EnableTransactionManagement
public class DataSourceConfig {

	private static final Logger LOG = LoggerFactory.getLogger(DataSourceConfig.class);

	@Bean
	public org.neo4j.ogm.config.Configuration configuration() {
		org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder()
				.uri("bolt://localhost").credentials("neo4j", "admin").build();
		return configuration;
	}

	@Bean
	public SessionFactory sessionFactory() {
		return new SessionFactory(configuration(), "com.example.demoNeo4j.graph");
	}

//  @Bean
//  public Session getSession() throws Exception {
//    return super.getSession();
//  }

	@Primary
	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create()
//        .driverClassName("com.mysql.jdbc.Driver")
				.build();
	}

	@Primary
	@Bean(name = "entityManagerFactory")
	@Autowired
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource") DataSource dataSource) {
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("spring.jpa.hibernate.ddl-auto", "update");
		properties.put("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return builder.dataSource(dataSource).properties(properties).packages("com.example.demoNeo4j.relational")
				.build();
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Autowired
	@Bean(name = "neo4jTransactionManager")
	public Neo4jTransactionManager neo4jTransactionManager() {
		return new Neo4jTransactionManager(sessionFactory());
	}

	@Autowired
	@Primary
	@Bean(name = "mysqlTransactionManager")
	public JpaTransactionManager mysqlTransactionManager(@Qualifier("entityManagerFactory") LocalContainerEntityManagerFactoryBean entityManagerFactory)
			throws Exception {
		return new JpaTransactionManager(entityManagerFactory.getObject());
	}

	@Autowired
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(Neo4jTransactionManager neo4jTransactionManager,
			JpaTransactionManager mysqlTransactionManager) {
		return new ChainedTransactionManager(mysqlTransactionManager, neo4jTransactionManager);
	}
}