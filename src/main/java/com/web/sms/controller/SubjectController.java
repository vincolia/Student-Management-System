package com.web.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.sms.model.Subject;
import com.web.sms.repository.SubjectRepository;

@Controller
public class SubjectController {
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@GetMapping("/admin/subjects")
	public String showAllSubjects(Model model) {
		model.addAttribute("subjects", subjectRepository.findAll());
		
		return "subjects/index_subject_list";
	}
	
	@GetMapping("/admin/subject/new") 
	public String createSubjectForm(Model model){
		
		model.addAttribute("subject", new Subject());
		
		return "subjects/createOrUpdate_Subject";
	}
	
	@PostMapping("/admin/subjects/save")
	public String saveSubject(Subject subject) {
		subjectRepository.save(subject);
		
		return "redirect:/admin/subjects";
	}
	
	@GetMapping("/subjects/edit/{id}")
	public String editSubjectForm(@PathVariable("id") int id,
								Model model) {
		
		model.addAttribute("subject", subjectRepository.findById(id).get());
		
		return "subjects/createOrUpdate_Subject";
	}
	
	/*
	@GetMapping("/subject/delete/{id}")
	public String deleteSubjectById(@PathVariable("id") int id) {
		subjectRepository.deleteById(id);
		
		return "redirect:/admin/subjects";
	}
	*/

}
