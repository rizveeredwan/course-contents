package com.example.demo.student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository){
		this.studentRepository = studentRepository; 
	}
    public List<Student> getStudent() {
		return this.studentRepository.findAll(); 
	}
	public void addNewStudent(Student s){
		Optional<Student> studentOptional  = studentRepository.findStudentByEmail(s.getEmail());
		if(studentOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		studentRepository.save(s); 
		System.out.println(s);

	}

    public void deleteStudent(Long studentId) {
   		boolean b = studentRepository.existsById(studentId);
		   if(!b) {
			   throw new IllegalStateException(studentId + " does not exist");
		   }
		studentRepository.deleteById(studentId);
    }
	@Transactional
	public void updateStudent(Long studentId, String name, String email) {
		Student s = studentRepository.findById(studentId).orElseThrow(
				() -> new IllegalStateException("student id with " +studentId + " is not found")
		);
		if(name != null && !name.isEmpty() && !Objects.equals(s.getName(), name)){
			s.setName(name);
		}
		if(email != null && !email.isEmpty() && !Objects.equals(s.getEmail(), email)){
			Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
			if(studentOptional.isPresent()) {
				throw new IllegalStateException("Email taken");
			}
			s.setEmail(email);
		}

	}
}
