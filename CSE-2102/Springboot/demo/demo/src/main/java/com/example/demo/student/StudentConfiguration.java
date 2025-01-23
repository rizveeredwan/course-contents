package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
           Student s1 =  new Student("Rizvee", LocalDate.of(2024, 4, 19), "rizvee@cse.du.ac.bd");
           Student s2 =  new Student("Tanvir", LocalDate.of(2020, 2, 17), "tanvir@cse.du.ac.bd");
           studentRepository.saveAll(List.of(s1, s2));
        };
    }
}
