package com.platformCommons.services;

import com.platformCommons.exceptions.AdminException;
import com.platformCommons.exceptions.LoginException;
import com.platformCommons.exceptions.StudentException;
import com.platformCommons.model.LoginDto;
import com.platformCommons.model.Session;

public interface LoginService {

	public Session login(LoginDto loginDto)throws LoginException, AdminException,StudentException;
	
	public String logout(Integer userId)throws LoginException;
	
}
