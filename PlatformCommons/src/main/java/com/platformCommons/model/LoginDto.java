package com.platformCommons.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginDto {

	private String email;
	
	private String password;
	
	private UserType userType;
	
}
