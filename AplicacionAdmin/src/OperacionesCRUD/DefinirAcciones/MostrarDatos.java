package OperacionesCRUD.DefinirAcciones;

import ConexionBS.ConexionBS_MYSQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MostrarDatos implements OperacionesCRUD.DeclararAcciones.MostrarDatos {

    public Object [][] MostrarClientes(){

            List<Object[]> lista = new ArrayList<>();

            try (Connection conexion= ConexionBS_MYSQL.ObtenerConexion()){

                PreparedStatement ps = conexion.prepareStatement("SELECT * FROM usuarios");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    lista.add(new Object[]{
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("contrasena"),
                            rs.getString("telefono"),
                            rs.getString("correo"),
                            rs.getInt("dni")
                    });
                }

                rs.close();
                ps.close();


            } catch (Exception e) {
                e.printStackTrace();
            }

            // Convertir List<Object[]> a Object[][]
            Object[][] datos = new Object[lista.size()][];
            for (int i = 0; i < lista.size(); i++) {
                datos[i] = lista.get(i);
            }

            return datos;


    }


    public Object [][] MostrarProductos(){

        List<Object []> Lista= new ArrayList<>();

        try(Connection conexion=ConexionBS_MYSQL.ObtenerConexion()){
            PreparedStatement Instruccion= conexion.prepareStatement("Select * from productos");
            ResultSet rs = Instruccion.executeQuery();

            while(rs.next()){
                Lista.add(new Object[]{
                    rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getInt("precio"),
                        rs.getInt("stock"),
                        rs.getString("categoria_id"),
                        rs.getString("imagen")

                });
            }

            rs.close();
            Instruccion.close();

        }

        catch (SQLException e ){
            System.out.println("Error: " + e.getMessage());
        }

        // Convertir List<Object[]> a Object[][]
        Object[][] datos = new Object[Lista.size()][];
        for (int i = 0; i < Lista.size(); i++) {
            datos[i] = Lista.get(i);
        }

        return datos;
    }



    public void CargarElementosDesdeBD(DefaultTableModel modelo, String Name) {
        //=====================IMPORTANTE===============================
        //---Debe tener necesariamente como columnas id, nombre y activo
        //==============================================================

            String sql = "SELECT id,nombre, activo FROM "+ Name ;

            try (Connection con = ConexionBS_MYSQL.ObtenerConexion();
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                // Limpiar la tabla antes de cargar
                modelo.setRowCount(0);

                while (rs.next()) {
                    int id=rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    boolean activo = rs.getInt("activo") == 1;

                    modelo.addRow(new Object[]{id,nombre, activo});
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,
                        "Error al cargar "+Name+ "\n + e.getMessage()",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
    }



    public Object [][] MostrarCategorias(){

        List<Object []> Lista= new ArrayList<>();

        try(Connection conexion=ConexionBS_MYSQL.ObtenerConexion()){
            PreparedStatement Instruccion= conexion.prepareStatement("Select * from categorias");
            ResultSet rs = Instruccion.executeQuery();

            while(rs.next()){
                Lista.add(new Object[]{
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("imagen")

                });
            }

            rs.close();
            Instruccion.close();
        }

        catch (SQLException e ){
            System.out.println("Error: " + e.getMessage());
        }

        // Convertir List<Object[]> a Object[][]
        Object[][] datos = new Object[Lista.size()][];
        for (int i = 0; i < Lista.size(); i++) {
            datos[i] = Lista.get(i);
        }

        return datos;
    }

    public Object [][] MostrarPromociones(){

        List<Object []> Lista= new ArrayList<>();

        try(Connection conexion=ConexionBS_MYSQL.ObtenerConexion()){
            PreparedStatement Instruccion= conexion.prepareStatement("Select * from promociones");
            ResultSet rs = Instruccion.executeQuery();

            while(rs.next()){
                Lista.add(new Object[]{
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("descuento"),
                        rs.getString("fecha_inicio"),
                        rs.getString("fecha_fin"),
                        rs.getString("activo")

                });
            }

            rs.close();
            Instruccion.close();
        }

        catch (SQLException e ){
            System.out.println("Error: " + e.getMessage());
        }

        // Convertir List<Object[]> a Object[][]
        Object[][] datos = new Object[Lista.size()][];
        for (int i = 0; i < Lista.size(); i++) {
            datos[i] = Lista.get(i);
        }

        return datos;
    }

//---------------------------------------------------------------------------------------------------------------//
//========================PENDIENTE: Crear metodos para evitar repetir codigo==================================//
//---------------------------------------------------------------------------------------------------------------//


}
