package com.hibernate.dao;

import com.hibernate.model.Clase;
import com.hibernate.model.Cliente;
import com.hibernate.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * DAOClase: Contiene las acciones de Clase contra la BD.
 * 
 * @author Lucas & Laura
 * @version 25/05/2023
 *
 */

public class DAOClase {

	/**
	 * Función para seleccionar un clase mediante su id.
	 * 
	 * @param id: Id del clase.
	 * @return clase seleccionado.
	 */

	public static Clase selectClaseById(int id) {

		Transaction transaction = null;
		Clase clase = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			clase = session.get(Clase.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return clase;
	}

	/**
	 * Función para insertar un clase en la base de datos.
	 * 
	 * @param c: Objeto clase con todos sus atributos.
	 */

	public static void insertClase(Clase clase) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(clase);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/**
	 * Función para actualizar una clase en la BD.
	 * 
	 * @param c: Objeto clase con todos sus atributos.
	 */

	public static void updateClase(Clase clase) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.merge(clase);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/**
	 * Función para eliminar una clase en la BD.
	 * 
	 * @param id: Id del clase.
	 */

	public static void deleteClase(int id) {
		Transaction transaction = null;
		Clase clase = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			clase = session.get(Clase.class, id);
			session.remove(clase);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/**
	 * Función para mostrar todas las clase almacenados en la BD.
	 * 
	 * @return clase: Lista de todas las clase que contiene la BD.
	 */

	public static List<Clase> selectAllClases() {
		Transaction transaction = null;
		List<Clase> clases = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			clases = session.createQuery("FROM Clase", Clase.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return clases;
	}

	/**
	 * Función para seleccionar una clase en concreto mediante su nombre.
	 * 
	 * @return clase: Devuelve el nombre de la clase que coincide con el parametro
	 *         pasado.
	 */

	public static Clase selectClase(String nom) {

		Transaction transaction = null;
		Clase cla = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query<Clase> query = session.createQuery("FROM Clase WHERE nombreClase=:nombre", Clase.class);
			query.setParameter("nombre", nom);
			cla = query.uniqueResult();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return cla;
	}

}
