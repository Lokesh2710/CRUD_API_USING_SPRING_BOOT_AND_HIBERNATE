package com.lokeshDev.crud_app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lokeshDev.crud_app.Service.StudentService;
import com.lokeshDev.crud_app.entity.Student;


@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/addStudent") // To add new Student data
	public Student addStudent(@RequestBody Student student)
	{
		return service.saveStudent(student);
	}
	
	@GetMapping("/all_students") // To get list of all Student data
	public List<Student> findAllStudent()
	{
		return service.getStudents();
	}
	
//	@GetMapping("/studentById/{id}") // To get student data by id
//	public Student findStudentById(@PathVariable int Id)
//	{
//		return service.getStudentById(Id);
//	}
	
//	@GetMapping("/student/{name}") // To get student data by name
//	public Student findStudentByName(@PathVariable String name)
//	{
//		return service.getStudentById(name);
//	}
	
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student)
	{
		return service.updateStudentInfo(student);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id)
	{
		return service.deleteStudent(id);
	}
	
}
