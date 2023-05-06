package com.hibernate.model;

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

	public Rutina() {
		super();
	}

	public Rutina(int idCliente, int idEjercicio) {
		super();
		this.idCliente = idCliente;
		this.idEjercicio = idEjercicio;
	}

	public int getIdCliente() {
		return idCliente;
	}

	void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdEjercicio() {
		return idEjercicio;
	}

	void setIdEjercicio(int idEjercicio) {
		this.idEjercicio = idEjercicio;
	}
	
	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	public String getNombreEjercicio() {
		return nombreEjercicio;
	}

	public void setNombreEjercicio(String nombreEjercicio) {
		this.nombreEjercicio = nombreEjercicio;
	}

}
