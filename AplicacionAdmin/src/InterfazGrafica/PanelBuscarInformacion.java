package InterfazGrafica;

import javax.swing.*;
import java.awt.*;


public class PanelBuscarInformacion {


    public static JPanel  MostrarPanelResultadoClientes(
            int id, String nombre, String apellido,
            int telefono, String correo, int dni){


            // ================= PANEL PRINCIPAL =================
            JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
            panelPrincipal.setPreferredSize(new Dimension(480, 480));
            panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

            // ================= FOTO PERFIL =================
            JPanel panelFoto = new JPanel(new BorderLayout());
            panelFoto.setPreferredSize(new Dimension(200, 200));
            panelFoto.setBorder(Herramientas.crearBordeSuave());

            JLabel lblFoto;

            try {
                ImageIcon icon = new ImageIcon("imagenes/" );
                Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                lblFoto = new JLabel(new ImageIcon(img));
            } catch (Exception e) {
                lblFoto = new JLabel("Foto de perfil", SwingConstants.CENTER);
            }

            panelFoto.add(lblFoto, BorderLayout.CENTER);

            JPanel contenedorFoto = new JPanel();
            contenedorFoto.add(panelFoto);
            panelPrincipal.add(contenedorFoto, BorderLayout.NORTH);

            // ================= FORMULARIO =================
            JPanel panelFormulario = new JPanel();
            panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));
            panelFormulario.setBorder(Herramientas.crearBordeSuave());

            // Fila 1 → Nombre | ID
            JPanel fila1 = new JPanel(new GridLayout(1, 2, 10, 0));
            fila1.add(Herramientas.crearCampo("Nombre:", nombre));
            fila1.add(Herramientas.crearCampo("ID:", String.valueOf(id)));

            // Fila 2 → Apellido
            JPanel fila2 = new JPanel(new GridLayout(1, 1));
            fila2.add(Herramientas.crearCampo("Apellido:", apellido));

            // Fila 3 → Correo
            JPanel fila3 = new JPanel(new GridLayout(1, 1));
            fila3.add(Herramientas.crearCampo("Correo:", correo));

            // Fila 4 → Teléfono | DNI
            JPanel fila4 = new JPanel(new GridLayout(1, 2, 10, 0));
            fila4.add(Herramientas.crearCampo("Teléfono:",String.valueOf(telefono)));
            fila4.add(Herramientas.crearCampo("DNI:", String.valueOf(dni)));

            panelFormulario.add(fila1);
            panelFormulario.add(Box.createVerticalStrut(10));
            panelFormulario.add(fila2);
            panelFormulario.add(Box.createVerticalStrut(10));
            panelFormulario.add(fila3);
            panelFormulario.add(Box.createVerticalStrut(10));
            panelFormulario.add(fila4);

            panelPrincipal.add(panelFormulario, BorderLayout.CENTER);

            return panelPrincipal;


    }




    public static JPanel MostrarPanelResultadoProductos(
            int id,
            String name,
            String desc,
            int categoriaId,
            int price,
            int stock,
            String imgName)
    {

        // ================= PANEL PRINCIPAL =================
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setPreferredSize(new Dimension(480, 480));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ================= PANEL IMAGEN =================
        JPanel panelImagen = new JPanel(new BorderLayout());
        panelImagen.setPreferredSize(new Dimension(460, 180));
        panelImagen.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        JLabel lblImagen;

        try {
            ImageIcon icon = new ImageIcon("imagenes/" + imgName);
            Image img = icon.getImage().getScaledInstance(460, 180, Image.SCALE_SMOOTH);
            lblImagen = new JLabel(new ImageIcon(img));
        } catch (Exception e) {
            lblImagen = new JLabel("Imagen no disponible", SwingConstants.CENTER);
        }

        panelImagen.add(lblImagen, BorderLayout.CENTER);
        panelPrincipal.add(panelImagen, BorderLayout.NORTH);

        // ================= PANEL INFO =================
        JPanel panelInfo = new JPanel(new GridLayout(1, 2, 10, 0));
        panelInfo.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        panelPrincipal.add(panelInfo, BorderLayout.CENTER);

        // ================= COLUMNA IZQUIERDA =================
        JPanel panelIzq = new JPanel();
        panelIzq.setLayout(new BoxLayout(panelIzq, BoxLayout.Y_AXIS));
        panelIzq.setBorder(Herramientas.crearBordeSuave());

        panelIzq.add(Herramientas.crearLabelInfo("Categoría:", String.valueOf(categoriaId)));
        panelIzq.add(Herramientas.crearLabelInfo("Stock:", String.valueOf(stock)));
        panelIzq.add(Herramientas.crearLabelInfo("Precio:", "$ " + price));
        panelIzq.add(Herramientas.crearLabelInfo("ID:", String.valueOf(id)));

        panelInfo.add(panelIzq);

        // ================= COLUMNA DERECHA =================
        JPanel panelDer = new JPanel();
        panelDer.setLayout(new BoxLayout(panelDer, BoxLayout.Y_AXIS));
        panelDer.setBorder(Herramientas.crearBordeSuave());

        JLabel lblTitulo = new JLabel(name);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextArea txtDescripcion = new JTextArea(desc);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        txtDescripcion.setEditable(false);
        txtDescripcion.setOpaque(false);
        txtDescripcion.setFont(new Font("Arial", Font.PLAIN, 13));

        panelDer.add(lblTitulo);
        panelDer.add(Box.createVerticalStrut(10));
        panelDer.add(txtDescripcion);

        panelInfo.add(panelDer);

        return panelPrincipal;
    }


    public static JPanel MostrarPanelResultadoCategorias(
            int categoria_id,
            String nombre,
            String descripcion
    ) {

        // ================= PANEL PRINCIPAL =================
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setPreferredSize(new Dimension(480, 220));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // ================= CABECERA =================
        JPanel panelHeader = new JPanel();
        panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.Y_AXIS));
        panelHeader.setBorder(Herramientas.crearBordeSuave());

        JLabel lblNombre = new JLabel(nombre);
        lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
        lblNombre.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelHeader.add(lblNombre);

        panelPrincipal.add(panelHeader, BorderLayout.NORTH);

        // ================= CUERPO =================
        JPanel panelBody = new JPanel();
        panelBody.setLayout(new BoxLayout(panelBody, BoxLayout.Y_AXIS));
        panelBody.setBorder(Herramientas.crearBordeSuave());

        // Descripción
        JTextArea txtDescripcion = new JTextArea(descripcion);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        txtDescripcion.setEditable(false);
        txtDescripcion.setOpaque(false);
        txtDescripcion.setFont(new Font("Arial", Font.PLAIN, 13));
        txtDescripcion.setBorder(BorderFactory.createTitledBorder("Descripción"));

        panelBody.add(txtDescripcion);
        panelBody.add(Box.createVerticalStrut(10));

        // Info inferior
        JPanel panelInfo = new JPanel(new GridLayout(1, 1));
        panelInfo.setOpaque(false);

        panelInfo.add(Herramientas.crearCampo("ID Categoría:", String.valueOf(categoria_id)));

        panelBody.add(panelInfo);

        panelPrincipal.add(panelBody, BorderLayout.CENTER);

        return panelPrincipal;
    }




    public static JPanel MostrarPanelResultadoPromociones(
            int promo_id,
            String nombre,
            String descripcion,
            int descuento,
            String fechaInicio,
            String fechaFin,
            String estado
    )
    {

        // ================= PANEL PRINCIPAL =================
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setPreferredSize(new Dimension(480, 260));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // ================= CABECERA =================
        JPanel panelHeader = new JPanel();
        panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.Y_AXIS));
        panelHeader.setBorder(Herramientas.crearBordeSuave());

        JLabel lblNombre = new JLabel(nombre);
        lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
        lblNombre.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblEstado = new JLabel("Estado: " + estado);
        lblEstado.setFont(new Font("Arial", Font.PLAIN, 12));
        lblEstado.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelHeader.add(lblNombre);
        panelHeader.add(Box.createVerticalStrut(5));
        panelHeader.add(lblEstado);

        panelPrincipal.add(panelHeader, BorderLayout.NORTH);

        // ================= CUERPO =================
        JPanel panelBody = new JPanel();
        panelBody.setLayout(new BoxLayout(panelBody, BoxLayout.Y_AXIS));
        panelBody.setBorder(Herramientas.crearBordeSuave());

        // Descripción
        JTextArea txtDescripcion = new JTextArea(descripcion);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        txtDescripcion.setEditable(false);
        txtDescripcion.setOpaque(false);
        txtDescripcion.setFont(new Font("Arial", Font.PLAIN, 13));
        txtDescripcion.setBorder(BorderFactory.createTitledBorder("Descripción"));

        panelBody.add(txtDescripcion);
        panelBody.add(Box.createVerticalStrut(10));

        // ================= INFO EXTRA =================
        JPanel panelInfo = new JPanel(new GridLayout(2, 2, 10, 5));
        panelInfo.setOpaque(false);

        panelInfo.add(Herramientas.crearCampo("Descuento:", descuento + " %"));
        panelInfo.add(Herramientas.crearCampo("ID Promoción:", String.valueOf(promo_id)));
        panelInfo.add(Herramientas.crearCampo("Inicio:", fechaInicio));
        panelInfo.add(Herramientas.crearCampo("Fin:", fechaFin));

        panelBody.add(panelInfo);

        panelPrincipal.add(panelBody, BorderLayout.CENTER);

        return panelPrincipal;
    }





}
