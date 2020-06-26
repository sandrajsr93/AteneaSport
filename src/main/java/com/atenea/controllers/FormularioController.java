package com.atenea.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.atenea.models.Formulario;
import com.atenea.repositories.*;

@Controller
public class FormularioController {

	@Autowired
	private FormularioRepository formularioRepository;
	
	@RequestMapping(value = "/formulario", method = RequestMethod.POST)
	public String login (@RequestParam String edad, @RequestParam String altura,
			@RequestParam String peso,@RequestParam String enfermedad,
			@RequestParam String si_alimentos,
			@RequestParam String no_alimentos) {
		
			Formulario nuevoFormulario = new Formulario (0, edad, altura, peso,
															enfermedad, si_alimentos, no_alimentos);
			
			//ESCRIBIR EN UN MAIL
			
			formularioRepository.save(nuevoFormulario);
			return "redirect:/index.html";
			
	}
	
}
