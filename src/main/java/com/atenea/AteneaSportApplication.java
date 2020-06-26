package com.atenea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class AteneaSportApplication {

	public static void main(String[] args) {
		SpringApplication.run(AteneaSportApplication.class, args);
	}
	
	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("/sobre")
	public String principal(Model model) {
		return "about";
	}
	
}
