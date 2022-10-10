package com.web.sms.repository;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.web.sms.model.Student;
import com.web.sms.model.Subject;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class StudentRepositoryTest {
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	void testAddSubject() {
		// Constructor String code, name, units
		Subject addIt = new Subject("IT01", "IT Fundamentals 01", 3);
		Subject addCprog = new Subject("CPROG01", "Computer Progamming 01", 3);
		Subject addCic = new Subject("CIC01", "Introduction to Computing 01", 3);
		
		entityManager.persist(addIt);
		entityManager.persist(addCprog);
		entityManager.persist(addCic);
	}
	
	@Test
	void testCreateNewStudentsAddOneSubject() {
		/* Constructor String firstName, lastName, LocalDate dob, gender, address, 
		 * 					email, contactNumber, gradeLevel, course, courseTitle
		*/
		Subject subject = entityManager.find(Subject.class, 1);
		
		LocalDate dob = LocalDate.of(1999, 02, 22);
		
		Student student = new Student("Kokomi", "Sangonomiya", dob , "Female", "Watatsumi Island",
							"sangonomiya@gmail.com", "09123456789", "1st Year", "BSIT", 
							"Bachelor of Science in Information Technology");
		
		student.addSubject(subject);
		
		studentRepository.save(student);		
	}
	
	@Test
	void testCreateNewStudentsAddTwoSubject() {
		Subject subject = entityManager.find(Subject.class, 1);
		Subject subject2 = entityManager.find(Subject.class, 2);
		
		LocalDate dob = LocalDate.of(1999, 9, 28);
		
		Student student = new Student("Ayaka", "Kamisato", dob , "Female", "Narukami Island",
							"ayaya@gmail.com", "09123456789", "1st Year", "BSIT", 
							"Bachelor of Science in Information Technology");
		
		student.addSubject(subject);
		student.addSubject(subject2);
		
		studentRepository.save(student);
	}
	
	@Test
	void testAddSubjectToExistingStudent() {
		Student student = studentRepository.findById(2).get();
		Subject subject = entityManager.find(Subject.class, 3);
		
		student.addSubject(subject);
	}
	
	@Test
	void testGetStudent() {
		Student student = studentRepository.findById(2).get();
		
		entityManager.detach(student);
		
		System.out.println(student.getId());
		System.out.println(student.getFirstName() + " " + student.getLastName());
	}
}
