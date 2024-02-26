package com.spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.entity.Student;
import com.spring.security.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	@GetMapping("/csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudents(){
	return ResponseEntity.ok(studentService.getStudents());
		
	}
	
	@PostMapping("/students")
	public ResponseEntity<Student> addStudent(@RequestBody Student student ){
		if(studentService.addStudent(student)) {
			return ResponseEntity.ok(student);
		}else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
}
