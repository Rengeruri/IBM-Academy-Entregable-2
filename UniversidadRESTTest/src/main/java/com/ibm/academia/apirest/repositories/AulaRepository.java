package com.ibm.academia.apirest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.entities.Aula;
import com.ibm.academia.apirest.enums.Pizarron;

@Repository
public interface AulaRepository extends CrudRepository<Aula, Integer>{
	
	public Iterable<Aula> findByPizzaron(Pizarron pizzaron);
	public Iterable<Aula> findByPabellonNombre(String nombrePabellon);
	public Aula findByNumeroAula(Integer numeroAula);
	
}
