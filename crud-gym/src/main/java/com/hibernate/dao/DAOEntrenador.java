package com.hibernate.dao;

/**
 * DAOEntrenador: Contiene las acciones de Entrenador contra la BD.
 * 
 * @author Lucas & Laura
 * @version 25/05/2023
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
	 * Función para seleccionar un entrenador mediante su id.
	 * 
	 * @param id: Id del entrenador.
	 * @return entrenador seleccionado.
	 */

	public static Entrenador selectEntrenadorById(int id) {

		Transaction transaction = null;
		Entrenador entrenador = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			entrenador = session.get(Entrenador.class, id);
			transaction.commit();
		} catch (Exception e1) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return entrenador;
	}

	/**
	 * Función para insertar un entrenador en la BD.
	 * 
	 * @param e: Objeto entrenador con todos sus atributos.
	 */

	public static void insertEntrenador(Entrenador entrenador) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(entrenador);
			transaction.commit();
		} catch (Exception e1) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/**
	 * Función para actualizar un entrenador en la BD.
	 * 
	 * @param e: Objeto entrenador con todos sus atributos.
	 */

	public static void updateEntrenador(Entrenador entrenador) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.merge(entrenador);
			transaction.commit();
		} catch (Exception e1) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/**
	 * Función para eliminar un entrenador en la BD.
	 * 
	 * @param id: Id del entrenador.
	 */

	public static void deleteEntrenador(int id) {
		Transaction transaction = null;
		Entrenador entrenador = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			entrenador = session.get(Entrenador.class, id);
			session.remove(entrenador);
			transaction.commit();
		} catch (Exception e1) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/**
	 * Función para mostrar todos los entrenador almacenados en la BD.
	 * 
	 * @return entrenador: Lista de todos los entrenador que contiene la BD.
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
	
	/**
	 * Función para seleccionar un entrenador en concreto mediante su nombre.
	 * 
	 * @return ent: Devuelve el nombre del entrenador que coincide con el parametro
	 *         pasado.
	 */

	public static Entrenador selectEntrenador(String entrenador) {

		Transaction transaction = null;
		Entrenador ent = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query<Entrenador> query = session.createQuery("FROM Entrenador WHERE nombreEntrenador=:entrenador",
					Entrenador.class);
			query.setParameter("entrenador", entrenador);
			ent = query.uniqueResult();
		} catch (Exception e1) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return ent;
	}
	
	/**
	 * Función para seleccionar un entrenador en concreto mediante su nombre y contraseña.
	 * 
	 * @return ent: Devuelve el nombre del entrenador y la contrseña que coincide con el parametro
	 *         pasado.
	 * @return null: Devuelve el null en caso de no coincidir con el parametro pasado.
	 */

	public Entrenador selectEntrenadorByUserAndPasswd(String nombre, String contraseña) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query<Entrenador> query = session.createQuery(
					"FROM Entrenador WHERE nombreEntrenador = :entrenador AND contraseña = :contra", Entrenador.class);
			query.setParameter("entrenador", nombre);
			query.setParameter("contra", contraseña);
			Entrenador ent = query.uniqueResult();
			return ent;
		} catch (Exception e1) {
		}
		return null;
	}
	
	/**
	 * Función para averiguar si existe en entrenador en la BD.
	 * 
	 * @return existe: Devuelve true or false dependiendo si existe o no el entrenador en la BD.
	 */

	public boolean existeEntrenador(Entrenador entrenador) {
		Transaction transaction = null;
		boolean existe = false;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query<Entrenador> query = session.createQuery(
					"from Entrenador where lower(trim(nombreEntrenador)) = lower(trim(:nombre)) "
							+ "and lower(trim(apellidosEntrenador)) = lower(trim(:apellidos))"
							+ "and edad = :edad and lower(trim(titulacion)) = lower(trim(:titulacion)) and lower(trim(contraseña)) = lower(trim(:contraseña))",
					Entrenador.class);
			query.setParameter("nombre", entrenador.getNombreEntrenador());
			query.setParameter("apellidos", entrenador.getApellidosEntrenador());
			query.setParameter("edad", entrenador.getEdad());
			query.setParameter("titulacion", entrenador.getTitulacion());
			query.setParameter("contraseña", entrenador.getContraseña());
			existe = query.uniqueResult() != null;
			transaction.commit();
		} catch (Exception e1) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return existe;
	}

}
