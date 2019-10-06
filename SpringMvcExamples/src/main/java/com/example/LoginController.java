package com.example;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	/*
	 * @RequestMapping("/validate") public String validatePage(HttpServletRequest
	 * req, Model m) { System.out.println("Inside validate page"); String userName =
	 * req.getParameter("user"); String pwd = req.getParameter("pass");
	 * if(pwd.equals("mani")) { String message = "Hello "+userName;
	 * m.addAttribute("message", message); return "welcome"; } else { String message
	 * = "You have enetered incorrect password";
	 * req.getSession().setAttribute("message", message);
	 * //m.addAttribute("message", message); return "error"; } }
	 */
	
	@RequestMapping(value = "/validate",method = RequestMethod.POST)
	public String validatePage(@RequestParam("user") String uname,@RequestParam("pass") String pass, Model m) {
		System.out.println("Inside validate page");
		String userName = uname;
		String pwd = pass;
		if(pwd.equals("mani")) {
			String message = "Hello "+userName;
			m.addAttribute("message", message);
			return "welcome";
		}
		else {
			String message = "You have enetered incorrect password";			
			m.addAttribute("message", message);
			return "error";
		}
	}
}
