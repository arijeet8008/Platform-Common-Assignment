package com.platformCommons.model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressDto {

	@NotNull
	private String houseNo;
	
	@NotNull
	private String colony;
	
	@NotNull
	private String city;
	
	@NotNull
	private String state;
	
	@NotNull
	private Integer pinCode;
	
	private AddressType addressType;
	
}
