package unidad6BinariosSerializacionJavaNIO;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

public class TableFileIntegration {
    
    // Declaramos el modelo de la tabla y la ruta del archivo a nivel de clase para poder acceder a ellos desde los métodos estáticos
    private static DefaultTableModel tableModel;
    private static final String FILE_PATH = "students_data.txt";

    public static void main(String[] args) {
        
        // Configuración principal de la ventana [cite: 1064-1066]
        JFrame frame = new JFrame("Student Data Manager");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Definimos las columnas y creamos el modelo inicializado con 0 filas [cite: 1067]
        String[] columns = {"Name", "Age", "Grade"};
        tableModel = new DefaultTableModel(columns, 0);
        
        // Creamos la tabla y su panel de desplazamiento [cite: 1069]
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Creamos los botones de acción [cite: 1070]
        JButton loadButton = new JButton("Load Data");
        JButton saveButton = new JButton("Save Data");
        
        // Panel contenedor para agrupar los botones en la parte inferior [cite: 1072]
        JPanel buttonPanel = new JPanel();

        // Asignamos los controladores de eventos a los botones usando expresiones lambda para código más limpio [cite: 1071]
        loadButton.addActionListener(e -> loadDataFromFile());
        saveButton.addActionListener(e -> saveDataToFile());

        // Añadimos los botones a su panel [cite: 1072-1073]
        buttonPanel.add(loadButton);
        buttonPanel.add(saveButton);

        // Ubicamos el panel de desplazamiento al centro y los botones al sur de la ventana [cite: 1074-1075]
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Hacemos visible la interfaz [cite: 1076]
        frame.setVisible(true);
    }

    /**
     * Carga los datos desde el archivo de texto y los inserta en la tabla.
     */
    private static void loadDataFromFile() {
        
        // Limpiamos la tabla antes de cargar nuevos datos para no duplicarlos [cite: 1078]
        tableModel.setRowCount(0); 
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            JOptionPane.showMessageDialog(null, "No existing data file found.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // try-with-resources para asegurar el cierre automático del BufferedReader [cite: 1080]
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            
            // Leemos línea por línea hasta el final del archivo [cite: 1081]
            while ((line = reader.readLine()) != null) {
                // Dividimos la línea usando el punto y coma como separador [cite: 1083]
                String[] dataParts = line.split(";");
                
                // Añadimos la fila extraída directamente al modelo de la tabla [cite: 1084]
                tableModel.addRow(dataParts);
            }
        } catch (IOException e) {
            // Manejamos la excepción mostrando un mensaje visual al usuario [cite: 1085-1086]
            JOptionPane.showMessageDialog(null, "Error loading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Guarda los datos actuales de la tabla en el archivo de texto.
     */
    private static void saveDataToFile() {
        File file = new File(FILE_PATH);

        // try-with-resources usando PrintWriter para facilitar la escritura con formato [cite: 1090-1091]
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            
            // Recorremos todas las filas existentes en el modelo de la tabla [cite: 1092]
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                
                // Extraemos el valor de cada celda (fila i, columna 0, 1 y 2) [cite: 1093-1096]
                String name = tableModel.getValueAt(i, 0).toString();
                String age = tableModel.getValueAt(i, 1).toString();
                String grade = tableModel.getValueAt(i, 2).toString();

                // Escribimos la fila en el archivo separada por punto y coma [cite: 1096]
                writer.println(name + ";" + age + ";" + grade);
            }
            JOptionPane.showMessageDialog(null, "Data saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (IOException e) {
            // Capturamos cualquier error de escritura [cite: 1099-1100]
            JOptionPane.showMessageDialog(null, "Error saving file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}