package com.bharath.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bharath.lms.model.Student;
import com.bharath.lms.repos.StudentRepo;

@Controller
public class StudentController {

	@Autowired
	private StudentRepo stdrepo;
	
	@GetMapping("/")
	public String listBooks(Model model) {
		model.addAttribute("student", stdrepo.findAll());
		return "student";

	}
	
	@GetMapping("/book/new")
	public String showCreateForm(Model model) {
		Student std = new Student();
		model.addAttribute("student",std);
		return "create_book";
		
	}
	
	@PostMapping("/books")
	public String saveBook(Student std) {
		stdrepo.save(std);
		return "redirect:/";
		
	}
	
	
	
	
	
}
