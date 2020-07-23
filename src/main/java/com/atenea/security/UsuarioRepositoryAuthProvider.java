package com.atenea.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.atenea.models.Cliente;
import com.atenea.repositories.ClienteRepository;



@Component
public class UsuarioRepositoryAuthProvider implements AuthenticationProvider{

	@Autowired
	private ClienteRepository userRepository;
		
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
			
		String email = auth.getName();//getEmail

		Cliente user = userRepository.findByEmail(email);
	 
		if (user == null) {
			 throw new BadCredentialsException("Usuario no encontrado");
		}
		 
		String password = (String) auth.getCredentials();
		 if (!new BCryptPasswordEncoder().matches(password, user.getPasswordHash())) {
			 throw new BadCredentialsException("Contraseña erronera");
		}
	
		List<GrantedAuthority> roles = new ArrayList<>();
		 
		String role = user.getRoles();
		roles.add(new SimpleGrantedAuthority(role));
		 
		return new UsernamePasswordAuthenticationToken(user.getEmail(), password, roles);
}	
	
	@Override
	public boolean supports(Class<?> authenticationObject) {
		return true;
	}
	
}

