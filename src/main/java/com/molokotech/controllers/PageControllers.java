package com.molokotech.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageControllers {
	@GetMapping("/index")
	public String indexOne() {
		return "index";
	}
	
	@GetMapping("/")
	public String indexTwo() {
		return "index";
	}
}
