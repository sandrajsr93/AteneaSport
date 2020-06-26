package com.atenea.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity 
public class Formulario {
	
	@Id 
	@GeneratedValue (strategy = GenerationType.AUTO) 
	private long idformulario;
	private String edad;
	private String altura;
	private String peso;
	private String enfermedad;
	private String si_alimentos;
	private String no_alimentos;
	
	@OneToOne()
	private Usuario usuario;
	
	public Formulario() {};
	
	public Formulario(long idformulario, String edad, String altura, String peso, String enfermedad,
			String si_alimentos, String no_alimentos) {
		super();
		this.idformulario = idformulario;
		this.edad = edad;
		this.altura = altura;
		this.peso = peso;
		this.enfermedad = enfermedad;
		this.si_alimentos = si_alimentos;
		this.no_alimentos = no_alimentos;
	}

	public long getIdformulario() {
		return idformulario;
	}

	public void setIdformulario(long idformulario) {
		this.idformulario = idformulario;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	public String getSi_alimentos() {
		return si_alimentos;
	}

	public void setSi_alimentos(String si_alimentos) {
		this.si_alimentos = si_alimentos;
	}

	public String getNo_alimentos() {
		return no_alimentos;
	}

	public void setNo_alimentos(String no_alimentos) {
		this.no_alimentos = no_alimentos;
	}
}
