package com.platformCommons.services;

import java.util.List;

import com.platformCommons.exceptions.CourseException;
import com.platformCommons.exceptions.StudentException;
import com.platformCommons.model.Course;
import com.platformCommons.model.Student;

public interface StudentService {

	public Student addStudent(Student student) throws StudentException;
	
	public Student getStudentByName(String name) throws StudentException;
	
	public Student updateStudent(Student student) throws StudentException;
	
	public Course leaveCourse(Integer id)throws StudentException,CourseException;
	
}
