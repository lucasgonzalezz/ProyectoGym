package com.hibernate.model;

/**
 * Entrenador: Datos del entrenador.
 * 
 * @author Lucas & Laura
 * @version 25/05/2023
 *
 */

import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "entrenador")
public class Entrenador {

	@Id
	@Column(name = "idEntrenador", updatable = false)
	private int idEntrenador;
	@Column(name = "nombreEntrenador")
	private String nombreEntrenador;
	@Column(name = "apellidosEntrenador")
	private String apellidosEntrenador;
	@Column(name = "edad")
	private int edad;
	@Column(name = "titulacion")
	private String titulacion;
	@Column(name = "contraseña")
	private String contraseña;

	@Fetch(FetchMode.JOIN)
	@ManyToMany // (cascade = CascadeType.ALL)
	@JoinTable(name = "entrenador_clase", joinColumns = @JoinColumn(name = "idEntrenador"), inverseJoinColumns = @JoinColumn(name = "idClase"))
	private List<Clase> clases = new ArrayList<Clase>();

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

	public Entrenador(String nombreEntrenador, String apellidosEntrenador, int edad, String titulacion,
			String contraseña) {
		super();
		this.nombreEntrenador = nombreEntrenador;
		this.apellidosEntrenador = apellidosEntrenador;
		this.edad = edad;
		this.titulacion = titulacion;
		this.contraseña = contraseña;
	}

	/*
	 * Getter
	 * 
	 * @return idEntrenador: Devuelve el ID del entrenador
	 */
	public int getIdEntrenador() {
		return idEntrenador;
	}

	/*
	 * Setter
	 * 
	 * @param idEntrenador: Establece el valor de ID  del entrenador
	 */
	public void setIdEntrenador(int idEntrenador) {
		this.idEntrenador = idEntrenador;
	}

	/*
	 * Getter
	 * 
	 * @return nombreEntrenador: Devuelve el nombre del entrenador
	 */
	public String getNombreEntrenador() {
		return nombreEntrenador;
	}

	/*
	 * Setter
	 * 
	 * @param nombreEntrenador: Establece el valor del nombre del entrenador
	 */
	public void setNombreEntrenador(String nombreEntrenador) {
		this.nombreEntrenador = nombreEntrenador;
	}

	/*
	 * Getter
	 * 
	 * @return apellidosEntrenador: Devuelve los apellidos del entrenador
	 */
	public String getApellidosEntrenador() {
		return apellidosEntrenador;
	}

	/*
	 * Setter
	 * 
	 * @param apellidoEntrenador: Establece el valor de los apellidos  del entrenador
	 */
	public void setApellidosEntrenador(String apellidosEntrenador) {
		this.apellidosEntrenador = apellidosEntrenador;
	}

	/*
	 * Getter
	 * 
	 * @return edad: Devuelve la edad del entrenador
	 */
	public int getEdad() {
		return edad;
	}

	/*
	 * Setter
	 * 
	 * @param edad: Establece el valor de la edad  del entrenador
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/*
	 * Getter
	 * 
	 * @return titulacion: Devuelve la titulacion del entrenador
	 */
	public String getTitulacion() {
		return titulacion;
	}

	/*
	 * Setter
	 * 
	 * @param titulacion: Establece el valor de la titulacion  del entrenador
	 */
	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	/*
	 * Getter
	 * 
	 * @return contraseña: Devuelve la contraseña del entrenador
	 */
	public String getContraseña() {
		return contraseña;
	}

	/*
	 * Setter
	 * 
	 * @param contrasela: Establece el valor de la contraseña del entrenador
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	/*
	 * Getter
	 * 
	 * @return clases: Devuelve una lista de las clases del entrenador
	 */
	public List<Clase> getClases() {
		return clases;
	}

	/*
	 * Setter
	 * 
	 * @param clases: Establece una lista de las calses del entrenador
	 */
	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	/*
	 * Añade una clase a un entrenador
	 */
	public void anyadirClase(Clase c) {
		this.clases.add(c);
		c.getEntrenador().add(this);
	}

	/*
	 * Quita una clase a un entrenador
	 */
	public void quitarClase(Clase c) {
		this.clases.remove(c);
		c.getEntrenador().remove(this);
	}

}