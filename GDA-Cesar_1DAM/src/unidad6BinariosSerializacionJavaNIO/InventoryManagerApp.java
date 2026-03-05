package unidad6BinariosSerializacionJavaNIO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

public class InventoryManagerApp {

    private static final String CSV_FILE = "inventory.csv";
    
    private static DefaultTableModel tableModel;
    private static JTextField nameField;
    private static JTextField categoryField;
    private static JTextField priceField;

    public static void main(String[] args) {
        
        // --- 1. CONFIGURACIÓN DE INTERFAZ ---
        JFrame frame = new JFrame("Enterprise Inventory System");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // --- 2. PANEL DE ENTRADA (NORTE) ---
        JPanel inputPanel = new JPanel(new GridLayout(2, 4, 5, 5));
        
        nameField = new JTextField();
        categoryField = new JTextField();
        priceField = new JTextField();
        JButton addButton = new JButton("Add Product");

        inputPanel.add(new JLabel("Product Name:"));
        inputPanel.add(new JLabel("Category:"));
        inputPanel.add(new JLabel("Price ($):"));
        inputPanel.add(new JLabel("")); // Espaciador
        
        inputPanel.add(nameField);
        inputPanel.add(categoryField);
        inputPanel.add(priceField);
        inputPanel.add(addButton);

        // --- 3. TABLA DE DATOS (CENTRO) ---
        String[] columns = {"Name", "Category", "Price"};
        tableModel = new DefaultTableModel(columns, 0); // [cite: 1017]
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table); // [cite: 1021]

        // --- 4. PANEL DE OPERACIONES (SUR) ---
        JPanel actionPanel = new JPanel();
        JButton findMaxButton = new JButton("Find Most Expensive");
        JButton exportCsvButton = new JButton("Export to CSV");
        
        actionPanel.add(findMaxButton);
        actionPanel.add(exportCsvButton);

        // --- 5. ENSAMBLAJE Y EVENTOS ---
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(actionPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addProduct());
        findMaxButton.addActionListener(e -> findMostExpensiveProduct());
        exportCsvButton.addActionListener(e -> exportDataToCsv());

        frame.setVisible(true);
    }

    /**
     * Valida y añade un nuevo producto a la tabla.
     */
    private static void addProduct() {
        String name = nameField.getText().trim();
        String category = categoryField.getText().trim();
        String priceStr = priceField.getText().trim();

        if (name.isEmpty() || category.isEmpty() || priceStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are mandatory.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double price = Double.parseDouble(priceStr);
            if (price < 0) throw new NumberFormatException("Price cannot be negative.");

            // Insertar fila dinámicamente [cite: 1037-1038]
            tableModel.addRow(new Object[]{name, category, price});
            
            // Limpiar formulario
            nameField.setText("");
            categoryField.setText("");
            priceField.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid price format.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Algoritmo de examen: Busca el valor máximo recorriendo las filas de la tabla[cite: 1193].
     */
    private static void findMostExpensiveProduct() {
        int rowCount = tableModel.getRowCount();
        if (rowCount == 0) {
            JOptionPane.showMessageDialog(null, "Inventory is empty.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        double maxPrice = -1;
        String mostExpensiveName = "";

        // Iterar sobre el modelo de datos para encontrar el máximo [cite: 1177-1180]
        for (int i = 0; i < rowCount; i++) {
            double currentPrice = Double.parseDouble(tableModel.getValueAt(i, 2).toString());
            
            if (currentPrice > maxPrice) {
                maxPrice = currentPrice;
                mostExpensiveName = tableModel.getValueAt(i, 0).toString();
            }
        }

        JOptionPane.showMessageDialog(null, "Most expensive: " + mostExpensiveName + " ($" + maxPrice + ")", "Result", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Exporta la tabla a formato CSV [cite: 1208-1227].
     */
    private static void exportDataToCsv() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE))) {
            
            // Escribir cabeceras [cite: 1210-1215]
            for (int c = 0; c < tableModel.getColumnCount(); c++) {
                writer.print(tableModel.getColumnName(c));
                if (c < tableModel.getColumnCount() - 1) writer.print(";");
            }
            writer.println();

            // Escribir datos [cite: 1216-1224]
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    writer.print(tableModel.getValueAt(i, j));
                    if (j < tableModel.getColumnCount() - 1) writer.print(";");
                }
                writer.println();
            }
            
            JOptionPane.showMessageDialog(null, "Exported to " + CSV_FILE, "Success", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Failed to export: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}