package com.platformCommons.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platformCommons.exceptions.CourseException;
import com.platformCommons.exceptions.StudentException;
import com.platformCommons.model.Course;
import com.platformCommons.model.Student;
import com.platformCommons.repo.AddressRepo;
import com.platformCommons.repo.CourseRepo;
import com.platformCommons.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private CourseRepo courseRepo;

	@Override
	public Student addStudent(Student student) throws StudentException {
		if(studentRepo.findByEmail(student.getEmail()) != null)
			throw new StudentException("Student already exists with the email:- "+student.getEmail());
		
		Student student2 = studentRepo.save(student);
		
		return student2;
		
	}

	@Override
	public Student getStudentByName(String name) throws StudentException {

		Student student = studentRepo.findByName(name);
		if(student == null)
			throw new StudentException("Invalid Name");
		return student;

	}

	@Override
	public Student updateStudent(Student student) throws StudentException {
		
		Optional<Student> opt = studentRepo.findById(student.getStudentId());
		
		if(opt.isEmpty())
			throw new StudentException("Invalid Id");
		
		return studentRepo.save(student);
		
	}

	@Override
	public Course leaveCourse(Integer id) throws StudentException, CourseException {

		Optional<Course> opt = courseRepo.findById(id);
		
		if(opt.isPresent()) {
			Course course = opt.get();
			courseRepo.delete(course);
			return course;
		}
		
		else
			throw new CourseException("Invalid Id");

	}	

}
