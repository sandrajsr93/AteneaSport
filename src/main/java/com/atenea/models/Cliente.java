package com.atenea.models;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
public class Cliente extends Usuario{
	
	private String tarifa;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private String roles;

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cliente(long idusuario, String nombre, String apellido, 
					String email, String contrasena,String tarifa, String roles) {
		
		super(idusuario, nombre, apellido, email, contrasena);
		this.tarifa = tarifa;
		this.roles = roles;
		// TODO Auto-generated constructor stub
	}

	public String getTarifa() {
		return tarifa;
	}

	public void setTarifa(String tarifa) {
		this.tarifa = tarifa;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
}
