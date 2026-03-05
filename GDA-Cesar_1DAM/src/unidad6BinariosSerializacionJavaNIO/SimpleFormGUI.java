package unidad6BinariosSerializacionJavaNIO;

import javax.swing.*;
import java.awt.event.*;

public class SimpleFormGUI {
    public static void main(String[] args) {
        
        // Creamos la ventana principal [cite: 882]
        JFrame frame = new JFrame("Examen DAM1 - Formulario");
        frame.setSize(350, 200); // Tamaño en píxeles (ancho, alto) [cite: 883]
        
        // OBLIGATORIO: Finaliza la ejecución del programa al cerrar la ventana con la 'X' [cite: 884]
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        // Desactivamos el diseño automático para usar coordenadas exactas (x, y, ancho, alto) [cite: 884]
        frame.setLayout(null); 

        // Etiqueta de texto descriptivo [cite: 886]
        JLabel nameLabel = new JLabel("Enter your name:");
        nameLabel.setBounds(20, 20, 150, 25); // [cite: 887]

        // Campo de entrada de texto para el usuario [cite: 890]
        JTextField nameField = new JTextField();
        nameField.setBounds(20, 50, 200, 25); // [cite: 890]

        // Botón de acción [cite: 892]
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(20, 90, 100, 30); // [cite: 893]

        // Controlador de eventos: Le decimos al botón qué hacer cuando lo pulsen [cite: 894, 895]
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // [cite: 896, 897]
                
                // Extraemos el texto que el usuario escribió en el campo [cite: 898]
                String userName = nameField.getText();
                
                // Validación básica de entrada
                if (userName.trim().isEmpty()) {
                    // Si está vacío, mostramos un JOptionPane de error [cite: 966-968]
                    JOptionPane.showMessageDialog(frame, "Name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Si es correcto, mostramos un JOptionPane de información [cite: 949-953]
                    JOptionPane.showMessageDialog(frame, "Hello, " + userName + "!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Añadimos todos los componentes construidos a la ventana [cite: 906-911]
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(submitButton);

        // Hacemos la ventana visible al usuario (siempre debe ser la última instrucción de diseño) [cite: 913]
        frame.setVisible(true);
    }
}