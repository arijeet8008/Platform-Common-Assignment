package com.platformCommons.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platformCommons.exceptions.AdminException;
import com.platformCommons.model.Admin;
import com.platformCommons.model.AdminDto;
import com.platformCommons.repo.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepo aRepo;

	@Override
	public Admin addAdmin(AdminDto adminDto) throws AdminException {
		if(aRepo.findByEmail(adminDto.getEmail()) != null)
			throw new AdminException("Admin already present with the email:-"+adminDto.getEmail());
		
		Admin admin = new Admin();
		
		admin.setEmail(adminDto.getEmail());
		admin.setPassword(adminDto.getPassword());
		admin.setName(adminDto.getName());
		
		return aRepo.save(admin);
	}

}
