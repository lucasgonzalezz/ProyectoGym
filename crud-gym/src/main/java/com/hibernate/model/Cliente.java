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
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idCliente")
	private int idCliente;
	@Column(name = "nombreCliente")
	private String nombreCliente;
	@Column(name = "apellidos")
	private String apellidos;
	@Column(name = "edad")
	private int edad;
	@Column(name = "altura")
	private double altura;
	@Column(name = "peso")
	private double peso;
	
	@Fetch(FetchMode.JOIN)
	@ManyToMany    //(cascade = CascadeType.ALL)
	@JoinTable(
			name="cliente_ejercicio",  //Se crea automaticamente...
			joinColumns = @JoinColumn(name = "idCliente"),
		    inverseJoinColumns = @JoinColumn(name = "idEjercicio")
			  )
	private List<Ejercicio> ejercicios=new ArrayList<Ejercicio>();
	
	/**
	 * Constructor.
	 */

	public Cliente() {
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

	public Cliente(String nombreCliente, String apellidos, int edad, double altura, double peso) {
		super();
		this.nombreCliente = nombreCliente;
		this.apellidos = apellidos;
		this.edad = edad;
		this.altura = altura;
		this.peso = peso;
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

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * Getter.
	 * 
	 * @return nombreCliente: Devuelve el Nombre del cliente.
	 */

	public String getNombreCliente() {
		return nombreCliente;
	}

	/**
	 * Setter.
	 * 
	 * @param nombreCliente: Establece el valor del Nombre del cliente.
	 */

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	/**
	 * Getter.
	 * 
	 * @return apellidos: Devuelve los Apellidos del cliente.
	 */

	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Setter.
	 * 
	 * @param apellidos: Establece el valor de los Apellidos del cliente.
	 */

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Getter.
	 * 
	 * @return edad: Devuelve la edad del cliente.
	 */

	public int getEdad() {
		return edad;
	}

	/**
	 * Setter.
	 * 
	 * @param edad: Establece el valor de la edad del cliente.
	 */

	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Getter.
	 * 
	 * @return altura: Devuelve la altura del cliente.
	 */

	public double getAltura() {
		return altura;
	}

	/**
	 * Setter.
	 * 
	 * @param altura: Establece el valor de la altura del cliente.
	 */

	public void setAltura(double altura) {
		this.altura = altura;
	}

	/**
	 * Getter.
	 * 
	 * @return peso: Devuelve el peso del cliente.
	 */

	public double getPeso() {
		return peso;
	}

	/**
	 * Setter.
	 * 
	 * @param peso: Establece el valor del peso del cliente.
	 */

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public List<Ejercicio> getEjercicios() {
		return ejercicios;
	}

	public void setEjercicios(List<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}
	
	public void anyadirEjercicio(Ejercicio e) {
		this.ejercicios.add(e);
		e.getClientes().add(this);
	}
	
	public void quitarEjercicio(Ejercicio e) {
		
		this.ejercicios.removeIf(ejercicio -> (e.getIdEjercicio()==ejercicio.getIdEjercicio()));
		e.getClientes().remove(this);
	}

}