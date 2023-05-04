package com.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ejercicio")
public class Ejercicio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idEjercicio")
	private int idEjercicio;
	@Column(name = "nombreEjercicio")
	private String nombreEjercicio;
	@Column(name = "numeroSeries")
	private int numeroSeries;
	@Column(name = "numeroRepeticiones")
	private int numeroRepeticiones;
	@Column(name = "cargaKg")
	private double cargaKg;

	public Ejercicio() {
		super();
	}

	public Ejercicio(String nombreEjercicio, int numeroSeries, int numeroRepeticiones, double cargaKg) {
		super();
		this.nombreEjercicio = nombreEjercicio;
		this.numeroSeries = numeroSeries;
		this.numeroRepeticiones = numeroRepeticiones;
		this.cargaKg = cargaKg;
	}

	public int getIdEjercicio() {
		return idEjercicio;
	}

	public void setIdEjercicio(int idEjercicio) {
		this.idEjercicio = idEjercicio;
	}

	public String getNombreEjercicio() {
		return nombreEjercicio;
	}

	public void setNombreEjercicio(String nombreEjercicio) {
		this.nombreEjercicio = nombreEjercicio;
	}

	public int getNumeroSeries() {
		return numeroSeries;
	}

	public void setNumeroSeries(int numeroSeries) {
		this.numeroSeries = numeroSeries;
	}

	public int getNumeroRepeticiones() {
		return numeroRepeticiones;
	}

	public void setNumeroRepeticiones(int numeroRepeticiones) {
		this.numeroRepeticiones = numeroRepeticiones;
	}

	public double getCargaKg() {
		return cargaKg;
	}

	public void setCargaKg(double cargaKg) {
		this.cargaKg = cargaKg;
	}

}
