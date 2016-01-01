package com.interlan.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interlan.dao.StudentDao;
import com.interlan.model.Student;
import com.interlan.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	@Transactional
	@Override
	public void add(Student student) {
		studentDao.add(student);
		
	}

	@Transactional
	@Override
	public void edit(Student student) {
		studentDao.edit(student);
		
	}

	@Transactional
	@Override
	public void delete(Student student) {
		studentDao.delete(student);
		
	}

	@Transactional
	@Override
	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		return studentDao.getStudent(studentId);
	}

	@Transactional
	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentDao.getAllStudent();
	}

}
