package com.Application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//this is a "normal" controller to render the templates to the user

@Controller
public class MainControllers {

	@GetMapping("/listen")
	public String listenMusic() {
		return "front/radio";
	}
	
}
