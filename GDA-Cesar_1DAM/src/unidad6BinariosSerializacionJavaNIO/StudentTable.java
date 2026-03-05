package unidad6BinariosSerializacionJavaNIO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentTable {
    
    public static void main(String[] args) {
        
        // Crear la ventana principal que contendrá nuestra tabla [cite: 1003, 1004]
        JFrame frame = new JFrame("Student List");
        
        // Definir el tamaño de la ventana en píxeles (ancho, alto) [cite: 1005]
        frame.setSize(500, 300);
        
        // Asegurar que el proceso del programa termine cuando el usuario cierre la ventana [cite: 1006]
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Definir los nombres de las cabeceras de las columnas en un arreglo de Strings [cite: 1008]
        String[] columns = {"Name", "Age", "Grade"};

        // Crear una matriz bidimensional de objetos para almacenar los datos estáticos de la tabla [cite: 1010]
        Object[][] data = {
            {"Ana", 18, 7.5},     // [cite: 1012]
            {"Luis", 19, 8.2},    // [cite: 1013]
            {"Marta", 18, 6.9},   // [cite: 1014]
            {"Carlos", 20, 9.1}   // [cite: 1015]
        };

        // Crear el modelo de la tabla. Esto gestiona los datos de forma independiente a la vista gráfica [cite: 1017]
        DefaultTableModel model = new DefaultTableModel(data, columns);

        // Crear el componente visual JTable pasándole nuestro modelo de datos [cite: 1019]
        JTable table = new JTable(model);

        // Envolver la tabla en un JScrollPane. Esto es obligatorio para que aparezcan las barras de desplazamiento y las cabeceras de las columnas [cite: 1021, 1033]
        JScrollPane scrollPane = new JScrollPane(table);

        // Añadir el panel de desplazamiento (que ya contiene la tabla en su interior) a la ventana principal [cite: 1023]
        frame.add(scrollPane);

        // Hacer visible la interfaz gráfica. Siempre debe ser la última instrucción de diseño [cite: 1025]
        frame.setVisible(true);
    }
}