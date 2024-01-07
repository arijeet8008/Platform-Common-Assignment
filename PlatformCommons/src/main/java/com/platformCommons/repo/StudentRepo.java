package com.platformCommons.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platformCommons.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

	public Student findByEmail(String email);
	
	public Student findByName(String Name);
	
}
