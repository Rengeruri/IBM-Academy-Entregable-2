package com.ibm.academia.apirest.entities;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "profesores")
@PrimaryKeyJoinColumn(name = "persona_id")
@Setter
@Getter
@NoArgsConstructor
public class Profesor extends Persona{

	@Column(name = "sueldo")
	private Double sueldo;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinTable(
			name = "profesor_carrera",
			joinColumns = @JoinColumn(name = "profesor_id"),
			inverseJoinColumns = @JoinColumn(name = "carrera_id")
	)
	private Set<Carrera> carreras;
	
	public Profesor(Integer id, String nombre, String apellido, String identificacion, Direccion direccion, Double sueldo) {
		super(id, nombre, apellido, identificacion, direccion);
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return super.toString() + "\tProfesor [sueldo=" + sueldo + "]";
	}



	private static final long serialVersionUID = 6212454084535480124L;

}
