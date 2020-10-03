package com.atenea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atenea.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, String>{
	
	@SuppressWarnings("unchecked")
//	@CacheEvict	(allEntries = true)
	Cliente save(Cliente user);
	
//	@CachePut
	Cliente findByEmail(String email);
	
//	@Cacheable
	Cliente findByNombre(String nombre);
	
	//Cliente findByEmailAndContrasena(String email,String contrasena);
	
////	@CacheEvict
	Cliente findByEmailAndPasswordHash (String email,String contrasena);
	
}
