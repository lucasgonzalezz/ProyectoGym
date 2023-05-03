package com.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

	public Cliente() {
		super();
	}

	public Cliente(String nombreCliente, String apellidos, int edad, double altura, double peso) {
		super();
		this.nombreCliente = nombreCliente;
		this.apellidos = apellidos;
		this.edad = edad;
		this.altura = altura;
		this.peso = peso;
	}

	public int getId() {
		return idCliente;
	}

	public void setId(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

}