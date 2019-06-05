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

	public void saveStudents(List<Student> student, String schoolName) {
		studentRepo.saveSchoolStudents(student, schoolName);
	}

	
	public List<Student> getStudents(String schoolName, int startIndex, int endIndex) {
		System.out.println("Called getStudents service");
		return studentRepo.getStudentsOfSchool(schoolName).subList(startIndex, endIndex);
	}
	

	public void deleteStudents(String schoolName) {
		studentRepo.deleteStudents(schoolName);
	}
}
