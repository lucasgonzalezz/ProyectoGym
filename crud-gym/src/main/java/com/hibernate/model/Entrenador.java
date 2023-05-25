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


//TODO COMENTAR LAURA (Toda la clase)

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

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	public void anyadirClase(Clase c) {
		this.clases.add(c);
		c.getEntrenador().add(this);
	}

	public void quitarClase(Clase c) {
		this.clases.remove(c);
		c.getEntrenador().remove(this);
	}

}