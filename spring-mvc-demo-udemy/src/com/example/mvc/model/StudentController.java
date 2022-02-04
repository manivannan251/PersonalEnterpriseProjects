package com.example.mvc.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {	
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		Student theStudent = new Student();
		
		model.addAttribute("student", theStudent);
		return "student-form";
	}
	
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		
		System.out.println("The student first name is "+student.getFirstName());
		System.out.println("The student last name is "+student.getLastName());
		return "student-confirmation";
	}

}
