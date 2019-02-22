package vista;

import javax.swing.JPanel;

import baseDeDatos.Modelo;
import javax.swing.JLabel;
import javax.swing.JTextField;

import base.Arma;

import javax.swing.JButton;

public class PanelArmas<T> extends JPanel {
	
	public JLabel lblNombre;
	public JTextField tfNombre;
	public JLabel lblAtaque;
	public JTextField tfAtaque;
	public JLabel lblNewLabel;
	public JTextField tfDuracion;
	public JButton btGuardar;
	public JButton btBorrar;
	public JButton btModificar;
	public PanelLista<Arma> panelLista;
	
	private Modelo modelo;
	public JLabel lblArmas;
	public JButton btBuscar;

	public PanelArmas(Modelo modelo) {
		this.modelo = modelo;
		setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(43, 56, 78, 14);
		add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(165, 53, 146, 20);
		add(tfNombre);
		tfNombre.setColumns(10);
		
		lblAtaque = new JLabel("Ataque");
		lblAtaque.setBounds(43, 137, 78, 14);
		add(lblAtaque);
		
		tfAtaque = new JTextField();
		tfAtaque.setBounds(165, 134, 146, 20);
		add(tfAtaque);
		tfAtaque.setColumns(10);
		
		lblNewLabel = new JLabel("Duracion");
		lblNewLabel.setBounds(43, 231, 78, 14);
		add(lblNewLabel);
		
		tfDuracion = new JTextField();
		tfDuracion.setBounds(165, 228, 146, 20);
		add(tfDuracion);
		tfDuracion.setColumns(10);
		
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
		
		lblArmas = new JLabel("Armas");
		lblArmas.setBounds(439, 56, 46, 14);
		add(lblArmas);
		
		btBuscar = new JButton("Buscar");
		btBuscar.setBounds(593, 393, 89, 23);
		add(btBuscar);
		
	}
}
