package com.web.sms.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student extends Person{
	
	@Column(length = 20)
	private String gradeLevel;
	
	@Column(length = 10)
	private String course;
	
	@Column(length = 100)
	private String courseTitle;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(
			name = "student_subject",
			joinColumns = @JoinColumn(name = "student_id"),
			inverseJoinColumns = @JoinColumn(name = "subject_id"))
	private Set<Subject> subjects = new HashSet<>();
	
	public Student() {
		
	}

	public Student(String firstName, String lastName, LocalDate dob, String gender, 
			String address, String email, String contactNumber, String gradeLevel, 
			String course, String courseTitle) {
		
		super(firstName, lastName, dob, gender, address, email, contactNumber);
		this.gradeLevel = gradeLevel;
		this.course = course;
		this.courseTitle = courseTitle;

	}

	public String getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	
	public void addSubject(Subject subject) {
		this.subjects.add(subject);
	}
	
	public void removeSubject(Subject subject) {
		this.subjects.remove(subject);
	}
}
