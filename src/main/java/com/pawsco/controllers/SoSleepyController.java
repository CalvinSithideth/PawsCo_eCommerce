package com.pawsco.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("addressForm")
public class SoSleepyController {

	@GetMapping
	public String sooooTired() {
		return "addressFormPage";
	}
}
