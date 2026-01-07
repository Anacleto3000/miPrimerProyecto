package Logica;

import OperacionesCRUD.DefinirAcciones.AgregarDatos;

import javax.swing.*;

public class ValidarEntradaOfertas {
   public static void ValidarEntradasForAddOfertas(String nombre,String idProducto
           , String Descuento,String FechaInicio, String FechaFin, String imagen){

       if(!Herramientas.ValidarEntradas(nombre,Herramientas.TipoValidacion.LETRAS_NUMEROS)){
           JOptionPane.showMessageDialog(null,"Ingrese solo letras y numeros");

       }

       if(!Herramientas.ValidarEntradas(idProducto,Herramientas.TipoValidacion.SOLO_NUMEROS)){
           JOptionPane.showMessageDialog(null,"Ingrese unicamente numeros");
       }

       if(!Herramientas.ValidarEntradas(Descuento,Herramientas.TipoValidacion.SOLO_NUMEROS)){
           JOptionPane.showMessageDialog(null,"Ingrese solo numeros");
       }

       if(!Herramientas.ValidarEntradas(FechaInicio,Herramientas.TipoValidacion.FECHA)){
           JOptionPane.showMessageDialog(null,"Respuesta incorrecta en la fecha de inicio");
       }

       if(!Herramientas.ValidarEntradas(FechaFin,Herramientas.TipoValidacion.FECHA)){
           JOptionPane.showMessageDialog(null,"Respuesta incorrecta en la fecha de fin");
       }

       if (imagen== null) {
           JOptionPane.showMessageDialog(null,
                   "Primero debes importar una imagen.",
                   "Aviso",
                   JOptionPane.WARNING_MESSAGE);
           return;
       }

       else {
           AgregarDatos  agregarDatos = new AgregarDatos();
           agregarDatos.AgregarOferta(nombre, idProducto, Descuento, FechaInicio, FechaFin, imagen);
       }


   }
}
