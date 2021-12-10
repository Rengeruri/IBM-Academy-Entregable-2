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
import com.ibm.academia.apirest.entities.Aula;
import com.ibm.academia.apirest.enums.Pizarron;
import com.ibm.academia.apirest.repositories.AulaRepository;

public class AulaDAOImpTest {
	
	AulaDAO aulaDao;
	AulaRepository aulaRepository;
	
	@BeforeEach
	void setUp() {
		aulaRepository = mock(AulaRepository.class);
		aulaDao = new AulaDAOImp(aulaRepository);
	}
	
	@Test
	@DisplayName("Test: Buscar aula por tipo pizarron")
	void findByPizzaron() {
		//Given
		when(aulaRepository.findByPizzaron(Pizarron.PIZARRA_TIZA)).thenReturn(Arrays.asList(DatosDummy.aula01(), DatosDummy.aula02()));
		
		//Where
		List<Aula> expected = (List<Aula>) aulaRepository.findByPizzaron(Pizarron.PIZARRA_TIZA);
		
		//Then
		assertThat(expected.get(1)).isEqualTo(DatosDummy.aula02());
		
		verify(aulaRepository).findByPizzaron(Pizarron.PIZARRA_TIZA);
	}
	
	@Test
	@DisplayName("Test: Buscar aula por nombre de pabellon")
	void findByPabellonNombre()	{
		//Given
		String nombrePabellon = "Pabellon feos";
		Aula aula = DatosDummy.aula02();
		aula.setPabellon(DatosDummy.pabellon02());
		
		when(aulaRepository.findByPabellonNombre(nombrePabellon)).thenReturn(Arrays.asList(DatosDummy.aula01(), aula));
		
		//Where
		List<Aula> expected = (List<Aula>) aulaRepository.findByPabellonNombre(nombrePabellon);
		
		//Then
		assertThat(expected.get(1)).isEqualTo(aula);
		
		verify(aulaRepository).findByPabellonNombre(nombrePabellon);
		
	}
	
	@Test
	@DisplayName("Test: Buscar aula por numero")
	void findByNumeroAula() {
		//Given
		Integer numeroAula = 3;
		when(aulaRepository.findByNumeroAula(numeroAula)).thenReturn(DatosDummy.aula03());
		
		//Where
		Aula expected = aulaRepository.findByNumeroAula(numeroAula);
		
		//Then
		assertThat(expected).isEqualTo(DatosDummy.aula03());
		
		verify(aulaRepository).findByNumeroAula(numeroAula);

	}

}
