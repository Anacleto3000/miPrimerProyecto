package InterfazGrafica;


import Logica.ValidarEntradaPromos;

import javax.swing.*;
import java.awt.*;

public class PanelAgregarPromocion extends JPanel {

    private JTextField txtNombre, txtDescuento, txtFechaInicio, txtFechaFin;
    private JTextArea txtDescripcion;
    private JButton btnRegistrar;
    private String NombreImagenPromocion;

    public PanelAgregarPromocion() {
        initComponents();
    }

    private void initComponents() {

        setBackground(new Color(230, 230, 230));
        setLayout(null);  // Para replicar exactamente el diseño

        // ===== TÍTULO =====
        JLabel lblTitulo = new JLabel("Agregar Promociones");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblTitulo.setBounds(40, 30, 300, 30);
        add(lblTitulo);



        //====Boton Importar Imagen ===

        JButton BtnImportIMG= new JButton("Importar imagen");
        BtnImportIMG.setBounds(500,30,230,45);
        BtnImportIMG.setBackground(new Color(120, 120, 120));
        BtnImportIMG.setForeground(Color.WHITE);
        BtnImportIMG.setFocusPainted(false);
        add(BtnImportIMG);


        // ===== LABELS =====
        JLabel lblNombre = new JLabel("Nombre :");
        lblNombre.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lblNombre.setBounds(40, 100, 150, 25);
        add(lblNombre);

        JLabel lblDescuento = new JLabel("Descuento :");
        lblDescuento.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lblDescuento.setBounds(500, 100, 200, 25);
        add(lblDescuento);

        JLabel lblDescripcion = new JLabel("Descripcion :");
        lblDescripcion.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lblDescripcion.setBounds(40, 170, 200, 25);
        add(lblDescripcion);

        JLabel lblFechaInicio = new JLabel("Fecha inicio :");
        lblFechaInicio.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lblFechaInicio.setBounds(40, 350, 200, 25);
        add(lblFechaInicio);

        JLabel lblFechaFin = new JLabel("Fecha Fin :");
        lblFechaFin.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lblFechaFin.setBounds(500, 350, 200, 25);
        add(lblFechaFin);

        // ===== CAMPOS =====

        // Nombre
        txtNombre = new JTextField();
        txtNombre.setFont(new Font("SansSerif", Font.PLAIN, 16));
        txtNombre.setBounds(150, 95, 300, 40);
        add(txtNombre);

        // Descuento
        txtDescuento = new JTextField();
        txtDescuento.setFont(new Font("SansSerif", Font.PLAIN, 16));
        txtDescuento.setBounds(620, 95, 100, 40);
        add(txtDescuento);

        // Descripcion
        txtDescripcion = new JTextArea();
        txtDescripcion.setFont(new Font("SansSerif", Font.PLAIN, 16));
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(txtDescripcion);
        scroll.setBounds(150, 165, 580, 150);
        add(scroll);

        // Fecha inicio
        txtFechaInicio = new JTextField();
        txtFechaInicio.setFont(new Font("SansSerif", Font.PLAIN, 16));
        txtFechaInicio.setBounds(170, 345, 150, 40);
        add(txtFechaInicio);

        // Fecha fin
        txtFechaFin = new JTextField();
        txtFechaFin.setFont(new Font("SansSerif", Font.PLAIN, 16));
        txtFechaFin.setBounds(620, 345, 150, 40);
        add(txtFechaFin);

        // ===== BOTÓN REGISTRAR =====
        btnRegistrar = new JButton("Registrar promocion");
        btnRegistrar.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnRegistrar.setBounds(350, 420, 230, 45);
        btnRegistrar.setBackground(new Color(120, 120, 120));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFocusPainted(false);
        add(btnRegistrar);


        BtnImportIMG.addActionListener(e -> {
            NombreImagenPromocion = Herramientas.seleccionarImagen(this, "Prmocion");
        });

        btnRegistrar.addActionListener(e -> {
            String nombre= txtNombre.getText();
            String descripcion= txtDescripcion.getText();
            String descuento=txtDescuento.getText();
            String FechaIni=txtFechaInicio.getText();
            String FechaFin=txtFechaFin.getText();

            ValidarEntradaPromos.ValidarEntradasForAddPromo(nombre,descripcion,descuento,FechaIni,FechaFin,NombreImagenPromocion);
        });


    }
}

