package com.eurovision.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PAIS")
@Data
public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PA_ID", nullable = false)
	Integer id;
	
	@Column(name = "PA_NOMBRE", unique = true, nullable = false)
	String nombre;
	
	@Column(name = "PA_ACTIVO", columnDefinition = "BOOL DEFAULT TRUE", nullable = false)
	Boolean activo;

	public Pais() {
		this.activo = Boolean.TRUE;
	}
	
	public Pais(String nombre) {
		this();
		this.nombre = nombre;
	}

}
