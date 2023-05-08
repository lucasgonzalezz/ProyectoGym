package com.hibernate.model;

/**
 * Ejercicio: Datos del ejercicio.
 * 
 * @author Lucas & Laura
 * @version 08/05/2023
 *
 */

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

	/**
	 * Constructor.
	 */

	public Ejercicio() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param nombreEjercicio
	 * @param numeroSeries
	 * @param numeroRepeticiones
	 * @param cargaKg
	 */

	public Ejercicio(String nombreEjercicio, int numeroSeries, int numeroRepeticiones, double cargaKg) {
		super();
		this.nombreEjercicio = nombreEjercicio;
		this.numeroSeries = numeroSeries;
		this.numeroRepeticiones = numeroRepeticiones;
		this.cargaKg = cargaKg;
	}

	/**
	 * Getter.
	 * 
	 * @return idEjercicio: Devuelve el ID del ejercicio.
	 */

	public int getIdEjercicio() {
		return idEjercicio;
	}

	/**
	 * Setter.
	 * 
	 * @param idEjercicio: Establece el valor de ID del ejercicio.
	 */

	public void setIdEjercicio(int idEjercicio) {
		this.idEjercicio = idEjercicio;
	}

	/**
	 * Getter.
	 * 
	 * @return nombreEjercicio: Devuelve el Nombre del ejercicio.
	 */

	public String getNombreEjercicio() {
		return nombreEjercicio;
	}

	/**
	 * Setter.
	 * 
	 * @param nombreEjercicio: Establece el Nombre del ejercicio.
	 */

	public void setNombreEjercicio(String nombreEjercicio) {
		this.nombreEjercicio = nombreEjercicio;
	}

	/**
	 * Getter.
	 * 
	 * @return numeroSeries: Devuelve el Numero de series del ejercicio.
	 */

	public int getNumeroSeries() {
		return numeroSeries;
	}

	/**
	 * Setter.
	 * 
	 * @param numeroSeries: Establece el Numero de series del ejercicio.
	 */

	public void setNumeroSeries(int numeroSeries) {
		this.numeroSeries = numeroSeries;
	}

	/**
	 * Getter.
	 * 
	 * @return numeroRepeticiones: Devuelve el valor del Numero de repeticiones del
	 *         ejercicio.
	 */

	public int getNumeroRepeticiones() {
		return numeroRepeticiones;
	}

	/**
	 * Setter.
	 * 
	 * @param numeroRepeticiones: Establece el valor del Numero de repeticiones del
	 *                            ejercicio.
	 */

	public void setNumeroRepeticiones(int numeroRepeticiones) {
		this.numeroRepeticiones = numeroRepeticiones;
	}

	/**
	 * Getter.
	 * 
	 * @return cargaKg: Devuelve el valor de la Carga en Kg del ejercicio.
	 */

	public double getCargaKg() {
		return cargaKg;
	}

	/**
	 * Setter.
	 * 
	 * @param cargaKg: Establece el valor de la Carga en Kg del ejercicio.
	 */

	public void setCargaKg(double cargaKg) {
		this.cargaKg = cargaKg;
	}

}
