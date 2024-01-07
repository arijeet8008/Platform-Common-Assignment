package com.platformCommons.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platformCommons.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{

	public Admin findByEmail(String email);
	
}
