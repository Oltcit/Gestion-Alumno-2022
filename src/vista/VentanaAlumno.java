package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class VentanaAlumno extends JFrame {

	private JPanel contentPane;
	private Coordinador miCoordinador;
	private JTextField txtDni;
	private JTextField txtApe;
	private JTextField txtFechaNac;
	private JCheckBox chkDoc;
	private JButton btnCancelar;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnGuardar;
	private JButton btnBuscar;
	
	

	public Coordinador getMiCoordinador() {
		return miCoordinador;
	}

	public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAlumno frame = new VentanaAlumno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaAlumno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnGuardar = new JButton("Guardar");
		panel.add(btnGuardar);
		
		btnAgregar = new JButton("Agregar");
		panel.add(btnAgregar);
		
		btnModificar = new JButton("Modificar");
		panel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		panel.add(btnEliminar);
		
		btnBuscar = new JButton("Buscar");
		panel.add(btnBuscar);
		
		btnCancelar = new JButton("Cancela");
		panel.add(btnCancelar);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dni:");
		lblNewLabel.setBounds(32, 33, 46, 14);
		panel_1.add(lblNewLabel);
		
		txtDni = new JTextField();
		txtDni.setBounds(97, 30, 86, 20);
		panel_1.add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido y nombre:");
		lblNewLabel_1.setBounds(32, 73, 118, 14);
		panel_1.add(lblNewLabel_1);
		
		txtApe = new JTextField();
		txtApe.setBounds(169, 70, 375, 20);
		panel_1.add(txtApe);
		txtApe.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha de nacimiento:");
		lblNewLabel_2.setBounds(32, 128, 118, 14);
		panel_1.add(lblNewLabel_2);
		
		txtFechaNac = new JTextField();
		txtFechaNac.setBounds(169, 125, 151, 20);
		panel_1.add(txtFechaNac);
		txtFechaNac.setColumns(10);
		
		chkDoc = new JCheckBox("Documentaci\u00F3n");
		chkDoc.setBounds(28, 172, 132, 23);
		panel_1.add(chkDoc);
	}
	
	private void habilita(boolean dni, boolean ape, boolean fnac, boolean doc, boolean btnguarda, boolean btnAgrega, 
			boolean btnMod, boolean btnEli, boolean btnBusca, boolean btnCancela) {
		
		txtDni.setEditable(dni);
		txtApe.setEditable(ape);
		txtFechaNac.setEditable(fnac);
		chkDoc.setEnabled(doc);
		btnGuardar.setVisible(btnguarda);
		btnAgregar.setEnabled(btnAgrega);
		btnModificar.setEnabled(btnMod);
		btnEliminar.setEnabled(btnEli);
		btnBuscar.setEnabled(btnBusca);
		btnCancelar.setEnabled(btnCancela);
		
		
	}
}
