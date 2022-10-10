package com.web.sms.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;

@Entity
public class Subject extends BaseEntity{
	
	@Column(length = 50)
	@GeneratedValue
	private String code;
	
	@Column(length = 200)
	private String name;
	
	@Column(length = 3)
	private int units;
	
	@ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "subjects", fetch = FetchType.LAZY)
	private Set<Student> studentEnrolled = new HashSet<>();
	
	public Subject() {

	}

	public Subject(String code, String name, int units) {
		super();
		this.code = code;
		this.name = name;
		this.units = units;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public Set<Student> getStudentEnrolled() {
		return studentEnrolled;
	}

	public void setStudentEnrolled(Set<Student> studentEnrolled) {
		this.studentEnrolled = studentEnrolled;
	}
	
	
}
