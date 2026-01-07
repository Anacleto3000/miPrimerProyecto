package OperacionesCRUD.DefinirAcciones;

import ConexionBS.ConexionBS_MYSQL;
import InterfazGrafica.PanelBuscarInformacion;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class BuscarOrEliminarDatos {



    public JPanel BuscarDatos(String TableName , int id){
        try(Connection conexion= ConexionBS_MYSQL.ObtenerConexion()) {
            String Sqltext="Select * from " + TableName + " where id= ?";
            PreparedStatement instruccion= conexion.prepareStatement(Sqltext);
            instruccion.setInt(1, id);
            ResultSet resultSet =instruccion.executeQuery();

            if (!resultSet.next()) {
                System.out.println("No se encontró registro");
                return null;
            }


            switch (TableName){
                case "Clientes":

                    int IDclient= resultSet.getInt("id");
                    String NameClient=resultSet.getString("nombre");
                    String Apellido=resultSet.getString("apellido");
                    int Telefono=resultSet.getInt("telefono");
                    String Correo=resultSet.getString("correo");
                    int DNI=resultSet.getInt("dni");

                    JPanel PanelDerechoClientes= PanelBuscarInformacion.MostrarPanelResultadoClientes(IDclient,NameClient,Apellido,Telefono,Correo,DNI);
                    return PanelDerechoClientes;


                case "Productos":
                    int IDproduct= resultSet.getInt("id");
                    String NameProduct=resultSet.getString("nombre");
                    String Descripcion=resultSet.getString("descripcion");
                    int precio=resultSet.getInt("precio");
                    int stock=resultSet.getInt("stock");
                    int categoria_id=resultSet.getInt("categoria_id");
                    String imagenName=resultSet.getString("imagen");

                     JPanel PanelDerechoProductos = PanelBuscarInformacion.MostrarPanelResultadoProductos(IDproduct, NameProduct, Descripcion, categoria_id, precio, stock, imagenName);
                     return PanelDerechoProductos;

                case "Categorias":
                    int IDcategoria= resultSet.getInt("id");
                    String nombre=resultSet.getString("nombre");
                    String descripcion= resultSet.getString("descripcion");

                    JPanel PanelDrechoCategorias= PanelBuscarInformacion.MostrarPanelResultadoCategorias(IDcategoria,nombre,descripcion);
                    return PanelDrechoCategorias;



                case "Promociones":

                    int  idpromocion= resultSet.getInt("id");
                    String NamePromo= resultSet.getString("nombre");
                    String DescripcionPromo= resultSet.getString("descripcion");
                    int Descuento=resultSet.getInt("descuento");
                    String FechaIni=resultSet.getString("fecha_inicio");
                    String FechaFin=resultSet.getString("fecha_fin");
                    String Estado=resultSet.getString("estado");

                    JPanel PanelDerechoPromociones= PanelBuscarInformacion.MostrarPanelResultadoPromociones(idpromocion,NamePromo,DescripcionPromo,Descuento,FechaIni,FechaFin,Estado);
                    return  PanelDerechoPromociones;

            }



        }
        catch (SQLException e){
            System.out.println("Error :" + e.getMessage());

            return null;
        }

        return null;

    }



    public void EliminarDatos(String TableName , int id){

        if (!TableName.matches("Productos|Categorias|Anuncios|Promociones")) {
            throw new IllegalArgumentException("Tabla no permitida");
        }

        try(Connection conexion= ConexionBS_MYSQL.ObtenerConexion()) {
            String Sqltext="Delete from "+TableName+ " where id= ?";
            PreparedStatement instruccion= conexion.prepareStatement(Sqltext);
            instruccion.setInt(1, id);
            instruccion.executeUpdate();

        }
        catch (SQLException e){
            System.out.println("Error :" + e.getMessage());
        }

    }

}
