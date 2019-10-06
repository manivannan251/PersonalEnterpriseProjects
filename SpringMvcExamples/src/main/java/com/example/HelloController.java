package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	
	  @RequestMapping("/") public String display() {
	  System.out.println("in the index page"); return "index"; }
	 
	
	@RequestMapping("/springboot")
	public String springbootController() {
		System.out.println("Inside Controller");
		return "springboot";
	}
}
