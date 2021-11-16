package uc.us_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/uc")
public class HomeController {

	@GetMapping
	public String mensaje() {
		return "Este es una prueba";
	}
}
