package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController; // added due to rest controller 

import com.example.demo.student.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@RestController // annotations 
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	

}
