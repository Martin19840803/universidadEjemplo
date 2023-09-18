package universidad.AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private static final String URL = "jdbc:mariadb://localhost:3306/";
    private static final String DB = "universidadulp";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection conexionDB() {
        Connection conexion = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexion = DriverManager.getConnection(URL+DB, USER, PASSWORD);
                    
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar Driver " + ex.getMessage());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexión " + ex.getMessage());
        }
        return conexion;

    }

    public static void cerrarConeccion(Connection conexion) {

        if (conexion != null) {

            try {
                conexion.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
            }
        }

    }
}
