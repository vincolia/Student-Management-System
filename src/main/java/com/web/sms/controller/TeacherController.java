package com.web.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.sms.model.Teacher;
import com.web.sms.repository.TeacherRepository;

@Controller
@RequestMapping("/admin/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@GetMapping
	public String showAllTeachers(Model model) {
		
		model.addAttribute("teachers", teacherRepository.findAll());
		
		return "teacher/index_teacher_list";
	}
	
	@PostMapping("/save")
	public String saveTeacher(Teacher teacher) {
		
		teacherRepository.save(teacher);
		
		return "redirect:/admin/teacher";
	}
	
	@GetMapping("/new")
	public String showCreateNewTeacherForm(Model model) {
		
		model.addAttribute("teacher", new Teacher());
		
		return "teacher/createOrUpdate_teacher";
	}
	
	@GetMapping("/edit/{id}")
	public String showEditTeacherForm(@PathVariable("id") int id,
									Model model) {
		
		model.addAttribute("teacher", teacherRepository.findById(id).get());
		
		return "teacher/createOrUpdate_teacher";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTeacher(@PathVariable("id") int id) {
		
		teacherRepository.deleteById(id);
		
		return "redirect:/admin/teacher";
	}

}
