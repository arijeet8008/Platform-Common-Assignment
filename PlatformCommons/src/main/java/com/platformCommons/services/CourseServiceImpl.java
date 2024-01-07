package com.platformCommons.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.platformCommons.exceptions.CourseException;
import com.platformCommons.model.Course;
import com.platformCommons.repo.CourseRepo;

public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseRepo courseRepo;

	@Override
	public Course addCourse(Course course) throws CourseException {

		Course courses = courseRepo.save(course);
		if(courses == null)
			throw new CourseException("Add Valid Course");
		
		return courses;

	}

}
