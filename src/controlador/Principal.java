package controlador;

import vista.VentanaAlumno;
import vista.VentanaPrincipal;

public class Principal {

	Coordinador miCoordinador;
	VentanaPrincipal miVentanaPrincipal;
	VentanaAlumno miVentanaAlumno;
	
	public static void main(String[] args) {
		Principal miPrincipal = new Principal();
		miPrincipal.iniciar();
	}

	private void iniciar() {
		
		// se crean todos los objetos
		miCoordinador = new Coordinador();
		miVentanaPrincipal = new VentanaPrincipal();
		miVentanaAlumno = new VentanaAlumno();
		
		//se relaciona el coordinador
		miCoordinador.setMiVentanaPrincipal(miVentanaPrincipal);
		miCoordinador.setMiVentanaAlumno(miVentanaAlumno);
		
		//se relacionan las clases con el coordinador
		miVentanaPrincipal.setMiCoordinador(miCoordinador);
		miVentanaAlumno.setMiCoordinador(miCoordinador);
		
		miVentanaPrincipal.setVisible(true);
		
		
	}

}
