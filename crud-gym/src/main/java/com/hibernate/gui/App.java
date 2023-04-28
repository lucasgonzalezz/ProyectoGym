package com.hibernate.gui;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hibernate.dao.GymDAO;
import com.hibernate.model.Cliente;
import com.hibernate.model.Ejercicio;

public class App {

	private JFrame frame;
	private JTable tableCliente;
	private JTable tableEjercicio;
	private JTable tableEjercicioCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(255, 69, 0));
		frame.setBounds(100, 100, 1115, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/**
		 * Label con imagenes de fondo
		 */
		tableEjercicio = new JTable();
		tableEjercicio.setBounds(471, 45, 1, 1);
		frame.getContentPane().add(tableEjercicio);
		tableCliente = new JTable();
		tableCliente.setBounds(81, 45, 1, 1);
		frame.getContentPane().add(tableCliente);
		JLabel lblAnillas = new JLabel("");
		lblAnillas.setIcon(new ImageIcon(App.class.getResource("/img/anillitas.png")));
		lblAnillas.setBounds(737, -150, 378, 446);
		frame.getContentPane().add(lblAnillas);
		
		JLabel lblPesas = new JLabel("");
		lblPesas.setIcon(new ImageIcon(App.class.getResource("/img/pesitas.png")));
		lblPesas.setBounds(-250, 362, 607, 446);
		frame.getContentPane().add(lblPesas);

		/**
		 * Tabla Cliente
		 */

		DefaultTableModel modelCliente = new DefaultTableModel();

		modelCliente.addColumn("ID");
		modelCliente.addColumn("Nombre");
		modelCliente.addColumn("Apellidos");
		modelCliente.addColumn("Edad");
		modelCliente.addColumn("Altura");
		modelCliente.addColumn("Peso");

		List<Cliente> listaClientes = GymDAO.selectAllClientes();

		for (Cliente cliente : listaClientes) {
			Object[] row = new Object[6];
			row[0] = cliente.getId();
			row[1] = cliente.getNombreCliente();
			row[2] = cliente.getApellidos();
			row[3] = cliente.getEdad();
			row[4] = cliente.getAltura();
			row[5] = cliente.getPeso();
			modelCliente.addRow(row);
		}

		JTable tableCliente = new JTable(modelCliente);
		tableCliente.setBounds(81, 45, 1, 1);
		tableCliente.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		JScrollPane scrollPaneCliente = new JScrollPane(tableCliente);
		scrollPaneCliente.setBounds(23, 30, 406, 216);
		frame.getContentPane().add(scrollPaneCliente);

		/**
		 * Tabla Ejercicio
		 */

		DefaultTableModel modelEjercicio = new DefaultTableModel();
		
		modelEjercicio.addColumn("ID");
		modelEjercicio.addColumn("Nombre");
		modelEjercicio.addColumn("Series");
		modelEjercicio.addColumn("Repeticiones");
		modelEjercicio.addColumn("KG");
		
		List<Ejercicio> listaEjercicios = GymDAO.selectAllEjercicios();
		
		for (Ejercicio ejercicio : listaEjercicios) {
			Object[] row = new Object[5];
			row[0] = ejercicio.getIdEjercicio();
			row[1] = ejercicio.getNombreEjercicio();
			row[2] = ejercicio.getNumeroSeries();
			row[3] = ejercicio.getNumeroRepeticiones();
			row[4] = ejercicio.getCargaKg();
			modelEjercicio.addRow(row);
		}
		
		JTable tableEjercicio = new JTable(modelEjercicio);
		tableEjercicio.setBounds(471, 30, 1, 1);
		tableEjercicio.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JScrollPane scrollPaneEjercicio = new JScrollPane(tableEjercicio);
		scrollPaneEjercicio.setBounds(762, 45, 290, 201);
		frame.getContentPane().add(scrollPaneEjercicio);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(App.class.getResource("/img/fondoGym.jpg")));
		lblFondo.setBounds(0, 0, 1115, 713);
		frame.getContentPane().add(lblFondo);
		
		/**
		 * TABLA RELACIONADA ENTRE CLIENTE Y EJERCICIO
		 * NECESARIO HACER JOIN
		 * POSIBLE FORMATO:
		 * SELECT * FROM Cliente c INNER JOIN Ejercicio e ON c.nombreCliente = txtFieldNombreClienteRelacionar AND e.nombreEjercicio = txtFieldNombreEjericcioRelacionar
		 * también lo podríamos hacer la elección checkbox 
		 */
		/*
		tableEjercicioCliente = new JTable();
		tableEjercicioCliente.setBounds(336, 201, 1, 1);
		frame.getContentPane().add(tableEjercicioCliente);
		
		DefaultTableModel modelEjercicioCliente = new DefaultTableModel();
		
		modelEjercicioCliente.addColumn("Cliente");
		modelEjercicioCliente.addColumn("Ejercicio");
		
		List<Rutina> listaRutina = GymDAO.
		
		*/

	}
}