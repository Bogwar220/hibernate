package vista;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;

import base.Personaje;
import baseDeDatos.Modelo;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextArea;

public class PanelPersonajes<T> extends JPanel{
	public JLabel lblNombre;
	public JTextField tfNombre;
	public JButton btnGuardar;
	public JButton btnBorrar;
	public PanelLista<Personaje> panelLista;
	public JLabel lblVida;
	public JLabel lblAtaque;
	public JLabel lblDescripcion;
	public JTextField tfVida;
	public JTextField tfAtaque;
	public JTextArea taDescripcion;
	public JLabel lblPersonajes;
	public JButton btnModificar;
	public PanelAnadirArma anadirArma;
	public PanelAnadirClase anadirClase;
	
	private Modelo modelo;		
	public JButton btnBuscar;
	
	public PanelPersonajes(Modelo modelo) {
		this.modelo=modelo;
		setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(30, 33, 76, 14);
		add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(112, 30, 139, 20);
		add(tfNombre);
		tfNombre.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(30, 497, 89, 23);
		add(btnGuardar);		
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(153, 497, 89, 23);
		add(btnBorrar);
		
		panelLista = new PanelLista<>();
		panelLista.setBounds(365,392,317,94);
		add(panelLista);
		
		lblVida = new JLabel("Vida");
		lblVida.setBounds(30, 69, 46, 14);
		add(lblVida);
		
		lblAtaque = new JLabel("Ataque");
		lblAtaque.setBounds(30, 108, 46, 14);
		add(lblAtaque);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(30, 150, 76, 14);
		add(lblDescripcion);
		
		tfVida = new JTextField();
		tfVida.setBounds(112, 66, 139, 20);
		add(tfVida);
		tfVida.setColumns(10);
		
		tfAtaque = new JTextField();
		tfAtaque.setBounds(112, 105, 139, 20);
		add(tfAtaque);
		tfAtaque.setColumns(10);
		
		taDescripcion = new JTextArea();
		taDescripcion.setBounds(112, 176, 196, 181);
		add(taDescripcion);
		
		lblPersonajes = new JLabel("Personajes:");
		lblPersonajes.setBounds(372, 367, 76, 14);
		add(lblPersonajes);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(289, 497, 89, 23);
		add(btnModificar);		
		
		anadirArma = new PanelAnadirArma();
		anadirArma.setBounds(365,33,317,152);
		add(anadirArma);
		
		anadirClase = new PanelAnadirClase();
		anadirClase.setBounds (365,205,317,152);
		add(anadirClase);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(593, 497, 89, 23);
		add(btnBuscar);
	}	
}
