package com.curso.model;

public class Formacion {

	private String nombreCurso;
	private Integer numAsignaturas;
	private Double precio;

	public Formacion(String nombreCurso, Integer numAsignaturas, Double precio) {
		super();
		this.nombreCurso = nombreCurso;
		this.numAsignaturas = numAsignaturas;
		this.precio = precio;
	}

	public Formacion() {
		super();
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public Integer getNumAsignaturas() {
		return numAsignaturas;
	}

	public void setNumAsignaturas(Integer numAsignaturas) {
		this.numAsignaturas = numAsignaturas;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}
