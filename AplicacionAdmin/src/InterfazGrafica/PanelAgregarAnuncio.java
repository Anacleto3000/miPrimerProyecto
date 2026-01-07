package InterfazGrafica;

import OperacionesCRUD.DefinirAcciones.AgregarDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class PanelAgregarAnuncio extends JPanel {

    private JLabel lblPreview;//Proximamente


        private String nombreImagenAnuncio;

    public PanelAgregarAnuncio() {

        setBackground(new Color(240, 240, 240));
        setLayout(new BorderLayout());

        // ===== CONTENEDOR CENTRAL =====
        JPanel contenido = new JPanel();
        contenido.setOpaque(false);
        contenido.setLayout(new BoxLayout(contenido, BoxLayout.Y_AXIS));
        contenido.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));
        add(contenido, BorderLayout.CENTER);

        // ===== TÍTULO =====
        JLabel lblTitulo = new JLabel("Agregar Anuncio");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        contenido.add(lblTitulo);

        contenido.add(Box.createVerticalStrut(30));

        // ===== CAMPO NOMBRE =====
        JLabel lblNombre = new JLabel("Nombre del anuncio");
        lblNombre.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNombre.setAlignmentX(Component.LEFT_ALIGNMENT);
        contenido.add(lblNombre);

        contenido.add(Box.createVerticalStrut(8));

        JTextField txtNombre = new JTextField();
        txtNombre.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        contenido.add(txtNombre);

        contenido.add(Box.createVerticalStrut(30));

        // ===== BOTÓN IMPORTAR IMAGEN =====
        JButton btnImportar = new JButton("Importar imagen");
        btnImportar.setFocusPainted(false);
        btnImportar.setBackground(new Color(220, 220, 220));
        btnImportar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnImportar.setMaximumSize(new Dimension(260, 45));
        contenido.add(btnImportar);

        contenido.add(Box.createVerticalStrut(40));

        // ===== BOTÓN AGREGAR ANUNCIO =====
        JButton btnAgregar = new JButton("Agregar Anuncio");
        btnAgregar.setFocusPainted(false);
        btnAgregar.setBackground(new Color(120, 120, 120));
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnAgregar.setMaximumSize(new Dimension(220, 45));
        contenido.add(btnAgregar);

        // ===== EVENTOS =====
        btnImportar.addActionListener(e -> {
            nombreImagenAnuncio = Herramientas.seleccionarImagen(this, "Anuncio");
        });

        btnAgregar.addActionListener(e -> {

            String nombreAnuncio = txtNombre.getText().trim();

            if (nombreAnuncio.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Debes ingresar un nombre para el anuncio.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (nombreImagenAnuncio == null) {
                JOptionPane.showMessageDialog(this,
                        "Primero debes importar una imagen.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            AgregarDatos agregarDatos = new AgregarDatos();

            // INSERTA nombre + imagen (activo = 0 por defecto)
            agregarDatos.AgregarAnuncio(nombreAnuncio, nombreImagenAnuncio);

            JOptionPane.showMessageDialog(this,
                    "Anuncio agregado correctamente.");

            // LIMPIAR
            txtNombre.setText("");
            nombreImagenAnuncio = null;
        });
    }




}

