package com.spring.cache.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.spring.cache.model.Student;
@Repository
public class StudentRepo {

	public void saveSchoolStudents(List<Student> student, String schoolName) {
		// TODO Auto-generated method stub
		
	}

	@Cacheable(value = "students", key = "#schoolName")
	public List<Student> getStudentsOfSchool(String schoolName) {
		System.out.println("called studentRepo getStudentsOfSchool");
		List<Student> students=new ArrayList<>();
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

	public void deleteStudents(String schoolName) {
		// TODO Auto-generated method stub
		
	}

}
