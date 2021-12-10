package com.ibm.academia.apirest.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "alumnos")
@PrimaryKeyJoinColumn(name = "persona_id")
@NoArgsConstructor
@Getter
@Setter
public class Alumno extends Persona{
	
	@ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "carrera_id")
	private Carrera carrera;
	
	public Alumno(Integer id, String nombre, String apellido, String identificacion, Direccion direccion) {
		super(id, nombre, apellido, identificacion, direccion);
	}
	
	@Override
	public String toString() {
		return super.toString() + "\tAlumno []";
	}

	private static final long serialVersionUID = 282135527639709536L;

}
