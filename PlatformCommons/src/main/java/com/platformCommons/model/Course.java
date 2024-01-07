package com.platformCommons.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseId;
	
	@NotNull
	private String courseDescription;
	
	@NotNull
	private String courseType;
	
	@NotNull
	private Integer courseDuration;
	
	@NotNull
	private String courseTopics;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Student> students;
}
