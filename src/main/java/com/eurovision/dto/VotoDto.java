package com.eurovision.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class VotoDto {
	private Integer id;
	private Integer idPais;
	private String nombrePais;
	private Integer puntos;
}
