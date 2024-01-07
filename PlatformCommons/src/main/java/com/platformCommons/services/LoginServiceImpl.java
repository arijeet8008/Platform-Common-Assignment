package com.platformCommons.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platformCommons.exceptions.AdminException;
import com.platformCommons.exceptions.LoginException;
import com.platformCommons.exceptions.StudentException;
import com.platformCommons.model.Admin;
import com.platformCommons.model.LoginDto;
import com.platformCommons.model.Session;
import com.platformCommons.model.Student;
import com.platformCommons.model.UserType;
import com.platformCommons.repo.AdminRepo;
import com.platformCommons.repo.SessionRepo;
import com.platformCommons.repo.StudentRepo;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private SessionRepo sessionRepo;
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Override
	public Session login(LoginDto loginDto) throws LoginException, AdminException, StudentException {
		Session session = null;

		if (loginDto.getUserType() == UserType.ADMIN) {

			Admin admin = adminRepo.findByEmail(loginDto.getEmail());

			if (admin == null)
				throw new AdminException("No Admin found with that email:-" + loginDto.getEmail());

			Integer userId = admin.getAdminId();

			Optional<Session> sessionOpt = sessionRepo.findById(userId);

			if (sessionOpt.isPresent())
				throw new LoginException("User is already logged in. Please logout first and then try to login");

			if (!admin.getPassword().equals(loginDto.getPassword()))
				throw new LoginException("The email and password combination seems incorrect. Please try again");

			String key = RandomString.make(6);

			Session adminSession = new Session();
			adminSession.setSessionKey(key);
			adminSession.setTimeStamp(LocalDateTime.now());
			adminSession.setUserId(admin.getAdminId());
			adminSession.setUserType(UserType.ADMIN);
			session = sessionRepo.save(adminSession);

		}
		
		else if (loginDto.getUserType() == UserType.STUDENT) {

			Student student = studentRepo.findByEmail(loginDto.getEmail());

			if (student == null)
				throw new StudentException("No User found with that email:-" + loginDto.getEmail());

			Integer userId = student.getStudentId();

			Optional<Session> sessionOpt = sessionRepo.findById(userId);

			if (sessionOpt.isPresent())
				throw new LoginException("User is already logged in. Please logout first and then try to login");

			if (!student.getPassword().equals(loginDto.getPassword()))
				throw new LoginException("The email and password combination seems incorrect. Please try again");

			String key = RandomString.make(6);

			Session customerSession = new Session();
			customerSession.setSessionKey(key);
			customerSession.setTimeStamp(LocalDateTime.now());
			customerSession.setUserId(student.getStudentId());
			customerSession.setUserType(UserType.STUDENT);
			session = sessionRepo.save(customerSession);

		}

		return session;
	}

	@Override
	public String logout(Integer userId) throws LoginException {
		
		Session session = sessionRepo.findById(userId)
				.orElseThrow(() -> new LoginException("No user is logged in with that userId:-" + userId));
		sessionRepo.delete(session);
		
		return "User logged out successfully";
	}

}
