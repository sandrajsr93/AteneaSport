package com.atenea.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.atenea.models.Cliente;
import com.atenea.repositories.ClienteRepository;

@Controller
public class RegistroContoller {

	@Autowired
	private ClienteRepository clienteRepository;

	@RequestMapping(value = "/registro", method = RequestMethod.POST)
	public String registro (@RequestParam String nombre, 
							@RequestParam String apellidos, @RequestParam String email, 
							@RequestParam String pass) {
		//Si el usuario no esta registrado que te lleve a login
		if (clienteRepository.findByEmailAndPasswordHash(email, pass) == null) {
			//Alta del Cliente
			Cliente nuevoCliente = new Cliente (0 , nombre, apellidos, email, pass, null, "ROLE_CLIENTE");
			clienteRepository.save(nuevoCliente);
			//Mandar un mail avisando que esta registrado
			
			return "redirect:/login.html";
			
		}else 
			//Si el usuario ya esta registrado que te lleve a index
			return "redirect:/index.html";
	}
	
	
}

