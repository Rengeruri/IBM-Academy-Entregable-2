package com.ibm.academia.apirest.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.enums.TipoEmpleado;

@DataJpaTest
public class EmpleadoRepositoryTest {
	
	@Autowired 
	@Qualifier("repositorioEmpleados")
	private PersonaRepository empleadoRepository;

	
	@Test
	@DisplayName("Test: Buscar por tipo de empleado")
	void findEmpleadoByTipoEmpleado() {
		//Given
		empleadoRepository.save(DatosDummy.empleado01());
		
		//When
		List<Persona> expected = (List<Persona>) ((EmpleadoRepository) empleadoRepository).findEmpleadoByTipoEmpleado(TipoEmpleado.ADMINISTRATIVO);
		
		//Then
		assertThat(expected.size() == 1).isTrue();
	}

}
