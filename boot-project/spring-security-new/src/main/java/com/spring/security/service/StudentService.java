package com.spring.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.security.entity.Student;

@Service
public class StudentService {

	private static List<Student> students=new ArrayList<>(List.of(
			new Student(1,"Shiva","Java"),
			new Student(2,"Muskan","Python")
			));
	
	public List<Student> getStudents(){
		return students;
	}
	
	public boolean addStudent(Student student) {
		return students.add(student);
	}
}
