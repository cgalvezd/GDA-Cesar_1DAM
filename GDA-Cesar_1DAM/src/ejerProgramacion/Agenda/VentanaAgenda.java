package ejerProgramacion.Agenda;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class VentanaAgenda extends JFrame {

	private JTable tabla;
	private DefaultTableModel modelo;
	private JTextField tfNombre, tfTelefono, tfEmail, tfBuscar;
	private JButton btnAñadir, btnBuscar;

	public VentanaAgenda() {
		super("Agenda de Contactos");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// 🔹 Panel principal
		JPanel panel = new JPanel(new BorderLayout());
		getContentPane().add(panel);

		// 🔹 Tabla de contactos
		modelo = new DefaultTableModel(new Object[] { "Nombre", "Teléfono", "Email" }, 0);
		tabla = new JTable(modelo);
		panel.add(new JScrollPane(tabla), BorderLayout.CENTER);

		// 🔹 Panel de entradas
		JPanel panelEntradas = new JPanel(new GridLayout(2, 4, 5, 5));
		tfNombre = new JTextField();
		tfTelefono = new JTextField();
		tfEmail = new JTextField();
		tfBuscar = new JTextField();

		btnAñadir = new JButton("Añadir");
		btnBuscar = new JButton("Buscar");

		panelEntradas.add(new JLabel("Nombre:"));
		panelEntradas.add(tfNombre);
		panelEntradas.add(new JLabel("Teléfono:"));
		panelEntradas.add(tfTelefono);
		panelEntradas.add(new JLabel("Email:"));
		panelEntradas.add(tfEmail);
		panelEntradas.add(btnAñadir);
		panelEntradas.add(btnBuscar);

		panel.add(panelEntradas, BorderLayout.NORTH);

		// 🔹 Eventos botones
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadirContacto();
			}
		});

		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarContacto();
			}
		});
	}

	private void añadirContacto() {
		String nombre = tfNombre.getText();
		String telefono = tfTelefono.getText();
		String email = tfEmail.getText();

		if (!nombre.isEmpty() && !telefono.isEmpty() && !email.isEmpty()) {
			modelo.addRow(new Object[] { nombre, telefono, email });
			tfNombre.setText("");
			tfTelefono.setText("");
			tfEmail.setText("");
			JOptionPane.showMessageDialog(this, "Contacto añadido.");
		} else {
			JOptionPane.showMessageDialog(this, "Rellena todos los campos.");
		}
	}

	private void buscarContacto() {
		String buscar = tfBuscar.getText().toLowerCase();
		for (int i = 0; i < modelo.getRowCount(); i++) {
			String nombre = modelo.getValueAt(i, 0).toString().toLowerCase();
			if (nombre.contains(buscar)) {
				tabla.setRowSelectionInterval(i, i);
				return;
			}
		}
		JOptionPane.showMessageDialog(this, "No se encontró el contacto.");
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new VentanaAgenda().setVisible(true);
		});
	}
}