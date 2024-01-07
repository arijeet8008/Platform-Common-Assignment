package com.platformCommons.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platformCommons.exceptions.AdminException;
import com.platformCommons.exceptions.CourseException;
import com.platformCommons.exceptions.SessionException;
import com.platformCommons.exceptions.StudentException;
import com.platformCommons.model.Admin;
import com.platformCommons.model.AdminDto;
import com.platformCommons.model.Course;
import com.platformCommons.model.Session;
import com.platformCommons.model.Student;
import com.platformCommons.model.UserType;
import com.platformCommons.services.AdminService;
import com.platformCommons.services.SessionService;
import com.platformCommons.services.StudentService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SessionService sessionService;
	
	@PostMapping("/admins")
	public ResponseEntity<Admin> addAdmin(@RequestBody @Valid AdminDto admin) throws AdminException{
		Admin savedAdmin = adminService.addAdmin(admin);
		return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
	}
	
	@PostMapping("/admins/students")
	public ResponseEntity<Student> addStudent(@RequestBody @Valid Student student,@RequestParam("sessionKey") String sessionKey)throws StudentException,SessionException{
		
		Session session = sessionService.getSessionByKey(sessionKey);
		if(session.getUserType() == UserType.ADMIN) {
			Student addStudent = studentService.addStudent(student);
			return new ResponseEntity<Student>(addStudent, HttpStatus.CREATED);
		}
		throw new SessionException("Please login with the correct credentials");
		
	}
	
	@PostMapping("/admins/course")
	public ResponseEntity<Course> addCourse(@RequestBody @Valid Course course ,@RequestParam("sessionKey") String sessionKey) throws AdminException,CourseException,SessionException{
		
		Session session = sessionService.getSessionByKey(sessionKey);
		if(session.getUserType() == UserType.ADMIN) {
			return new ResponseEntity<Course>(course, HttpStatus.CREATED);
		}
		throw new SessionException("Please login with the correct credentials");
		
	}
	
	@GetMapping("/studentByName/{name}")
	public ResponseEntity<Student> getStudentByName(@PathVariable("name") String name,@RequestParam("sessionKey") String sessionKey) throws StudentException,SessionException{
		
		Session session = sessionService.getSessionByKey(sessionKey);
		if(session.getUserType() == UserType.ADMIN) {
			Student student = studentService.getStudentByName(name);
			return new ResponseEntity<Student>(student, HttpStatus.ACCEPTED);
		}
		throw new SessionException("Please login with the correct credentials");
		
	}
	
}
