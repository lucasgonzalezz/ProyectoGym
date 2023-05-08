package com.hibernate.model;

/**
 * Rutina: Datos de la rutina.
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
@Table(name = "rutina")
public class Rutina {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fk_idCliente")
	private int idCliente;
	private String nombreCliente;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fk_idEjercicio")
	private int idEjercicio;
	private String nombreEjercicio;

	/**
	 * Constructor.
	 */

	public Rutina() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param idCliente
	 * @param idEjercicio
	 */

	public Rutina(int idCliente, int idEjercicio) {
		super();
		this.idCliente = idCliente;
		this.idEjercicio = idEjercicio;
	}

	/**
	 * Getter.
	 * 
	 * @return idCliente: Devuelve el ID del cliente.
	 */

	public int getIdCliente() {
		return idCliente;
	}

	/**
	 * Setter.
	 * 
	 * @param idCliente: Establece el valor de ID del cliente.
	 */

	void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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

	void setIdEjercicio(int idEjercicio) {
		this.idEjercicio = idEjercicio;
	}

	/**
	 * Getter.
	 * 
	 * @return nombreCliente: Devuelve el nombre del cliente.
	 */

	public String getNombreCliente() {
		return nombreCliente;
	}

	/**
	 * Setter.
	 * 
	 * @param nombreCliente: Establece el nombre del cliente.
	 */

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	/**
	 * Getter.
	 * 
	 * @return nombreEjercicio: Devuelve el nombre del ejercicio.
	 */

	public String getNombreEjercicio() {
		return nombreEjercicio;
	}

	/**
	 * Setter.
	 * 
	 * @param nombreEjercicio: Establece el nombre del ejercicio.
	 */

	public void setNombreEjercicio(String nombreEjercicio) {
		this.nombreEjercicio = nombreEjercicio;
	}

}
