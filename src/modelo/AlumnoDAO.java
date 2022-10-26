package modelo;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class AlumnoDAO {
	public void registrarAlumno(AlumnoVO miAlumnoVO) {
		try{
			Conexion conex = new Conexion();
			Statement estatuto=conex.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO alumno VALUES ('"+miAlumnoVO.getDni()+"','"
					+miAlumnoVO.getApe()+"','"+miAlumnoVO.getFecha()+"','"+miAlumnoVO.getDoc()+"')");
			
			JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente","Información",
					JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();
		} catch (SQLException e){
			System.out.println("dni: "+miAlumnoVO.getDni()+" Ape: "+miAlumnoVO.getApe());
			System.out.println("Fecha: "+miAlumnoVO.getFecha()+" DOc: "+miAlumnoVO.getDoc());
			JOptionPane.showMessageDialog(null, "No se registró", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}

}
