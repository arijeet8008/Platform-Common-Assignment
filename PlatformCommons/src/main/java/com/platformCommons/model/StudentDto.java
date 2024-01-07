//package com.platformCommons.model;
//
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//public class StudentDto {
//
//	@NotNull
//	@Email
//	private String email;
//
//	@NotNull
//	@Size(min = 8, max = 15, message = "Password should be minimum 8 and maximum 15 characters long")
//	private String password;
//
//	@NotNull
//	@Size(min = 3, max = 15, message = "Name should be minimum 3 and maximum 15 characters long")
//	private String name;
//
//	@NotNull
//	private AddressDto address;
//	
//}
