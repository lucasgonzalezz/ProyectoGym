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
import com.hibernate.util.HibernateUtil;

import jakarta.persistence.TypedQuery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class DAOEjercicio {

	/**
	 * Función para seleccionar un ejercicio mediante su id.
	 * 
	 * @param id: Id del ejercicio.
	 * @return ejercicio seleccionado.
	 */

	public static Ejercicio selectEjercicioById(int id) {

		Transaction transaction = null;
		Ejercicio e = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			e = session.get(Ejercicio.class, id);
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

	public static void insertEjercicio(Ejercicio e) {
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

	public static void updateEjercicio(Ejercicio e) {
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

	public static void deleteEjercicio(int id) {
		Transaction transaction = null;
		Ejercicio e = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			e = session.get(Ejercicio.class, id);
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

	public static List<Ejercicio> selectAllEjercicios() {
		Transaction transaction = null;
		List<Ejercicio> ejercicios = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			ejercicios = session.createQuery("FROM Ejercicio", Ejercicio.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return ejercicios;
	}

	public static Ejercicio selectEjercicio(String ejer) {

		Transaction transaction = null;
		Ejercicio e = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query<Ejercicio> query = session.createQuery("FROM Ejercicio WHERE nombreEjercicio=:ejercicio", Ejercicio.class);
			query.setParameter("ejercicio", ejer);
			e = query.uniqueResult();
		} catch (Exception e1) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return e;
	}
	
}
