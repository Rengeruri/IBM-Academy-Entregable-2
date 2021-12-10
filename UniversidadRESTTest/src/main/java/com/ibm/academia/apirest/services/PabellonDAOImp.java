package com.ibm.academia.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.apirest.entities.Pabellon;
import com.ibm.academia.apirest.repositories.PabellonRepository;

@Service
public class PabellonDAOImp extends GenericoDAOImp<Pabellon, PabellonRepository> implements PabellonDAO{

	@Autowired
	public PabellonDAOImp(PabellonRepository repository) {
		super(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Pabellon findByNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Pabellon> findByDireccionLocalidad(String nombre) {
		return repository.findByDireccionLocalidad(nombre);
	}

}
