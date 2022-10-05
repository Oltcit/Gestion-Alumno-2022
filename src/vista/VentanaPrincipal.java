package vista;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private Coordinador miCoordinador;
	
	

	public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setTitle("Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAlumno = new JButton("Alumno");
		btnAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miCoordinador.mostrarVentanaAlumno();
			}
		});
		btnAlumno.setBounds(69, 72, 89, 23);
		contentPane.add(btnAlumno);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/ciudad2.jpg")));
		lblNewLabel.setBounds(0, 0, 501, 343);
		contentPane.add(lblNewLabel);
		
		JButton btnMateria = new JButton("Materia");
		btnMateria.setBounds(288, 72, 89, 23);
		contentPane.add(btnMateria);
		
		JButton btnNota = new JButton("Nota");
		btnNota.setBounds(171, 151, 89, 23);
		contentPane.add(btnNota);
	}
}
