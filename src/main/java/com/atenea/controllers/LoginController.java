package com.atenea.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.atenea.models.*;
import com.atenea.repositories.ClienteRepository;

@Controller
public class LoginController {
	
//	@GetMapping("/login")
//	public String login() {
//	return "login";
//	}
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login (@RequestParam String email, 
							@RequestParam String pass) {
		
		//Si el usuario esta registrado que te lleve a principal
		if (clienteRepository.findByEmailAndContrasena(email, pass) != null) {
			
//			Usuario nuevoUsuario = new Usuario (0 , null, null, email, pass, null);
//			usuarioRepository.save(nuevoUsuario);
			return "redirect:/index.html";
			
		}else 
			//Si el usuario no esta registrado que te lleve a register
			return "redirect:/register.html";
	}

}
