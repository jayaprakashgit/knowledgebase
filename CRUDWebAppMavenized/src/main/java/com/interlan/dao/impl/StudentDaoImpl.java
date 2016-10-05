package com.interlan.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.interlan.dao.StudentDao;
import com.interlan.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Student student) {
		session.getCurrentSession().save(student);
		
	}

	@Override
	public void edit(Student student) {
		session.getCurrentSession().update(student);
		
	}

	@Override
	public void delete(Student student) {
		session.getCurrentSession().delete(getStudent(student.getStudentId()));
		
	}

	@Override
	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		return (Student) session.getCurrentSession().get(Student.class, studentId);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Student").list();
	}

}
