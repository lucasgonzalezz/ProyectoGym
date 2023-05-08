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
import com.hibernate.model.Rutina;
import com.hibernate.util.HibernateUtil;

import jakarta.persistence.TypedQuery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class GymDAO {

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

	/**
	 * Función para enlazar el nombre del cliente junto con el ejercicio que debe
	 * realizar.
	 * 
	 * @return rutina: Nombre del cliente junto con el ejercicio que debe realizar.
	 */

	public static List<Rutina> selectAllRutina() {
		Transaction transaction = null;
		List<Rutina> rutina = new ArrayList<>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			String hql = "SELECT c.nombreCliente, e.nombreEjercicio FROM Cliente c INNER JOIN Ejercicio e";

			TypedQuery<Object[]> hqlQuery = session.createQuery(hql, Object[].class);

			List<Object[]> results = hqlQuery.getResultList();

			for (Object[] result : results) {
				Rutina r = new Rutina();
				r.setNombreCliente((String) result[0]);
				r.setNombreEjercicio((String) result[1]);
				rutina.add(r);
			}

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return rutina;
	}

}
