package com.example.chartgame.configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	private EntityManager em;
	private DataSource ds;
	
	public SpringConfig(EntityManager em, DataSource ds) {
		super();
		this.em = em;
		this.ds = ds;
	}
	
	
	
	
}
