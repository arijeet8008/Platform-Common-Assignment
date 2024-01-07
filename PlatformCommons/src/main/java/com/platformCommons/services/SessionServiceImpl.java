package com.platformCommons.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platformCommons.exceptions.SessionException;
import com.platformCommons.model.Session;
import com.platformCommons.repo.SessionRepo;

@Service
public class SessionServiceImpl implements SessionService{
	
	@Autowired
	private SessionRepo sRepo;

	@Override
	public Session getSessionByKey(String key) throws SessionException {

		Session currentSession = sRepo.findBySessionKey(key);
		
		if(currentSession == null)
			throw new SessionException("No session fouund with that session key");
		
		return currentSession;

	}

}
