package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	static String bd = "alumno";
	static String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
	static String url="jdbc:ucanaccess://c:\\datosaccess\\"+bd+".accdb";
	
	Connection conn =null;
	
	public Conexion(){
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			
			if (conn!=null){
				System.out.println("Conexión a la base de datos "+bd+" OK");
			}
		} catch (SQLException e){
			System.out.println(e);
		} catch (ClassNotFoundException e){
			System.out.println(e);
		} catch (Exception e){
			System.out.println(e);
		}
	}
	
	public Connection getConnection(){
		return conn;
	}
	
	public void desconectar(){
		conn = null;
	}
}
