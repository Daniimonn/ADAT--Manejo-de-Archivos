import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Datos extends JFrame {

	private JPanel contentPane;
	private JTextField txtDescripcionArticulo, txtPrecioArticulo;
	private JLabel lblDescripcion, lblPrecio, lblProductos;
	private JTextArea txtMostrarTexto;
	private JButton btnGuardar, btnMostrar, btnLimpiar;
	private File archivo = new File("articulos.txt");

	public static void main(String[] args) {
		Datos frame = new Datos();
		frame.setVisible(true);
	}

	
	public Datos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtDescripcionArticulo = new JTextField();
		txtDescripcionArticulo.setBounds(261, 307, 198, 20);
		contentPane.add(txtDescripcionArticulo);
		txtDescripcionArticulo.setColumns(10);

		txtPrecioArticulo = new JTextField();
		txtPrecioArticulo.setBounds(261, 348, 198, 20);
		contentPane.add(txtPrecioArticulo);
		txtPrecioArticulo.setColumns(10);

		lblDescripcion = new JLabel("Descripción del Artículo:");
		lblDescripcion.setBounds(61, 310, 190, 14);
		contentPane.add(lblDescripcion);

		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(61, 351, 135, 14);
		contentPane.add(lblPrecio);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				escribirFichero();
				txtDescripcionArticulo.setText("");
				txtPrecioArticulo.setText("");
			}
		});
		btnGuardar.setBounds(261, 396, 89, 23);
		contentPane.add(btnGuardar);

		txtMostrarTexto = new JTextArea();
		txtMostrarTexto.setBounds(604, 232, 569, 230);
		contentPane.add(txtMostrarTexto);

		btnMostrar = new JButton("Mostrar");
		btnMostrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarFichero();
			}
		});
		btnMostrar.setBounds(604, 492, 89, 23);
		contentPane.add(btnMostrar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMostrarTexto.setText("");
			}
		});
		btnLimpiar.setBounds(1084, 492, 89, 23);
		contentPane.add(btnLimpiar);
		
		lblProductos = new JLabel("PRODUCTOS");
		lblProductos.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblProductos.setBounds(520, 54, 406, 81);
		contentPane.add(lblProductos);
	}

	public void escribirFichero() {
		try {
			FileWriter fw = new FileWriter(archivo, true);
			fw.write("Artículo: " + txtDescripcionArticulo.getText() + " ---> " + "Precio: "
					+ txtPrecioArticulo.getText() + "\n");
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void mostrarFichero() {
		try {
			Scanner sc = new Scanner(archivo);
			while (sc.hasNextLine()) {
				txtMostrarTexto.append(sc.nextLine() + "\n");
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
