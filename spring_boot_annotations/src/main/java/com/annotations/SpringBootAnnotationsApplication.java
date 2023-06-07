package com.annotations;

import mypack.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringBootAnnotationsApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("student2")
	private Student student;
//
//	@Autowired
//	private Student student1;

	@Autowired
	private Date date;

	@Autowired
	private Emp emp;

	@Autowired
	private Dog dog;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAnnotationsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.student.studying();
//		this.student1.studying();
		this.emp.whatsYourName();
		this.dog.eating();
	}
}
