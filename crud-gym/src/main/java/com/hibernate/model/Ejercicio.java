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
	private int cargaKg;

	public Ejercicio() {
		super();
	}

	public Ejercicio(int idEjercicio, String nombreEjercicio, int numeroSeries, int numeroRepeticiones, int cargaKg) {
		super();
		this.idEjercicio = idEjercicio;
		this.nombreEjercicio = nombreEjercicio;
		this.numeroSeries = numeroSeries;
		this.numeroRepeticiones = numeroRepeticiones;
		this.cargaKg = cargaKg;
	}

	int getIdEjercicio() {
		return idEjercicio;
	}

	void setIdEjercicio(int idEjercicio) {
		this.idEjercicio = idEjercicio;
	}

	String getNombreEjercicio() {
		return nombreEjercicio;
	}

	void setNombreEjercicio(String nombreEjercicio) {
		this.nombreEjercicio = nombreEjercicio;
	}

	int getNumeroSeries() {
		return numeroSeries;
	}

	void setNumeroSeries(int numeroSeries) {
		this.numeroSeries = numeroSeries;
	}

	int getNumeroRepeticiones() {
		return numeroRepeticiones;
	}

	void setNumeroRepeticiones(int numeroRepeticiones) {
		this.numeroRepeticiones = numeroRepeticiones;
	}

	int getCargaKg() {
		return cargaKg;
	}

	void setCargaKg(int cargaKg) {
		this.cargaKg = cargaKg;
	}

}
