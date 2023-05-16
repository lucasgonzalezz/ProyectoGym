package com.hibernate.gui;

import java.awt.EventQueue;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import org.hibernate.Session;

import com.hibernate.dao.DAOCliente;
import com.hibernate.dao.DAOEjercicio;
import com.hibernate.model.Cliente;
import com.hibernate.model.Ejercicio;
import com.hibernate.util.HibernateUtil;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

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

	int clienteId;
	int ejercicioId;

	String clienteNombre = "";
	String clienteApellido = "";
	int clienteEdad = 0;
	double clienteAltura = 0.0;
	double clientePeso = 0.0;

	String ejercicioNombre = "";
	int ejercicioNumSeries = 0;
	int ejercicioRepeticiones = 0;
	double ejercicioCarga = 0.0;

	DAOCliente clienteDAO = new DAOCliente();
	DAOEjercicio ejercicioDAO = new DAOEjercicio();
	private JTable tableRutina;
	private JTextField txtClienteRutina;
	private JTextField txtEjercicioRutina;

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
	@SuppressWarnings("serial")
	private void initialize() {

		frame = new JFrame();
		frame.setBackground(new Color(255, 69, 0));
		frame.setBounds(100, 100, 1756, 858);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		/**
		 * Jlabel del Cliente.
		 */
		
		txtEjercicioRutina = new JTextField();
		txtEjercicioRutina.setForeground(Color.BLACK);
		txtEjercicioRutina.setFont(new Font("Dialog", Font.BOLD, 16));
		txtEjercicioRutina.setColumns(10);
		txtEjercicioRutina.setBorder(null);
		txtEjercicioRutina.setBackground(new Color(255, 140, 0));
		txtEjercicioRutina.setBounds(758, 150, 352, 19);
		frame.getContentPane().add(txtEjercicioRutina);
		
		txtClienteRutina = new JTextField();
		txtClienteRutina.setForeground(Color.BLACK);
		txtClienteRutina.setFont(new Font("Dialog", Font.BOLD, 16));
		txtClienteRutina.setColumns(10);
		txtClienteRutina.setBorder(null);
		txtClienteRutina.setBackground(new Color(255, 140, 0));
		txtClienteRutina.setBounds(758, 101, 352, 19);
		frame.getContentPane().add(txtClienteRutina);

		JLabel lblClienteRutina = new JLabel("Cliente:");
		lblClienteRutina.setForeground(new Color(255, 140, 0));
		lblClienteRutina.setFont(new Font("Dialog", Font.BOLD, 18));
		lblClienteRutina.setBounds(663, 102, 89, 15);
		frame.getContentPane().add(lblClienteRutina);

		JLabel lblEjercicioRutina = new JLabel("Ejercicio:");
		lblEjercicioRutina.setForeground(new Color(255, 140, 0));
		lblEjercicioRutina.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEjercicioRutina.setBounds(663, 151, 89, 15);
		frame.getContentPane().add(lblEjercicioRutina);
		
		JLabel lblRutina = new JLabel("Rutina");
		lblRutina.setForeground(new Color(255, 140, 0));
		lblRutina.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 56));
		lblRutina.setBounds(783, 21, 199, 54);
		frame.getContentPane().add(lblRutina);

		JLabel lblClienteNombre = new JLabel("Nombre:");
		lblClienteNombre.setFont(new Font("Dialog", Font.BOLD, 18));
		lblClienteNombre.setForeground(new Color(255, 140, 0));
		lblClienteNombre.setBounds(28, 92, 117, 35);
		frame.getContentPane().add(lblClienteNombre);

		JLabel lblTablaCliente = new JLabel("Cliente");
		lblTablaCliente.setForeground(new Color(255, 140, 0));
		lblTablaCliente.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 56));
		lblTablaCliente.setBounds(218, 21, 199, 55);
		frame.getContentPane().add(lblTablaCliente);

		JLabel lblTablaEjercicio = new JLabel("Ejercicio");
		lblTablaEjercicio.setForeground(new Color(255, 140, 0));
		lblTablaEjercicio.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 56));
		lblTablaEjercicio.setBounds(1369, 13, 257, 70);
		frame.getContentPane().add(lblTablaEjercicio);

		JLabel lblClienteApellidos = new JLabel("Apellidos:");
		lblClienteApellidos.setFont(new Font("Dialog", Font.BOLD, 18));
		lblClienteApellidos.setForeground(new Color(255, 140, 0));
		lblClienteApellidos.setBounds(28, 136, 117, 35);
		frame.getContentPane().add(lblClienteApellidos);

		JLabel lblClienteEdad = new JLabel("Edad:");
		lblClienteEdad.setFont(new Font("Dialog", Font.BOLD, 18));
		lblClienteEdad.setForeground(new Color(255, 140, 0));
		lblClienteEdad.setBounds(28, 183, 117, 35);
		frame.getContentPane().add(lblClienteEdad);

		JLabel lblClienteAltura = new JLabel("Altura:");
		lblClienteAltura.setFont(new Font("Dialog", Font.BOLD, 18));
		lblClienteAltura.setForeground(new Color(255, 140, 0));
		lblClienteAltura.setBounds(28, 230, 117, 35);
		frame.getContentPane().add(lblClienteAltura);

		JLabel lblClientePeso = new JLabel("Peso:");
		lblClientePeso.setFont(new Font("Dialog", Font.BOLD, 18));
		lblClientePeso.setForeground(new Color(255, 140, 0));
		lblClientePeso.setBounds(28, 277, 117, 35);
		frame.getContentPane().add(lblClientePeso);

		/**
		 * TextField del Cliente.
		 */

		txtClienteNombre = new JTextField();
		txtClienteNombre.setFont(new Font("Dialog", Font.BOLD, 16));
		txtClienteNombre.setForeground(new Color(0, 0, 0));
		txtClienteNombre.setBackground(new Color(255, 140, 0));
		txtClienteNombre.setBorder(null);
		txtClienteNombre.setBounds(129, 101, 433, 19);
		frame.getContentPane().add(txtClienteNombre);
		txtClienteNombre.setColumns(10);

		txtClienteApellidos = new JTextField();
		txtClienteApellidos.setFont(new Font("Dialog", Font.BOLD, 16));
		txtClienteApellidos.setBackground(new Color(255, 140, 0));
		txtClienteApellidos.setBorder(null);
		txtClienteApellidos.setColumns(10);
		txtClienteApellidos.setBounds(129, 145, 433, 19);
		frame.getContentPane().add(txtClienteApellidos);

		txtClienteEdad = new JTextField();
		txtClienteEdad.setFont(new Font("Dialog", Font.BOLD, 16));
		txtClienteEdad.setBorder(null);
		txtClienteEdad.setBackground(new Color(255, 140, 0));
		txtClienteEdad.setColumns(10);
		txtClienteEdad.setBounds(129, 192, 433, 19);
		frame.getContentPane().add(txtClienteEdad);

		txtClienteAltura = new JTextField();
		txtClienteAltura.setFont(new Font("Dialog", Font.BOLD, 16));
		txtClienteAltura.setBackground(new Color(255, 140, 0));
		txtClienteAltura.setBorder(null);
		txtClienteAltura.setColumns(10);
		txtClienteAltura.setBounds(129, 239, 433, 19);
		frame.getContentPane().add(txtClienteAltura);

		txtClientePeso = new JTextField();
		txtClientePeso.setFont(new Font("Dialog", Font.BOLD, 16));
		txtClientePeso.setBorder(null);
		txtClientePeso.setBackground(new Color(255, 140, 0));
		txtClientePeso.setColumns(10);
		txtClientePeso.setBounds(129, 285, 433, 19);
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

		DefaultTableModel modelCliente = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que todas las celdas no sean editables
            }
        };
        
		modelCliente.addColumn("ID");
		modelCliente.addColumn("Nombre");
		modelCliente.addColumn("Apellidos");
		modelCliente.addColumn("Edad");
		modelCliente.addColumn("Altura");
		modelCliente.addColumn("Peso");

		List<Cliente> listaClientes = DAOCliente.selectAllClientes();

		for (Cliente cliente : listaClientes) {
			Object[] row = new Object[6];
			row[0] = cliente.getIdCliente();
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
				txtClienteRutina.setText(modelCliente.getValueAt(index, 1).toString());
				txtClienteApellidos.setText(modelCliente.getValueAt(index, 2).toString());
				txtClienteEdad.setText(modelCliente.getValueAt(index, 3).toString());
				txtClienteAltura.setText(modelCliente.getValueAt(index, 4).toString());
				txtClientePeso.setText(modelCliente.getValueAt(index, 5).toString());
			}
		});
		tableCliente.setBounds(81, 45, 1, 1);
		tableCliente.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableCliente.setForeground(new Color(255, 102, 0));
		tableCliente.setFont(new Font("Dialog", Font.BOLD, 16));
		
		tableCliente.setRowHeight(25);
		
		TableColumnModel columnModel = tableCliente.getColumnModel();
		TableColumn column0 = columnModel.getColumn(0);
        column0.setPreferredWidth(20);
        TableColumn column1 = columnModel.getColumn(1);
        column1.setPreferredWidth(100);
        TableColumn column2 = columnModel.getColumn(2);
        column2.setPreferredWidth(180);
        TableColumn column3 = columnModel.getColumn(3);
        column3.setPreferredWidth(45);
        TableColumn column4 = columnModel.getColumn(4);
        column4.setPreferredWidth(45);
        TableColumn column5 = columnModel.getColumn(5);
        column5.setPreferredWidth(45);
        
        DefaultTableCellRenderer cellRenderer = (DefaultTableCellRenderer) tableCliente.getDefaultRenderer(Object.class);
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        JTableHeader header = tableCliente.getTableHeader();
        header.setPreferredSize(new java.awt.Dimension(header.getWidth(), 35));
        
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(255, 102, 0));
        headerRenderer.setForeground(Color.BLACK);
        headerRenderer.setFont(headerRenderer.getFont().deriveFont(Font.BOLD, 16));
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        header.setDefaultRenderer(headerRenderer);

		JScrollPane scrollPaneCliente = new JScrollPane(tableCliente);
		scrollPaneCliente.setOpaque(false);
		scrollPaneCliente.setEnabled(false);
		scrollPaneCliente.setBounds(28, 524, 534, 284);
		frame.getContentPane().add(scrollPaneCliente);
		scrollPaneCliente.setBorder(null);

		/**
		 * Botones del Cliente.
		 */

		/**
		 * Botón para mostrar los clientes de la BD en la tabla.
		 */

		JButton btnMostrarClientes = new JButton("");
		btnMostrarClientes.setOpaque(false);
		btnMostrarClientes.setBorderPainted(false);
		btnMostrarClientes.setBorder(null);
		btnMostrarClientes.setVisible(false);
		btnMostrarClientes.setFont(new Font("Dialog", Font.BOLD, 14));
		btnMostrarClientes.setBackground(UIManager.getColor("Button.background"));
		btnMostrarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelCliente.setRowCount(0);

				List<Cliente> listaClientes = DAOCliente.selectAllClientes();
				for (Cliente clientes : listaClientes) {
					Object[] row = new Object[6];
					row[0] = clientes.getIdCliente();
					row[1] = clientes.getNombreCliente();
					row[2] = clientes.getApellidos();
					row[3] = clientes.getEdad();
					row[4] = clientes.getAltura();
					row[5] = clientes.getPeso();
					modelCliente.addRow(row);
				}
			}
		});
		btnMostrarClientes.setBounds(593, 333, 59, 48);
		frame.getContentPane().add(btnMostrarClientes);

		/**
		 * Botón para insertar un nuevo cliente en la BD.
		 */

		JButton btnInsertarCliente = new JButton("  Insertar");
		btnInsertarCliente.setForeground(Color.BLACK);
		btnInsertarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				clienteNombre = txtClienteNombre.getText();
				if (clienteNombre.length() == 0) {
					JOptionPane.showMessageDialog(null, "El campo nombre está vacío", "ERROR", 0);
				}

				clienteApellido = txtClienteApellidos.getText();
				if (clienteApellido.length() == 0) {
					JOptionPane.showMessageDialog(null, "El campo apellidos está vacío", "ERROR", 0);
				}

				try {
					clienteEdad = Integer.parseInt(txtClienteEdad.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "El campo edad está vacío o el dato introducido es incorrecto",
							"ERROR", 0);
				}

				try {
					clienteAltura = Double.parseDouble(txtClienteAltura.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,
							"El campo altura está vacío o el dato introducido es incorrecto", "ERROR", 0);
				}

				try {
					clientePeso = Double.parseDouble(txtClientePeso.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,
							"El campo cliente está vacío o el dato introducido es incorrecto", "ERROR", 0);
				}

				Cliente c = new Cliente(clienteNombre, clienteApellido, clienteEdad, clienteAltura, clientePeso);

				DAOCliente.insertCliente(c);

				btnMostrarClientes.doClick();

				txtClienteNombre.setText("");
				txtClienteApellidos.setText("");
				txtClienteEdad.setText("");
				txtClienteAltura.setText("");
				txtClientePeso.setText("");
			}
		});
		btnInsertarCliente.setIcon(new ImageIcon(App.class.getResource("/img/guardar.png")));
		btnInsertarCliente.setFont(new Font("Dialog", Font.BOLD, 20));
		btnInsertarCliente.setBackground(new Color(255, 140, 0));
		btnInsertarCliente.setBounds(28, 333, 534, 48);
		frame.getContentPane().add(btnInsertarCliente);

		/**
		 * Botón para actualizar un cliente en la BD.
		 */

		JButton btnActualizarCliente = new JButton(" Actualizar");
		btnActualizarCliente.setForeground(Color.BLACK);
		btnActualizarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				clienteNombre = txtClienteNombre.getText();
				if (clienteNombre.length() == 0) {
					JOptionPane.showMessageDialog(null, "El campo nombre está vacío", "ERROR", 0);
				}

				clienteApellido = txtClienteApellidos.getText();
				if (clienteApellido.length() == 0) {
					JOptionPane.showMessageDialog(null, "El campo apellidos está vacío", "ERROR", 0);
				}

				try {
					clienteEdad = Integer.parseInt(txtClienteEdad.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "El campo edad está vacío o el dato introducido es incorrecto",
							"ERROR", 0);
				}

				try {
					clienteAltura = Double.parseDouble(txtClienteAltura.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,
							"El campo altura está vacío o el dato introducido es incorrecto", "ERROR", 0);
				}

				try {
					clientePeso = Double.parseDouble(txtClientePeso.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,
							"El campo cliente está vacío o el dato introducido es incorrecto", "ERROR", 0);
				}

				clienteId = Integer.parseInt(txtClienteId.getText());
				Cliente c = DAOCliente.selectClienteById(clienteId);

				c.setNombreCliente(clienteNombre);
				c.setApellidos(clienteApellido);
				c.setEdad(clienteEdad);
				c.setAltura(clienteAltura);
				c.setPeso(clientePeso);

				DAOCliente.updateCliente(c);

				btnMostrarClientes.doClick();

				txtClienteNombre.setText("");
				txtClienteApellidos.setText("");
				txtClienteEdad.setText("");
				txtClienteAltura.setText("");
				txtClientePeso.setText("");
			}
		});
		btnActualizarCliente.setIcon(new ImageIcon(App.class.getResource("/img/actualizar.png")));
		btnActualizarCliente.setFont(new Font("Dialog", Font.BOLD, 20));
		btnActualizarCliente.setBackground(new Color(255, 140, 0));
		btnActualizarCliente.setBounds(28, 393, 534, 48);
		frame.getContentPane().add(btnActualizarCliente);

		/**
		 * Botón para eliminar un cliente en la BD.
		 */

		JButton btnEliminarCliente = new JButton(" Eliminar");
		btnEliminarCliente.setForeground(Color.BLACK);
		btnEliminarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				clienteNombre = txtClienteNombre.getText();
				if (clienteNombre.length() == 0) {
					JOptionPane.showMessageDialog(null, "El campo nombre está vacío", "ERROR", 0);
				}

				clienteApellido = txtClienteApellidos.getText();
				if (clienteApellido.length() == 0) {
					JOptionPane.showMessageDialog(null, "El campo apellidos está vacío", "ERROR", 0);
				}

				try {
					clienteEdad = Integer.parseInt(txtClienteEdad.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "El campo edad está vacío o el dato introducido es incorrecto",
							"ERROR", 0);
				}

				try {
					clienteAltura = Double.parseDouble(txtClienteAltura.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,
							"El campo altura está vacío o el dato introducido es incorrecto", "ERROR", 0);
				}

				try {
					clientePeso = Double.parseDouble(txtClientePeso.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,
							"El campo cliente está vacío o el dato introducido es incorrecto", "ERROR", 0);
				}

				clienteId = Integer.parseInt(txtClienteId.getText());
				DAOCliente.deleteCliente(clienteId);

				btnMostrarClientes.doClick();

				txtClienteNombre.setText("");
				txtClienteApellidos.setText("");
				txtClienteEdad.setText("");
				txtClienteAltura.setText("");
				txtClientePeso.setText("");
			}
		});
		btnEliminarCliente.setIcon(new ImageIcon(App.class.getResource("/img/eliminar.png")));
		btnEliminarCliente.setBackground(new Color(255, 140, 0));
		btnEliminarCliente.setFont(new Font("Dialog", Font.BOLD, 20));
		btnEliminarCliente.setBounds(28, 453, 534, 48);
		frame.getContentPane().add(btnEliminarCliente);

		/**
		 * JLabel del Ejercicio.
		 */

		JLabel lblEjercicioNombre = new JLabel("Nombre:");
		lblEjercicioNombre.setForeground(new Color(255, 140, 0));
		lblEjercicioNombre.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEjercicioNombre.setBounds(1203, 102, 117, 35);
		frame.getContentPane().add(lblEjercicioNombre);

		JLabel lblEjercicioNumSeries = new JLabel("Nº Series:");
		lblEjercicioNumSeries.setForeground(new Color(255, 140, 0));
		lblEjercicioNumSeries.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEjercicioNumSeries.setBounds(1203, 163, 117, 35);
		frame.getContentPane().add(lblEjercicioNumSeries);

		JLabel lblRepeticiones = new JLabel("Repeticiones:");
		lblRepeticiones.setForeground(new Color(255, 140, 0));
		lblRepeticiones.setFont(new Font("Dialog", Font.BOLD, 18));
		lblRepeticiones.setBounds(1203, 223, 140, 35);
		frame.getContentPane().add(lblRepeticiones);

		JLabel lblEjercicioCarga = new JLabel("Cargar (kg):");
		lblEjercicioCarga.setForeground(new Color(255, 140, 0));
		lblEjercicioCarga.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEjercicioCarga.setBounds(1207, 277, 117, 35);
		frame.getContentPane().add(lblEjercicioCarga);

		txtEjercicioNombre = new JTextField();
		txtEjercicioNombre.setForeground(Color.BLACK);
		txtEjercicioNombre.setFont(new Font("Dialog", Font.BOLD, 16));
		txtEjercicioNombre.setColumns(10);
		txtEjercicioNombre.setBorder(null);
		txtEjercicioNombre.setBackground(new Color(255, 140, 0));
		txtEjercicioNombre.setBounds(1338, 108, 379, 19);
		frame.getContentPane().add(txtEjercicioNombre);

		txtEjercicioNumSeries = new JTextField();
		txtEjercicioNumSeries.setFont(new Font("Dialog", Font.BOLD, 16));
		txtEjercicioNumSeries.setColumns(10);
		txtEjercicioNumSeries.setBorder(null);
		txtEjercicioNumSeries.setBackground(new Color(255, 140, 0));
		txtEjercicioNumSeries.setBounds(1338, 172, 379, 19);
		frame.getContentPane().add(txtEjercicioNumSeries);

		txtEjercicioRepeticiones = new JTextField();
		txtEjercicioRepeticiones.setFont(new Font("Dialog", Font.BOLD, 16));
		txtEjercicioRepeticiones.setColumns(10);
		txtEjercicioRepeticiones.setBorder(null);
		txtEjercicioRepeticiones.setBackground(new Color(255, 140, 0));
		txtEjercicioRepeticiones.setBounds(1338, 230, 379, 19);
		frame.getContentPane().add(txtEjercicioRepeticiones);

		txtEjercicioCarga = new JTextField();
		txtEjercicioCarga.setFont(new Font("Dialog", Font.BOLD, 16));
		txtEjercicioCarga.setColumns(10);
		txtEjercicioCarga.setBorder(null);
		txtEjercicioCarga.setBackground(new Color(255, 140, 0));
		txtEjercicioCarga.setBounds(1338, 286, 379, 19);
		frame.getContentPane().add(txtEjercicioCarga);

		txtEjercicioId = new JTextField();
		txtEjercicioId.setOpaque(false);
		txtEjercicioId.setVisible(false);
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

		DefaultTableModel modelEjercicio = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que todas las celdas no sean editables
            }
        };

		modelEjercicio.addColumn("ID");
		modelEjercicio.addColumn("Nombre");
		modelEjercicio.addColumn("Series");
		modelEjercicio.addColumn("Repeticiones");
		modelEjercicio.addColumn("KG");

		List<Ejercicio> listaEjercicios = DAOEjercicio.selectAllEjercicios();

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
				int indexEjercicio = tableEjercicio.getSelectedRow();
				TableModel modelEjercicio = tableEjercicio.getModel();
				txtEjercicioId.setText(modelEjercicio.getValueAt(indexEjercicio, 0).toString());
				txtEjercicioNombre.setText(modelEjercicio.getValueAt(indexEjercicio, 1).toString()); 
				txtEjercicioRutina.setText(modelEjercicio.getValueAt(indexEjercicio, 1).toString()); 
				txtEjercicioNumSeries.setText(modelEjercicio.getValueAt(indexEjercicio, 2).toString());
				txtEjercicioRepeticiones.setText(modelEjercicio.getValueAt(indexEjercicio, 3).toString());
				txtEjercicioCarga.setText(modelEjercicio.getValueAt(indexEjercicio, 4).toString());
			}
		});
		tableEjercicio.setBounds(471, 30, 1, 1);
		tableEjercicio.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableEjercicio.setForeground(new Color(255, 102, 0));
		tableEjercicio.setFont(new Font("Dialog", Font.BOLD, 16));

		tableEjercicio.setRowHeight(25);
		
		TableColumnModel columnModelEjercicio = tableEjercicio.getColumnModel();
		TableColumn column1Ejer = columnModelEjercicio.getColumn(0);
		column1Ejer.setPreferredWidth(20);
        TableColumn column2Ejer = columnModelEjercicio.getColumn(1);
        column2Ejer.setPreferredWidth(175);
        TableColumn column3Ejer = columnModelEjercicio.getColumn(2);
        column3Ejer.setPreferredWidth(30);
        TableColumn column4Ejer = columnModelEjercicio.getColumn(3);
        column4Ejer.setPreferredWidth(100);
        TableColumn column5Ejer = columnModelEjercicio.getColumn(4);
        column5Ejer.setPreferredWidth(20);
        
        DefaultTableCellRenderer cellRendererEjercicio = (DefaultTableCellRenderer) tableEjercicio.getDefaultRenderer(Object.class);
        cellRendererEjercicio.setHorizontalAlignment(SwingConstants.CENTER);
        
        JTableHeader headerEjercicio = tableEjercicio.getTableHeader();
        headerEjercicio.setPreferredSize(new java.awt.Dimension(headerEjercicio.getWidth(), 35));
        
        DefaultTableCellRenderer headerRendererEjercicio = new DefaultTableCellRenderer();
        headerRendererEjercicio.setBackground(new Color(255, 102, 0));
        headerRendererEjercicio.setForeground(Color.BLACK);
        headerRendererEjercicio.setFont(headerRendererEjercicio.getFont().deriveFont(Font.BOLD, 16));
        headerRendererEjercicio.setHorizontalAlignment(SwingConstants.CENTER);
        headerEjercicio.setDefaultRenderer(headerRendererEjercicio);
		
		JScrollPane scrollPaneEjercicio = new JScrollPane(tableEjercicio);
		scrollPaneEjercicio.setOpaque(false);
		scrollPaneEjercicio.setBounds(1203, 524, 515, 284);
		frame.getContentPane().add(scrollPaneEjercicio);
		scrollPaneEjercicio.setBorder(null);

		/**
		 * Botones del Ejercicio.
		 */

		/**
		 * Botón para mostrar los ejercicio de la BD en la tabla.
		 */

		JButton btnMostrarEjercicios = new JButton("");
		btnMostrarEjercicios.setOpaque(false);
		btnMostrarEjercicios.setBorderPainted(false);
		btnMostrarEjercicios.setBorder(null);
		btnMostrarEjercicios.setVisible(false);
		btnMostrarEjercicios.setFont(new Font("Dialog", Font.BOLD, 14));
		btnMostrarEjercicios.setBackground(UIManager.getColor("Button.background"));
		btnMostrarEjercicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelEjercicio.setRowCount(0);

				List<Ejercicio> listaEjercicios = DAOEjercicio.selectAllEjercicios();
				for (Ejercicio ejercicios : listaEjercicios) {
					Object[] row = new Object[5];
					row[0] = ejercicios.getIdEjercicio();
					row[1] = ejercicios.getNombreEjercicio();
					row[2] = ejercicios.getNumeroSeries();
					row[3] = ejercicios.getNumeroRepeticiones();
					row[4] = ejercicios.getCargaKg();
					modelEjercicio.addRow(row);
				}
			}
		});
		btnMostrarEjercicios.setBounds(1120, 313, 59, 48);
		frame.getContentPane().add(btnMostrarEjercicios);

		/**
		 * Botón para insertar un ejercicio en la BD.
		 */

		JButton btnInsertarEjercicio = new JButton("  Insertar");
		btnInsertarEjercicio.setForeground(Color.BLACK);
		btnInsertarEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ejercicioNombre = txtEjercicioNombre.getText();
				if (ejercicioNombre.length() == 0) {
					JOptionPane.showMessageDialog(null, "El campo nombre está vacío", "ERROR", 0);
				}

				try {
					ejercicioNumSeries = Integer.parseInt(txtEjercicioNumSeries.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "El campo edad está vacío o el dato introducido es incorrecto",
							"ERROR", 0);
				}

				try {
					ejercicioRepeticiones = Integer.parseInt(txtEjercicioRepeticiones.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "El campo edad está vacío o el dato introducido es incorrecto",
							"ERROR", 0);
				}

				try {
					ejercicioCarga = Double.parseDouble(txtEjercicioCarga.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,
							"El campo altura está vacío o el dato introducido es incorrecto", "ERROR", 0);
				}

				Ejercicio e = new Ejercicio(ejercicioNombre, ejercicioNumSeries, ejercicioRepeticiones, ejercicioCarga);
				DAOEjercicio.insertEjercicio(e);

				btnMostrarEjercicios.doClick();

				txtEjercicioNombre.setText("");
				txtEjercicioNumSeries.setText("");
				txtEjercicioRepeticiones.setText("");
				txtEjercicioCarga.setText("");
			}
		});
		btnInsertarEjercicio.setIcon(new ImageIcon(App.class.getResource("/img/guardar.png")));
		btnInsertarEjercicio.setFont(new Font("Dialog", Font.BOLD, 20));
		btnInsertarEjercicio.setBackground(new Color(255, 140, 0));
		btnInsertarEjercicio.setBounds(1203, 333, 514, 48);
		frame.getContentPane().add(btnInsertarEjercicio);

		/**
		 * Botón para actualizar un ejercicio en la BD.
		 */

		JButton btnActualizarEjercicio = new JButton("  Actualizar");
		btnActualizarEjercicio.setForeground(Color.BLACK);
		btnActualizarEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ejercicioNombre = txtEjercicioNombre.getText();
				if (ejercicioNombre.length() == 0) {
					JOptionPane.showMessageDialog(null, "El campo nombre está vacío", "ERROR", 0);
				}

				try {
					ejercicioNumSeries = Integer.parseInt(txtEjercicioNumSeries.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "El campo edad está vacío o el dato introducido es incorrecto",
							"ERROR", 0);
				}

				try {
					ejercicioRepeticiones = Integer.parseInt(txtEjercicioRepeticiones.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "El campo edad está vacío o el dato introducido es incorrecto",
							"ERROR", 0);
				}

				try {
					ejercicioCarga = Double.parseDouble(txtEjercicioCarga.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,
							"El campo altura está vacío o el dato introducido es incorrecto", "ERROR", 0);
				}

				ejercicioId = Integer.parseInt(txtEjercicioId.getText());
				Ejercicio e = DAOEjercicio.selectEjercicioById(ejercicioId);

				e.setNombreEjercicio(ejercicioNombre);
				e.setNumeroSeries(ejercicioNumSeries);
				e.setNumeroRepeticiones(ejercicioRepeticiones);
				e.setCargaKg(ejercicioCarga);

				DAOEjercicio.updateEjercicio(e);

				btnMostrarEjercicios.doClick();

				txtEjercicioNombre.setText("");
				txtEjercicioNumSeries.setText("");
				txtEjercicioRepeticiones.setText("");
				txtEjercicioCarga.setText("");
			}
		});
		btnActualizarEjercicio.setIcon(new ImageIcon(App.class.getResource("/img/actualizar.png")));
		btnActualizarEjercicio.setFont(new Font("Dialog", Font.BOLD, 20));
		btnActualizarEjercicio.setBackground(new Color(255, 140, 0));
		btnActualizarEjercicio.setBounds(1203, 394, 513, 48);
		frame.getContentPane().add(btnActualizarEjercicio);

		/**
		 * Botón para eliminar un ejercicio en la BD.
		 */

		JButton btnEliminarEjercicio = new JButton("Eliminar");
		btnEliminarEjercicio.setForeground(Color.BLACK);
		btnEliminarEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ejercicioNombre = txtEjercicioNombre.getText();
				if (ejercicioNombre.length() == 0) {
					JOptionPane.showMessageDialog(null, "El campo nombre está vacío", "ERROR", 0);
				}

				try {
					ejercicioNumSeries = Integer.parseInt(txtEjercicioNumSeries.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "El campo edad está vacío o el dato introducido es incorrecto",
							"ERROR", 0);
				}

				try {
					ejercicioRepeticiones = Integer.parseInt(txtEjercicioRepeticiones.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "El campo edad está vacío o el dato introducido es incorrecto",
							"ERROR", 0);
				}

				try {
					ejercicioCarga = Double.parseDouble(txtEjercicioCarga.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,
							"El campo altura está vacío o el dato introducido es incorrecto", "ERROR", 0);
				}

				ejercicioId = Integer.parseInt(txtEjercicioId.getText());
				Ejercicio e = DAOEjercicio.selectEjercicioById(ejercicioId);

				e.setNombreEjercicio(ejercicioNombre);
				e.setNumeroSeries(ejercicioNumSeries);
				e.setNumeroRepeticiones(ejercicioRepeticiones);
				e.setCargaKg(ejercicioCarga);

				ejercicioId = Integer.parseInt(txtEjercicioId.getText());
				DAOEjercicio.deleteEjercicio(ejercicioId);

				btnMostrarEjercicios.doClick();

				txtEjercicioNombre.setText("");
				txtEjercicioNumSeries.setText("");
				txtEjercicioRepeticiones.setText("");
				txtEjercicioCarga.setText("");
			}
		});
		btnEliminarEjercicio.setIcon(new ImageIcon(App.class.getResource("/img/eliminar.png")));
		btnEliminarEjercicio.setFont(new Font("Dialog", Font.BOLD, 20));
		btnEliminarEjercicio.setBackground(new Color(255, 140, 0));
		btnEliminarEjercicio.setBounds(1203, 454, 513, 48);
		frame.getContentPane().add(btnEliminarEjercicio);

		/*
		 * Tabla Rutina.
		 */

		DefaultTableModel modelRutina = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que todas las celdas no sean editables
            }
        };

		modelRutina.addColumn("Cliente");
		modelRutina.addColumn("Ejercicio");

		modelRutina.setRowCount(0);
		List<Cliente> clientes = DAOCliente.selectAllClientes();

		for (Cliente c : clientes) {
			List<Ejercicio> ejercicioCliente = c.getEjercicios();

			for (Ejercicio ejer : ejercicioCliente) {
				Object[] row = new Object[2];

				row[0] = c.getNombreCliente();
				row[1] = ejer.getNombreEjercicio();
				modelRutina.addRow(row);
			}

		}

		JScrollPane scrollPaneRutina = new JScrollPane();
		scrollPaneRutina.setOpaque(false);
		scrollPaneRutina.setEnabled(false);
		scrollPaneRutina.setBorder(null);
		scrollPaneRutina.setBounds(662, 331, 448, 477);
		frame.getContentPane().add(scrollPaneRutina);

		tableRutina = new JTable(modelRutina);
		tableRutina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tableRutina.getSelectedRow();
				TableModel modelRutina = tableRutina.getModel();
				txtClienteRutina.setText(modelRutina.getValueAt(index, 0).toString());
				txtEjercicioRutina.setText(modelRutina.getValueAt(index, 1).toString());
			}
		});
		scrollPaneRutina.setViewportView(tableRutina);

		JButton btnMostrarRutina = new JButton("");
		btnMostrarRutina.setOpaque(false);
		btnMostrarRutina.setBorderPainted(false);
		btnMostrarRutina.setBorder(null);
		btnMostrarRutina.setVisible(false);
		btnMostrarRutina.setFont(new Font("Dialog", Font.BOLD, 14));
		btnMostrarRutina.setBackground(UIManager.getColor("Button.background"));
		btnMostrarRutina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelRutina.setRowCount(0);
				List<Cliente> clientes = DAOCliente.selectAllClientes();

				for (Cliente c : clientes) {
					List<Ejercicio> ejercicioCliente = c.getEjercicios();

					for (Ejercicio ejer : ejercicioCliente) {
						Object[] row = new Object[2];

						row[0] = c.getNombreCliente();
						row[1] = ejer.getNombreEjercicio();
						modelRutina.addRow(row);
					}

				}
			}
		});
		btnMostrarRutina.setBounds(846, 478, 89, 23);
		frame.getContentPane().add(btnMostrarRutina);
		
		DefaultTableCellRenderer cellRendererRutina = (DefaultTableCellRenderer) tableRutina.getDefaultRenderer(Object.class);
		cellRendererRutina.setHorizontalAlignment(SwingConstants.CENTER);
        
        JTableHeader headerRutina = tableRutina.getTableHeader();
        headerRutina.setPreferredSize(new java.awt.Dimension(headerRutina.getWidth(), 35));
        
        DefaultTableCellRenderer headerRendererRutina = new DefaultTableCellRenderer();
        headerRendererRutina.setBackground(new Color(255, 102, 0));
        headerRendererRutina.setForeground(Color.BLACK);
        headerRendererRutina.setFont(headerRendererRutina.getFont().deriveFont(Font.BOLD, 16));
        headerRendererRutina.setHorizontalAlignment(SwingConstants.CENTER);
        headerRutina.setDefaultRenderer(headerRendererRutina);
		
		JButton btnAsignarRutina = new JButton("  Asignar");
		btnAsignarRutina.setForeground(Color.BLACK);
		btnAsignarRutina.setIcon(new ImageIcon(App.class.getResource("/img/asignar.png")));
		btnAsignarRutina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente c = DAOCliente.selectCliente(txtClienteRutina.getText());
				Ejercicio e = DAOEjercicio.selectEjercicio(txtEjercicioRutina.getText());

				c.anyadirEjercicio(e);
				DAOCliente.updateCliente(c);
				
				btnMostrarRutina.doClick();
			}
		});
		btnAsignarRutina.setFont(new Font("Dialog", Font.BOLD, 20));
		btnAsignarRutina.setBackground(new Color(255, 140, 0));
		btnAsignarRutina.setBounds(663, 192, 447, 48);
		frame.getContentPane().add(btnAsignarRutina);

		JButton btnEliminarRutina = new JButton(" Eliminar");
		btnEliminarRutina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente c = DAOCliente.selectCliente(txtClienteRutina.getText());
				Ejercicio e = DAOEjercicio.selectEjercicio(txtEjercicioRutina.getText());

				c.quitarEjercicio(e);;
				DAOCliente.updateCliente(c);
				
				btnMostrarRutina.doClick();
			}
		});
		btnEliminarRutina.setForeground(Color.BLACK);
		btnEliminarRutina.setIcon(new ImageIcon(App.class.getResource("/img/eliminar.png")));
		btnEliminarRutina.setFont(new Font("Dialog", Font.BOLD, 20));
		btnEliminarRutina.setBackground(new Color(255, 140, 0));
		btnEliminarRutina.setBounds(663, 264, 451, 48);
		frame.getContentPane().add(btnEliminarRutina);
		
		/**
		 * JLabel del Fondo.
		 */

		JLabel lblFondo = new JLabel("");
		lblFondo.setOpaque(true);
		lblFondo.setFont(new Font("Dialog", Font.BOLD, 16));
		lblFondo.setForeground(new Color(0, 0, 0));
		lblFondo.setIcon(new ImageIcon(App.class.getResource("/img/fondoGym.jpg")));
		lblFondo.setBounds(0, -31, 1825, 864);
		frame.getContentPane().add(lblFondo);

	}
}