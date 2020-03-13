package com.atenea;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserServiceRest {
	
	/**
	* Lista de ejemplo de usuarios
	*/
	private static List<User> listaUsuarios = new ArrayList<User>() {
		{
			add(new User("Rosa", "Marfil"));
			add(new User("Pepito", "Grillo"));
			add(new User("Manuela", "Lago"));
		}
	};
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
    public List<User>  getUsers(){
        return listaUsuarios;
    }
}
