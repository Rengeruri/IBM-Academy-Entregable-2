package com.ibm.academia.apirest.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.entities.Direccion;
import com.ibm.academia.apirest.entities.Pabellon;

@DataJpaTest
public class PabellonRepositoryTest {
	
	@Autowired
	private PabellonRepository pabellonRepository;
	
	@BeforeEach
	void setUp() {
		pabellonRepository.save(DatosDummy.pabellon01());
		pabellonRepository.save(DatosDummy.pabellon02());
	}
	
	@AfterEach
	void tearDown() {
		pabellonRepository.deleteAll();
	}
	
	@Test
	@DisplayName("Test: Encontrar pabellon por la localidad")
	void findByDireccionLocalidad() {
		//Given
		Pabellon pabellon = DatosDummy.pabellon03();
		pabellon.setDireccion(new Direccion("Calle chochos", "70", "08765", "Depa alto", "1", "Localidad grande"));
		pabellonRepository.save(pabellon);
		
		//Where
		List<Pabellon> expected = (List<Pabellon>) pabellonRepository.findByDireccionLocalidad("Localidad grande");
		
		//Then
		assertThat(expected.size() == 1).isTrue();
		
	}
	
	@Test
	@DisplayName("Test: Encontrar pabellon por nombre")
	void findByNombre() {
		//Given
		  //setUp()
		
		//Where
		Pabellon expected = pabellonRepository.findByNombre("Pabellon guapos");
		
		//Then
		assertThat(expected).isInstanceOf(Pabellon.class);
		
	}

}
