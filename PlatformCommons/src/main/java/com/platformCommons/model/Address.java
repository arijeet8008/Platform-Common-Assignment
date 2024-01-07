package com.platformCommons.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	
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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Student student;
	
}
