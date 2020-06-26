package com.atenea.models;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
public class NoCliente extends Usuario{
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;

	public NoCliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NoCliente(List<String> roles) {
		super();
		this.roles = roles;
	}

	public NoCliente(long idusuario, String nombre, String apellido, 	
			String email, String contrasena,List<String> roles) {
		super(idusuario, nombre, apellido, email, contrasena);
		this.roles = roles;
		// TODO Auto-generated constructor stub
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
}
