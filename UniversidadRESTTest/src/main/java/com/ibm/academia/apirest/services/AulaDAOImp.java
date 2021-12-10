package com.ibm.academia.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.apirest.entities.Aula;
import com.ibm.academia.apirest.enums.Pizarron;
import com.ibm.academia.apirest.repositories.AulaRepository;

@Service
public class AulaDAOImp extends GenericoDAOImp<Aula, AulaRepository> implements AulaDAO{

	@Autowired
	public AulaDAOImp(AulaRepository repository) {
		super(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Aula> findByPizzaron(Pizarron pizzaron) {
		return repository.findByPizzaron(pizzaron);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Aula> findByPabellonNombre(String nombrePabellon) {
		return repository.findByPabellonNombre(nombrePabellon);
	}

	@Override
	@Transactional(readOnly = true)
	public Aula findByNumeroAula(Integer numeroAula) {
		return repository.findByNumeroAula(numeroAula);
	}

}
