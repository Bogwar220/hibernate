package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import base.Arma;
import base.Clase;
import baseDeDatos.Modelo;
import util.JComboGenerico;

public class PanelAnadirClase extends JPanel implements ActionListener {

	public JPanel panel;
	public JScrollPane scrollPane;
	public JList<Clase> lista;
	public JComboGenerico<Clase> cbClase;
	public DefaultListModel<Clase> modeloLista;
	public JButton btMas;
	public JButton btMenos;

	public PanelAnadirClase() {
		setLayout(new BorderLayout(0,0));
		
		panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 45, 258, 87);
		add(scrollPane, BorderLayout.CENTER);
		
		lista = new JList<>();
		scrollPane.setViewportView(lista);
		modeloLista = new DefaultListModel<>();
		lista.setModel(modeloLista);
		
		cbClase = new JComboGenerico<>();
		cbClase.setBounds(46, 32, 100, -18);
		cbClase.setPreferredSize(new Dimension(100,20));
		panel.add(cbClase);
		
		btMas = new JButton("+");
		btMas.setBounds(169, 11, 48, 23);
		panel.add(btMas);
		
		btMenos = new JButton("-");
		btMenos.setBounds(227, 11, 48, 23);
		panel.add(btMenos);		
		
		inicializar();
		actioners();
		listeners();
	}
	
	public void inicializar() {
		Modelo modelo = new Modelo();
		List<Clase> clases = modelo.getClases();
		cbClase.inicializar(clases);
	}
	
	private void actioners() {
		btMas.setActionCommand("+");
		btMenos.setActionCommand("-");
	}
	
	private void listeners() {
		btMas.addActionListener(this);
		btMenos.addActionListener(this);
	}
	
	public List<Clase> getListadoClases(){
		return Collections.list(modeloLista.elements());
	}
	
	public void anadirClases(List<Clase> clases) {
		modeloLista.removeAllElements();
		for(Clase clase : clases) {
			modeloLista.addElement(clase);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch(e.getActionCommand()) {
			case "+":
				Clase claseSeleccionada = cbClase.getDatoSeleccionado();
				if(claseSeleccionada == null)
					return;
				if(modeloLista.contains(claseSeleccionada))
					return;
				
				modeloLista.addElement(claseSeleccionada);
				break;
			case "-":
				if(lista.getSelectedIndex() == -1)
					return;
				
				cbClase.addItem(modeloLista.remove(lista.getSelectedIndex()));
				break;
				default:
					break;
		}
	}

}
