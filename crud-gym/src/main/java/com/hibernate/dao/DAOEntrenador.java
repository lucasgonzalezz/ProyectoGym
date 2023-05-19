package com.hibernate.dao;

/**
 * GymDAO: Contiene todas la acciones contra la BD.
 * 
 * @author Lucas & Laura
 * @version 08/05/2023
 *
 */

import com.hibernate.model.Cliente;
import com.hibernate.model.Ejercicio;
import com.hibernate.model.Entrenador;
import com.hibernate.util.HibernateUtil;

import jakarta.persistence.TypedQuery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class DAOEntrenador {

	/**
	 * Función para seleccionar un ejercicio mediante su id.
	 * 
	 * @param id: Id del ejercicio.
	 * @return ejercicio seleccionado.
	 */

	public static Entrenador selectEntrenadorById(int id) {

		Transaction transaction = null;
		Entrenador e = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			e = session.get(Entrenador.class, id);
			transaction.commit();
		} catch (Exception e1) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return e;
	}

	/**
	 * Función para insertar un ejercicio en la base de datos.
	 * 
	 * @param e: Objeto ejercicio con todos sus atributos.
	 */

	public static void insertEntrenador(Entrenador e) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(e);
			transaction.commit();
		} catch (Exception e1) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/**
	 * Función para actualizar un ejercicio en la base de datos.
	 * 
	 * @param e: Objeto ejercicio con todos sus atributos.
	 */

	public static void updateEntrenador(Entrenador e) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.merge(e);
			transaction.commit();
		} catch (Exception e1) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/**
	 * Función para eliminar un ejercicio en la base de datos.
	 * 
	 * @param id: Id del ejercicio.
	 */

	public static void deleteEntrenador(int id) {
		Transaction transaction = null;
		Entrenador e = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			e = session.get(Entrenador.class, id);
			session.remove(e);
			transaction.commit();
		} catch (Exception e1) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/**
	 * Función para mostrar todos los ejercicios almacenados en la BD.
	 * 
	 * @return cliente: Lista de todos los ejercicios que contiene la BD.
	 */

	public static List<Entrenador> selectAllEntrenadores() {
		Transaction transaction = null;
		List<Entrenador> entrenadores = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			entrenadores = session.createQuery("FROM Entrenador", Entrenador.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return entrenadores;
	}

	public static Entrenador selectEntrenador(String entre) {

		Transaction transaction = null;
		Entrenador e = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query<Entrenador> query = session.createQuery("FROM Entrenador WHERE nombreEntrenador=:entrenador", Entrenador.class);
			query.setParameter("entrenador", entre);
			e = query.uniqueResult();
		} catch (Exception e1) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return e;
	}
	
}
