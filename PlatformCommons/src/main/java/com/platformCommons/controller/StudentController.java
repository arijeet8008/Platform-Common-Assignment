package com.platformCommons.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platformCommons.exceptions.CourseException;
import com.platformCommons.exceptions.SessionException;
import com.platformCommons.exceptions.StudentException;
import com.platformCommons.model.Course;
import com.platformCommons.model.Session;
import com.platformCommons.model.Student;
import com.platformCommons.model.UserType;
import com.platformCommons.services.SessionService;
import com.platformCommons.services.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SessionService sessionService;
	
	@PutMapping("/students")
	public ResponseEntity<Student> updateStudent(@RequestBody @Valid Student student,@RequestParam("sessionKey") String sessionKey) throws StudentException,SessionException{
		
		Session session = sessionService.getSessionByKey(sessionKey);
		if(session.getUserType() == UserType.STUDENT) {
			Student updateStudent = studentService.updateStudent(student);
			return new ResponseEntity<Student>(updateStudent, HttpStatus.ACCEPTED);
		}
		throw new SessionException("Please login with the correct credentials");
		
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Course> updateStudent(@PathVariable("id")Integer id,@RequestParam("sessionKey") String sessionKey) throws StudentException,SessionException, CourseException{
		
		Session session = sessionService.getSessionByKey(sessionKey);
		if(session.getUserType() == UserType.STUDENT) {
			Course deleteCourse = studentService.leaveCourse(id);
			return new ResponseEntity<Course>(deleteCourse,HttpStatus.ACCEPTED);
		}
		throw new SessionException("Please login with the correct credentials");
		
	}
	
}
