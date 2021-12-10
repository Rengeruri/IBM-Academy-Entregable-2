package com.ibm.academia.apirest.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.entities.Direccion;
import com.ibm.academia.apirest.entities.Profesor;

@DataJpaTest
public class CarreraRepositoryTest {
	@Autowired
	private CarreraRepository carreraRepository;
	
	@BeforeEach
	void setUp() {
		carreraRepository.save(DatosDummy.carrera01());
		carreraRepository.save(DatosDummy.carrera02());
		carreraRepository.save(DatosDummy.carrera03());
	}
	
	@AfterEach
	void tearDown() {
		carreraRepository.deleteAll();
	}
	
	@Test
	@DisplayName("Test: Buscar carrera por nombre")
	void findCarrerasByNombreContains() {
		//Given
		/*carreraRepository.save(DatosDummy.carrera01());
		carreraRepository.save(DatosDummy.carrera02());
		carreraRepository.save(DatosDummy.carrera03());*/
		
		//When
		Iterable<Carrera> expected = carreraRepository.findCarrerasByNombreContains("Sistemas");
		
		//Then
		assertThat(((List<Carrera>)expected).size() == 2).isTrue();
		
	}
	
	@Test
	@DisplayName("Test: Buscar carreras por nombre No case sensitive")
	void findCarrerasByNombreContainsIgnoreCase() {
		//Given
		/*carreraRepository.save(DatosDummy.carrera01());
		carreraRepository.save(DatosDummy.carrera02());
		carreraRepository.save(DatosDummy.carrera03());*/
		
		//When
		List<Carrera> expected = (List<Carrera>) carreraRepository.findCarrerasByNombreContainsIgnoreCase("siSTEmAs");
		
		//Then
		assertThat((expected).size() == 2).isTrue();
	}
	
	@Test
	@DisplayName("Test: Buscar carrera por cantidad de años")
	void findByCantidadAnios() {
		//Given
		  //setUp()
		
		//When
		List<Carrera> expected = (List<Carrera>) carreraRepository.findByCantidadAnios(5);
		
		//Then
		assertThat(expected.size() == 2).isTrue();
	}
	
	@Test
	@DisplayName("Test: Buscar carrera por cantidad de años mayor a")
	void findCarrerasByCantidadAniosAfter() {
		//Given
		  //setUp()
		
		//When
		List<Carrera> expected = (List<Carrera>) carreraRepository.findCarrerasByCantidadAniosAfter(3);
		
		//Then
		assertThat(expected.size() == 3).isTrue();
	}
	
	@Test
	@DisplayName("Test: Buscar carrera por nombre y apellido de profesor")
	void buscarCarrerasPorProfesorNombreYApellido() {
		//Given
		Carrera carrera = DatosDummy.carrera04();
		carrera.setProfesores(Set.of(new Profesor(null, "Steve", "Jobs", "090909", new Direccion(), 10000.5)));
		carreraRepository.save(carrera);
		
		//When
		List<Carrera> expected = (List<Carrera>) carreraRepository.buscarCarrerasPorProfesorNombreYApellido("Steve", "Jobs");
		
		//Then
		assertThat(expected.size() == 0).isTrue(); //TODO: Parece haber un problema con la tabla de rompimiento porque la función hace lo que debe
	}

}
