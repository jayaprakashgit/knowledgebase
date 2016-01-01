package com.interlan.service;

import java.util.List;

import com.interlan.model.Student;

public interface StudentService {
	
	public void add(Student student);
	public void edit(Student student);
	public void delete(Student student);	
	public Student getStudent(int studentId);
	public List<Student> getAllStudent();

}
