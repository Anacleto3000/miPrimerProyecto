package OperacionesCRUD.DefinirAcciones;

import ConexionBS.ConexionBS_MYSQL;
import InterfazGrafica.Herramientas;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class ModificarDatos {
    public void ActivarOrDesactivarElementos(String Name){
        // guardar en BD
        String sql = "UPDATE "+ Name +" SET activo = ? WHERE id = ?";

        try (Connection con = ConexionBS_MYSQL.ObtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            for (int i = 0; i < Herramientas.modelo.getRowCount(); i++) {

                boolean activo = (Boolean) Herramientas.modelo.getValueAt(i, 2);
                int id = (Integer) Herramientas.modelo.getValueAt(i, 0);

                ps.setInt(1, activo ? 1 : 0);
                ps.setInt(2, id);
                ps.executeUpdate();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(Herramientas.panel,
                    "Error al guardar cambios:\n" + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
}
