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
import javax.swing.JOptionPane;
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
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Component;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App {

	private JFrame frame;
	private JTable tableCliente;
	private JTable tableEjercicio;
	private JTable tableEjercicioCliente;
	private JTextField txtClienteNombre;
	private JTextField txtClienteApellidos;
	private JTextField txtClienteEdad;
	private JTextField txtClienteAltura;
	private JTextField txtClientePeso;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		
		GymDAO gDAO = new GymDAO();
		List<Cliente> listaCliente = null;
		
		frame = new JFrame();
		frame.setBackground(new Color(255, 69, 0));
		frame.setBounds(100, 100, 1190, 838);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		/**
		 * Label con imagenes de fondo
		 */
		

		JLabel lblClienteNombre = new JLabel("Nombre:");
		lblClienteNombre.setFont(new Font("Dialog", Font.BOLD, 16));
		lblClienteNombre.setForeground(new Color(255, 140, 0));
		lblClienteNombre.setBounds(53, 92, 117, 35);
		frame.getContentPane().add(lblClienteNombre);

		JLabel lblTablaCliente = new JLabel("Cliente");
		lblTablaCliente.setForeground(new Color(255, 140, 0));
		lblTablaCliente.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 38));
		lblTablaCliente.setBounds(147, 22, 183, 42);
		frame.getContentPane().add(lblTablaCliente);

		JLabel lblTablaEjercicio = new JLabel("Ejercicio");
		lblTablaEjercicio.setForeground(new Color(255, 140, 0));
		lblTablaEjercicio.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 32));
		lblTablaEjercicio.setBounds(925, 25, 183, 42);
		frame.getContentPane().add(lblTablaEjercicio);
		tableEjercicio = new JTable();
		tableEjercicio.setForeground(new Color(51, 51, 51));
		tableEjercicio.setFont(UIManager.getFont("Button.font"));
		tableEjercicio.setBackground(new Color(255, 153, 0));
		tableEjercicio.setBounds(471, 45, 1, 1);
		frame.getContentPane().add(tableEjercicio);
		tableCliente = new JTable();
		tableCliente.setOpaque(false);
		tableCliente.setForeground(new Color(255, 102, 0));
		tableCliente.setBackground(new Color(176, 196, 222));
		tableCliente.setBounds(81, 45, 1, 1);
		frame.getContentPane().add(tableCliente);

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
		tableCliente.setForeground(new Color(255, 102, 0));
		tableCliente.setFont(new Font("Dialog", Font.BOLD, 12));

		JScrollPane scrollPaneCliente = new JScrollPane(tableCliente);
		scrollPaneCliente.setOpaque(false);
		scrollPaneCliente.setEnabled(false);
		scrollPaneCliente.setBounds(53, 512, 350, 279);
		frame.getContentPane().add(scrollPaneCliente);
		scrollPaneCliente.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 102, 0),
				new Color(255, 102, 0), new Color(255, 102, 0), new Color(255, 102, 0)));

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
		tableEjercicio.setForeground(new Color(255, 102, 0));
		tableEjercicio.setFont(new Font("Dialog", Font.BOLD, 12));

		JScrollPane scrollPaneEjercicio = new JScrollPane(tableEjercicio);
		scrollPaneEjercicio.setOpaque(false);
		scrollPaneEjercicio.setBounds(801, 512, 349, 277);
		frame.getContentPane().add(scrollPaneEjercicio);
		scrollPaneEjercicio.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 102, 0),
				new Color(255, 102, 0), new Color(255, 102, 0), new Color(255, 102, 0)));
		
		JButton btnMostrarUsuarios = new JButton("Mostrar Clientes");
		btnMostrarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Cliente> listaClientes = null;
				
				modelCliente.setRowCount(0);
				listaClientes = GymDAO.selectAllClientes();
				for (int i = 0; i < listaClientes.size(); i++) {
					Object[] row = new Object[6];
					row[0] = listaClientes.get(i).getId();
					row[1] = listaClientes.get(i).getNombreCliente();
					row[2] = listaClientes.get(i).getApellidos();
					row[3] = listaClientes.get(i).getEdad();
					row[4] = listaClientes.get(i).getAltura();
					row[5] = listaClientes.get(i).getPeso();
					modelCliente.addRow(row);
				}
				
				
			}
		});
		btnMostrarUsuarios.setBounds(430, 322, 117, 25);
		frame.getContentPane().add(btnMostrarUsuarios);
		btnMostrarUsuarios.setVisible(false);

		JButton btnMostrarEjercicios = new JButton("Mostrar Ejercicios");
		btnMostrarEjercicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Ejercicio> listaEjercicios = null;
				
				modelEjercicio.setRowCount(0);
				listaEjercicios = GymDAO.selectAllEjercicios();
				for (int i = 0; i < listaEjercicios.size(); i++) {
					Object[] row = new Object[5];
					row[0] = listaEjercicios.get(i).getIdEjercicio();
					row[1] = listaEjercicios.get(i).getNombreEjercicio();
					row[2] = listaEjercicios.get(i).getNumeroSeries();
					row[3] = listaEjercicios.get(i).getNumeroRepeticiones();
					row[4] = listaEjercicios.get(i).getCargaKg();
					modelEjercicio.addRow(row);
				}
			}
		});
		btnMostrarEjercicios.setBounds(674, 309, 117, 25);
		frame.getContentPane().add(btnMostrarEjercicios);

		JLabel lblClienteApellidos = new JLabel("Apellidos:");
		lblClienteApellidos.setFont(new Font("Dialog", Font.BOLD, 16));
		lblClienteApellidos.setForeground(new Color(255, 140, 0));
		lblClienteApellidos.setBounds(53, 136, 117, 35);
		frame.getContentPane().add(lblClienteApellidos);

		JLabel lblClienteEdad = new JLabel("Edad:");
		lblClienteEdad.setFont(new Font("Dialog", Font.BOLD, 16));
		lblClienteEdad.setForeground(new Color(255, 140, 0));
		lblClienteEdad.setBounds(53, 183, 117, 35);
		frame.getContentPane().add(lblClienteEdad);

		JLabel lblClienteAltura = new JLabel("Altura:");
		lblClienteAltura.setFont(new Font("Dialog", Font.BOLD, 16));
		lblClienteAltura.setForeground(new Color(255, 140, 0));
		lblClienteAltura.setBounds(53, 230, 117, 35);
		frame.getContentPane().add(lblClienteAltura);

		JLabel lblClientePeso = new JLabel("Peso:");
		lblClientePeso.setFont(new Font("Dialog", Font.BOLD, 16));
		lblClientePeso.setForeground(new Color(255, 140, 0));
		lblClientePeso.setBounds(53, 277, 117, 35);
		frame.getContentPane().add(lblClientePeso);

		txtClienteNombre = new JTextField();
		txtClienteNombre.setFont(new Font("Dialog", Font.BOLD, 14));
		txtClienteNombre.setForeground(new Color(0, 0, 0));
		txtClienteNombre.setBackground(new Color(255, 140, 0));
		txtClienteNombre.setBorder(null);
		txtClienteNombre.setBounds(154, 101, 244, 19);
		frame.getContentPane().add(txtClienteNombre);
		txtClienteNombre.setColumns(10);

		txtClienteApellidos = new JTextField();
		txtClienteApellidos.setFont(new Font("Dialog", Font.BOLD, 12));
		txtClienteApellidos.setBackground(new Color(255, 140, 0));
		txtClienteApellidos.setBorder(null);
		txtClienteApellidos.setColumns(10);
		txtClienteApellidos.setBounds(154, 145, 244, 19);
		frame.getContentPane().add(txtClienteApellidos);

		txtClienteEdad = new JTextField();
		txtClienteEdad.setFont(new Font("Dialog", Font.BOLD, 12));
		txtClienteEdad.setBorder(null);
		txtClienteEdad.setBackground(new Color(255, 140, 0));
		txtClienteEdad.setColumns(10);
		txtClienteEdad.setBounds(154, 192, 244, 19);
		frame.getContentPane().add(txtClienteEdad);

		txtClienteAltura = new JTextField();
		txtClienteAltura.setFont(new Font("Dialog", Font.BOLD, 12));
		txtClienteAltura.setBackground(new Color(255, 140, 0));
		txtClienteAltura.setBorder(null);
		txtClienteAltura.setColumns(10);
		txtClienteAltura.setBounds(154, 239, 244, 19);
		frame.getContentPane().add(txtClienteAltura);

		txtClientePeso = new JTextField();
		txtClientePeso.setFont(new Font("Dialog", Font.BOLD, 12));
		txtClientePeso.setBorder(null);
		txtClientePeso.setBackground(new Color(255, 140, 0));
		txtClientePeso.setColumns(10);
		txtClientePeso.setBounds(154, 285, 244, 19);
		frame.getContentPane().add(txtClientePeso);

		JLabel lblClienteNombre_1 = new JLabel("Nombre:");
		lblClienteNombre_1.setForeground(new Color(255, 140, 0));
		lblClienteNombre_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblClienteNombre_1.setBounds(805, 92, 117, 35);
		frame.getContentPane().add(lblClienteNombre_1);

		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Dialog", Font.BOLD, 14));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(255, 140, 0));
		textField.setBounds(906, 101, 244, 19);
		frame.getContentPane().add(textField);

		JLabel lblClienteApellidos_1 = new JLabel("Apellidos:");
		lblClienteApellidos_1.setForeground(new Color(255, 140, 0));
		lblClienteApellidos_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblClienteApellidos_1.setBounds(805, 136, 117, 35);
		frame.getContentPane().add(lblClienteApellidos_1);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.BOLD, 12));
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(new Color(255, 140, 0));
		textField_1.setBounds(906, 145, 244, 19);
		frame.getContentPane().add(textField_1);

		JLabel lblClienteEdad_1 = new JLabel("Edad:");
		lblClienteEdad_1.setForeground(new Color(255, 140, 0));
		lblClienteEdad_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblClienteEdad_1.setBounds(805, 183, 117, 35);
		frame.getContentPane().add(lblClienteEdad_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Dialog", Font.BOLD, 12));
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(new Color(255, 140, 0));
		textField_2.setBounds(906, 192, 244, 19);
		frame.getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Dialog", Font.BOLD, 12));
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBackground(new Color(255, 140, 0));
		textField_3.setBounds(906, 239, 244, 19);
		frame.getContentPane().add(textField_3);

		JLabel lblClienteEdad_1_1 = new JLabel("Edad:");
		lblClienteEdad_1_1.setForeground(new Color(255, 140, 0));
		lblClienteEdad_1_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblClienteEdad_1_1.setBounds(805, 230, 117, 35);
		frame.getContentPane().add(lblClienteEdad_1_1);

		JButton btnInsertarCliente = new JButton("  Insertar");
		btnInsertarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nuevoNombre = "";
				String nuevoApellido = "";
				int nuevaEdad = 0;
				double nuevaAltura = 0.0;
				double nuevoPeso = 0.0;

				nuevoNombre = txtClienteNombre.getText();
				if (nuevoNombre.length() == 0) {
					JOptionPane.showMessageDialog(null, "El campo nombre está vacío", "ERROR", 0);
				}

				nuevoApellido = txtClienteApellidos.getText();
				if (nuevoApellido.length() == 0) {
					JOptionPane.showMessageDialog(null, "El campo nombre está vacío", "ERROR", 0);
				}

				
				
				try {
					nuevaEdad = Integer.parseInt(txtClienteEdad.getText());
				} catch (ArithmeticException e) {
					JOptionPane.showMessageDialog(null, "El dato pasado como edad no es númerico", "ERROR", 0);
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "El campo edad está vacío", "ERROR", 0);
				}

				try {
					nuevaAltura = Double.parseDouble(txtClienteAltura.getText());
				} catch (ArithmeticException e) {
					JOptionPane.showMessageDialog(null, "El dato pasado como altura no es númerico", "ERROR", 0);
					JOptionPane.showMessageDialog(null, "El campo altura está vacío", "ERROR", 0);
				}

				try {
					nuevoPeso = Double.parseDouble(txtClientePeso.getText());
				} catch (ArithmeticException e) {
					JOptionPane.showMessageDialog(null, "El dato pasado como peso no es númerico", "ERROR", 0);
					JOptionPane.showMessageDialog(null, "El campo peso está vacío", "ERROR", 0);
				}

				Cliente c = new Cliente(nuevoNombre, nuevoApellido, nuevaEdad, nuevaAltura, nuevoPeso);
				GymDAO.insertCliente(c);
				btnMostrarUsuarios.doClick();
				
				txtClienteNombre.setText("");
				txtClienteApellidos.setText("");
				txtClienteEdad.setText("");
				txtClienteAltura.setText("");
				txtClientePeso.setText("");
			}
		});
		btnInsertarCliente.setIcon(new ImageIcon(App.class.getResource("/img/guardar.png")));
		btnInsertarCliente.setFont(new Font("Dialog", Font.BOLD, 16));
		btnInsertarCliente.setBackground(new Color(255, 140, 0));
		btnInsertarCliente.setBounds(53, 333, 350, 48);
		frame.getContentPane().add(btnInsertarCliente);

		JButton btnActualizarCliente = new JButton("  Actualizar");
		btnActualizarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombreActualizar;
				String apellidosActualizar;
				int edadActualizar = 0;
				double alturaActualizar = 0;
				double pesoActualizar = 0;
				
				nombreActualizar = txtClienteNombre.getText();
				if (nombreActualizar.length() == 0) {
					JOptionPane.showMessageDialog(null, "El campo nombre está vacío", "ERROR", 0);
				}

				apellidosActualizar = txtClienteApellidos.getText();
				if (apellidosActualizar.length() == 0) {
					JOptionPane.showMessageDialog(null, "El campo nombre está vacío", "ERROR", 0);
				}

				try {
					edadActualizar = Integer.parseInt(txtClienteEdad.getText());
				} catch (ArithmeticException e) {
					JOptionPane.showMessageDialog(null, "El dato pasado como edad no es númerico", "ERROR", 0);
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "El campo edad está vacío", "ERROR", 0);
				}

				try {
					alturaActualizar = Double.parseDouble(txtClienteAltura.getText());
				} catch (ArithmeticException e) {
					JOptionPane.showMessageDialog(null, "El dato pasado como altura no es númerico", "ERROR", 0);
					JOptionPane.showMessageDialog(null, "El campo altura está vacío", "ERROR", 0);
				}

				try {
					pesoActualizar = Double.parseDouble(txtClientePeso.getText());
				} catch (ArithmeticException e) {
					JOptionPane.showMessageDialog(null, "El dato pasado como peso no es númerico", "ERROR", 0);
					JOptionPane.showMessageDialog(null, "El campo peso está vacío", "ERROR", 0);
				}
				
				Cliente c = new Cliente(nombreActualizar, apellidosActualizar, edadActualizar, alturaActualizar, pesoActualizar);
				GymDAO.updateCliente(c);
				btnMostrarUsuarios.doClick();
			}
		});
		btnActualizarCliente.setIcon(new ImageIcon(App.class.getResource("/img/actualizar.png")));
		btnActualizarCliente.setFont(new Font("Dialog", Font.BOLD, 16));
		btnActualizarCliente.setBackground(new Color(255, 140, 0));
		btnActualizarCliente.setBounds(53, 393, 350, 48);
		frame.getContentPane().add(btnActualizarCliente);

		JButton btnEliminarCliente = new JButton("Eliminar");
		btnEliminarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombreEliminar;
				String apellidosEliminar;
				int edadEliminar = 0;
				double alturaEliminar = 0;
				double pesoEliminar = 0;
				
				nombreEliminar = txtClienteNombre.getText();
				if (nombreEliminar.length() == 0) {
					JOptionPane.showMessageDialog(null, "El campo nombre está vacío", "ERROR", 0);
				}

				apellidosEliminar = txtClienteApellidos.getText();
				if (apellidosEliminar.length() == 0) {
					JOptionPane.showMessageDialog(null, "El campo nombre está vacío", "ERROR", 0);
				}

				try {
					edadEliminar = Integer.parseInt(txtClienteEdad.getText());
				} catch (ArithmeticException e) {
					JOptionPane.showMessageDialog(null, "El dato pasado como edad no es númerico", "ERROR", 0);
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "El campo edad está vacío", "ERROR", 0);
				}

				try {
					alturaEliminar = Double.parseDouble(txtClienteAltura.getText());
				} catch (ArithmeticException e) {
					JOptionPane.showMessageDialog(null, "El dato pasado como altura no es númerico", "ERROR", 0);
					JOptionPane.showMessageDialog(null, "El campo altura está vacío", "ERROR", 0);
				}

				try {
					pesoEliminar = Double.parseDouble(txtClientePeso.getText());
				} catch (ArithmeticException e) {
					JOptionPane.showMessageDialog(null, "El dato pasado como peso no es númerico", "ERROR", 0);
					JOptionPane.showMessageDialog(null, "El campo peso está vacío", "ERROR", 0);
				}
				/**
				Cliente c = new Cliente(nombreEliminar, apellidosEliminar, edadEliminar, alturaEliminar, pesoEliminar);
				int eliminar = GymDAO.selectClienteById(c);
				GymDAO.deleteCliente(eliminar);
				btnMostrarUsuarios.doClick();*/
			}
		});
		btnEliminarCliente.setIcon(new ImageIcon(App.class.getResource("/img/eliminar.png")));
		btnEliminarCliente.setBackground(new Color(255, 140, 0));
		btnEliminarCliente.setFont(new Font("Dialog", Font.BOLD, 16));
		btnEliminarCliente.setBounds(53, 453, 350, 48);
		frame.getContentPane().add(btnEliminarCliente);

		JButton btnInsertarEjercicio = new JButton("  Insertar");
		btnInsertarEjercicio.setIcon(new ImageIcon(App.class.getResource("/img/guardar.png")));
		btnInsertarEjercicio.setFont(new Font("Dialog", Font.BOLD, 16));
		btnInsertarEjercicio.setBackground(new Color(255, 140, 0));
		btnInsertarEjercicio.setBounds(800, 333, 350, 48);
		frame.getContentPane().add(btnInsertarEjercicio);

		JButton btnActualizarEjercicio = new JButton("  Actualizar");
		btnActualizarEjercicio.setIcon(new ImageIcon(App.class.getResource("/img/actualizar.png")));
		btnActualizarEjercicio.setFont(new Font("Dialog", Font.BOLD, 16));
		btnActualizarEjercicio.setBackground(new Color(255, 140, 0));
		btnActualizarEjercicio.setBounds(801, 393, 350, 48);
		frame.getContentPane().add(btnActualizarEjercicio);

		JButton btnEliminarEjercicio = new JButton("Eliminar");
		btnEliminarEjercicio.setIcon(new ImageIcon(App.class.getResource("/img/eliminar.png")));
		btnEliminarEjercicio.setFont(new Font("Dialog", Font.BOLD, 16));
		btnEliminarEjercicio.setBackground(new Color(255, 140, 0));
		btnEliminarEjercicio.setBounds(800, 454, 350, 48);
		frame.getContentPane().add(btnEliminarEjercicio);

		JLabel lblFondo = new JLabel("");
		lblFondo.setOpaque(true);
		lblFondo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFondo.setForeground(new Color(0, 0, 0));
		lblFondo.setIcon(new ImageIcon(App.class.getResource("/img/fondoGym.jpg")));
		lblFondo.setBounds(-15, 0, 1233, 819);
		frame.getContentPane().add(lblFondo);

		/**
		 * TABLA RELACIONADA ENTRE CLIENTE Y EJERCICIO NECESARIO HACER JOIN POSIBLE
		 * FORMATO: SELECT * FROM Cliente c INNER JOIN Ejercicio e ON c.nombreCliente =
		 * txtFieldNombreClienteRelacionar AND e.nombreEjercicio =
		 * txtFieldNombreEjericcioRelacionar también lo podríamos hacer la elección
		 * checkbox
		 */
		/*
		 * tableEjercicioCliente = new JTable(); tableEjercicioCliente.setBounds(336,
		 * 201, 1, 1); frame.getContentPane().add(tableEjercicioCliente);
		 * 
		 * DefaultTableModel modelEjercicioCliente = new DefaultTableModel();
		 * 
		 * modelEjercicioCliente.addColumn("Cliente");
		 * modelEjercicioCliente.addColumn("Ejercicio");
		 * 
		 * List<Rutina> listaRutina = GymDAO.
		 * 
		 */

	}
}