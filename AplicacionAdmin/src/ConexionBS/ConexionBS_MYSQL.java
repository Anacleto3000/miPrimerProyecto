package ConexionBS;
import java.sql.*;

public class ConexionBS_MYSQL {

    public static Connection ObtenerConexion() {
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/miPrimerProyecto";

        try {
            Connection conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");
            return conexion;

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

}

