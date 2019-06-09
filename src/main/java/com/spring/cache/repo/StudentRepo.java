package com.spring.cache.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.spring.cache.model.Student;

@Repository
@CacheConfig(cacheNames = "students", cacheManager = "redisCacheManager")
public class StudentRepo {

	@CacheEvict(key = "#schoolName")
	public void daleteSchool(String schoolName) {
		System.out.println("deleting school information." + schoolName);

	}

	@Cacheable(key = "#schoolName", sync=true)
	public List<Student> getStudents(String schoolName) {
		System.out.println("called studentRepo getStudentsOfSchool");
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "him1", 31));
		students.add(new Student(2, "him2", 32));
		students.add(new Student(3, "him3", 33));
		students.add(new Student(4, "him4", 34));
		students.add(new Student(5, "him5", 35));
		students.add(new Student(6, "him6", 36));
		students.add(new Student(7, "him7", 37));
		students.add(new Student(8, "him8", 38));
		students.add(new Student(8, "him9", 39));
		students.add(new Student(10, "him10", 310));
		students.add(new Student(11, "him11", 311));
		return students;
	}

	@CachePut(key = "#schoolName", unless = "#result == null")
	public List<Student> setStudents(List<Student> student, String schoolName) {
		// TODO Auto-generated method stub
		System.out.println("student:" + student + ",schoolName:" + schoolName);
		return student;
	}

}
