package InterfazGrafica;

import javax.swing.*;
import java.awt.*;


public class TablaMostrarDatos {
    public static JScrollPane TablaMostrarDatos(String[] columnas, Object[][] datos) {

        JTable tabla = new JTable(datos, columnas);

        tabla.setRowHeight(30);
        tabla.setFont(new Font("SansSerif", Font.PLAIN, 14));
        tabla.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 15));
        tabla.getTableHeader().setBackground(new Color(200, 200, 200));

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBorder(BorderFactory.createEmptyBorder());

        return scroll;
    }
}


