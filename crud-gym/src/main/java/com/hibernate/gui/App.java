package com.hibernate.gui;

import java.awt.EventQueue;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import com.hibernate.dao.DAOCliente;
import com.hibernate.dao.DAOEjercicio;
import com.hibernate.model.Cliente;
import com.hibernate.model.Ejercicio;
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
import java.awt.Component;

public class App {

	private JFrame frmGym;

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
	private JTextField txtGrupoMuscular;
	private JTextField txtEntrenadorApellidos;
	private JTextField txtEntrenadorTitulación;
	private JTextField txtNombreEntrenador;
	private JTextField txtEntrenadorEdad;
	private JTextField txtEntrenadorImpartirClase;
	private JTextField txtClaseImpartirClase;
	private JTextField txtNombreClase;
	private JTextField txtLugarClase;
	private JTextField txtTopeClase;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmGym.setVisible(true);
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

		frmGym = new JFrame();
		frmGym.setTitle("El Gym de L&L");
		frmGym.setResizable(true);
		frmGym.setBackground(new Color(255, 69, 0));
		frmGym.setBounds(500, 500, 2500, 1500);
		frmGym.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGym.getContentPane().setLayout(null);
		frmGym.setSize(1758, 1640);
				
				JLabel lblEjercicioId = new JLabel("Id:");
				lblEjercicioId.setForeground(new Color(255, 140, 0));
				lblEjercicioId.setFont(new Font("Dialog", Font.BOLD, 18));
				lblEjercicioId.setBounds(1204, 22, 36, 35);
				frmGym.getContentPane().add(lblEjercicioId);
				
				JLabel lblClienteId = new JLabel("Id:");
				lblClienteId.setForeground(new Color(255, 140, 0));
				lblClienteId.setFont(new Font("Dialog", Font.BOLD, 18));
				lblClienteId.setBounds(28, 22, 36, 35);
				frmGym.getContentPane().add(lblClienteId);
		
				txtClienteId = new JTextField();
				txtClienteId.setEnabled(false);
				txtClienteId.setEditable(false);
				txtClienteId.setForeground(Color.BLACK);
				txtClienteId.setFont(new Font("Dialog", Font.BOLD, 14));
				txtClienteId.setColumns(10);
				txtClienteId.setBorder(null);
				txtClienteId.setBackground(new Color(255, 140, 0));
				txtClienteId.setBounds(61, 22, 36, 35);
				frmGym.getContentPane().add(txtClienteId);
		
		txtTopeClase = new JTextField();
		txtTopeClase.setForeground(Color.BLACK);
		txtTopeClase.setFont(new Font("Dialog", Font.BOLD, 16));
		txtTopeClase.setColumns(10);
		txtTopeClase.setBorder(null);
		txtTopeClase.setBackground(new Color(255, 140, 0));
		txtTopeClase.setBounds(1312, 905, 406, 19);
		frmGym.getContentPane().add(txtTopeClase);
		
		txtNombreClase = new JTextField();
		txtNombreClase.setForeground(Color.BLACK);
		txtNombreClase.setFont(new Font("Dialog", Font.BOLD, 16));
		txtNombreClase.setColumns(10);
		txtNombreClase.setBorder(null);
		txtNombreClase.setBackground(new Color(255, 140, 0));
		txtNombreClase.setBounds(1312, 797, 406, 20);
		frmGym.getContentPane().add(txtNombreClase);
		
		JButton btnEliminarEjercicio_1 = new JButton("Eliminar");
		btnEliminarEjercicio_1.setIcon(new ImageIcon(App.class.getResource("/img/eliminar.png")));
		btnEliminarEjercicio_1.setForeground(Color.BLACK);
		btnEliminarEjercicio_1.setFont(new Font("Dialog", Font.BOLD, 20));
		btnEliminarEjercicio_1.setBackground(new Color(255, 140, 0));
		btnEliminarEjercicio_1.setBounds(1204, 1074, 513, 48);
		frmGym.getContentPane().add(btnEliminarEjercicio_1);
		
		JLabel lblLugarClase = new JLabel("Lugar:");
		lblLugarClase.setForeground(new Color(255, 140, 0));
		lblLugarClase.setFont(new Font("Dialog", Font.BOLD, 18));
		lblLugarClase.setBounds(1204, 847, 117, 35);
		frmGym.getContentPane().add(lblLugarClase);
		
		JLabel lblTopeClase = new JLabel("Tope:");
		lblTopeClase.setForeground(new Color(255, 140, 0));
		lblTopeClase.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTopeClase.setBounds(1204, 897, 140, 35);
		frmGym.getContentPane().add(lblTopeClase);
		
		JLabel lblNombreClase = new JLabel("Nombre:");
		lblNombreClase.setForeground(new Color(255, 140, 0));
		lblNombreClase.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNombreClase.setBounds(1204, 789, 117, 35);
		frmGym.getContentPane().add(lblNombreClase);
		
		JButton btnInsertarEjercicio_1 = new JButton("  Insertar");
		btnInsertarEjercicio_1.setIcon(new ImageIcon(App.class.getResource("/img/guardar.png")));
		btnInsertarEjercicio_1.setForeground(Color.BLACK);
		btnInsertarEjercicio_1.setFont(new Font("Dialog", Font.BOLD, 20));
		btnInsertarEjercicio_1.setBackground(new Color(255, 140, 0));
		btnInsertarEjercicio_1.setBounds(1204, 958, 514, 48);
		frmGym.getContentPane().add(btnInsertarEjercicio_1);
		
		JButton btnActualizarEjercicio_1 = new JButton("  Actualizar");
		btnActualizarEjercicio_1.setIcon(new ImageIcon(App.class.getResource("/img/actualizar.png")));
		btnActualizarEjercicio_1.setForeground(Color.BLACK);
		btnActualizarEjercicio_1.setFont(new Font("Dialog", Font.BOLD, 20));
		btnActualizarEjercicio_1.setBackground(new Color(255, 140, 0));
		btnActualizarEjercicio_1.setBounds(1204, 1015, 513, 48);
		frmGym.getContentPane().add(btnActualizarEjercicio_1);
		
		JScrollPane scrollPaneClase = new JScrollPane((Component) null);
		scrollPaneClase.setOpaque(false);
		scrollPaneClase.setBorder(null);
		scrollPaneClase.setBounds(1203, 1137, 515, 263);
		frmGym.getContentPane().add(scrollPaneClase);
		
		txtLugarClase = new JTextField();
		txtLugarClase.setForeground(Color.BLACK);
		txtLugarClase.setFont(new Font("Dialog", Font.BOLD, 16));
		txtLugarClase.setColumns(10);
		txtLugarClase.setBorder(null);
		txtLugarClase.setBackground(new Color(255, 140, 0));
		txtLugarClase.setBounds(1312, 855, 406, 19);
		frmGym.getContentPane().add(txtLugarClase);
		
		JScrollPane scrollImpartirClase = new JScrollPane();
		scrollImpartirClase.setOpaque(false);
		scrollImpartirClase.setEnabled(false);
		scrollImpartirClase.setBorder(null);
		scrollImpartirClase.setBounds(663, 1005, 448, 395);
		frmGym.getContentPane().add(scrollImpartirClase);
		
		txtClaseImpartirClase = new JTextField();
		txtClaseImpartirClase.setForeground(Color.BLACK);
		txtClaseImpartirClase.setFont(new Font("Dialog", Font.BOLD, 16));
		txtClaseImpartirClase.setEditable(false);
		txtClaseImpartirClase.setColumns(10);
		txtClaseImpartirClase.setBorder(null);
		txtClaseImpartirClase.setBackground(new Color(255, 140, 0));
		txtClaseImpartirClase.setBounds(787, 844, 323, 19);
		frmGym.getContentPane().add(txtClaseImpartirClase);
		
		JLabel lblClaseImpartirClase = new JLabel("Clase:");
		lblClaseImpartirClase.setForeground(new Color(255, 140, 0));
		lblClaseImpartirClase.setFont(new Font("Dialog", Font.BOLD, 18));
		lblClaseImpartirClase.setBounds(663, 845, 117, 15);
		frmGym.getContentPane().add(lblClaseImpartirClase);
		
		JButton btnAsignarClase = new JButton("  Asignar");
		btnAsignarClase.setIcon(new ImageIcon(App.class.getResource("/img/asignar.png")));
		btnAsignarClase.setForeground(Color.BLACK);
		btnAsignarClase.setFont(new Font("Dialog", Font.BOLD, 20));
		btnAsignarClase.setBackground(new Color(255, 140, 0));
		btnAsignarClase.setBounds(663, 884, 447, 48);
		frmGym.getContentPane().add(btnAsignarClase);
		
		JLabel lblEntreadorImpartirClase = new JLabel("Entrenador:");
		lblEntreadorImpartirClase.setForeground(new Color(255, 140, 0));
		lblEntreadorImpartirClase.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEntreadorImpartirClase.setBounds(663, 799, 108, 15);
		frmGym.getContentPane().add(lblEntreadorImpartirClase);
		
		JButton btnEliminarImpartirClase = new JButton(" Eliminar");
		btnEliminarImpartirClase.setIcon(new ImageIcon(App.class.getResource("/img/eliminar.png")));
		btnEliminarImpartirClase.setForeground(Color.BLACK);
		btnEliminarImpartirClase.setFont(new Font("Dialog", Font.BOLD, 20));
		btnEliminarImpartirClase.setBackground(new Color(255, 140, 0));
		btnEliminarImpartirClase.setBounds(663, 943, 447, 48);
		frmGym.getContentPane().add(btnEliminarImpartirClase);
		
		txtEntrenadorImpartirClase = new JTextField();
		txtEntrenadorImpartirClase.setForeground(Color.BLACK);
		txtEntrenadorImpartirClase.setFont(new Font("Dialog", Font.BOLD, 16));
		txtEntrenadorImpartirClase.setEditable(false);
		txtEntrenadorImpartirClase.setColumns(10);
		txtEntrenadorImpartirClase.setBorder(null);
		txtEntrenadorImpartirClase.setBackground(new Color(255, 140, 0));
		txtEntrenadorImpartirClase.setBounds(787, 798, 323, 19);
		frmGym.getContentPane().add(txtEntrenadorImpartirClase);
		
		JLabel lblFiltrar = new JLabel("Filtrar");
		lblFiltrar.setForeground(new Color(255, 140, 0));
		lblFiltrar.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 42));
		lblFiltrar.setBounds(822, 285, 136, 54);
		frmGym.getContentPane().add(lblFiltrar);
		
		JScrollPane scrollPaneEntrenador = new JScrollPane((Component) null);
		scrollPaneEntrenador.setOpaque(false);
		scrollPaneEntrenador.setEnabled(false);
		scrollPaneEntrenador.setBorder(null);
		scrollPaneEntrenador.setBounds(28, 1135, 534, 265);
		frmGym.getContentPane().add(scrollPaneEntrenador);
		
		JButton btnInsertarEntrenador = new JButton("  Insertar");
		btnInsertarEntrenador.setIcon(new ImageIcon(App.class.getResource("/img/guardar.png")));
		btnInsertarEntrenador.setForeground(Color.BLACK);
		btnInsertarEntrenador.setFont(new Font("Dialog", Font.BOLD, 20));
		btnInsertarEntrenador.setBackground(new Color(255, 140, 0));
		btnInsertarEntrenador.setBounds(28, 956, 534, 48);
		frmGym.getContentPane().add(btnInsertarEntrenador);
		
		JButton btnActualizarEntrenador = new JButton(" Actualizar");
		btnActualizarEntrenador.setIcon(new ImageIcon(App.class.getResource("/img/actualizar.png")));
		btnActualizarEntrenador.setForeground(Color.BLACK);
		btnActualizarEntrenador.setFont(new Font("Dialog", Font.BOLD, 20));
		btnActualizarEntrenador.setBackground(new Color(255, 140, 0));
		btnActualizarEntrenador.setBounds(28, 1016, 534, 48);
		frmGym.getContentPane().add(btnActualizarEntrenador);
		
		JButton btnEliminarEntrenador = new JButton(" Eliminar");
		btnEliminarEntrenador.setIcon(new ImageIcon(App.class.getResource("/img/eliminar.png")));
		btnEliminarEntrenador.setForeground(Color.BLACK);
		btnEliminarEntrenador.setFont(new Font("Dialog", Font.BOLD, 20));
		btnEliminarEntrenador.setBackground(new Color(255, 140, 0));
		btnEliminarEntrenador.setBounds(28, 1076, 534, 48);
		frmGym.getContentPane().add(btnEliminarEntrenador);
		
		txtNombreEntrenador = new JTextField();
		txtNombreEntrenador.setForeground(Color.BLACK);
		txtNombreEntrenador.setFont(new Font("Dialog", Font.BOLD, 16));
		txtNombreEntrenador.setColumns(10);
		txtNombreEntrenador.setBorder(null);
		txtNombreEntrenador.setBackground(new Color(255, 140, 0));
		txtNombreEntrenador.setBounds(138, 798, 424, 19);
		frmGym.getContentPane().add(txtNombreEntrenador);
		
		txtEntrenadorEdad = new JTextField();
		txtEntrenadorEdad.setForeground(Color.BLACK);
		txtEntrenadorEdad.setFont(new Font("Dialog", Font.BOLD, 16));
		txtEntrenadorEdad.setColumns(10);
		txtEntrenadorEdad.setBorder(null);
		txtEntrenadorEdad.setBackground(new Color(255, 140, 0));
		txtEntrenadorEdad.setBounds(138, 880, 424, 19);
		frmGym.getContentPane().add(txtEntrenadorEdad);
		
		txtEntrenadorApellidos = new JTextField();
		txtEntrenadorApellidos.setForeground(Color.BLACK);
		txtEntrenadorApellidos.setFont(new Font("Dialog", Font.BOLD, 16));
		txtEntrenadorApellidos.setColumns(10);
		txtEntrenadorApellidos.setBorder(null);
		txtEntrenadorApellidos.setBackground(new Color(255, 140, 0));
		txtEntrenadorApellidos.setBounds(138, 837, 424, 19);
		frmGym.getContentPane().add(txtEntrenadorApellidos);
		
		JLabel lblEntrenadorTitulación = new JLabel("Titulación:");
		lblEntrenadorTitulación.setForeground(new Color(255, 140, 0));
		lblEntrenadorTitulación.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEntrenadorTitulación.setBounds(28, 910, 117, 35);
		frmGym.getContentPane().add(lblEntrenadorTitulación);
		
		JLabel lblNombreEntrenador = new JLabel("Nombre:");
		lblNombreEntrenador.setForeground(new Color(255, 140, 0));
		lblNombreEntrenador.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNombreEntrenador.setBounds(28, 789, 117, 35);
		frmGym.getContentPane().add(lblNombreEntrenador);
		
		txtEntrenadorTitulación = new JTextField();
		txtEntrenadorTitulación.setForeground(Color.BLACK);
		txtEntrenadorTitulación.setFont(new Font("Dialog", Font.BOLD, 16));
		txtEntrenadorTitulación.setColumns(10);
		txtEntrenadorTitulación.setBorder(null);
		txtEntrenadorTitulación.setBackground(new Color(255, 140, 0));
		txtEntrenadorTitulación.setBounds(138, 918, 424, 19);
		frmGym.getContentPane().add(txtEntrenadorTitulación);
		
		JLabel lblEntrenadorApellidos = new JLabel("Apellidos:");
		lblEntrenadorApellidos.setForeground(new Color(255, 140, 0));
		lblEntrenadorApellidos.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEntrenadorApellidos.setBounds(28, 828, 117, 35);
		frmGym.getContentPane().add(lblEntrenadorApellidos);
		
		JLabel lblEntrenadorEdad = new JLabel("Edad:");
		lblEntrenadorEdad.setForeground(new Color(255, 140, 0));
		lblEntrenadorEdad.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEntrenadorEdad.setBounds(28, 872, 117, 35);
		frmGym.getContentPane().add(lblEntrenadorEdad);
		
		JLabel lblClase = new JLabel("Clase");
		lblClase.setForeground(new Color(255, 140, 0));
		lblClase.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 56));
		lblClase.setBounds(1408, 723, 152, 55);
		frmGym.getContentPane().add(lblClase);
		
		JLabel lblImpartirClase = new JLabel("Impartir Clase");
		lblImpartirClase.setForeground(new Color(255, 140, 0));
		lblImpartirClase.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 56));
		lblImpartirClase.setBounds(700, 723, 389, 55);
		frmGym.getContentPane().add(lblImpartirClase);
		
		JLabel lblEntrenador = new JLabel("Entrenador");
		lblEntrenador.setForeground(new Color(255, 140, 0));
		lblEntrenador.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 56));
		lblEntrenador.setBounds(157, 723, 323, 55);
		frmGym.getContentPane().add(lblEntrenador);
		
		JLabel lblGrupoMuscularRutina = new JLabel("Grupo Muscular:");
		lblGrupoMuscularRutina.setForeground(new Color(255, 140, 0));
		lblGrupoMuscularRutina.setFont(new Font("Dialog", Font.BOLD, 18));
		lblGrupoMuscularRutina.setBounds(663, 352, 152, 15);
		frmGym.getContentPane().add(lblGrupoMuscularRutina);
		
		JComboBox comboBoxGrupoMuscular = new JComboBox();
		comboBoxGrupoMuscular.setBounds(825, 350, 285, 24);
		frmGym.getContentPane().add(comboBoxGrupoMuscular);
		
		JLabel lblGrupoMuscular = new JLabel("Grupo Muscular:");
		lblGrupoMuscular.setForeground(new Color(255, 140, 0));
		lblGrupoMuscular.setFont(new Font("Dialog", Font.BOLD, 18));
		lblGrupoMuscular.setBounds(1203, 230, 168, 35);
		frmGym.getContentPane().add(lblGrupoMuscular);
		
		txtGrupoMuscular = new JTextField();
		txtGrupoMuscular.setForeground(Color.BLACK);
		txtGrupoMuscular.setFont(new Font("Dialog", Font.BOLD, 16));
		txtGrupoMuscular.setColumns(10);
		txtGrupoMuscular.setBorder(null);
		txtGrupoMuscular.setBackground(new Color(255, 140, 0));
		txtGrupoMuscular.setBounds(1369, 238, 348, 19);
		frmGym.getContentPane().add(txtGrupoMuscular);

		txtEjercicioRutina = new JTextField();
		txtEjercicioRutina.setEditable(false);
		txtEjercicioRutina.setForeground(Color.BLACK);
		txtEjercicioRutina.setFont(new Font("Dialog", Font.BOLD, 16));
		txtEjercicioRutina.setColumns(10);
		txtEjercicioRutina.setBorder(null);
		txtEjercicioRutina.setBackground(new Color(255, 140, 0));
		txtEjercicioRutina.setBounds(775, 131, 335, 19);
		frmGym.getContentPane().add(txtEjercicioRutina);

		txtClienteRutina = new JTextField();
		txtClienteRutina.setEditable(false);
		txtClienteRutina.setForeground(Color.BLACK);
		txtClienteRutina.setFont(new Font("Dialog", Font.BOLD, 16));
		txtClienteRutina.setColumns(10);
		txtClienteRutina.setBorder(null);
		txtClienteRutina.setBackground(new Color(255, 140, 0));
		txtClienteRutina.setBounds(775, 85, 335, 19);
		frmGym.getContentPane().add(txtClienteRutina);

		JButton btnVaciarRutina = new JButton("");
		btnVaciarRutina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtClienteRutina.setText("");
				txtEjercicioRutina.setText("");
			}
		});
		btnVaciarRutina.setOpaque(false);
		btnVaciarRutina.setBackground(new Color(0, 0, 0));
		btnVaciarRutina.setBorder(null);
		btnVaciarRutina.setIcon(new ImageIcon(App.class.getResource("/img/vaciar.png")));
		btnVaciarRutina.setBounds(955, 22, 59, 48);
		frmGym.getContentPane().add(btnVaciarRutina);

		JLabel lblClienteRutina = new JLabel("Cliente:");
		lblClienteRutina.setForeground(new Color(255, 140, 0));
		lblClienteRutina.setFont(new Font("Dialog", Font.BOLD, 18));
		lblClienteRutina.setBounds(663, 86, 89, 15);
		frmGym.getContentPane().add(lblClienteRutina);

		JLabel lblEjercicioRutina = new JLabel("Ejercicio:");
		lblEjercicioRutina.setForeground(new Color(255, 140, 0));
		lblEjercicioRutina.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEjercicioRutina.setBounds(663, 132, 117, 15);
		frmGym.getContentPane().add(lblEjercicioRutina);

		JLabel lblRutina = new JLabel("Rutina");
		lblRutina.setForeground(new Color(255, 140, 0));
		lblRutina.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 56));
		lblRutina.setBounds(786, 11, 185, 54);
		frmGym.getContentPane().add(lblRutina);

		JLabel lblClienteNombre = new JLabel("Nombre:");
		lblClienteNombre.setFont(new Font("Dialog", Font.BOLD, 18));
		lblClienteNombre.setForeground(new Color(255, 140, 0));
		lblClienteNombre.setBounds(28, 77, 117, 35);
		frmGym.getContentPane().add(lblClienteNombre);

		JLabel lblTablaCliente = new JLabel("Cliente");
		lblTablaCliente.setForeground(new Color(255, 140, 0));
		lblTablaCliente.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 56));
		lblTablaCliente.setBounds(205, 11, 198, 55);
		frmGym.getContentPane().add(lblTablaCliente);

		JLabel lblTablaEjercicio = new JLabel("Ejercicio");
		lblTablaEjercicio.setForeground(new Color(255, 140, 0));
		lblTablaEjercicio.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 56));
		lblTablaEjercicio.setBounds(1369, 3, 244, 70);
		frmGym.getContentPane().add(lblTablaEjercicio);

		JLabel lblClienteApellidos = new JLabel("Apellidos:");
		lblClienteApellidos.setFont(new Font("Dialog", Font.BOLD, 18));
		lblClienteApellidos.setForeground(new Color(255, 140, 0));
		lblClienteApellidos.setBounds(28, 115, 117, 35);
		frmGym.getContentPane().add(lblClienteApellidos);

		JLabel lblClienteEdad = new JLabel("Edad:");
		lblClienteEdad.setFont(new Font("Dialog", Font.BOLD, 18));
		lblClienteEdad.setForeground(new Color(255, 140, 0));
		lblClienteEdad.setBounds(28, 152, 117, 35);
		frmGym.getContentPane().add(lblClienteEdad);

		JLabel lblClienteAltura = new JLabel("Altura:");
		lblClienteAltura.setFont(new Font("Dialog", Font.BOLD, 18));
		lblClienteAltura.setForeground(new Color(255, 140, 0));
		lblClienteAltura.setBounds(28, 191, 117, 35);
		frmGym.getContentPane().add(lblClienteAltura);

		JLabel lblClientePeso = new JLabel("Peso:");
		lblClientePeso.setFont(new Font("Dialog", Font.BOLD, 18));
		lblClientePeso.setForeground(new Color(255, 140, 0));
		lblClientePeso.setBounds(28, 230, 117, 35);
		frmGym.getContentPane().add(lblClientePeso);

		/**
		 * TextField del Cliente.
		 */

		txtClienteNombre = new JTextField();
		txtClienteNombre.setFont(new Font("Dialog", Font.BOLD, 16));
		txtClienteNombre.setForeground(new Color(0, 0, 0));
		txtClienteNombre.setBackground(new Color(255, 140, 0));
		txtClienteNombre.setBorder(null);
		txtClienteNombre.setBounds(138, 85, 424, 19);
		frmGym.getContentPane().add(txtClienteNombre);
		txtClienteNombre.setColumns(10);

		txtClienteApellidos = new JTextField();
		txtClienteApellidos.setForeground(Color.BLACK);
		txtClienteApellidos.setFont(new Font("Dialog", Font.BOLD, 16));
		txtClienteApellidos.setBackground(new Color(255, 140, 0));
		txtClienteApellidos.setBorder(null);
		txtClienteApellidos.setColumns(10);
		txtClienteApellidos.setBounds(138, 124, 424, 19);
		frmGym.getContentPane().add(txtClienteApellidos);

		txtClienteEdad = new JTextField();
		txtClienteEdad.setForeground(Color.BLACK);
		txtClienteEdad.setFont(new Font("Dialog", Font.BOLD, 16));
		txtClienteEdad.setBorder(null);
		txtClienteEdad.setBackground(new Color(255, 140, 0));
		txtClienteEdad.setColumns(10);
		txtClienteEdad.setBounds(138, 161, 424, 19);
		frmGym.getContentPane().add(txtClienteEdad);

		txtClienteAltura = new JTextField();
		txtClienteAltura.setForeground(Color.BLACK);
		txtClienteAltura.setFont(new Font("Dialog", Font.BOLD, 16));
		txtClienteAltura.setBackground(new Color(255, 140, 0));
		txtClienteAltura.setBorder(null);
		txtClienteAltura.setColumns(10);
		txtClienteAltura.setBounds(138, 200, 424, 19);
		frmGym.getContentPane().add(txtClienteAltura);

		txtClientePeso = new JTextField();
		txtClientePeso.setForeground(Color.BLACK);
		txtClientePeso.setFont(new Font("Dialog", Font.BOLD, 16));
		txtClientePeso.setBorder(null);
		txtClientePeso.setBackground(new Color(255, 140, 0));
		txtClientePeso.setColumns(10);
		txtClientePeso.setBounds(138, 238, 424, 19);
		frmGym.getContentPane().add(txtClientePeso);

		JButton btnVaciarCliente = new JButton("");
		btnVaciarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtClienteId.setText("");
				txtClienteNombre.setText("");
				txtClienteApellidos.setText("");
				txtClienteEdad.setText("");
				txtClienteAltura.setText("");
				txtClientePeso.setText("");
			}
		});
		btnVaciarCliente.setOpaque(false);
		btnVaciarCliente.setBackground(new Color(0, 0, 0));
		btnVaciarCliente.setBorder(null);
		btnVaciarCliente.setIcon(new ImageIcon(App.class.getResource("/img/vaciar.png")));
		btnVaciarCliente.setBounds(386, 21, 59, 48);
		frmGym.getContentPane().add(btnVaciarCliente);

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
		tableCliente.setShowVerticalLines(false);
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
		column0.setPreferredWidth(30);
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

		DefaultTableCellRenderer cellRenderer = (DefaultTableCellRenderer) tableCliente
				.getDefaultRenderer(Object.class);
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
		scrollPaneCliente.setBounds(28, 456, 534, 256);
		frmGym.getContentPane().add(scrollPaneCliente);
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
		frmGym.getContentPane().add(btnMostrarClientes);

		/**
		 * Botón para insertar un nuevo cliente en la BD.
		 */

		JButton btnInsertarCliente = new JButton("  Insertar");
		btnInsertarCliente.setForeground(Color.BLACK);
		btnInsertarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean camposValidos = true;

				clienteNombre = txtClienteNombre.getText();
				if (clienteNombre.length() == 0) {
				    JOptionPane.showMessageDialog(null, "El campo NOMBRE está vacío", "ERROR",
				            JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (clienteNombre.matches(".*\\d.*")) {
				    JOptionPane.showMessageDialog(null, "El campo NOMBRE no debe contener números", "ERROR",
				            JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (!clienteNombre.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+")) {
				    JOptionPane.showMessageDialog(null, "El campo NOMBRE no debe contener caracteres especiales", "ERROR",
				            JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				}

				clienteApellido = txtClienteApellidos.getText();
				if (clienteApellido.length() == 0) {
				    JOptionPane.showMessageDialog(null, "El campo APELLIDOS está vacío", "ERROR",
				            JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (clienteApellido.matches(".*\\d.*")) {
				    JOptionPane.showMessageDialog(null, "El campo APELLIDOS no debe contener números", "ERROR",
				            JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (!clienteApellido.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+")) {
				    JOptionPane.showMessageDialog(null, "El campo APELLIDOS no debe contener caracteres especiales", "ERROR",
				            JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				}

				String edadTexto = txtClienteEdad.getText();
				if (edadTexto.length() == 0) {
				    JOptionPane.showMessageDialog(null, "El campo EDAD está vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (!edadTexto.matches("[0-9]+")) {
				    JOptionPane.showMessageDialog(null, "El dato introducido en el campo EDAD es incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (!edadTexto.matches("\\d+")) {
				    JOptionPane.showMessageDialog(null, "El dato introducido en el campo EDAD contiene símbolos", "ERROR", JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else {
				    clienteEdad = Integer.parseInt(edadTexto);
				    if (clienteEdad < 16 || clienteEdad > 90) {
				        JOptionPane.showMessageDialog(null, "El dato introducido en el campo EDAD está fuera del rango permitido (16 - 90)", "ERROR", JOptionPane.ERROR_MESSAGE);
				        camposValidos = false;
				    }
				}

				String alturaTexto = txtClienteAltura.getText();
				if (alturaTexto.length() == 0) {
				    JOptionPane.showMessageDialog(null, "El campo ALTURA está vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (!alturaTexto.matches("[0-9.]+")) {
				    JOptionPane.showMessageDialog(null, "El dato introducido en el campo ALTURA es incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else {
				    double altura = Double.parseDouble(alturaTexto);
				    if (altura < 1 || altura > 3) {
				        JOptionPane.showMessageDialog(null, "El dato introducido en el campo ALTURA está fuera del rango permitido (1 - 3)", "ERROR", JOptionPane.ERROR_MESSAGE);
				        camposValidos = false;
				    } else {
				        clienteAltura = altura;
				    }
				}

				String pesoTexto = txtClientePeso.getText();
				if (pesoTexto.length() == 0) {
				    JOptionPane.showMessageDialog(null, "El campo PESO está vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (!pesoTexto.matches("^\\d+(\\.\\d+)?$")) {
				    JOptionPane.showMessageDialog(null, "El dato introducido en el campo PESO es incorrecto", "ERROR",
				            JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else {
				    clientePeso = Double.parseDouble(pesoTexto);
				    if (clientePeso < 45 || clientePeso > 300) {
				        JOptionPane.showMessageDialog(null,
				                "El dato introducido en el campo PESO está fuera del rango permitido (45 - 300)",
				                "ERROR", JOptionPane.ERROR_MESSAGE);
				        camposValidos = false;
				    }
				}

				if (camposValidos) {
					Cliente c = new Cliente(clienteNombre, clienteApellido, clienteEdad, clienteAltura, clientePeso);

					DAOCliente.insertCliente(c);

					btnMostrarClientes.doClick();

					txtClienteNombre.setText("");
					txtClienteApellidos.setText("");
					txtClienteEdad.setText("");
					txtClienteAltura.setText("");
					txtClientePeso.setText("");
				}
			}
		});
		btnInsertarCliente.setIcon(new ImageIcon(App.class.getResource("/img/guardar.png")));
		btnInsertarCliente.setFont(new Font("Dialog", Font.BOLD, 20));
		btnInsertarCliente.setBackground(new Color(255, 140, 0));
		btnInsertarCliente.setBounds(28, 277, 534, 48);
		frmGym.getContentPane().add(btnInsertarCliente);

		/**
		 * Botón para actualizar un cliente en la BD.
		 */

		JButton btnActualizarCliente = new JButton(" Actualizar");
		btnActualizarCliente.setForeground(Color.BLACK);
		btnActualizarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				boolean camposValidos = true;

				clienteNombre = txtClienteNombre.getText();
				if (clienteNombre.length() == 0) {
				    JOptionPane.showMessageDialog(null, "El campo NOMBRE está vacío", "ERROR",
				            JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (clienteNombre.matches(".*\\d.*")) {
				    JOptionPane.showMessageDialog(null, "El campo NOMBRE no debe contener números", "ERROR",
				            JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (!clienteNombre.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+")) {
				    JOptionPane.showMessageDialog(null, "El campo NOMBRE no debe contener caracteres especiales", "ERROR",
				            JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				}

				clienteApellido = txtClienteApellidos.getText();
				if (clienteApellido.length() == 0) {
				    JOptionPane.showMessageDialog(null, "El campo APELLIDOS está vacío", "ERROR",
				            JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (clienteApellido.matches(".*\\d.*")) {
				    JOptionPane.showMessageDialog(null, "El campo APELLIDOS no debe contener números", "ERROR",
				            JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (!clienteApellido.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+")) {
				    JOptionPane.showMessageDialog(null, "El campo APELLIDOS no debe contener caracteres especiales", "ERROR",
				            JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				}

				String edadTexto = txtClienteEdad.getText();
				if (edadTexto.length() == 0) {
				    JOptionPane.showMessageDialog(null, "El campo EDAD está vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (!edadTexto.matches("[0-9]+")) {
				    JOptionPane.showMessageDialog(null, "El dato introducido en el campo EDAD es incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (!edadTexto.matches("\\d+")) {
				    JOptionPane.showMessageDialog(null, "El dato introducido en el campo EDAD contiene símbolos", "ERROR", JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else {
				    clienteEdad = Integer.parseInt(edadTexto);
				    if (clienteEdad < 16 || clienteEdad > 90) {
				        JOptionPane.showMessageDialog(null, "El dato introducido en el campo EDAD está fuera del rango permitido (16 - 90)", "ERROR", JOptionPane.ERROR_MESSAGE);
				        camposValidos = false;
				    }
				}

				String alturaTexto = txtClienteAltura.getText();
				if (alturaTexto.length() == 0) {
				    JOptionPane.showMessageDialog(null, "El campo ALTURA está vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (!alturaTexto.matches("[0-9.]+")) {
				    JOptionPane.showMessageDialog(null, "El dato introducido en el campo ALTURA es incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else {
				    double altura = Double.parseDouble(alturaTexto);
				    if (altura < 1 || altura > 3) {
				        JOptionPane.showMessageDialog(null, "El dato introducido en el campo ALTURA está fuera del rango permitido (1 - 3)", "ERROR", JOptionPane.ERROR_MESSAGE);
				        camposValidos = false;
				    } else {
				        clienteAltura = altura;
				    }
				}

				String pesoTexto = txtClientePeso.getText();
				if (pesoTexto.length() == 0) {
				    JOptionPane.showMessageDialog(null, "El campo PESO está vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (!pesoTexto.matches("^\\d+(\\.\\d+)?$")) {
				    JOptionPane.showMessageDialog(null, "El dato introducido en el campo PESO es incorrecto", "ERROR",
				            JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else {
				    clientePeso = Double.parseDouble(pesoTexto);
				    if (clientePeso < 45 || clientePeso > 300) {
				        JOptionPane.showMessageDialog(null,
				                "El dato introducido en el campo PESO está fuera del rango permitido (45 - 300)",
				                "ERROR", JOptionPane.ERROR_MESSAGE);
				        camposValidos = false;
				    }
				}

				if (camposValidos) {
					Cliente c = new Cliente(clienteNombre, clienteApellido, clienteEdad, clienteAltura, clientePeso);

					DAOCliente.insertCliente(c);

					btnMostrarClientes.doClick();

					txtClienteNombre.setText("");
					txtClienteApellidos.setText("");
					txtClienteEdad.setText("");
					txtClienteAltura.setText("");
					txtClientePeso.setText("");
				}
			}
		});
		btnActualizarCliente.setIcon(new ImageIcon(App.class.getResource("/img/actualizar.png")));
		btnActualizarCliente.setFont(new Font("Dialog", Font.BOLD, 20));
		btnActualizarCliente.setBackground(new Color(255, 140, 0));
		btnActualizarCliente.setBounds(28, 337, 534, 48);
		frmGym.getContentPane().add(btnActualizarCliente);

		/**
		 * Botón para eliminar un cliente en la BD.
		 */

		JButton btnEliminarCliente = new JButton(" Eliminar");
		btnEliminarCliente.setForeground(Color.BLACK);
		btnEliminarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				boolean camposValidos = true;

				clienteNombre = txtClienteNombre.getText();
				if (clienteNombre.length() == 0) {
				    JOptionPane.showMessageDialog(null, "El campo NOMBRE está vacío", "ERROR",
				            JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (clienteNombre.matches(".*\\d.*")) {
				    JOptionPane.showMessageDialog(null, "El campo NOMBRE no debe contener números", "ERROR",
				            JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (!clienteNombre.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+")) {
				    JOptionPane.showMessageDialog(null, "El campo NOMBRE no debe contener caracteres especiales", "ERROR",
				            JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				}

				clienteApellido = txtClienteApellidos.getText();
				if (clienteApellido.length() == 0) {
				    JOptionPane.showMessageDialog(null, "El campo APELLIDOS está vacío", "ERROR",
				            JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (clienteApellido.matches(".*\\d.*")) {
				    JOptionPane.showMessageDialog(null, "El campo APELLIDOS no debe contener números", "ERROR",
				            JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (!clienteApellido.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+")) {
				    JOptionPane.showMessageDialog(null, "El campo APELLIDOS no debe contener caracteres especiales", "ERROR",
				            JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				}

				String edadTexto = txtClienteEdad.getText();
				if (edadTexto.length() == 0) {
				    JOptionPane.showMessageDialog(null, "El campo EDAD está vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (!edadTexto.matches("[0-9]+")) {
				    JOptionPane.showMessageDialog(null, "El dato introducido en el campo EDAD es incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (!edadTexto.matches("\\d+")) {
				    JOptionPane.showMessageDialog(null, "El dato introducido en el campo EDAD contiene símbolos", "ERROR", JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else {
				    clienteEdad = Integer.parseInt(edadTexto);
				    if (clienteEdad < 16 || clienteEdad > 90) {
				        JOptionPane.showMessageDialog(null, "El dato introducido en el campo EDAD está fuera del rango permitido (16 - 90)", "ERROR", JOptionPane.ERROR_MESSAGE);
				        camposValidos = false;
				    }
				}

				String alturaTexto = txtClienteAltura.getText();
				if (alturaTexto.length() == 0) {
				    JOptionPane.showMessageDialog(null, "El campo ALTURA está vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (!alturaTexto.matches("[0-9.]+")) {
				    JOptionPane.showMessageDialog(null, "El dato introducido en el campo ALTURA es incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else {
				    double altura = Double.parseDouble(alturaTexto);
				    if (altura < 1 || altura > 3) {
				        JOptionPane.showMessageDialog(null, "El dato introducido en el campo ALTURA está fuera del rango permitido (1 - 3)", "ERROR", JOptionPane.ERROR_MESSAGE);
				        camposValidos = false;
				    } else {
				        clienteAltura = altura;
				    }
				}

				String pesoTexto = txtClientePeso.getText();
				if (pesoTexto.length() == 0) {
				    JOptionPane.showMessageDialog(null, "El campo PESO está vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (!pesoTexto.matches("^\\d+(\\.\\d+)?$")) {
				    JOptionPane.showMessageDialog(null, "El dato introducido en el campo PESO es incorrecto", "ERROR",
				            JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else {
				    clientePeso = Double.parseDouble(pesoTexto);
				    if (clientePeso < 45 || clientePeso > 300) {
				        JOptionPane.showMessageDialog(null,
				                "El dato introducido en el campo PESO está fuera del rango permitido (45 - 300)",
				                "ERROR", JOptionPane.ERROR_MESSAGE);
				        camposValidos = false;
				    }
				}

				if (camposValidos) {
					Cliente c = new Cliente(clienteNombre, clienteApellido, clienteEdad, clienteAltura, clientePeso);

					DAOCliente.insertCliente(c);

					btnMostrarClientes.doClick();

					txtClienteNombre.setText("");
					txtClienteApellidos.setText("");
					txtClienteEdad.setText("");
					txtClienteAltura.setText("");
					txtClientePeso.setText("");
				}
			}
		});
		btnEliminarCliente.setIcon(new ImageIcon(App.class.getResource("/img/eliminar.png")));
		btnEliminarCliente.setBackground(new Color(255, 140, 0));
		btnEliminarCliente.setFont(new Font("Dialog", Font.BOLD, 20));
		btnEliminarCliente.setBounds(28, 397, 534, 48);
		frmGym.getContentPane().add(btnEliminarCliente);

		/**
		 * JLabel del Ejercicio.
		 */

		JLabel lblEjercicioNombre = new JLabel("Nombre:");
		lblEjercicioNombre.setForeground(new Color(255, 140, 0));
		lblEjercicioNombre.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEjercicioNombre.setBounds(1203, 77, 117, 35);
		frmGym.getContentPane().add(lblEjercicioNombre);

		JLabel lblEjercicioNumSeries = new JLabel("Nº Series:");
		lblEjercicioNumSeries.setForeground(new Color(255, 140, 0));
		lblEjercicioNumSeries.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEjercicioNumSeries.setBounds(1203, 115, 117, 35);
		frmGym.getContentPane().add(lblEjercicioNumSeries);

		JLabel lblRepeticiones = new JLabel("Repeticiones:");
		lblRepeticiones.setForeground(new Color(255, 140, 0));
		lblRepeticiones.setFont(new Font("Dialog", Font.BOLD, 18));
		lblRepeticiones.setBounds(1203, 152, 140, 35);
		frmGym.getContentPane().add(lblRepeticiones);

		JLabel lblEjercicioCarga = new JLabel("Carga (kg):");
		lblEjercicioCarga.setForeground(new Color(255, 140, 0));
		lblEjercicioCarga.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEjercicioCarga.setBounds(1203, 191, 136, 35);
		frmGym.getContentPane().add(lblEjercicioCarga);

		txtEjercicioNombre = new JTextField();
		txtEjercicioNombre.setForeground(Color.BLACK);
		txtEjercicioNombre.setFont(new Font("Dialog", Font.BOLD, 16));
		txtEjercicioNombre.setColumns(10);
		txtEjercicioNombre.setBorder(null);
		txtEjercicioNombre.setBackground(new Color(255, 140, 0));
		txtEjercicioNombre.setBounds(1369, 85, 348, 20);
		frmGym.getContentPane().add(txtEjercicioNombre);

		txtEjercicioNumSeries = new JTextField();
		txtEjercicioNumSeries.setForeground(Color.BLACK);
		txtEjercicioNumSeries.setFont(new Font("Dialog", Font.BOLD, 16));
		txtEjercicioNumSeries.setColumns(10);
		txtEjercicioNumSeries.setBorder(null);
		txtEjercicioNumSeries.setBackground(new Color(255, 140, 0));
		txtEjercicioNumSeries.setBounds(1369, 123, 348, 19);
		frmGym.getContentPane().add(txtEjercicioNumSeries);

		txtEjercicioRepeticiones = new JTextField();
		txtEjercicioRepeticiones.setForeground(Color.BLACK);
		txtEjercicioRepeticiones.setFont(new Font("Dialog", Font.BOLD, 16));
		txtEjercicioRepeticiones.setColumns(10);
		txtEjercicioRepeticiones.setBorder(null);
		txtEjercicioRepeticiones.setBackground(new Color(255, 140, 0));
		txtEjercicioRepeticiones.setBounds(1369, 160, 348, 19);
		frmGym.getContentPane().add(txtEjercicioRepeticiones);

		txtEjercicioCarga = new JTextField();
		txtEjercicioCarga.setForeground(Color.BLACK);
		txtEjercicioCarga.setFont(new Font("Dialog", Font.BOLD, 16));
		txtEjercicioCarga.setColumns(10);
		txtEjercicioCarga.setBorder(null);
		txtEjercicioCarga.setBackground(new Color(255, 140, 0));
		txtEjercicioCarga.setBounds(1369, 199, 348, 19);
		frmGym.getContentPane().add(txtEjercicioCarga);

		txtEjercicioId = new JTextField();
		txtEjercicioId.setEnabled(false);
		txtEjercicioId.setEditable(false);
		txtEjercicioId.setForeground(Color.BLACK);
		txtEjercicioId.setFont(new Font("Dialog", Font.BOLD, 14));
		txtEjercicioId.setColumns(10);
		txtEjercicioId.setBorder(null);
		txtEjercicioId.setBackground(new Color(255, 140, 0));
		txtEjercicioId.setBounds(1241, 23, 36, 35);
		frmGym.getContentPane().add(txtEjercicioId);

		JButton btnVaciarEjercicio = new JButton("");
		btnVaciarEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtEjercicioId.setText("");
				txtEjercicioNombre.setText("");
				txtEjercicioNumSeries.setText("");
				txtEjercicioRepeticiones.setText("");
				txtEjercicioCarga.setText("");
			}
		});
		btnVaciarEjercicio.setOpaque(false);
		btnVaciarEjercicio.setBackground(new Color(0, 0, 0));
		btnVaciarEjercicio.setBorder(null);
		btnVaciarEjercicio.setIcon(new ImageIcon(App.class.getResource("/img/vaciar.png")));
		btnVaciarEjercicio.setBounds(1600, 22, 59, 48);
		frmGym.getContentPane().add(btnVaciarEjercicio);

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
		tableEjercicio.setShowVerticalLines(false);
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

		DefaultTableCellRenderer cellRendererEjercicio = (DefaultTableCellRenderer) tableEjercicio
				.getDefaultRenderer(Object.class);
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
		scrollPaneEjercicio.setBounds(1202, 456, 515, 256);
		frmGym.getContentPane().add(scrollPaneEjercicio);
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
		btnMostrarEjercicios.setBounds(1122, 333, 59, 48);
		frmGym.getContentPane().add(btnMostrarEjercicios);

		/**
		 * Botón para insertar un ejercicio en la BD.
		 */

		JButton btnInsertarEjercicio = new JButton("  Insertar");
		btnInsertarEjercicio.setForeground(Color.BLACK);
		btnInsertarEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean camposValidos = true;
				
				ejercicioNombre = txtEjercicioNombre.getText();
				if (ejercicioNombre.length() == 0) {
				    JOptionPane.showMessageDialog(null, "El campo NOMBRE está vacío", "ERROR",
				            JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (ejercicioNombre.matches(".*\\d.*")) {
				    JOptionPane.showMessageDialog(null, "El campo NOMBRE no debe contener números", "ERROR",
				            JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (!ejercicioNombre.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+")) {
				    JOptionPane.showMessageDialog(null, "El campo NOMBRE no debe contener caracteres especiales", "ERROR",
				            JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				}

				String ejercicioNumSeriesStr = txtEjercicioNumSeries.getText();
				if (ejercicioNumSeriesStr.length() == 0) {
				    JOptionPane.showMessageDialog(null, "El campo NUMERO SERIES está vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (!ejercicioNumSeriesStr.matches("[0-9]+")) {
				    JOptionPane.showMessageDialog(null, "El dato introducido en el campo NUMERO SERIES es incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (!ejercicioNumSeriesStr.matches("\\d+")) {
				    JOptionPane.showMessageDialog(null, "El dato introducido en el campo NUMERO SERIES contiene símbolos", "ERROR", JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				}
				ejercicioNumSeries = Integer.parseInt(txtEjercicioNumSeries.getText());

				String ejercicioRepeticionesStr = txtEjercicioRepeticiones.getText();
				if (ejercicioRepeticionesStr.length() == 0) {
				    JOptionPane.showMessageDialog(null, "El campo REPETICIONES está vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (!ejercicioRepeticionesStr.matches("\\d+")) {
				    JOptionPane.showMessageDialog(null, "El dato introducido en el campo REPETICIONES contiene símbolos", "ERROR", JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else {
				    try {
				        ejercicioRepeticiones = Integer.parseInt(ejercicioRepeticionesStr);
				    } catch (NumberFormatException e) {
				        JOptionPane.showMessageDialog(null, "El dato introducido en el campo REPETICIONES no es válido", "ERROR", JOptionPane.ERROR_MESSAGE);
				        camposValidos = false;
				    }
				}

				String ejercicioCargaStr = txtEjercicioCarga.getText();
				if (ejercicioCargaStr.length() == 0) {
				    JOptionPane.showMessageDialog(null, "El campo CARGA está vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else if (!ejercicioCargaStr.matches("^\\d+(\\.\\d+)?$")) {
				    JOptionPane.showMessageDialog(null, "El dato introducido en el campo CARGA es incorrecto", "ERROR",
				            JOptionPane.ERROR_MESSAGE);
				    camposValidos = false;
				} else {
				    try {
				        ejercicioCarga = Double.parseDouble(ejercicioCargaStr);
				    } catch (NumberFormatException e) {
				        JOptionPane.showMessageDialog(null, "El dato introducido en el campo CARGA es incorrecto", "ERROR",
				                JOptionPane.ERROR_MESSAGE);
				        camposValidos = false;
				    }
				}

				if (camposValidos) {
					Ejercicio e = new Ejercicio(ejercicioNombre, ejercicioNumSeries, ejercicioRepeticiones, ejercicioCarga);
					DAOEjercicio.insertEjercicio(e);

					btnMostrarEjercicios.doClick();

					txtEjercicioNombre.setText("");
					txtEjercicioNumSeries.setText("");
					txtEjercicioRepeticiones.setText("");
					txtEjercicioCarga.setText("");
				}
			}
		});
		btnInsertarEjercicio.setIcon(new ImageIcon(App.class.getResource("/img/guardar.png")));
		btnInsertarEjercicio.setFont(new Font("Dialog", Font.BOLD, 20));
		btnInsertarEjercicio.setBackground(new Color(255, 140, 0));
		btnInsertarEjercicio.setBounds(1203, 277, 514, 48);
		frmGym.getContentPane().add(btnInsertarEjercicio);

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
		btnActualizarEjercicio.setBounds(1203, 334, 513, 48);
		frmGym.getContentPane().add(btnActualizarEjercicio);

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
		btnEliminarEjercicio.setBounds(1203, 393, 513, 48);
		frmGym.getContentPane().add(btnEliminarEjercicio);

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
		scrollPaneRutina.setBounds(663, 385, 447, 327);
		frmGym.getContentPane().add(scrollPaneRutina);

		tableRutina = new JTable(modelRutina);
		tableRutina.setFont(new Font("Dialog", Font.BOLD, 16));
		tableRutina.setShowVerticalLines(false);
		tableRutina.setRowHeight(25);
		tableRutina.setForeground(new Color(255, 102, 0));
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
		btnMostrarRutina.setFont(new Font("Dialog", Font.BOLD, 16));
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
		frmGym.getContentPane().add(btnMostrarRutina);

		DefaultTableCellRenderer cellRendererRutina = (DefaultTableCellRenderer) tableRutina
				.getDefaultRenderer(Object.class);
		cellRendererRutina.setHorizontalAlignment(SwingConstants.CENTER);

		JTableHeader headerRutina = tableRutina.getTableHeader();
		headerRutina.setPreferredSize(new java.awt.Dimension(headerRutina.getWidth(), 35));
		headerRutina.setFont(headerRutina.getFont().deriveFont(Font.BOLD, 16));

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
		btnAsignarRutina.setBounds(663, 171, 447, 48);
		frmGym.getContentPane().add(btnAsignarRutina);

		JButton btnEliminarRutina = new JButton(" Eliminar");
		btnEliminarRutina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente c = DAOCliente.selectCliente(txtClienteRutina.getText());
				Ejercicio e = DAOEjercicio.selectEjercicio(txtEjercicioRutina.getText());

				c.quitarEjercicio(e);
				;
				DAOCliente.updateCliente(c);

				btnMostrarRutina.doClick();
			}
		});
		btnEliminarRutina.setForeground(Color.BLACK);
		btnEliminarRutina.setIcon(new ImageIcon(App.class.getResource("/img/eliminar.png")));
		btnEliminarRutina.setFont(new Font("Dialog", Font.BOLD, 20));
		btnEliminarRutina.setBackground(new Color(255, 140, 0));
		btnEliminarRutina.setBounds(663, 226, 447, 48);
		frmGym.getContentPane().add(btnEliminarRutina);

		/**
		 * JLabel del Fondo.
		 */

		JLabel lblFondo = new JLabel("");
		lblFondo.setOpaque(true);
		lblFondo.setFont(new Font("Dialog", Font.BOLD, 16));
		lblFondo.setForeground(new Color(0, 0, 0));
		lblFondo.setIcon(new ImageIcon(App.class.getResource("/img/fondoGymDef.jpg")));
		lblFondo.setBounds(0, -65, 1825, 1690);
		frmGym.getContentPane().add(lblFondo);

	}
}