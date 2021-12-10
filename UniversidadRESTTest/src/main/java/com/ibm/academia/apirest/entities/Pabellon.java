package com.ibm.academia.apirest.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pabellones")
@Setter
@Getter
@NoArgsConstructor
public class Pabellon implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "tamano_metros")
	private Double tamanoMetros;
	@Column(name = "nombre", unique = true, nullable = false)
	private String nombre;
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
	
	@OneToMany(mappedBy = "pabellon", fetch = FetchType.LAZY)
	private Set<Aula> aulas;
	
	public Pabellon(Integer id, Double tamanoMetros, String nombre, Direccion direccion) {
		this.id = id;
		this.tamanoMetros = tamanoMetros;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pabellon other = (Pabellon) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "Pabellon [id=" + id + ", tamanoMetros=" + tamanoMetros + ", nombre=" + nombre + "]";
	}
	
	@PrePersist
	private void antesPersistir()
	{
		this.fechaAlta = new Date();
	}
	
	@PreUpdate
	private void antesActualizar()
	{
		this.fechaModificacion = new Date();
	}

	private static final long serialVersionUID = 5895151497921997034L;
	
}
