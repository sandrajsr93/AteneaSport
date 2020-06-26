package com.atenea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atenea.models.Formulario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormularioRepository extends JpaRepository <Formulario, Long>{
	
	@SuppressWarnings("unchecked")
	Formulario save(Formulario formulario);

}
