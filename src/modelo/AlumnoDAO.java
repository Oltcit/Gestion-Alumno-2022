package modelo;

import java.sql.*;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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

	public void buscarAlumnos(DefaultTableModel modelo) {
		try {
			Conexion conex = new Conexion ();
			Statement estatuto = conex.getConnection().createStatement();
			ResultSet res = estatuto.executeQuery("Select * from alumno order by Ape");
			while (res.next()) {
				Object fila [] = new Object [4];
				fila [0] = res.getInt("Dni");
				fila [1] = res.getString("Ape");
				fila [2] = res.getString ("Fecha");
				fila [3] = res.getInt("Doc");
				modelo.addRow(fila);
			}
			res.close();
			estatuto.close();
			conex.desconectar();
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}

	public void modificarAlumno(AlumnoVO miAlumnoVO) {
		// TODO Auto-generated method stub
		try {
			Conexion conex= new Conexion();
			String consulta= "UPDATE alumno set Dni=?, Ape=?, Fecha=?, Doc=? where Dni=?";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			estatuto.setInt(1,  miAlumnoVO.getDni());
			estatuto.setString(2,  miAlumnoVO.getApe());
			estatuto.setString(3,  miAlumnoVO.getFecha());
			estatuto.setInt(4,  miAlumnoVO.getDoc());
			estatuto.setInt(5,  miAlumnoVO.getDni());
			estatuto.executeUpdate();
			JOptionPane.showMessageDialog(null, "se modifico", "confirmacion", JOptionPane.INFORMATION_MESSAGE);
		}catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "Error en la consulta","ERROR",JOptionPane.ERROR_MESSAGE); 
		}
	}

	public void eliminarAlumno(int dni) {
		// TODO Auto-generated method stub
		try {
			Conexion conex = new Conexion();
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("delete from alumno where Dni='" + dni + "'");
			JOptionPane.showMessageDialog(null,"Se eliminó", "Información", JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,  "No se eliminó", "Información", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
	}

}
