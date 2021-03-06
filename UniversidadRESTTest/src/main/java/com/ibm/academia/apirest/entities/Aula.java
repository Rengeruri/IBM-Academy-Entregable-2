package com.ibm.academia.apirest.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import com.ibm.academia.apirest.enums.Pizarron;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "aulas")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Aula implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "numero_aula", unique = true)
	private Integer numeroAula;
	@Column(name = "medidas")
	private String medidas;
	@Column(name = "cantidad_pupitres")
	private Integer cantidadPupitres;
	@Column(name = "pizarron")
	@Enumerated(EnumType.STRING)
	private Pizarron pizzaron;
	@Column(name = "fecha_alta")
	private Date fechaAlta;
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "pabellon_id", foreignKey = @ForeignKey(name = "FK_PABELLON_ID"))
	private Pabellon pabellon;
	
	public Aula(Integer id, Integer numeroAula, String medidas, Integer cantidadPupitres, Pizarron pizzaron) {
		this.id = id;
		this.numeroAula = numeroAula;
		this.medidas = medidas;
		this.cantidadPupitres = cantidadPupitres;
		this.pizzaron = pizzaron;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, numeroAula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aula other = (Aula) obj;
		return Objects.equals(id, other.id) && Objects.equals(numeroAula, other.numeroAula);
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
	
	private static final long serialVersionUID = -2359298033476451017L;
	
}
