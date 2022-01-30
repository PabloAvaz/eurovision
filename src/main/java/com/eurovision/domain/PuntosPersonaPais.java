package com.eurovision.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PUNTOS_PERSONA_PAIS")
@Data
@NoArgsConstructor
public class PuntosPersonaPais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PP_VOTO_ID")
	Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "PP_PERSONA")
	Persona persona;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "PP_PAIS")
	Pais pais;
	
	@Column(name="PP_PUNTOS")
	Integer puntos;

	public PuntosPersonaPais(Persona persona, Pais pais, Integer puntos) {
		this.persona = persona;
		this.pais = pais;
		this.puntos = puntos;
	}

}
