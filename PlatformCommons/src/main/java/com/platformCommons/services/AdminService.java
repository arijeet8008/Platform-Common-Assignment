package com.platformCommons.services;

import com.platformCommons.exceptions.AdminException;
import com.platformCommons.model.Admin;
import com.platformCommons.model.AdminDto;

public interface AdminService {

	public Admin addAdmin(AdminDto adminDto)throws AdminException;
	
}
