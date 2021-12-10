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
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.enums.TipoEmpleado;
import com.ibm.academia.apirest.repositories.EmpleadoRepository;

public class EmpleadoDAOImpTest {
	
	EmpleadoDAO empleadoDao;
	EmpleadoRepository empleadoRepository;
	
	@BeforeEach
	void setUp() {
		empleadoRepository = mock(EmpleadoRepository.class);
		empleadoDao = new EmpleadoDAOImp(empleadoRepository);
	}
	
	@Test
	@DisplayName("Test: Buscar empleado por tipo")
	void findEmpleadoByTipoEmpleado() {
		//Given
		when(empleadoRepository.findEmpleadoByTipoEmpleado(TipoEmpleado.ADMINISTRATIVO)).thenReturn(Arrays.asList(DatosDummy.empleado01(), DatosDummy.empleado02()));
		
		//Where
		List<Persona> expected = (List<Persona>) empleadoRepository.findEmpleadoByTipoEmpleado(TipoEmpleado.ADMINISTRATIVO);
		
		//Then
		assertThat(expected.get(0)).isEqualTo(DatosDummy.empleado01());
		
		verify(empleadoRepository).findEmpleadoByTipoEmpleado(TipoEmpleado.ADMINISTRATIVO);
	}
	
}
