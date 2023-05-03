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
import javax.swing.table.TableModel;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class App {

	private JFrame frame;

	private JTextField txtClienteNombre;
	private JTextField txtClienteApellidos;
	private JTextField txtClienteEdad;
	private JTextField txtClienteAltura;
	private JTextField txtClientePeso;
	private JTextField txtClienteId;

	private JTextField txtEjercicioNombre;
	private JTextField txtEjercicioNumSeries;
	private JTextField txtEjercicioRepeticiones;
	private JTextField txtEjercicioCarga;
	private JTextField txtEjercicioId;

	String ClienteNombre = "";
	String ClienteApellido = "";
	int ClienteEdad = 0;
	double ClienteAltura = 0.0;
	double ClientePeso = 0.0;

	String EjercicioNombre = "";
	int EjercicioNumSeries = 0;
	int EjercicioRepeticiones = 0;
	double EjercicioCarga = 0.0;

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
		frame.setBounds(100, 100, 1190, 838);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		/**
		 * Jlabel del Cliente.
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
		lblTablaEjercicio.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 38));
		lblTablaEjercicio.setBounds(925, 25, 183, 42);
		frame.getContentPane().add(lblTablaEjercicio);

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

		/**
		 * TextField del Cliente.
		 */

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

		txtClienteId = new JTextField();
		txtClienteId.setVisible(false);
		txtClienteId.setOpaque(false);
		txtClienteId.setForeground(Color.BLACK);
		txtClienteId.setFont(new Font("Dialog", Font.BOLD, 14));
		txtClienteId.setColumns(10);
		txtClienteId.setBorder(null);
		txtClienteId.setBackground(new Color(255, 140, 0));
		txtClienteId.setBounds(398, 22, 244, 19);
		frame.getContentPane().add(txtClienteId);

		/**
		 * Tabla del Cliente.
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
		tableCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tableCliente.getSelectedRow();
				TableModel modelCliente = tableCliente.getModel();
				txtClienteId.setText(modelCliente.getValueAt(index, 0).toString());
				txtClienteNombre.setText(modelCliente.getValueAt(index, 1).toString());
				txtClienteApellidos.setText(modelCliente.getValueAt(index, 2).toString());
				txtClienteEdad.setText(modelCliente.getValueAt(index, 3).toString());
				txtClienteAltura.setText(modelCliente.getValueAt(index, 4).toString());
				txtClientePeso.setText(modelCliente.getValueAt(index, 5).toString());
			}
		});
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
		 * Botones del Cliente.
		 */

		/**
		 * Botón para mostrar los clientes de la BD en la tabla.
		 */

		JButton btnMostrarUsuarios = new JButton("");
		btnMostrarUsuarios.setBorder(null);
		btnMostrarUsuarios.setOpaque(false);
		btnMostrarUsuarios.setEnabled(false);
		btnMostrarUsuarios.setVisible(false);
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
		btnMostrarUsuarios.setBounds(414, 334, 152, 48);
		frame.getContentPane().add(btnMostrarUsuarios);

		/**
		 * Botón para insertar un nuevo cliente en la BD.
		 */

		JButton btnInsertarCliente = new JButton("  Insertar");
		btnInsertarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteNombre = txtClienteNombre.getText();
				if (ClienteNombre.length() == 0) {
					JOptionPane.showMessageDialog(null, "El campo nombre está vacío", "ERROR", 0);
				}

				ClienteApellido = txtClienteApellidos.getText();
				if (ClienteApellido.length() == 0) {
					JOptionPane.showMessageDialog(null, "El campo nombre está vacío", "ERROR", 0);
				}

				try {
					ClienteEdad = Integer.parseInt(txtClienteEdad.getText());
				} catch (ArithmeticException e) {
					JOptionPane.showMessageDialog(null, "El dato pasado como edad no es númerico", "ERROR", 0);
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "El campo edad está vacío", "ERROR", 0);
				}

				try {
					ClienteAltura = Double.parseDouble(txtClienteAltura.getText());
				} catch (ArithmeticException e) {
					JOptionPane.showMessageDialog(null, "El dato pasado como altura no es númerico", "ERROR", 0);
					JOptionPane.showMessageDialog(null, "El campo altura está vacío", "ERROR", 0);
				}

				try {
					ClientePeso = Double.parseDouble(txtClientePeso.getText());
				} catch (ArithmeticException e) {
					JOptionPane.showMessageDialog(null, "El dato pasado como peso no es númerico", "ERROR", 0);
					JOptionPane.showMessageDialog(null, "El campo peso está vacío", "ERROR", 0);
				}

				Cliente c = new Cliente(ClienteNombre, ClienteApellido, ClienteEdad, ClienteAltura, ClientePeso);

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

		/**
		 * Botón para actualizar un cliente en la BD.
		 */

		JButton btnActualizarCliente = new JButton("  Actualizar");
		btnActualizarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteNombre = txtClienteNombre.getText();
				if (ClienteNombre.length() == 0) {
					JOptionPane.showMessageDialog(null, "El campo nombre está vacío", "ERROR", 0);
				}

				ClienteApellido = txtClienteApellidos.getText();
				if (ClienteApellido.length() == 0) {
					JOptionPane.showMessageDialog(null, "El campo nombre está vacío", "ERROR", 0);
				}

				try {
					ClienteEdad = Integer.parseInt(txtClienteEdad.getText());
				} catch (ArithmeticException e) {
					JOptionPane.showMessageDialog(null, "El dato pasado como edad no es númerico", "ERROR", 0);
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "El campo edad está vacío", "ERROR", 0);
				}

				try {
					ClienteAltura = Double.parseDouble(txtClienteAltura.getText());
				} catch (ArithmeticException e) {
					JOptionPane.showMessageDialog(null, "El dato pasado como altura no es númerico", "ERROR", 0);
					JOptionPane.showMessageDialog(null, "El campo altura está vacío", "ERROR", 0);
				}

				try {
					ClientePeso = Double.parseDouble(txtClientePeso.getText());
				} catch (ArithmeticException e) {
					JOptionPane.showMessageDialog(null, "El dato pasado como peso no es númerico", "ERROR", 0);
					JOptionPane.showMessageDialog(null, "El campo peso está vacío", "ERROR", 0);
				}
				int id;
				id = Integer.parseInt(txtClienteId.getText());
				Cliente c = GymDAO.selectClienteById(id);

				c.setNombreCliente(ClienteNombre);
				c.setApellidos(ClienteApellido);
				c.setEdad(ClienteEdad);
				c.setAltura(ClienteAltura);
				c.setPeso(ClientePeso);

				GymDAO.updateCliente(c);

				btnMostrarUsuarios.doClick();
			}
		});
		btnActualizarCliente.setIcon(new ImageIcon(App.class.getResource("/img/actualizar.png")));
		btnActualizarCliente.setFont(new Font("Dialog", Font.BOLD, 16));
		btnActualizarCliente.setBackground(new Color(255, 140, 0));
		btnActualizarCliente.setBounds(53, 393, 350, 48);
		frame.getContentPane().add(btnActualizarCliente);

		/**
		 * Botón para eliminar un cliente en la BD.
		 */

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
				int id;
				id = Integer.parseInt(txtClienteId.getText());
				GymDAO.deleteCliente(id);
				btnMostrarUsuarios.doClick();
			}
		});
		btnEliminarCliente.setIcon(new ImageIcon(App.class.getResource("/img/eliminar.png")));
		btnEliminarCliente.setBackground(new Color(255, 140, 0));
		btnEliminarCliente.setFont(new Font("Dialog", Font.BOLD, 16));
		btnEliminarCliente.setBounds(53, 453, 350, 48);
		frame.getContentPane().add(btnEliminarCliente);

		/**
		 * JLabel del Ejercicio.
		 */

		JLabel lblEjercicioNombre = new JLabel("Nombre:");
		lblEjercicioNombre.setForeground(new Color(255, 140, 0));
		lblEjercicioNombre.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEjercicioNombre.setBounds(801, 102, 117, 35);
		frame.getContentPane().add(lblEjercicioNombre);

		JLabel lblEjercicioNumSeries = new JLabel("Nº Series:");
		lblEjercicioNumSeries.setForeground(new Color(255, 140, 0));
		lblEjercicioNumSeries.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEjercicioNumSeries.setBounds(801, 163, 117, 35);
		frame.getContentPane().add(lblEjercicioNumSeries);

		JLabel lblRepeticiones = new JLabel("Repeticiones:");
		lblRepeticiones.setForeground(new Color(255, 140, 0));
		lblRepeticiones.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRepeticiones.setBounds(801, 223, 140, 35);
		frame.getContentPane().add(lblRepeticiones);

		JLabel lblEjercicioCarga = new JLabel("Cargar (kg):");
		lblEjercicioCarga.setForeground(new Color(255, 140, 0));
		lblEjercicioCarga.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEjercicioCarga.setBounds(805, 277, 117, 35);
		frame.getContentPane().add(lblEjercicioCarga);

		/**
		 * TextField del Ejercicio.
		 */
		
		txtEjercicioNombre = new JTextField();
		txtEjercicioNombre.setForeground(Color.BLACK);
		txtEjercicioNombre.setFont(new Font("Dialog", Font.BOLD, 14));
		txtEjercicioNombre.setColumns(10);
		txtEjercicioNombre.setBorder(null);
		txtEjercicioNombre.setBackground(new Color(255, 140, 0));
		txtEjercicioNombre.setBounds(925, 108, 225, 19);
		frame.getContentPane().add(txtEjercicioNombre);

		txtEjercicioNumSeries = new JTextField();
		txtEjercicioNumSeries.setFont(new Font("Dialog", Font.BOLD, 12));
		txtEjercicioNumSeries.setColumns(10);
		txtEjercicioNumSeries.setBorder(null);
		txtEjercicioNumSeries.setBackground(new Color(255, 140, 0));
		txtEjercicioNumSeries.setBounds(925, 172, 225, 19);
		frame.getContentPane().add(txtEjercicioNumSeries);

		txtEjercicioRepeticiones = new JTextField();
		txtEjercicioRepeticiones.setFont(new Font("Dialog", Font.BOLD, 12));
		txtEjercicioRepeticiones.setColumns(10);
		txtEjercicioRepeticiones.setBorder(null);
		txtEjercicioRepeticiones.setBackground(new Color(255, 140, 0));
		txtEjercicioRepeticiones.setBounds(925, 230, 225, 19);
		frame.getContentPane().add(txtEjercicioRepeticiones);

		txtEjercicioCarga = new JTextField();
		txtEjercicioCarga.setFont(new Font("Dialog", Font.BOLD, 12));
		txtEjercicioCarga.setColumns(10);
		txtEjercicioCarga.setBorder(null);
		txtEjercicioCarga.setBackground(new Color(255, 140, 0));
		txtEjercicioCarga.setBounds(925, 286, 225, 19);
		frame.getContentPane().add(txtEjercicioCarga);

		txtEjercicioId = new JTextField();
		txtEjercicioId.setVisible(false);
		txtEjercicioId.setOpaque(false);
		txtEjercicioId.setForeground(Color.BLACK);
		txtEjercicioId.setFont(new Font("Dialog", Font.BOLD, 14));
		txtEjercicioId.setColumns(10);
		txtEjercicioId.setBorder(null);
		txtEjercicioId.setBackground(new Color(255, 140, 0));
		txtEjercicioId.setBounds(663, 22, 244, 19);
		frame.getContentPane().add(txtEjercicioId);

		/**
		 * Tabla del Ejercicio.
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
		tableEjercicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tableEjercicio.getSelectedRow();
				TableModel modelEjercicio = tableCliente.getModel();
				txtEjercicioNombre.setText(modelEjercicio.getValueAt(index, 1).toString());
				txtEjercicioNumSeries.setText(modelEjercicio.getValueAt(index, 2).toString());
				txtEjercicioRepeticiones.setText(modelEjercicio.getValueAt(index, 3).toString());
				txtEjercicioCarga.setText(modelEjercicio.getValueAt(index, 4).toString());
			}
		});
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

		/**
		 * Botones del Ejercicio.
		 */
		
		/**
		 * Botón para mostrar los ejercicio de la BD en la tabla.
		 */

		JButton btnMostrarEjercicios = new JButton("");
		btnMostrarEjercicios.setBorder(null);
		btnMostrarEjercicios.setOpaque(false);
		btnMostrarEjercicios.setEnabled(false);
		btnMostrarEjercicios.setVisible(false);
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
		btnMostrarEjercicios.setBounds(622, 334, 166, 48);
		frame.getContentPane().add(btnMostrarEjercicios);

		/**
		 * Botón para insertar un ejercicio en la BD.
		 */
		
		JButton btnInsertarEjercicio = new JButton("  Insertar");
		btnInsertarEjercicio.addActionListener(new ActionListener() {
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
		btnInsertarEjercicio.setIcon(new ImageIcon(App.class.getResource("/img/guardar.png")));
		btnInsertarEjercicio.setFont(new Font("Dialog", Font.BOLD, 16));
		btnInsertarEjercicio.setBackground(new Color(255, 140, 0));
		btnInsertarEjercicio.setBounds(800, 333, 350, 48);
		frame.getContentPane().add(btnInsertarEjercicio);

		/**
		 * Botón para actualizar un ejercicio en la BD.
		 */
		
		JButton btnActualizarEjercicio = new JButton("  Actualizar");
		btnActualizarEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnActualizarEjercicio.setIcon(new ImageIcon(App.class.getResource("/img/actualizar.png")));
		btnActualizarEjercicio.setFont(new Font("Dialog", Font.BOLD, 16));
		btnActualizarEjercicio.setBackground(new Color(255, 140, 0));
		btnActualizarEjercicio.setBounds(801, 393, 350, 48);
		frame.getContentPane().add(btnActualizarEjercicio);

		/**
		 * Botón para eliminar un ejercicio en la BD.
		 */
		
		JButton btnEliminarEjercicio = new JButton("Eliminar");
		btnEliminarEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEliminarEjercicio.setIcon(new ImageIcon(App.class.getResource("/img/eliminar.png")));
		btnEliminarEjercicio.setFont(new Font("Dialog", Font.BOLD, 16));
		btnEliminarEjercicio.setBackground(new Color(255, 140, 0));
		btnEliminarEjercicio.setBounds(800, 454, 350, 48);
		frame.getContentPane().add(btnEliminarEjercicio);

		/**
		 * JLabel del Fondo.
		 */

		JLabel lblFondo = new JLabel("");
		lblFondo.setOpaque(true);
		lblFondo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFondo.setForeground(new Color(0, 0, 0));
		lblFondo.setIcon(new ImageIcon(App.class.getResource("/img/fondoGym.jpg")));
		lblFondo.setBounds(0, -30, 1233, 819);
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