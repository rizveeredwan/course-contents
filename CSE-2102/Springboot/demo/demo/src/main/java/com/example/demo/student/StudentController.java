package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {
    private final StudentService studentService; 

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService; 
    }   
    @GetMapping
	/*public String Hello(){ // Rest end points
		return "Hello"; 
	}*/
	public List<Student> getStudent(){
		return this.studentService.getStudent(); 
	}
    @PostMapping
    public void registerNewStudent(@RequestBody Student s){ // invoking this service 
        this.studentService.addNewStudent(s);
    }
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
    @PutMapping(path="{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        System.out.println("came " + studentId);
        studentService.updateStudent(studentId, name, email);
    }
}
