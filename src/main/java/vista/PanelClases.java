package vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import base.Arma;
import base.Clase;
import baseDeDatos.Modelo;

public class PanelClases<T> extends JPanel {


	public JLabel lblNombre;
	public JTextField tfNombre;
	public JLabel lDefensa;
	public JTextField tfDefensa;
	public JLabel lblNewLabel;
	public JTextField tfMana;
	public JButton btGuardar;
	public JButton btBorrar;
	public JButton btModificar;
	public PanelLista<Clase> panelLista;
	
	private Modelo modelo;
	public JLabel lClases;
	public JLabel lblNewLabel_1;
	public JTextField tfMagia;
	public JButton btBuscar;

	public PanelClases(Modelo modelo) {
		this.modelo = modelo;
		setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(43, 56, 78, 14);
		add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(165, 53, 146, 20);
		add(tfNombre);
		tfNombre.setColumns(10);
		
		lDefensa = new JLabel("Defensa");
		lDefensa.setBounds(43, 110, 78, 14);
		add(lDefensa);
		
		tfDefensa = new JTextField();
		tfDefensa.setBounds(165, 107, 146, 20);
		add(tfDefensa);
		tfDefensa.setColumns(10);
		
		lblNewLabel = new JLabel("Mana");
		lblNewLabel.setBounds(43, 172, 78, 14);
		add(lblNewLabel);
		
		tfMana = new JTextField();
		tfMana.setBounds(165, 169, 146, 20);
		add(tfMana);
		tfMana.setColumns(10);
		
		btGuardar = new JButton("Guardar");
		btGuardar.setBounds(43, 393, 89, 23);
		add(btGuardar);
		
		btBorrar = new JButton("Borrar");
		btBorrar.setBounds(178, 393, 89, 23);
		add(btBorrar);
		
		btModificar = new JButton("Modificar");
		btModificar.setBounds(322, 393, 89, 23);
		add(btModificar);
		
		panelLista = new PanelLista<>();
		panelLista.setBounds(424,84,258,273);
		add(panelLista);
		
		lClases = new JLabel("Clases");
		lClases.setBounds(439, 56, 46, 14);
		add(lClases);
		
		lblNewLabel_1 = new JLabel("Magia");
		lblNewLabel_1.setBounds(43, 234, 46, 14);
		add(lblNewLabel_1);
		
		tfMagia = new JTextField();
		tfMagia.setBounds(165, 231, 146, 20);
		add(tfMagia);
		tfMagia.setColumns(10);
		
		btBuscar = new JButton("Buscar");
		btBuscar.setBounds(593, 393, 89, 23);
		add(btBuscar);
		
	}
}
