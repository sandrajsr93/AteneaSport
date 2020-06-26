package com.atenea.models;

import java.util.*;

import javax.persistence.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Usuario {

	@Id 
	@GeneratedValue (strategy = GenerationType.AUTO) 
	private long idusuario;
	private String nombre;
	private String apellido;
//	private String contrasena;
	private String email; 
	private String tarifa;
	private String contrasena;
	
	@OneToOne()
	private Formulario formulario;

	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	
	public Usuario() {}
		
	public Usuario(long idusuario, String nombre, String apellido,  String email, 
					String contrasena) {
		super();
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
//		this.contrasena = contrasena;
		this.contrasena = new BCryptPasswordEncoder().encode(contrasena);
}


	public long getIdusuario() {
		return idusuario;
	}


	public void setIdusuario(long idusuario) {
		this.idusuario = idusuario;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTarifa() {
		return tarifa;
	}


	public void setTarifa(String tarifa) {
		this.tarifa = tarifa;
	}

	public String getPasswordHash() {
		// TODO Auto-generated method stub
		return null;
	}


//	public Usuario (String nombre, String email, String contrasena) {
//		this.nombre = nombre;
//		this.email = email;
//		this.contrasena= contrasena;
////		this.passwordHash = new BCryptPasswordEncoder().encode(passwordHash); 
////		this.roles = new ArrayList<>(Arrays.asList(roles));
//		
//	}


	
	
}
