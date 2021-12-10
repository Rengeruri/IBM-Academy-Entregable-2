package com.ibm.academia.apirest.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.entities.Profesor;

@DataJpaTest
public class ProfesorRepositoryTest {
	
	@Autowired
	@Qualifier("repositorioProfesores")
	private PersonaRepository profesorRepository;
	
	@Test
	@DisplayName("Test: Buscar profesores por nombre carrera")
	void findProfesoresByCarrera(){
		//Given
		Profesor profesor = (Profesor) DatosDummy.profesor01();
		profesor.setCarreras(Set.of(new Carrera(null, "Ingenieria en Sistemas", 49, 5)));
		profesorRepository.save(profesor);

		
		//Where
		List<Persona> expected = (List<Persona>) ((ProfesorRepository) profesorRepository).findProfesoresByCarrera("Ingenieria en Sistemas");
		
		//Then
		assertThat(expected.size() == 1).isTrue();
		
	}

}
