package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.cglib.core.Local;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity // hibernate
@Table // adding a table 
public class Student {
    @Id
    @SequenceGenerator(
        name="student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    private Long id;
    private String name;
    @Transient
    private Integer age;
    private LocalDate time;
    private String email; 
    public Student(){

    }
    public Student(Long id, String name, LocalDate time, String email){
        this.id = id;
        this.name = name;
        this.time = time; 
        this.email = email;
    }
    public Student(String name, LocalDate time, String email){
        this.name = name;
        this.time = time; 
        this.email = email;
    }

    public void setId(Long id){
        this.id = id; 
    }
    public Long getID(){
        return this.id; 
    }

    public void setName(String name){
        this.name = name; 
    }
    public String getName(){
        return this.name; 
    }

    public void setEmail(String email){
        this.email = email; 
    }
    public String getEmail(){
        return this.email; 
    }

    public void setAge(int age){
        this.age = age; 
    }
    public int getAge(){
        return Period.between(time, LocalDate.now()).getYears(); 
    }

    public void setTime(LocalDate time){
        this.time = time; 
    }
    public LocalDate getTime(){
        return this.time; 
    }

    public String toString(){
        return "Here student " + this.id + " " + this.name + " " + this.email + " " + this.age + " " + this.time + "\n"; 
    }


}
