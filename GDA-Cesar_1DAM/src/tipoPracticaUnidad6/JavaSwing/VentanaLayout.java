package tipoPracticaUnidad6.JavaSwing;

import javax.swing.*;
import java.awt.*;

public class VentanaLayout {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("BorderLayout");

        ventana.setSize(500,300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana.setLayout(new BorderLayout());

        JButton btnGuardar = new JButton("Guardar");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnEliminar = new JButton("Eliminar");

        JTextField txtBuscar = new JTextField();

        ventana.add(btnGuardar, BorderLayout.NORTH);
        ventana.add(btnBuscar, BorderLayout.SOUTH);
        ventana.add(btnEliminar, BorderLayout.EAST);
        ventana.add(txtBuscar, BorderLayout.CENTER);

        ventana.setVisible(true);
    }
}