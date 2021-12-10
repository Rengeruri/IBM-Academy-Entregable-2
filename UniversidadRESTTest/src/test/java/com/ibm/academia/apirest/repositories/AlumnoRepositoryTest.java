package com.ibm.academia.apirest.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.entities.Alumno;
import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.entities.Persona;

@DataJpaTest
public class AlumnoRepositoryTest {
	
	@Autowired
	@Qualifier("repositorioAlumnos")
	private PersonaRepository alumnoRepository;
	
	@Autowired
	private CarreraRepository carreraRepository;
	
	@Test
	@DisplayName("Test: Buscar alumno por nombre de la carrera")
	void buscarAlumnoPorNombreCarrera() {
		
		Iterable<Persona> personas = alumnoRepository.saveAll(
				Arrays.asList(DatosDummy.alumno01(),
						DatosDummy.alumno02(),
						DatosDummy.alumno03()));
		
		Carrera carrera = carreraRepository.save(DatosDummy.carrera01());
		personas.forEach(alumno -> ((Alumno)alumno).setCarrera(carrera));
		alumnoRepository.saveAll(personas);
		
		String nombreCarrera = "Ingenieria en Sistemas";
		List<Persona> expected = (List<Persona>) ((AlumnoRepository)alumnoRepository).buscarAlumnoPorNombreCarrera(nombreCarrera);
		
		assertThat(expected.size() == 3).isTrue();
		
	}
	
	@Test
	@DisplayName("Test: Buscar alumno por nombre de la carrera sin valores	")
	void buscarAlumnoPorNombreCarreraSinValores() {
		
		Iterable<Persona> personas = alumnoRepository.saveAll(
				Arrays.asList(DatosDummy.alumno01(),
						DatosDummy.alumno02(),
						DatosDummy.alumno03()));
		
		Carrera carrera = carreraRepository.save(DatosDummy.carrera01());
		personas.forEach(alumno -> ((Alumno)alumno).setCarrera(carrera));
		alumnoRepository.saveAll(personas);
		
		String nombreCarrera = "Ingenieria en Alimentos";
		List<Persona> expected = (List<Persona>) ((AlumnoRepository)alumnoRepository).buscarAlumnoPorNombreCarrera(nombreCarrera);
		
		assertThat(expected.isEmpty()).isTrue();
		
	}

}
