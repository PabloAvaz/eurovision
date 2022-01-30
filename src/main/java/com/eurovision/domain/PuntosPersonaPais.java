package com.eurovision.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "PUNTOS_PERSONA_PAIS")
@Data
public class PuntosPersonaPais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PP_VOTO_ID")
	Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PP_PERSONA")
	Persona persona;
	
	@OneToOne
	@JoinColumn(name = "PP_PAIS")
	Pais pais;
	
	@Column(name="PP_PUNTOS")
	Integer puntos;

}
