package com.web.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.sms.model.Student;
import com.web.sms.repository.StudentRepository;
import com.web.sms.repository.SubjectRepository;

@Controller
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;

	public StudentController(StudentRepository studentRepository, SubjectRepository subjectRepository) {
		super();
		this.studentRepository = studentRepository;
		this.subjectRepository = subjectRepository;
	}
	
	@GetMapping("/admin/student/home")
	public String showAllStudent(Model model) {
		model.addAttribute("students", studentRepository.findAll());
		
		return "index_student_list";
	}
	
	@GetMapping("/admin/student/new")
	public String showCreateNewStudentForm(Model model) {
		model.addAttribute("student", new Student());
		
		return "create_update_student";
	}
	
	@PostMapping("/new/student/save")
	public String saveStudent(Student student) {
		studentRepository.save(student);
		
		return "redirect:/admin/student/home";
	}
	
	@GetMapping("/student/edit/{id}")
	public String showEditStudentForm(@PathVariable("id") int id, Model model) {
		
		//studentRepository.findById(id).ifPresent(edit -> model.addAttribute("student", edit));
		
		model.addAttribute("student", studentRepository.findById(id).get());
		
		return "create_update_student";
	}
	
	@GetMapping("/student/profile/{id}")
	public String showStudentProfile(@PathVariable("id") int id, Model model) {
		
		model.addAttribute("student", studentRepository.findById(id).get());
		
		return "student_profile";
	}
	
	@GetMapping("/student/profile/add/{id}")
	public String showAddSubjectToStudent(@PathVariable("id") int id, Model model) {
		
		model.addAttribute("student", studentRepository.findById(id).get());
		
		// List all subject
		model.addAttribute("listAllSubject", subjectRepository.findAll());
		
		return "student_profile_add_subject";
	}
	
	@GetMapping("admin/student/delete/{id}")
	public String removeStudent(@PathVariable("id") int id) {
		studentRepository.deleteById(id);
		
		return "redirect:/admin/student/home";
	}

}
