package practicaUnidad6.javaSwing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class VentanaLayout {

	public static void main(String[] args) {

		// 1. VENTANA
		JFrame ventana = new JFrame("Border Layout");

		// 2. DIMENSIONES
		ventana.setSize(500, 300);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ventana.setLayout(new BorderLayout());
		
		JButton btnGuardar = new JButton("Guardar");
		JButton btnBuscar = new JButton("Buscar");
		JButton btnEliminar = new JButton("Eliminar");
		
		JTextField txtBuscar = new JTextField();
		
		ventana.add(btnGuardar, BorderLayout.NORTH);
		ventana.add(btnBuscar, BorderLayout.SOUTH);
		ventana.add(btnEliminar, BorderLayout.EAST);
		ventana.add(txtBuscar, BorderLayout.CENTER);
		
		ventana.setVisible(true);

	}

}
