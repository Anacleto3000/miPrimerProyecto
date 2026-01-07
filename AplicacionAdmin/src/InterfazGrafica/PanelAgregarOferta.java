package InterfazGrafica;

import Logica.ValidarEntradaCategorias;
import Logica.ValidarEntradaOfertas;

import javax.swing.*;
import java.awt.*;

public class PanelAgregarOferta extends JPanel {

    private JTextField txtNombre;
    private JTextField txtIdProducto;
    private JTextField txtDescuento;
    private JButton btnRegistrar;
    private JButton btnImportarIMG;
    private String NombreImagenCategoria;
    private JTextField txtFechaInicio;
    private JTextField txtFechaFin;



    public PanelAgregarOferta() {
        initComponents();
    }

    private void initComponents() {

        setBackground(new Color(230, 230, 230));
        setLayout(null);  // Para respetar el diseño exacto de la imagen

        // ===== TÍTULO =====
        JLabel lblTitulo = new JLabel("Agregar Categoria");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblTitulo.setBounds(40, 30, 300, 30);
        add(lblTitulo);

        // ===== LABEL NOMBRE =====
        JLabel lblNombre = new JLabel("Nombre :");
        lblNombre.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lblNombre.setBounds(40, 120, 150, 25);
        add(lblNombre);



        // ===== CAMPO NOMBRE =====
        txtNombre = new JTextField();
        txtNombre.setFont(new Font("SansSerif", Font.PLAIN, 16));
        txtNombre.setBounds(160, 110, 350, 45);
        add(txtNombre);

        //BOTON IMPORTAR IMAGEN=====
        btnImportarIMG=new JButton("Importar imagen");
        btnImportarIMG.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnImportarIMG.setFocusPainted(false);
        btnImportarIMG.setBounds(550, 100, 230, 45);
        btnImportarIMG.setBackground(new Color(120, 120, 120));
        btnImportarIMG.setForeground(Color.WHITE);
        add(btnImportarIMG);

        btnImportarIMG.addActionListener(e -> {
            NombreImagenCategoria= Herramientas.seleccionarImagen(this, "Categoria");
        });




        // ===== LABEL id producto =====
        JLabel lblDescripcion = new JLabel("Id del producto:");
        lblDescripcion.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lblDescripcion.setBounds(40, 200, 200, 25);
        add(lblDescripcion);

        // ===== CAMPO id producto =====
        txtIdProducto = new JTextField();
        txtIdProducto.setFont(new Font("SansSerif", Font.PLAIN, 16));
        txtIdProducto.setBounds(200,190,80,50);
        add(txtIdProducto);




        // ==========Label descuento========
        JLabel lblDescuento= new JLabel("Descuento(sin %)");
        lblDescuento.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lblDescuento.setBounds(40, 290, 200, 25);
        add(lblDescuento);


        // ==========Label Campo descuento========
        txtDescuento= new JTextField();
        txtDescuento.setFont(new Font("SansSerif", Font.PLAIN, 16));
        txtDescuento.setBounds(200,280,80,50);
        add(txtDescuento);




        //============ Label Fecha Inicio ===========

        JLabel lblFechaIni= new JLabel("Fecha de inicio");
        lblFechaIni.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lblFechaIni.setBounds(40, 370, 200, 25);
        add(lblFechaIni);


        // ==========Label Campo fecha inicio========
        txtFechaInicio= new JTextField();
        txtFechaInicio.setFont(new Font("SansSerif", Font.PLAIN, 16));
        txtFechaInicio.setBounds(200,360,150,50);
        add(txtFechaInicio);



        //============ Label Fecha Fin===========

        JLabel lblFechaFin= new JLabel("Fecha de fin");
        lblFechaFin.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lblFechaFin.setBounds(450, 370, 200, 25);
        add(lblFechaFin);


        // ==========Label Campo fecha fin========
        txtFechaFin= new JTextField();
        txtFechaFin.setFont(new Font("SansSerif", Font.PLAIN, 16));
        txtFechaFin.setBounds(590,360,150,50);
        add(txtFechaFin);








        // ===== BOTÓN REGISTRAR =====
        btnRegistrar = new JButton("Registrar oferta");
        btnRegistrar.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setBounds(350, 450, 230, 45);
        btnRegistrar.setBackground(new Color(120, 120, 120));
        btnRegistrar.setForeground(Color.WHITE);
        add(btnRegistrar);


        btnRegistrar.addActionListener(e -> {
           String nombre= txtNombre.getText();
           String idProducto= txtIdProducto.getText();
           String Descuento= txtDescuento.getText();
           String FechaIni= txtFechaInicio.getText();
           String FechaFin= txtFechaFin.getText();

            ValidarEntradaOfertas.ValidarEntradasForAddOfertas(nombre,idProducto,Descuento,FechaIni,FechaFin,NombreImagenCategoria);

        });
    }
}
