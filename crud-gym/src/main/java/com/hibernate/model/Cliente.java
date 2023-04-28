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
	private int altura;
	@Column(name = "peso")
	private int peso;

	public Cliente() {
		super();
	}

	public Cliente(int idCliente, String nombreCliente, String apellidos, int edad, int altura, int peso) {
		super();
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.apellidos = apellidos;
		this.edad = edad;
		this.altura = altura;
		this.peso = peso;
	}

	int getId() {
		return idCliente;
	}

	void setId(int idCliente) {
		this.idCliente = idCliente;
	}

	String getNombreCliente() {
		return nombreCliente;
	}

	void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	String getApellidos() {
		return apellidos;
	}

	void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	int getEdad() {
		return edad;
	}

	void setEdad(int edad) {
		this.edad = edad;
	}

	int getAltura() {
		return altura;
	}

	void setAltura(int altura) {
		this.altura = altura;
	}

	int getPeso() {
		return peso;
	}

	void setPeso(int peso) {
		this.peso = peso;
	}

}