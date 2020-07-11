package basededatos;

import com.mysql.jdbc.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ConexionBD {
	
	private static Connection db = null ;
    private String driver = "jdbc:mysql";
    private String url = "localhost";
    private int puerto = 8889;
    private String bd = "prueba";

    public ConexionBD() {
    	
        if (db == null) {
            try {
            	Class.forName("com.mysql.jdbc.Driver");
                db = DriverManager.getConnection(driver + "://" + url + ":" + puerto + "/" + bd, "root", "root");
            } catch (SQLException ex) {
            	System.out.println("error con el driver 0");
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException e) {
				System.out.println("error con el driver");
				e.printStackTrace();
			}
        }
    }

    public static Connection devolverConexion() {
    	
        if (db == null) {
            new ConexionBD();
        }
        return db;
    }
    
    public static void cerrarConexion(){
        if(db!=null){
            try {
                db.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
	

}
