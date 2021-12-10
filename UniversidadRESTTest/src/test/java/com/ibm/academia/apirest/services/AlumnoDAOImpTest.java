package com.ibm.academia.apirest.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.entities.Alumno;
import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.repositories.AlumnoRepository;

public class AlumnoDAOImpTest {
	
	AlumnoDAO alumnoDao;
	AlumnoRepository alumnoRepository;
	
	@BeforeEach
	void setUp() {
		alumnoRepository = mock(AlumnoRepository.class);
		alumnoDao = new AlumnoDAOImp(alumnoRepository);
	}
	
	@Test
	@DisplayName("Test: Buscar alumno por el nombre de la carrera")
	void buscarAlumnoPorNombreCarrera() {
		//Given
		String nombreCarrera = "Ingenieria en papitas";
		Alumno alumno = (Alumno) DatosDummy.alumno01();
		alumno.setCarrera(new Carrera(null, nombreCarrera, 10, 20));
		when(alumnoRepository.buscarAlumnoPorNombreCarrera(nombreCarrera)).thenReturn(Arrays.asList(alumno, DatosDummy.alumno02()));
		
		//Where
		List<Persona> expected = (List<Persona>) alumnoRepository.buscarAlumnoPorNombreCarrera(nombreCarrera);
		
		//Then
		assertThat(expected.get(0)).isEqualTo((Persona)alumno);
		
		verify(alumnoRepository).buscarAlumnoPorNombreCarrera(nombreCarrera);
			
	}

}
