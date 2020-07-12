package basededatos;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/* Nombres : Edison Andres Gamba Robayo - 20191020170
Angello Davis Agualimpia Linares - 20191020136 */


public class BaseDeDatos {
	
	public static void main(String[] args) {
		
		PersonaDAO p = new PersonaDAO();
		
		Persona p1 = p.buscarID(2);
		p1.setEdad(25);
		p.salvar();
		System.out.println(p1.getEdad());
		System.out.println(p1.getNombre()+ " "+p1.getApellido());
		p.cerrarBd();
		
	}
}

