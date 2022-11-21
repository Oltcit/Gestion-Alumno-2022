package vista;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Coordinador;
import modelo.AlumnoDAO;
import modelo.AlumnoVO;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaAlumnoBuscar extends JFrame {
Coordinador miCoordinador;
	public Coordinador getMiCoordinador() {
	return miCoordinador;
}

public void setMiCoordinador(Coordinador miCoordinador) {
	this.miCoordinador = miCoordinador;
}

	private JPanel contentPane;
	private JTable Tabla;
	JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAlumnoBuscar frame = new VentanaAlumnoBuscar();
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
	public VentanaAlumnoBuscar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btnVolver);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
	}

	public void mostrarDatosConTableModel() {
		
	DefaultTableModel modelo = new DefaultTableModel();
	Tabla = new JTable();
	Tabla.addMouseListener (new MouseAdapter(){
		public void mouseClicked (MouseEvent e) {
			miCoordinador.pasarDatosalumno(pasarDatos (e));
		}
		
	});
	
	
	Tabla.setModel(modelo);
	modelo.addColumn("Dni");
	modelo.addColumn("Apellido");
	modelo.addColumn("Fecha");
	modelo.addColumn("Documentación");
	AlumnoDAO miAlumnoDAO = new AlumnoDAO ();
	miAlumnoDAO.buscarAlumnos (modelo);
	scrollPane.setViewportView (Tabla);
	}

	protected AlumnoVO pasarDatos(MouseEvent e) {
		// TODO Auto-generated method stub
		AlumnoVO miAlumnoVO = new AlumnoVO();
		int row = Tabla.rowAtPoint (e.getPoint());
		miAlumnoVO.setDni (Integer.valueOf(Tabla.getValueAt(row,0).toString()));
		miAlumnoVO.setApe(Tabla.getValueAt(row,1).toString());
		miAlumnoVO.setFecha(Tabla.getValueAt(row,2).toString());
		int estado = Integer.valueOf(Tabla.getValueAt(row, 3).toString());
		if (estado==1)
			miAlumnoVO.setDoc(1);
		else
			miAlumnoVO.setDoc(0);
		
		
	
		return miAlumnoVO;
	}

}
