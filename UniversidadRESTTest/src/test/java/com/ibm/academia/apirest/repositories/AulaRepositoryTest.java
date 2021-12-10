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
import com.ibm.academia.apirest.entities.Aula;
import com.ibm.academia.apirest.entities.Direccion;
import com.ibm.academia.apirest.entities.Pabellon;
import com.ibm.academia.apirest.enums.Pizarron;

@DataJpaTest
public class AulaRepositoryTest {
	
	@Autowired
	private AulaRepository aulaRepository;
	
	@BeforeEach
	void setUp() {
		aulaRepository.save(DatosDummy.aula01());
		aulaRepository.save(DatosDummy.aula02());
	}
	
	@AfterEach
	void tearDown() {
		aulaRepository.deleteAll();
	}
	
	@Test
	@DisplayName("Test: Encontrar aula por tipo pizarron")
	void findByPizzaron() {
		//Given
		  //setUp()
		
		//Where
		List<Aula> expected = (List<Aula>) aulaRepository.findByPizzaron(Pizarron.PIZARRA_BLANCA);
		
		//Then
		assertThat(expected.size() == 1).isTrue();
	}
	
	@Test
	@DisplayName("Test: Encontrar aula por nombre de pabellon")
	void findByPabellonNombre(){
		//Give
		Aula aula = DatosDummy.aula03();
		aula.setPabellon(new Pabellon(null, 25.5, "Pabellon sexy", new Direccion()));
		aulaRepository.save(aula);
		
		//Where
		List<Aula> expected = (List<Aula>) aulaRepository.findByPabellonNombre("Pabellon sexy");
		
		//Then
		assertThat(expected.size() == 1).isTrue();
	}
	
	@Test
	@DisplayName("Test: Encontrar aula por numero")
	void findByNumeroAula() {
		//Given
		  //setUp()
		
		//Where
		Aula expected = aulaRepository.findByNumeroAula(1);
		
		//Then
		assertThat(expected).isInstanceOf(Aula.class);
	}

}
