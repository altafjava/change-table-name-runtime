package com.javaaltaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TestDumpApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestDumpApplication.class, args);
	}

}
