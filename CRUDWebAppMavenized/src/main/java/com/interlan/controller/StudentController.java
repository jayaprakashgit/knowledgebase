package com.interlan.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.interlan.model.Student;
import com.interlan.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	//@RequestMapping("/index")
	@RequestMapping(value={"/index", "/"})
	public String setupForm(Map<String, Object> map){
		Student student = new Student();
		map.put("student", student);
		map.put("studentList", studentService.getAllStudent());
		return "student";
	}
	
	@RequestMapping(value="/student.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Student student, BindingResult result, @RequestParam String action, Map<String, Object> map){
		Student studentResult = new Student();
		switch(action.toLowerCase()){
			case "add":
				studentService.add(student);
				studentResult= student;
				break;
			case "edit":
				studentService.edit(student);
				studentResult = student;
				break;
			case "delete":
				studentService.delete(student);
				studentResult = new Student();
				break;
			case "search":
				Student searchStudent = studentService.getStudent(student.getStudentId());
				studentResult = studentResult != null ? searchStudent : new Student();
				break;
		}
		map.put("student", studentResult);
		map.put("studentList", studentService.getAllStudent());
		return "student";
	}
}
