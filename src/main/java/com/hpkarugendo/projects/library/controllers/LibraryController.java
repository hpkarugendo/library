package com.hpkarugendo.projects.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibraryController {
	
	@GetMapping({"/", "projects/library"})
	public String library() {
		return "projects/library/index";
	}

}
