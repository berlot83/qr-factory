package com.molokotech.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("errorMsg", "Usuario o Password incorrectos.");

		if (logout != null)
			model.addAttribute("msg", "Saliste.");
		//PrintName.printUser(model);
		return "login"; /* login */
	}
	
	@GetMapping("/bulk-factory")
	public String bulkFactory() {
		return "bulk-factory";
	}
}
