package basededatos;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class BaseDeDatos {
	
	public static void main(String[] args) {
		
		PersonaDAO p = new PersonaDAO();
		
		Persona p1 = p.buscarID(1);
		p1.setEdad(20);
		p.salvar();
		System.out.println(p1.getNombre()+ " "+p1.getApellido());
		p.cerrarBd();
		
	
		/*Connection ad = (Connection) ConexionBD.devolverConexion();
		
		try {
			// el statement genera el vinculo con la base de datos :)
			Statement st = (Statement) ad.createStatement();
			ResultSet rs = st.executeQuery("select * form persona");
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(3) + " "+ rs.getString(2));
			}
			ConexionBD.cerrarConexion();
		} catch (SQLException e) {
			System.out.println("error al generar el statement");
			//e.printStackTrace();
		}	*/
		
	
	}
}

