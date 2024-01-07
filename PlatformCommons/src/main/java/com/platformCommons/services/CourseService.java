package com.platformCommons.services;

import com.platformCommons.exceptions.CourseException;
import com.platformCommons.model.Course;

public interface CourseService {

	public Course addCourse(Course course) throws CourseException;
	
}
