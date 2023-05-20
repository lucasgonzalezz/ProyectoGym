package com.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Cliente: Datos del cliente.
 * 
 * @author Lucas & Laura
 * @version 08/05/2023
 *
 */

@Entity
@Table(name = "entrenador")
public class Entrenador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idEntrenador")
	private int idEntrenador;
	@Column(name = "nombreEntrenador")
	private String nombreEntrenador;
	@Column(name = "apellidosEntrenador")
	private String apellidosEntrenador;
	@Column(name = "edad")
	private int edad;
	@Column(name = "titulacion")
	private String titulacion;
	
	/**
	 * Constructor.
	 */

	public Entrenador() {
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

	public Entrenador(String nombreEntrenador, String apellidosEntrenador, int edad, String titulacion) {
		super();
		this.nombreEntrenador = nombreEntrenador;
		this.apellidosEntrenador = apellidosEntrenador;
		this.edad = edad;
		this.titulacion = titulacion;
	}	
	
	public int getIdEntrenador() {
		return idEntrenador;
	}

	public void setIdEntrenador(int idEntrenador) {
		this.idEntrenador = idEntrenador;
	}

	public String getNombreEntrenador() {
		return nombreEntrenador;
	}

	public void setNombreEntrenador(String nombreEntrenador) {
		this.nombreEntrenador = nombreEntrenador;
	}

	public String getApellidosEntrenador() {
		return apellidosEntrenador;
	}

	public void setApellidosEntrenador(String apellidosEntrenador) {
		this.apellidosEntrenador = apellidosEntrenador;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

}