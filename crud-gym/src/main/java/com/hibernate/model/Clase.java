package com.hibernate.model;

/**
 * Clase: Datos de la clase.
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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;


@Entity
@Table(name = "clase")
public class Clase {

	@Id
	@Column(name = "idClase", updatable = false)
	private int idClase;
	@Column(name = "lugar")
	private String lugar;
	@Column(name = "tope")
	private int tope;
	@Column(name = "nombreClase")
	private String nombreClase;

	@Fetch(FetchMode.JOIN)
	@ManyToMany // (cascade = CascadeType.ALL)
	@JoinTable(name = "entrenador_clase", joinColumns = @JoinColumn(name = "idClase"), inverseJoinColumns = @JoinColumn(name = "idEntrenador"))
	private List<Entrenador> entrenadores = new ArrayList<Entrenador>();

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

	public Clase(String lugar, int tope, String nombreClase) {
		super();
		this.lugar = lugar;
		this.tope = tope;
		this.nombreClase = nombreClase;
	}

	/*
	 * Getter
	 * 
	 * @return idClase: Devuelve el ID de la clase
	 */
	public int getIdClase() {
		return idClase;
	}

	/*
	 * Setter
	 * 
	 * @param: Establece el valor id de la clase
	 */
	public void setIdClase(int idClase) {
		this.idClase = idClase;
	}

	/*
	 * Getter
	 * 
	 * @return lugar: Devuelve el lugar de la clase
	 */
	public String getLugar() {
		return lugar;
	}

	/*
	 * Setter
	 * 
	 * @param: Establece el valor lugar de la clase
	 */
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	/*
	 * Getter
	 * 
	 * @return tope: Devuelve el tope de la clase
	 */
	public int getTope() {
		return tope;
	}

	/*
	 * Setter
	 * 
	 * @param: Establece el valor tope de la clase
	 */
	public void setTope(int tope) {
		this.tope = tope;
	}

	/*
	 * Getter
	 * 
	 * @return nombreClase: Devuelve el nombre de la clase
	 */
	public String getNombreClase() {
		return nombreClase;
	}

	/*
	 * Setter
	 * 
	 * @param: Establece el valor nombre de la clase
	 */
	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}

	/*
	 * Getter
	 * 
	 * @return entrenadores: Devuelve una lista con los entrenadores
	 */
	public List<Entrenador> getEntrenador() {
		return entrenadores;
	}

	/*
	 * Setter
	 * 
	 *@param entrenadores: Establece los entrenadores de la clase
	 */
	public void setEntrenador(List<Entrenador> entrenadores) {
		this.entrenadores = entrenadores;
	}

	/*
	 * Añade entrenadores a la clase
	 */
	public void anyadirEntrenador(Entrenador e) {
		this.entrenadores.add(e);
		e.getClases().add(this);
	}

	/*
	 * Quita los entradores de la clase
	 */
	public void quitarEntrenador(Entrenador e) {
		this.entrenadores.removeIf(entrenador -> (e.getIdEntrenador() == entrenador.getIdEntrenador()));
		e.getClases().remove(this);
	}

}