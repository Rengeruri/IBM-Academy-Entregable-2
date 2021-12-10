package com.ibm.academia.apirest.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
public abstract class Persona implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre", nullable = false, length = 60)
	private String nombre;
	@Column(name = "apellido", nullable = false, length = 60)
	private String apellido;
	@Column(name = "identificacion", nullable = false, unique = true, length = 10)
	private String identificacion;
	@Column(name = "fecha_alta")
	private Date fechaAlta;
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "codigoPostal", column = @Column(name = "codigo_postal")),
		@AttributeOverride(name = "departamento", column = @Column(name = "departamento"))
	})
	private Direccion direccion;
	
	public Persona(Integer id, String nombre, String apellido, String identificacion, Direccion direccion) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.identificacion = identificacion;
		this.direccion = direccion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, identificacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(id, other.id) && Objects.equals(identificacion, other.identificacion);
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", identificacion="
				+ identificacion + "]";
	}
	
	@PrePersist
	private void antesPersistir() {
		this.fechaAlta = new Date();
	}
	@PreUpdate
	private void antesActualizar() {
		this.fechaModificacion = new Date();
	}
	
	private static final long serialVersionUID = 452603984251805406L;

}
