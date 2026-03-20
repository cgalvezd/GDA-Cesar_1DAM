package tipoPracticaUnidad6.JavaSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaProductos {

    public static void main(String[] args) {

        // 1 Crear ventana
        JFrame ventana = new JFrame("Registro de producto");

        // 2 Tamaño
        ventana.setSize(350,200);

        // 3 Cerrar programa
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 4 Layout
        ventana.setLayout(new GridLayout(3,2));

        // 5 Componentes
        JLabel lblNombre = new JLabel("Nombre producto:");
        JTextField txtNombre = new JTextField();

        JLabel lblPrecio = new JLabel("Precio:");
        JTextField txtPrecio = new JTextField();

        JButton btnGuardar = new JButton("Guardar");

        // 6 Añadir componentes
        ventana.add(lblNombre);
        ventana.add(txtNombre);
        ventana.add(lblPrecio);
        ventana.add(txtPrecio);
        ventana.add(btnGuardar);

        // 7 Evento botón
        btnGuardar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String nombre = txtNombre.getText();
                String precio = txtPrecio.getText();

                JOptionPane.showMessageDialog(null,
                        "Producto: " + nombre +
                        "\nPrecio: " + precio);
            }
        });

        // 8 Mostrar ventana
        ventana.setVisible(true);
    }
}