package unidad6BinariosSerializacionJavaNIO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class EmployeePayrollDashboard {

    private static DefaultTableModel tableModel;
    private static JTextField nameField;
    private static JTextField deptField;
    private static JTextField salaryField;
    
    // Constante para definir el umbral de "salario alto"
    private static final double HIGH_SALARY_THRESHOLD = 3000.00;

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Payroll Dashboard");
        frame.setSize(650, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        // --- PANEL DE ENTRADA ---
        JPanel inputPanel = new JPanel(new GridLayout(2, 4, 5, 5));
        
        nameField = new JTextField();
        deptField = new JTextField();
        salaryField = new JTextField();
        JButton addButton = new JButton("Hire Employee");

        inputPanel.add(new JLabel("Employee Name:"));
        inputPanel.add(new JLabel("Department:"));
        inputPanel.add(new JLabel("Salary (€):"));
        inputPanel.add(new JLabel("")); 
        
        inputPanel.add(nameField);
        inputPanel.add(deptField);
        inputPanel.add(salaryField);
        inputPanel.add(addButton);

        // --- TABLA DE EMPLEADOS ---
        String[] columns = {"Name", "Department", "Salary"};
        tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // --- PANEL DE ANÁLISIS ---
        JPanel analysisPanel = new JPanel();
        JButton totalPayrollButton = new JButton("Calculate Total Payroll");
        JButton countHighEarnersButton = new JButton("Count High Earners (> €3000)");
        
        analysisPanel.add(totalPayrollButton);
        analysisPanel.add(countHighEarnersButton);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(analysisPanel, BorderLayout.SOUTH);

        // --- EVENTOS ---
        addButton.addActionListener(e -> hireEmployee());
        totalPayrollButton.addActionListener(e -> calculateTotalPayroll());
        countHighEarnersButton.addActionListener(e -> countHighEarners());

        frame.setVisible(true);
    }

    /**
     * Añade un empleado a la tabla tras validar los datos.
     */
    private static void hireEmployee() {
        String name = nameField.getText().trim();
        String dept = deptField.getText().trim();
        String salaryStr = salaryField.getText().trim();

        if (name.isEmpty() || dept.isEmpty() || salaryStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Missing data.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double salary = Double.parseDouble(salaryStr);
            tableModel.addRow(new Object[]{name, dept, salary});
            
            nameField.setText("");
            deptField.setText("");
            salaryField.setText("");
            nameField.requestFocus(); // Buenas prácticas: devolver el foco al primer campo

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Salary must be numeric.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Recorre la tabla y suma todos los salarios para obtener el gasto total de nóminas [cite: 1176-1180].
     */
    private static void calculateTotalPayroll() {
        double totalPayroll = 0;
        int rowCount = tableModel.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            double currentSalary = Double.parseDouble(tableModel.getValueAt(i, 2).toString());
            totalPayroll += currentSalary;
        }

        JOptionPane.showMessageDialog(null, String.format("Total monthly payroll: €%.2f", totalPayroll), "Financial Summary", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Operación agregada condicional: Cuenta cuántos empleados superan el umbral definido .
     */
    private static void countHighEarners() {
        int highEarnersCount = 0;
        int rowCount = tableModel.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            double currentSalary = Double.parseDouble(tableModel.getValueAt(i, 2).toString());
            
            // Condición lógica dentro del bucle
            if (currentSalary >= HIGH_SALARY_THRESHOLD) {
                highEarnersCount++;
            }
        }

        JOptionPane.showMessageDialog(null, "Employees earning >= €3000: " + highEarnersCount, "HR Analytics", JOptionPane.INFORMATION_MESSAGE);
    }
}