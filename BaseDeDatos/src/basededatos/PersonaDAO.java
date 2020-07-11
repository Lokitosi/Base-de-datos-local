package basededatos;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class PersonaDAO {
	private Persona p;

	public void salvar() {
		Connection ad = (Connection) ConexionBD.devolverConexion();

		try {

			String query = "UPDATE persona\n"+"SET nombre = ?, apellido = ?,edad = ?"+
			"WHERE ID = ?;";
			
			
			// el statement genera el vinculo con la base de datos :)
			PreparedStatement st = (PreparedStatement) ad.prepareStatement(query);
			st.setString(1, p.getNombre());
			st.setString(1, p.getApellido());
			st.setInt(1, p.getEdad());
			st.setInt(1, p.getID());
			
			ResultSet rs = st.executeQuery(query);
			
		} catch (SQLException e) {
			System.out.println("error al generar el statement 2");
			// e.printStackTrace();

		}
	}

	public Persona buscarID(int ID) {
		Connection ad = (Connection) ConexionBD.devolverConexion();

		try {
			// el statement genera el vinculo con la base de datos :)
			Statement st = (Statement) ad.createStatement();
			ResultSet rs = st.executeQuery("select * form persona WHERE ID =" + ID);

			while (rs.next()) {
				this.p = new Persona(rs.getInt(1), rs.getString(3), rs.getString(2), rs.getInt(4));
			}
			
		} catch (SQLException e) {
			System.out.println("error al generar el statement 1");
			// e.printStackTrace();

		}
		return p;
	}
	
	public void cerrarBd() {
		 ConexionBD.cerrarConexion();
	}
}
