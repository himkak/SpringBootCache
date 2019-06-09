package com.spring.cache.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cache.model.Student;
import com.spring.cache.repo.StudentRepo;

@Service
public class SchoolService {

	@Autowired
	private StudentRepo studentRepo;

	public void deleteSchool(String schoolName) {
		studentRepo.daleteSchool(schoolName);
	}

	public List<Student> getStudents(String schoolName, int startIndex, int endIndex) {
		System.out.println("Called getStudents service");
		return studentRepo.getStudents(schoolName).subList(startIndex, endIndex);
	}

	public void setStudent(List<Student> student, String schoolName) {
		studentRepo.setStudents(student, schoolName);
	}
}
