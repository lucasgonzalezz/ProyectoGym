package com.hibernate.dao;

/**
 * GymDAO: Contiene las acciones de Cliente contra la BD..
 * 
 * @author Lucas & Laura
 * @version 25/05/2023
 *
 */

import com.hibernate.model.Cliente;
import com.hibernate.model.Ejercicio;
import com.hibernate.util.HibernateUtil;

import jakarta.persistence.TypedQuery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class DAOCliente {

	/**
	 * Función para seleccionar un cliente mediante su id.
	 * 
	 * @param id: Id del cliente.
	 * @return cliente seleccionado.
	 */

	public static Cliente selectClienteById(int id) {

		Transaction transaction = null;
		Cliente c = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			c = session.get(Cliente.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return c;
	}

	/**
	 * Función para insertar un cliente en la base de datos.
	 * 
	 * @param c: Objeto cliente con todos sus atributos.
	 */

	public static void insertCliente(Cliente c) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(c);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/**
	 * Función para actualizar un cliente en la base de datos.
	 * 
	 * @param c: Objeto cliente con todos sus atributos.
	 */

	public static void updateCliente(Cliente c) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.merge(c);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/**
	 * Función para eliminar un cliente en la base de datos.
	 * 
	 * @param id: Id del cliente.
	 */

	public static void deleteCliente(int id) {
		Transaction transaction = null;
		Cliente c = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			c = session.get(Cliente.class, id);
			session.remove(c);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/**
	 * Función para mostrar todos los clientes almacenados en la BD.
	 * 
	 * @return cliente: Lista de todos los cliente que contiene la BD.
	 */

	public static List<Cliente> selectAllClientes() {
		Transaction transaction = null;
		List<Cliente> clientes = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			clientes = session.createQuery("FROM Cliente", Cliente.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return clientes;
	}
	
	/**
	 * Función para seleccionar un cliente en concreto mediante su nombre y contraseña.
	 * 
	 * @return c: Devuelve el nombre del cliente y la contrseña que coincide con el parametro
	 *         pasado.
	 * @return null: Devuelve el null en caso de no coincidir con el parametro pasado.
	 */

	public static Cliente selectCliente(String nom) {

		Transaction transaction = null;
		Cliente c = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query<Cliente> query = session.createQuery("FROM Cliente WHERE nombreCliente=:nombre", Cliente.class);
			query.setParameter("nombre", nom);
			c = query.uniqueResult();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return c;
	}


}
