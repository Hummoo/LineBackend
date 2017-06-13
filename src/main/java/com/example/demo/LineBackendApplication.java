package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.service.TableService;

@SpringBootApplication
public class LineBackendApplication implements CommandLineRunner {

	@Autowired
	TableService tableService;

	public static void main(String[] args) {
		SpringApplication.run(LineBackendApplication.class, args);

	}

	@Override
	public void run(String... arg0) throws Exception {
		tableService.dropTable();
		tableService.createLineGroup();
	}

}
