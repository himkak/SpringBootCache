package com.spring.cache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
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
	
	@CachePut(value = "students", key = "#schoolName")
	@PutMapping("/{schoolName}")
	public void insertStudents(@RequestBody List<Student> students,@PathVariable String schoolName) {
		studentService.saveStudents(students, schoolName);
	}
	
	@GetMapping(value="/{schoolName}", params = { "page", "size" })
	public List<Student> getStudents(@PathVariable String schoolName, int page, int size){
		int endIndex=page*size;
		int startIndex=endIndex-size;
		return studentService.getStudents(schoolName, startIndex, endIndex);
	}
	
	@CacheEvict(value = "students", allEntries=true)
	@DeleteMapping("/{schoolName}")
	public void deleteCache(@PathVariable String schoolName) {
		studentService.deleteStudents(schoolName);
	}

}
