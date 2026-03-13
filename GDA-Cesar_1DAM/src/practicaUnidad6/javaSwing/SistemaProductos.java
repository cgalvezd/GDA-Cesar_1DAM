package practicaUnidad6.javaSwing;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SistemaProductos {

	public static void main(String[] args) {

		JFrame ventana = new JFrame("Sistema de Productos");
		ventana.setSize(600, 400);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLayout(new BorderLayout());

		JPanel panel = new JPanel(new GridLayout(4, 2));

		JTextField txtId = new JTextField();
		JTextField txtNombre = new JTextField();
		JTextField txtPrecio = new JTextField();
		JTextField txtBuscar = new JTextField();

		panel.add(new JLabel("ID"));
		panel.add(txtId);
		panel.add(new JLabel("Nombre"));
		panel.add(txtNombre);
		panel.add(new JLabel("Precio"));
		panel.add(txtPrecio);
		panel.add(new JLabel("Buscar"));
		panel.add(txtBuscar);

		String[] columnas = { "ID", "Nombre", "Precio" };
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

		JTable tabla = new JTable(modelo);

		JScrollPane scroll = new JScrollPane(tabla);

		JPanel botones = new JPanel();

		JButton btnAgregar = new JButton("Agregar");
		JButton btnPromedio = new JButton("Promedio");
		JButton btnBuscar = new JButton("Buscar");

		botones.add(btnAgregar);
		botones.add(btnPromedio);
		botones.add(btnBuscar);

		btnAgregar.addActionListener(e -> {
			modelo.addRow(new Object[] { txtId.getText(), txtNombre.getText(), txtPrecio.getText() });
		});

		btnPromedio.addActionListener(e -> {
			double suma = 0;
			for (int i = 0; i < modelo.getRowCount(); i++) {
				suma += Double.parseDouble(modelo.getValueAt(i, 2).toString());
			}

			double promedio = suma / modelo.getRowCount();
			
			JOptionPane.showMessageDialog(null, "Promedio precios: "+promedio);

		});
		
		  btnBuscar.addActionListener(e -> {

	            String buscar = txtBuscar.getText();

	            for(int i=0;i<modelo.getRowCount();i++){

	                if(modelo.getValueAt(i,1).toString().equals(buscar)){

	                    JOptionPane.showMessageDialog(null,
	                            "Producto encontrado fila "+i);
	                }
	            }

	        });

	        ventana.add(panel,BorderLayout.NORTH);
	        ventana.add(scroll,BorderLayout.CENTER);
	        ventana.add(botones,BorderLayout.SOUTH);

	        ventana.setVisible(true);
	}

}
