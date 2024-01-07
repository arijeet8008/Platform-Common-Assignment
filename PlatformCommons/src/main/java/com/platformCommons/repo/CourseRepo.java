package com.platformCommons.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platformCommons.model.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer>{

}
