package OperacionesCRUD.DeclararAcciones;

import javax.swing.table.DefaultTableModel;

public interface MostrarDatos {


    Object [][] MostrarClientes();

    Object [][] MostrarProductos();

    Object [][] MostrarCategorias();

    Object [][] MostrarPromociones();

    void CargarElementosDesdeBD(DefaultTableModel modelo, String Name);


}
