package InterfazGrafica;

import Logica.ValidarEntradaProductos;
import OperacionesCRUD.DefinirAcciones.AgregarDatos;

import javax.swing.*;
import java.awt.*;

public class PanelAgregarProducto extends JPanel {

    private JTextField txtNombre, txtPrecio, txtStock, txtCategoria;
    private JTextArea txtDescripcion;
    private JButton btnImportarImagen, btnRegistrar;
    private String nombreImagenSeleccionada = null;


    public PanelAgregarProducto() {
        initComponents();
    }

    private void initComponents() {

        setBackground(new Color(230, 230, 230));
        setLayout(null);  // Para posicionar exactamente como tu diseño original

        // ===== TÍTULO =====
        JLabel lblTitulo = new JLabel("Agregar Productos");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblTitulo.setBounds(30, 20, 300, 30);
        add(lblTitulo);

        // ===== BOTÓN IMPORTAR IMAGEN =====
        btnImportarImagen = new JButton("Importar imagen");
        btnImportarImagen.setBounds(650, 20, 200, 40);
        btnImportarImagen.setBackground(new Color(210, 200, 160));
        btnImportarImagen.setFocusPainted(false);
        btnImportarImagen.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(btnImportarImagen);

        // ===== LABELS =====
        JLabel lblNombre = new JLabel("Nombre :");
        lblNombre.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lblNombre.setBounds(30, 80, 150, 25);
        add(lblNombre);

        JLabel lblPrecio = new JLabel("Precio :");
        lblPrecio.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lblPrecio.setBounds(500, 80, 150, 25);
        add(lblPrecio);

        JLabel lblDescripcion = new JLabel("Descripcion :");
        lblDescripcion.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lblDescripcion.setBounds(30, 140, 150, 25);
        add(lblDescripcion);

        JLabel lblStock = new JLabel("Stock :");
        lblStock.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lblStock.setBounds(30, 330, 150, 25);
        add(lblStock);

        JLabel lblCategoria = new JLabel("Categoria :");
        lblCategoria.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lblCategoria.setBounds(500, 330, 150, 25);
        add(lblCategoria);

        // ===== CAMPOS DE TEXTO =====
        txtNombre = crearCampoTexto();
        txtNombre.setBounds(150, 75, 300, 40);
        add(txtNombre);

        txtPrecio = crearCampoTexto();
        txtPrecio.setBounds(580, 75, 150, 40);
        add(txtPrecio);

        // descripcion
        txtDescripcion = new JTextArea();
        txtDescripcion.setFont(new Font("SansSerif", Font.PLAIN, 16));
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(txtDescripcion);
        scroll.setBounds(150, 135, 580, 170);
        add(scroll);

        txtStock = crearCampoTexto();
        txtStock.setBounds(150, 325, 150, 40);
        add(txtStock);

        txtCategoria = crearCampoTexto();
        txtCategoria.setBounds(630, 325, 150, 40);
        add(txtCategoria);



        btnImportarImagen.addActionListener(e -> {
            String imagen = Herramientas.seleccionarImagen(this,"producto");

            if (imagen != null) {
                nombreImagenSeleccionada = imagen;


                System.out.println("Imagen seleccionada: " + imagen);
            }
        });

        // ===== BOTÓN REGISTRAR =====
        btnRegistrar = new JButton("Registrar producto");
        btnRegistrar.setBounds(350, 400, 200, 45);
        btnRegistrar.setBackground(new Color(120, 120, 120));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(btnRegistrar);

        btnRegistrar.addActionListener(e -> {
            String nombre=txtNombre.getText();
            String descripcion= txtDescripcion.getText();
            String precio=txtPrecio.getText();
            String stock= txtStock.getText();
            String categoria=txtCategoria.getText();


            ValidarEntradaProductos.ValidarEntradaForAddProducto(nombre, descripcion, precio, stock, categoria, nombreImagenSeleccionada);
        });
    }

    // ===== Campos de texto sin redondeos =====
    private JTextField crearCampoTexto() {
        JTextField txt = new JTextField();
        txt.setFont(new Font("SansSerif", Font.PLAIN, 16));
        return txt;
    }







}


