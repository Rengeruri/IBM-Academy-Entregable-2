package com.ibm.academia.apirest.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.entities.Pabellon;
import com.ibm.academia.apirest.repositories.PabellonRepository;

public class PabellonDAOImpTest {
	
	PabellonDAO pabellonDao;
	PabellonRepository pabellonRepository;
	
	@BeforeEach
	void setUp() {
		pabellonRepository = mock(PabellonRepository.class);
		pabellonDao = new PabellonDAOImp(pabellonRepository);
	}
	
	@Test
	@DisplayName("Test: Buscar pabellon por nombre")
	void findByNombre() {
		//Given
		String nombrePabellon = "Pabellon guapos";
		when(pabellonRepository.findByNombre(nombrePabellon)).thenReturn(DatosDummy.pabellon01());
		
		//Where
		Pabellon expected = pabellonRepository.findByNombre(nombrePabellon);
		
		//Then
		assertThat(expected).isEqualTo(DatosDummy.pabellon01());
		
		verify(pabellonRepository).findByNombre(nombrePabellon);
		
	}

}
