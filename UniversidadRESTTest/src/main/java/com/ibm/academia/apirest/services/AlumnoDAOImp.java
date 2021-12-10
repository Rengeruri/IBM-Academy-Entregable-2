package com.ibm.academia.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.repositories.AlumnoRepository;
import com.ibm.academia.apirest.repositories.PersonaRepository;

@Service
public class AlumnoDAOImp extends PersonaDAOImp implements AlumnoDAO{

	@Autowired
	public AlumnoDAOImp(@Qualifier("repositorioAlumnos")PersonaRepository repository) {
		super(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Persona> buscarAlumnoPorNombreCarrera(String nombre) {
		return ((AlumnoRepository)repository).buscarAlumnoPorNombreCarrera(nombre);
	}
	

}
