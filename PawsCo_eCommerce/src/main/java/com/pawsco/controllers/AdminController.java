package com.pawsco.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.pawsco.business.User;

@Controller
public class AdminController {
	
	@GetMapping("admin")
	private String checkAdmin(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		System.out.println(user);
		
		if(user.getIsAdmin()) {
			return "admin";
		}else {
			return "home";
		}
		
		
	}
}
