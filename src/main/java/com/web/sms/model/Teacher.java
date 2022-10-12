package com.web.sms.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Teacher extends Person{
	
	@Column(length = 50)
	public String department;
	
	@OneToMany(mappedBy = "teacher")
	private Set<Subject> subjects = new HashSet<>();

	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	
	public String getFullName() {
		
		return getFirstName() + " " + getLastName();
	}
	
}
