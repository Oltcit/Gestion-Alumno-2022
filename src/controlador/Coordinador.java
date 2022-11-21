package controlador;

import modelo.AlumnoDAO;
import modelo.AlumnoVO;
import vista.VentanaAlumno;
import vista.VentanaAlumnoBuscar;
import vista.VentanaPrincipal;

public class Coordinador {

	private VentanaPrincipal miVentanaPrincipal;
	private VentanaAlumno miVentanaAlumno;
	private VentanaAlumnoBuscar miVentanaAlumnoBuscar;
	
	
	public VentanaAlumnoBuscar getMiVentanaAlumnoBuscar() {
		return miVentanaAlumnoBuscar;
	}
	public void setMiVentanaAlumnoBuscar(VentanaAlumnoBuscar miVentanaAlumnoBuscar) {
		this.miVentanaAlumnoBuscar = miVentanaAlumnoBuscar;
	}
	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}
	public void setMiVentanaPrincipal(VentanaPrincipal casa) {
		this.miVentanaPrincipal = casa;
	}
	public VentanaAlumno getMiVentanaAlumno() {
		return miVentanaAlumno;
	}
	public void setMiVentanaAlumno(VentanaAlumno miVentanaAlumno) {
		this.miVentanaAlumno = miVentanaAlumno;
	}
	
	// mostrar ventanas
	public void mostrarVentanaAlumno() {
		miVentanaAlumno.setVisible(true);
		
	}
	public void registrarAlumno(AlumnoVO miAlumnoVO) {
		AlumnoDAO miAlumnoDAO = new AlumnoDAO();
		miAlumnoDAO.registrarAlumno(miAlumnoVO);
		
	}
	public void modificarAlumno(AlumnoVO miAlumnoVO) {
		// TODO Auto-generated method stub
		AlumnoDAO miAlumnoDAO = new AlumnoDAO();
		miAlumnoDAO.modificarAlumno(miAlumnoVO);
		
	}
	public void mostrarVentanaAlumnoBuscar() {
		miVentanaAlumnoBuscar.setVisible (true);
		miVentanaAlumnoBuscar.mostrarDatosConTableModel ();
	}
	
	public void pasarDatosAlumno(AlumnoVO miAlumnoVO) {
		miVentanaAlumno.muestraAlumno(miAlumnoVO);
	}
	public void pasarDatosalumno(AlumnoVO miAlumnoVO) {
		miVentanaAlumno.muestraAlumno(miAlumnoVO);
		
	}
	public void eliminarAlumno(int Dni) {
		// TODO Auto-generated method stub
		AlumnoDAO miAlumnoDAO= new AlumnoDAO();
		miAlumnoDAO.eliminarAlumno(Dni);
		
	}
}
