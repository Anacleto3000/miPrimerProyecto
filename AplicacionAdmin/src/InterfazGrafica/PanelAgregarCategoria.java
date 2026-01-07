package InterfazGrafica;



import Logica.ValidarEntradaCategorias;
import OperacionesCRUD.DefinirAcciones.AgregarDatos;

import javax.swing.*;
import java.awt.*;

public class PanelAgregarCategoria extends JPanel {

    private JTextField txtNombre;
    private JTextArea txtDescripcion;
    private JButton btnRegistrar;
    private JButton btnImportarIMG;
    private String NombreImagenCategoria;


    public PanelAgregarCategoria() {
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




        // ===== LABEL DESCRIPCION =====
        JLabel lblDescripcion = new JLabel("Descripcion :");
        lblDescripcion.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lblDescripcion.setBounds(40, 200, 200, 25);
        add(lblDescripcion);

        // ===== CAMPO DESCRIPCION (AREA) =====
        txtDescripcion = new JTextArea();
        txtDescripcion.setFont(new Font("SansSerif", Font.PLAIN, 16));
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(txtDescripcion);
        scroll.setBounds(160, 190, 600, 180);
        add(scroll);

        // ===== BOTÓN REGISTRAR =====
        btnRegistrar = new JButton("Registrar categoria");
        btnRegistrar.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setBounds(350, 400, 230, 45);
        btnRegistrar.setBackground(new Color(120, 120, 120));
        btnRegistrar.setForeground(Color.WHITE);
        add(btnRegistrar);


        btnRegistrar.addActionListener(e -> {
            String nombre=txtNombre.getText();
            String descripcion=txtDescripcion.getText();

            ValidarEntradaCategorias.ValidarEntradaForAddCategoria(nombre,descripcion,NombreImagenCategoria);
        });
    }

    /* Métodos públicos para obtener valores (si los necesitas)
    public String getNombre() { return txtNombre.getText().trim(); }
    public String getDescripcion() { return txtDescripcion.getText().trim(); }
    public JButton getBtnRegistrar() { return btnRegistrar; } */
}



