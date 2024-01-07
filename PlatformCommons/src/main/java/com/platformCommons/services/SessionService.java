package com.platformCommons.services;

import com.platformCommons.exceptions.SessionException;
import com.platformCommons.model.Session;

public interface SessionService {

	public Session getSessionByKey(String key) throws SessionException;
	
}
