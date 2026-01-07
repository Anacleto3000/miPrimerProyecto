package InterfazGrafica;

import OperacionesCRUD.DefinirAcciones.ModificarDatos;
import OperacionesCRUD.DefinirAcciones.MostrarDatos;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Herramientas {

    public static String seleccionarImagen(JComponent parent , String name) {

        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Seleccionar imagen de " + name);

        chooser.setFileFilter(new FileNameExtensionFilter(
                "Imágenes (JPG, PNG)", "jpg", "png", "jpeg"
        ));

        int resultado = chooser.showOpenDialog(parent);

        if (resultado == JFileChooser.APPROVE_OPTION) {

                File archivoSeleccionado = chooser.getSelectedFile();
                String nombreImagen = archivoSeleccionado.getName();

                File destino = new File(
                        "C:/xampp/htdocs/miWeb/miPrimerProyecto/imagenes/" + nombreImagen
                );

                try {
                    Files.copy(
                            archivoSeleccionado.toPath(),
                            destino.toPath(),
                            StandardCopyOption.REPLACE_EXISTING
                    );

                    JOptionPane.showMessageDialog(parent, "Imagen importada correctamente.");
                    return nombreImagen; // Retorno de un valor de tipo string que se pasara a la columna imagen de cierta tabla
                }
                catch (IOException e) {
                    JOptionPane.showMessageDialog(parent, "Error al copiar la imagen.");
                    e.printStackTrace();
                }

        }

        return null; // No se seleccionó nada
    }


    //==========================================//
    public static DefaultTableModel modelo;
    public static JPanel panel;
    //==========================================//

    public static JPanel crearPanelActivarOrDesactivarElementos(String Name) {

        panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // ===== TÍTULO =====
        JLabel titulo = new JLabel("Activar o desactivar " + Name);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titulo, BorderLayout.NORTH);



        // ===== MODELO DE TABLA =====
        modelo = new DefaultTableModel(
                new Object[]{"ID", "Nombre de " +Name , "Estado"}, 0
        ) {
            @Override
            public Class<?> getColumnClass(int column) {
                return column == 2 ? Boolean.class : String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2; // solo checkbox
            }
        };


        JTable tabla = new JTable(modelo);


        tabla.setRowHeight(35);
        tabla.getColumnModel().getColumn(1).setMaxWidth(80);

        JScrollPane scroll = new JScrollPane(tabla);
        panel.add(scroll, BorderLayout.CENTER);

        //Cargar los anuncios de la base de datos


            MostrarDatos mostrarDatos= new MostrarDatos();
            mostrarDatos.CargarElementosDesdeBD(modelo, Name);


        // ===== BOTÓN APLICAR CAMBIOS =====
        JButton btnAplicar = new JButton("Aplicar cambios");
        btnAplicar.setFocusPainted(false);

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBoton.add(btnAplicar);
        panel.add(panelBoton, BorderLayout.SOUTH);

        // ===== ACCIÓN DEL BOTÓN =====
        btnAplicar.addActionListener(e -> {

            int MaxActivos;

            if(Name.equals("Anuncios")){
                MaxActivos= 2;
            }
            else if (Name.equals("Promociones")) {
                 MaxActivos = 6;
            }

            else {
                MaxActivos = Integer.MAX_VALUE;
            }

            int activos = 0;

            for (int i = 0; i < modelo.getRowCount(); i++) {
                Boolean estado = (Boolean) modelo.getValueAt(i, 2);
                if (estado != null && estado) activos++;

            }

                if (activos > MaxActivos ) {
                    JOptionPane.showMessageDialog(panel,
                            "Solo se permiten "+ MaxActivos + Name + "activos",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }



            // AQUÍ iría la lógica de BD
            ModificarDatos modificarDatos= new ModificarDatos();
            modificarDatos.ActivarOrDesactivarElementos(Name);


            JOptionPane.showMessageDialog(panel,
                    "Cambios aplicados correctamente",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        return panel;
    }







    public static Border crearBordeSuave() {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );
    }

    public static JPanel crearLabelInfo(String titulo, String valor) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel.setOpaque(false);

        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 12));

        JLabel lblValor = new JLabel(valor);
        lblValor.setFont(new Font("Arial", Font.PLAIN, 12));

        panel.add(lblTitulo);
        panel.add(lblValor);

        return panel;
    }


    public static JPanel crearCampo(String titulo, String valor) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);

        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 12));

        JLabel lblValor = new JLabel(valor);
        lblValor.setFont(new Font("Arial", Font.PLAIN, 13));
        lblValor.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        panel.add(lblTitulo);
        panel.add(lblValor);

        return panel;
    }




}
