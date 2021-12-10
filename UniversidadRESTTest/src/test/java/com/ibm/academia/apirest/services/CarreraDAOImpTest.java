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
import com.ibm.academia.apirest.entities.Direccion;
import com.ibm.academia.apirest.entities.Profesor;
import com.ibm.academia.apirest.repositories.CarreraRepository;

public class CarreraDAOImpTest {
	
	CarreraDAO carreraDao;
	CarreraRepository carreraRepository;
	
	@BeforeEach
	void setUp() {
		carreraRepository = mock(CarreraRepository.class);
		carreraDao = new CarreraDAOImp(carreraRepository);
	}
	
	@Test
	@DisplayName("Test: Encontrar carrera por cantidad de años")
	void findByCantidadAnios() {
		//Given
		Integer anios = 4;
		when(carreraRepository.findByCantidadAnios(anios)).thenReturn(Arrays.asList(DatosDummy.carrera01(), DatosDummy.carrera02()));
		
		//Where
		List<Carrera> expected = (List<Carrera>) carreraRepository.findByCantidadAnios(anios);
		
		//Then
		assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01());
		
		verify(carreraRepository).findByCantidadAnios(anios);
		
	}
	
	@Test
	@DisplayName("Test: Buscar carreras por nombre")
	void findCarrerasByNombreContains() {
		//Given
		String nombre = "Ingenieria";
		when(carreraRepository.findCarrerasByNombreContains(nombre)).thenReturn(Arrays.asList(DatosDummy.carrera01(), DatosDummy.carrera03()));
		
		//Where
		List<Carrera> expected = (List<Carrera>) carreraDao.findCarrerasByNombreContains(nombre);
		
		//Then
		assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01());
		assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera03());
		
		verify(carreraRepository).findCarrerasByNombreContains(nombre);
		
	}
	
	@Test
	@DisplayName("Test: Buscar carreras por nombre No case Sensitive")
	void findCarrerasByNombreContainsIgnoreCase() 
	{
	    //Given
	    String nombre = "ingenieria";
	    when(carreraRepository.findCarrerasByNombreContainsIgnoreCase(nombre))
	            .thenReturn(Arrays.asList(DatosDummy.carrera01(), DatosDummy.carrera03()));
	    //When
	    List<Carrera> expected = (List<Carrera>) carreraDao.findCarrerasByNombreContainsIgnoreCase(nombre);
	     //Then
	    assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01());	     assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera03());

	    verify(carreraRepository).findCarrerasByNombreContainsIgnoreCase(nombre);
	}
	 
	@Test
	@DisplayName("Test: Buscar Carreras despues de N años")
	void findCarrerasByCantidadAniosAfter() 
	{
	    //Given
	    Integer cantidad = 4;
	    when(carreraRepository.findCarrerasByCantidadAniosAfter(cantidad))
	            .thenReturn(Arrays.asList(DatosDummy.carrera01(), DatosDummy.carrera03()));
	    //When
	    List<Carrera> expected = (List<Carrera>) carreraDao.findCarrerasByCantidadAniosAfter(cantidad);

	    //Then
	    assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01());
	    assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera03());

	    verify(carreraRepository).findCarrerasByCantidadAniosAfter(cantidad);
	}
	
	@Test
	@DisplayName("Test: Buscar carreras por nombre y apellido del profesor")
	void buscarCarrerasPorProfesorNombreYApellido() {
		//Given
		Carrera carrera = DatosDummy.carrera01();
		carrera.setProfesores(Set.of(new Profesor(null, "Steve", "Jobs", "01800", new Direccion(), 100.5)));
		when(carreraRepository.buscarCarrerasPorProfesorNombreYApellido("Steve", "Jobs")).thenReturn(Arrays.asList(carrera, DatosDummy.carrera03()));
		
		//Where
		List<Carrera> expected = (List<Carrera>) carreraRepository.buscarCarrerasPorProfesorNombreYApellido("Steve", "Jobs");
		
		//Then
		assertThat(expected.get(0)).isEqualTo(carrera);
		
		verify(carreraRepository).buscarCarrerasPorProfesorNombreYApellido("Steve", "Jobs");
	}

}
