package com.platformCommons.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Session {

	@Id
	private Integer userId;
	
	private UserType userType;
	
	private LocalDateTime timeStamp;
	
	private String sessionKey;
	
}
