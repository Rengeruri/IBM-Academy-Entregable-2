package com.ibm.academia.apirest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ibm.academia.apirest.entities.Pabellon;

@Repository
public interface PabellonRepository extends CrudRepository<Pabellon, Integer>{
	
	public Iterable<Pabellon> findByDireccionLocalidad(String nombre);
	public Pabellon findByNombre(String nombre);
	
}
