package com.ibm.academia.apirest.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.entities.Profesor;
import com.ibm.academia.apirest.repositories.ProfesorRepository;

public class ProfesorDAOImpTest {
	
	ProfesorDAO profesorDao;
	ProfesorRepository profesorRepository;
	
	@BeforeEach
	void setUp() {
		profesorRepository = mock(ProfesorRepository.class);
		profesorDao = new ProfesorDAOImp(profesorRepository);
	}
	
	@Test
	@DisplayName("Test: Buscar profesor por el nombre de la carrera")
	void findProfesoresByCarrera() {
		//Given
		String nombreCarrera = "Ingenieria en dormir";
		Profesor profesor = (Profesor) DatosDummy.profesor01();
		profesor.setCarreras(Set.of(new Carrera(null, nombreCarrera, 30, 10)));
		when(profesorRepository.findProfesoresByCarrera(nombreCarrera)).thenReturn(Arrays.asList(profesor, DatosDummy.profesor02()));
		
		//Where
		List<Persona> expected = (List<Persona>) profesorRepository.findProfesoresByCarrera(nombreCarrera);
		
		//Then
		assertThat(expected.get(0)).isEqualTo((Persona)profesor);
		
		verify(profesorRepository).findProfesoresByCarrera(nombreCarrera);
		
	}

}
