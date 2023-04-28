package com.hibernate.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class App {

	private JFrame frame;

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
		
		JLabel lblAnillas = new JLabel("");
		lblAnillas.setIcon(new ImageIcon(App.class.getResource("/img/anillitas.png")));
		lblAnillas.setBounds(737, -150, 378, 446);
		frame.getContentPane().add(lblAnillas);
		
		JLabel lblPesas = new JLabel("");
		lblPesas.setIcon(new ImageIcon(App.class.getResource("/img/pesitas.png")));
		lblPesas.setBounds(-250, 362, 607, 446);
		frame.getContentPane().add(lblPesas);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(App.class.getResource("/img/fondoGym.jpg")));
		lblFondo.setBounds(0, 0, 1115, 713);
		frame.getContentPane().add(lblFondo);
	}
}