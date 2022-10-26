package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.AlumnoVO;

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
	private int accion;
	

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
		setTitle("Altas, bajas, modificaciones y consultas de alumnos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 616, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarAlumno();
			}
		});
		panel.add(btnGuardar);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarAlumno();
			}
		});
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
		lblNewLabel_2.setBounds(32, 128, 127, 14);
		panel_1.add(lblNewLabel_2);
		
		txtFechaNac = new JTextField();
		txtFechaNac.setBounds(169, 125, 151, 20);
		panel_1.add(txtFechaNac);
		txtFechaNac.setColumns(10);
		
		chkDoc = new JCheckBox("Documentaci\u00F3n");
		chkDoc.setBounds(28, 172, 132, 23);
		panel_1.add(chkDoc);
		
		limpiar();
	}
	
	protected void guardarAlumno() {
		
	try {
		AlumnoVO miAlumnoVO = new AlumnoVO();
		miAlumnoVO.setDni(Integer.valueOf(txtDni.getText()));
		miAlumnoVO.setApe(txtApe.getText());
		miAlumnoVO.setFecha(txtFechaNac.getText());
		if (chkDoc.isSelected())
			miAlumnoVO.setDoc(1);
		else
			miAlumnoVO.setDoc(0);
		
		if (accion==1){
			miCoordinador.registrarAlumno(miAlumnoVO);
		} else {
			miCoordinador.modificarAlumno(miAlumnoVO);
		}
		limpiar();
	} catch (Exception e){
		JOptionPane.showMessageDialog(null, "Error en el ingreso de datos","Error",
				JOptionPane.ERROR_MESSAGE);
		limpiar();
	}
	}

	protected void agregarAlumno() {
		accion = 1;
		habilita(true, true, true, true, true, false, false, false, false, true);
		txtDni.grabFocus();
	}

	private void limpiar() {
		txtDni.setText("");
		txtApe.setText("");
		txtFechaNac.setText("");
		chkDoc.setSelected(false);
		
		habilita(true,false,false,false,false,true,false,false,true,false);
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
