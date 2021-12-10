package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.entities.Aula;
import com.ibm.academia.apirest.enums.Pizarron;

public interface AulaDAO extends GenericoDAO<Aula>{
	
	public Iterable<Aula> findByPizzaron(Pizarron pizzaron);
	public Iterable<Aula> findByPabellonNombre(String nombrePabellon);
	public Aula findByNumeroAula(Integer numeroAula);
	
}
