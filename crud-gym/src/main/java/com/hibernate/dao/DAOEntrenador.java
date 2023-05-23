package com.hibernate.dao;

import com.hibernate.model.Cliente;

/**
 * GymDAO: Contiene todas la acciones contra la BD.
 * 
 * @author Lucas & Laura
 * @version 08/05/2023
 *
 */

import com.hibernate.model.Entrenador;
import com.hibernate.util.HibernateUtil;
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
		Entrenador ent = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			ent = session.get(Entrenador.class, id);
			transaction.commit();
		} catch (Exception e1) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return ent;
	}

	/**
	 * Función para insertar un ejercicio en la base de datos.
	 * 
	 * @param e: Objeto ejercicio con todos sus atributos.
	 */

	public static void insertEntrenador(Entrenador ent) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(ent);
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

	public static void updateEntrenador(Entrenador ent) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.merge(ent);
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
		Entrenador ent = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			ent = session.get(Entrenador.class, id);
			session.remove(ent);
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
		Entrenador ent = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query<Entrenador> query = session.createQuery("FROM Entrenador WHERE nombreEntrenador=:entrenador",
					Entrenador.class);
			query.setParameter("entrenador", entre);
			ent = query.uniqueResult();
		} catch (Exception e1) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return ent;
	}

	public static Entrenador selectEntrenadorByUserAndPasswd(String nombre, String contraseña) {
		
		Entrenador ent = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query<Entrenador> query = session.createQuery(
					"FROM Entrenador WHERE nombreEntrenador = :entrenador AND contraseña = :contra", Entrenador.class);
			query.setParameter("entrenador", nombre);
			query.setParameter("contra", contraseña);
			ent = query.uniqueResult();

		} catch (Exception e1) {
			return null;
		}
		return ent;

	}

}
