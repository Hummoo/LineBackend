package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TableService {
	private static final Logger log = LoggerFactory.getLogger(TableService.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void dropTable() {
		log.info("dropTable");

		jdbcTemplate.execute("DROP TABLE LINE_GROUP IF EXISTS");
		
		log.info("dropTable executed");
	}
	
	public void createLineGroup() {
		log.info("createLineGroup");
		
		jdbcTemplate.execute("CREATE TABLE LINE_GROUP(ID SERIAL, GROUP_USER_ID VARCHAR(33), AGENT_CODE CHAR(5), CREATED_DT TIMESTAMP)");
		
		log.info("createLineGroup executed");
	}
}
