package ejerProgramacion.Bancario;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class VentanaBancaria {
	JTextField txtRuta = new JTextField("movimientos.csv");
	JTextField txtLimite = new JTextField("500");
	DefaultTableModel modelo = new DefaultTableModel(new String[] { "Tarjeta", "Total (€)", "Estado" }, 0);
	JTable tabla = new JTable(modelo);
	JButton btnProcesar = new JButton("Procesar");
	JButton btnLimpiar = new JButton("Limpiar");

	public VentanaBancaria() {
		super("Control de Movimientos Bancarios");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Panel formulario
		JPanel pnl = new JPanel(new GridLayout(3, 2, 6, 6));
		pnl.add(new JLabel("Fichero:"));
		pnl.add(txtRuta);
		pnl.add(new JLabel("Límite alerta (€):"));
		pnl.add(txtLimite);
		pnl.add(btnLimpiar);
		pnl.add(btnProcesar);
		add(pnl, BorderLayout.NORTH);

		// Tabla de resultados
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(tabla), BorderLayout.CENTER);

		// Eventos
		btnProcesar.addActionListener(e -> {
			String ruta = txtRuta.getText().trim();
			String limStr = txtLimite.getText().trim();
			if (ruta.isEmpty() || limStr.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Rellena todos los campos");
				return;
			}
			double limite;
			try {
				limite = Double.parseDouble(limStr);
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Límite no válido");
				return;
			}
			HashMap<String, Double> mapa = LectorMovimientos.leer(ruta);
			modelo.setRowCount(0); // Limpio tabla
			for (Map.Entry<String, Double> entry : mapa.entrySet()) {
				String estado = entry.getValue() > limite ? "ALERTA" : "OK";
				modelo.addRow(new Object[] { entry.getKey(), String.format("%.2f", entry.getValue()), estado });
			}
			GestorMovimientos.procesar(ruta, "alertas.txt", limite);
		});

		btnLimpiar.addActionListener(e -> {
			modelo.setRowCount(0); // Vacío tabla
			txtRuta.setText("");
			txtLimite.setText("500");
		});

		setSize(600, 400);
		setLocationRelativeTo(null); // Centrado
	}

}
