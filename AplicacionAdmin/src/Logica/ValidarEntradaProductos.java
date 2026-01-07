package Logica;


import OperacionesCRUD.DefinirAcciones.AgregarDatos;

import javax.swing.*;

public class ValidarEntradaProductos {
    public static void ValidarEntradaForAddProducto(String nombre, String Descripcion, String precio, String  stock, String Categoria, String imagenName){


        if(!Herramientas.ValidarEntradas(nombre,Herramientas.TipoValidacion.LETRAS_NUMEROS)){
            JOptionPane.showMessageDialog(null,"Solo debe ingresar Letras o numeros");
            return;
        }

        if(!Herramientas.ValidarEntradas(Descripcion,Herramientas.TipoValidacion.TEXTO_LIBRE)){
            JOptionPane.showMessageDialog(null,"Esta opcion no deberia aparecer");
            return;
        }

        if(!Herramientas.ValidarEntradas(precio,Herramientas.TipoValidacion.SOLO_NUMEROS)){
            JOptionPane.showMessageDialog(null,"Ingrese unicamente nuemros enteros");
            return;
        }

        if(!Herramientas.ValidarEntradas(stock,Herramientas.TipoValidacion.SOLO_NUMEROS)){
            JOptionPane.showMessageDialog(null,"Ingrese unicamente numeros enteros");
            return;
        }

        if(!Herramientas.ValidarEntradas(Categoria,Herramientas.TipoValidacion.SOLO_NUMEROS)){
            JOptionPane.showMessageDialog(null,"Ingrese unicamente letras");
           return;
        }

        else {
            AgregarDatos AddDatos= new AgregarDatos();
            AddDatos.AgregarProducto(nombre,Descripcion, precio, stock, Categoria, imagenName);

        }






    }
}
