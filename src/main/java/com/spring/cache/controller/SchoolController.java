package com.spring.cache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cache.model.Student;
import com.spring.cache.service.SchoolService;

@RestController
@RequestMapping("students/")
public class SchoolController {

	@Autowired
	private SchoolService studentService;

	@PutMapping("/{schoolName}")
	public void insertStudents(@RequestBody List<Student> student, @PathVariable String schoolName) {
		studentService.setStudent(student, schoolName);
	}

	@GetMapping(value = "/{schoolName}", params = { "page", "size" })
	public List<Student> getStudents(@PathVariable String schoolName, int page, int size) {
		int endIndex = page * size;
		int startIndex = endIndex - size;
		return studentService.getStudents(schoolName, startIndex, endIndex);
	}

	@DeleteMapping("/{schoolName}")
	public void deleteCache(@PathVariable String schoolName) {
		studentService.deleteSchool(schoolName);
	}

}
