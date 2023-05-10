package com.hibernate.model;

import java.util.ArrayList;
import java.util.List;

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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "rutina")
public class Rutina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRutina;
	@Column(name = "repeticionesReales")
	private int repeticionesReales;
	@Column(name = "diaSemana")
	private String diaSemana;

	@ManyToMany
	@JoinTable(name = "Rutina_Ejercicio", joinColumns = @JoinColumn(name = "fk_idEjercicio"), inverseJoinColumns = @JoinColumn(name = "fk_idCliente"))
	private List<Cliente> clientes = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "Rutina_Cliente", joinColumns = @JoinColumn(name = "fk_idCliente"), inverseJoinColumns = @JoinColumn(name = "fk_idEjercicio"))
	private List<Ejercicio> ejercicios = new ArrayList<>();

	private String nombreCliente;
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

	public Rutina(List<Cliente> clientes, List<Ejercicio> ejercicios, int repeticionesReales, String diaSemana) {
		super();
		this.clientes = clientes;
		this.ejercicios = ejercicios;
		this.repeticionesReales = repeticionesReales;
		this.diaSemana = diaSemana;
	}

	/**
	 * Getter.
	 * 
	 * @return idCliente: Devuelve el ID del cliente.
	 */

	public List<Cliente> getCliente() {
		return clientes;
	}

	/**
	 * Setter.
	 * @param clientes 
	 * 
	 * @param idCliente: Establece el valor de ID del cliente.
	 */

	public void setCliente(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	/**
	 * Getter.
	 * 
	 * @return idEjercicio: Devuelve el ID del ejercicio.
	 */

	public List<Ejercicio> getEjercicio() {
		return ejercicios;
	}

	/**
	 * Setter.
	 * 
	 * @param idEjercicio: Establece el valor de ID del ejercicio.
	 */

	public void setEjercicio(List<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
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
	
	/**
	 * Getter.
	 * 
	 * @return repeticionesReales: Devuelve el número de repeticones reales que ha realizado.
	 */

	public int getRepeticionesReales() {
		return repeticionesReales;
	}

	/**
	 * Setter.
	 * 
	 * @param repeticionesReales: Establece el número real de repeticiones que ha realizado.
	 */

	public void setRepeticionesReales(int repeticionesReales) {
		this.repeticionesReales = repeticionesReales;
	}
	
	/**
	 * Getter.
	 * 
	 * @return diaSemana: Devuelve el día de la semana.
	 */

	public String getDiaSemana() {
		return diaSemana;
	}

	/**
	 * Setter.
	 * 
	 * @param diaSemana: Establece el día de la semana.
	 */

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

}
