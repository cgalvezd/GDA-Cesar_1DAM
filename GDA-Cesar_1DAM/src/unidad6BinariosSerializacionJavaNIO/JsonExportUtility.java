package unidad6BinariosSerializacionJavaNIO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonExportUtility {

    public static void main(String[] args) {
        // Configuramos un modelo de tabla con datos de prueba simulando lo que vería el usuario [cite: 1008-1017]
        String[] columns = {"Name", "Age", "Grade"};
        Object[][] data = {
            {"Ana", 18, 7.5},
            {"Luis", 19, 8.2}
        };
        DefaultTableModel tableModel = new DefaultTableModel(data, columns);

        // Ejecutamos el método que los profesores te pedirían implementar [cite: 1236]
        exportTableToJson(tableModel, "alumnos.json");
    }

    /**
     * Exporta el contenido de un DefaultTableModel a un archivo JSON estructurado.
     * @param model El modelo de datos de la tabla.
     * @param filePath La ruta del archivo de destino.
     */
    public static void exportTableToJson(DefaultTableModel model, String filePath) {
        
        // try-with-resources usando PrintWriter para escribir en el archivo [cite: 1237]
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            
            // Iniciamos el documento JSON, que será un arreglo (array) de objetos [cite: 1238]
            writer.println("[");

            // Bucle EXTERNO: Recorremos cada fila de la tabla [cite: 1239]
            for (int i = 0; i < model.getRowCount(); i++) {
                
                // Abrimos un nuevo objeto JSON para la fila actual [cite: 1239]
                writer.println("  {");
                
                // Bucle INTERNO: Recorremos cada columna de la fila en la que estamos [cite: 1240]
                for (int j = 0; j < model.getColumnCount(); j++) {
                    
                    // Extraemos el nombre de la columna y lo pasamos a minúsculas para usarlo como CLAVE 
                    String key = model.getColumnName(j).toLowerCase();
                    
                    // Extraemos el VALOR de la celda específica [cite: 1243]
                    String value = model.getValueAt(i, j).toString();

                    // Formateamos la línea. Las comillas dobles en Java se escapan con \" [cite: 1243]
                    writer.print("    \"" + key + "\": \"" + value + "\"");

                    // Control lógico vital para JSON: Si NO es la última columna, añadimos una coma [cite: 1244]
                    if (j < model.getColumnCount() - 1) {
                        writer.println(",");
                    } else {
                        writer.println(); // Si es la última columna, solo damos un salto de línea
                    }
                }
                
                // Cerramos el objeto JSON de la fila actual [cite: 1245]
                writer.print("  }");

                // Control lógico vital: Si NO es la última fila de la tabla, separamos el objeto del siguiente con una coma [cite: 1246]
                if (i < model.getRowCount() - 1) {
                    writer.println(",");
                } else {
                    writer.println();
                }
            }
            
            // Cerramos el arreglo principal de JSON [cite: 1249]
            writer.println("]");
            
            // Mensaje visual confirmando la operación [cite: 949]
            JOptionPane.showMessageDialog(null, "Data exported successfully to " + filePath, "Export Complete", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            // Manejo estricto de errores con mensaje visual para el usuario [cite: 1250-1251]
            JOptionPane.showMessageDialog(null, "Failed to write JSON file: " + e.getMessage(), "I/O Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}