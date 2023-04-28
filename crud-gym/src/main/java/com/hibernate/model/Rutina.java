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
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fk_idEjercicio")
	private int idEjercicio;

	public Rutina() {
		super();
	}

	public Rutina(int idCliente, int idEjercicio) {
		super();
		this.idCliente = idCliente;
		this.idEjercicio = idEjercicio;
	}

	int getIdCliente() {
		return idCliente;
	}

	void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	int getIdEjercicio() {
		return idEjercicio;
	}

	void setIdEjercicio(int idEjercicio) {
		this.idEjercicio = idEjercicio;
	}

}
