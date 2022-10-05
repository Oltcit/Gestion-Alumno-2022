package controlador;

import vista.VentanaAlumno;
import vista.VentanaPrincipal;

public class Coordinador {

	private VentanaPrincipal miVentanaPrincipal;
	private VentanaAlumno miVentanaAlumno;
	
	
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
	
	
}