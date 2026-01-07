package Logica;

import OperacionesCRUD.DefinirAcciones.AgregarDatos;

import javax.swing.*;
import java.awt.*;

public class ValidarEntradaPromos {

    public static void ValidarEntradasForAddPromo(String nombre, String descripcion,String descuento, String Fechaini, String FechaFin,String imagen){

      if(!Herramientas.ValidarEntradas(nombre,Herramientas.TipoValidacion.LETRAS_NUMEROS)){
          JOptionPane.showMessageDialog(null,"No ingrese valores especiales");
          return;
      }

      if(!Herramientas.ValidarEntradas(descripcion,Herramientas.TipoValidacion.LETRAS_NUMEROS)){
            JOptionPane.showMessageDialog(null,"No ingrese valores especiales");
            return;
      }

      if(!Herramientas.ValidarEntradas(descuento,Herramientas.TipoValidacion.SOLO_NUMEROS)){
            JOptionPane.showMessageDialog(null,"Solo ingrese numeros enteros");
            return;
      }

      if(!Herramientas.ValidarEntradas(Fechaini,Herramientas.TipoValidacion.FECHA)){
            JOptionPane.showMessageDialog(null,"Respuesta incorrecta");
            return;
      }

      if(!Herramientas.ValidarEntradas(FechaFin,Herramientas.TipoValidacion.FECHA)){
            JOptionPane.showMessageDialog(null,"Respuesta incorrecto");
            return;
      }

      else {
          AgregarDatos ADDdatos= new AgregarDatos();
          ADDdatos.AgregarPromocion(nombre,descripcion,descuento,Fechaini,FechaFin, imagen);
      }

    }
}
