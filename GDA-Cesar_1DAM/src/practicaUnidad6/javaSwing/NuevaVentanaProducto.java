package practicaUnidad6.javaSwing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class NuevaVentanaProducto {

	public static void main(String[] args) {
		
		//1. CREAR VENTANA
		JFrame ventana = new JFrame("AGREGAR PRODUCTO");
		
		//2. TAMAÑO DE LA VENTANA
		ventana.setSize(500, 300);
		
		//3. CERRAR PROGRAMA
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//4. LAYOUTS
		ventana.setLayout(new GridLayout(3,2));
		
		//5. DECLARAR COMPONENTES
		JLabel lblNombre = new JLabel("Producto: ");
		JTextField txtNombre = new JTextField();
		
		JLabel lblPrecio = new JLabel("Precio: ");
		JTextField txtPrecio = new JTextField();
		
		JButton btnGuardar = new JButton("Guardar");
		
		//6. AÑADIR COMPONENTES
		ventana.add(lblNombre);
		ventana.add(txtNombre);
		ventana.add(lblPrecio);
		ventana.add(txtPrecio);
		ventana.add(btnGuardar);
		
		//7. EVENTO BOTON
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre = txtNombre.getText();
				String precio = txtPrecio.getText();
				
				JOptionPane.showMessageDialog(null, "Producto: "+nombre+"\nPrecio: "+precio);
			}
		});
		
		//8. MOSTRAR VENTANA
		ventana.setVisible(true);
	}
}