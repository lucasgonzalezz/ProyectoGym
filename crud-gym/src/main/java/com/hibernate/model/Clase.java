package com.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

/**
 * Cliente: Datos del cliente.
 * 
 * @author Lucas & Laura
 * @version 08/05/2023
 *
 */

@Entity
@Table(name = "clase")
public class Clase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idClase")
	private int idClase;
	@Column(name = "lugar")
	private String lugar;
	@Column(name = "tope")
	private int tope;
	@Column(name = "nombreClase")
	private String nombreClase;
	
	/**
	 * Constructor.
	 */

	public Clase() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param nombreCliente
	 * @param apellidos
	 * @param edad
	 * @param altura
	 * @param peso
	 */

	public Clase(int idClase, String lugar, int tope, String nombreClase) {
		super();
		this.idClase = idClase;
		this.lugar = lugar;
		this.tope = tope;
		this.nombreClase = nombreClase;
	}

	public int getIdClase() {
		return idClase;
	}

	public void setIdClase(int idClase) {
		this.idClase = idClase;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public int getTope() {
		return tope;
	}

	public void setTope(int tope) {
		this.tope = tope;
	}

	public String getNombreClase() {
		return nombreClase;
	}

	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}	

}