package unidad6BinariosSerializacionJavaNIO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

public class StudentManagerApp {

    // Constante para el nombre del archivo, evitando "magic strings"
    private static final String FILE_PATH = "alumnos.txt";
    
    // Componentes a nivel de clase para ser accesibles desde los métodos estáticos
    private static DefaultTableModel tableModel;
    private static JTextField nameField;
    private static JTextField ageField;
    private static JTextField gradeField;

    public static void main(String[] args) {
        
        // --- 1. CONFIGURACIÓN DE LA VENTANA PRINCIPAL ---
        JFrame frame = new JFrame("Enterprise Student Manager");
        frame.setSize(600, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10)); // Usamos BorderLayout con márgenes

        // --- 2. PANEL SUPERIOR: FORMULARIO DE ENTRADA ---
        // GridLayout organiza los componentes en una cuadrícula (2 filas, 4 columnas)
        JPanel inputPanel = new JPanel(new GridLayout(2, 4, 5, 5));
        
        nameField = new JTextField();
        ageField = new JTextField();
        gradeField = new JTextField();
        JButton addButton = new JButton("Add Student");

        // Fila 1: Etiquetas [cite: 885-888]
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(new JLabel("Grade:"));
        inputPanel.add(new JLabel("")); // Celda vacía para cuadrar el diseño
        
        // Fila 2: Campos de texto y Botón [cite: 889-893]
        inputPanel.add(nameField);
        inputPanel.add(ageField);
        inputPanel.add(gradeField);
        inputPanel.add(addButton);

        // --- 3. PANEL CENTRAL: TABLA DE DATOS ---
        String[] columns = {"Name", "Age", "Grade"};
        tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // --- 4. PANEL INFERIOR: BOTÓN DE CÁLCULO ---
        JPanel bottomPanel = new JPanel();
        JButton calcAvgButton = new JButton("Calculate Class Average");
        bottomPanel.add(calcAvgButton);

        // --- 5. ENSAMBLAJE Y EVENTOS ---
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Asignación de eventos [cite: 894-897]
        addButton.addActionListener(e -> addNewStudent());
        calcAvgButton.addActionListener(e -> calculateGeneralAverage());

        // Al iniciar la aplicación, cargamos los datos existentes en el archivo
        loadExistingStudents();

        frame.setVisible(true);
    }

    /**
     * Carga los alumnos desde el archivo alumnos.txt a la tabla al arrancar [cite: 1049, 1077-1088].
     */
    private static void loadExistingStudents() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return; // Si no existe, simplemente no cargamos nada

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Separamos por punto y coma (patrón estándar CSV manual)
                String[] data = line.split(";");
                if (data.length == 3) {
                    tableModel.addRow(data); // Añadimos directamente al modelo de la JTable
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage(), "I/O Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Valida los campos, añade el alumno al archivo físico y actualiza la tabla visual[cite: 1050].
     */
    private static void addNewStudent() {
        String name = nameField.getText().trim();
        String ageStr = ageField.getText().trim();
        String gradeStr = gradeField.getText().trim();

        // Validación básica de campos vacíos
        if (name.isEmpty() || ageStr.isEmpty() || gradeStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // Validamos que edad y nota sean números correctos
            int age = Integer.parseInt(ageStr);
            double grade = Double.parseDouble(gradeStr);

            // Guardamos en el archivo en modo APPEND (true) para no borrar los anteriores 
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
                writer.write(name + ";" + age + ";" + grade);
                writer.newLine(); // Salto de línea seguro [cite: 288, 291]
            }

            // Actualizamos la tabla visualmente [cite: 1037-1038]
            tableModel.addRow(new Object[]{name, age, grade});

            // Limpiamos los campos para el siguiente ingreso
            nameField.setText("");
            ageField.setText("");
            gradeField.setText("");

        } catch (NumberFormatException ex) {
            // Capturamos el error si el usuario escribe letras en lugar de números [cite: 964-968]
            JOptionPane.showMessageDialog(null, "Age must be an integer and Grade a decimal number.", "Format Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saving to file.", "I/O Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Calcula la nota media iterando sobre los datos cargados en el modelo de la tabla [cite: 1181-1182].
     */
    private static void calculateGeneralAverage() {
        int rowCount = tableModel.getRowCount();
        
        if (rowCount == 0) {
            JOptionPane.showMessageDialog(null, "No students available to calculate average.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        double totalSum = 0;

        for (int i = 0; i < rowCount; i++) {
            // Extraemos la nota (columna 2), la convertimos a String y luego a double
            double grade = Double.parseDouble(tableModel.getValueAt(i, 2).toString());
            totalSum += grade;
        }

        double average = totalSum / rowCount;
        
        // Mostramos el resultado con formato a 2 decimales [cite: 106-109]
        String message = String.format("The general average grade of %d students is: %.2f", rowCount, average);
        JOptionPane.showMessageDialog(null, message, "Class Average", JOptionPane.INFORMATION_MESSAGE);
    }
}