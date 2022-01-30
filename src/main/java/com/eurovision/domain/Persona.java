package com.eurovision.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "PERSONA")
@Data
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "P_ID")
	Integer id;
	
	@Column(name="P_APODO", unique = true, nullable = false)
	String apodo;
	
	@Column(name="P_NOMBRE")
	String nombre;
	
	@Column(name = "P_ACTIVA", columnDefinition = "BOOL DEFAULT TRUE", nullable = false)
	Boolean activa;
	
	public Persona() {
		this.activa = true;
	}
	
	public Persona(String apodo, String nombre) {
		this();
		this.apodo = apodo;
		this.nombre = nombre;
	}
	
}
