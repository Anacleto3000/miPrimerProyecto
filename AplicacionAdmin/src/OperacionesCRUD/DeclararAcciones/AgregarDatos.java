package OperacionesCRUD.DeclararAcciones;


public interface AgregarDatos {

    void AgregarProducto(String Nombre, String Descripcion, String Precio, String Stock, String Categoria, String ImagenName);

    void AgregarCategoria(String nombre, String descripcion, String imagen);

    void AgregarAnuncio(String nameAD, String nombreImagen);

    void AgregarPromocion(String Nombre, String Descripcion, String Descuento, String FechaInicio, String FechaFin, String imagen);

    void AgregarOferta(String nameOfert, String idProducto, String Descuento, String FechaIni, String FechaFin, String imagen);
}
