package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import base.Arma;
import baseDeDatos.Modelo;
import util.JComboGenerico;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class PanelAnadirArma extends JPanel implements ActionListener {
	public JPanel panel;
	public JScrollPane scrollPane;
	public JList<Arma> lista;
	public JComboGenerico<Arma> cbArmas;
	public DefaultListModel<Arma> modeloLista;
	public JButton btMas;
	public JButton btMenos;

	public PanelAnadirArma() {
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
		
		cbArmas = new JComboGenerico<>();
		cbArmas.setBounds(46, 32, 100, -18);
		cbArmas.setPreferredSize(new Dimension(100,20));
		panel.add(cbArmas);
		
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
		List<Arma> armas = modelo.getArmasDisponibles();
		cbArmas.inicializar(armas);
	}
	
	private void actioners() {
		btMas.setActionCommand("+");
		btMenos.setActionCommand("-");
	}
	
	private void listeners() {
		btMas.addActionListener(this);
		btMenos.addActionListener(this);
	}
	
	public List<Arma> getListadoArmas(){
		return Collections.list(modeloLista.elements());
	}
	
	public void anadirArmas(List<Arma> armas) {
		modeloLista.removeAllElements();
		for(Arma arma : armas) {
			modeloLista.addElement(arma);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch(e.getActionCommand()) {
			case "+":
				Arma armaSeleccionada = cbArmas.getDatoSeleccionado();
				if(armaSeleccionada == null)
					return;
				if(modeloLista.contains(armaSeleccionada))
					return;
				
				modeloLista.addElement(armaSeleccionada);
				break;
			case "-":
				if(lista.getSelectedIndex() == -1)
					return;
				
				cbArmas.addItem(modeloLista.remove(lista.getSelectedIndex()));
				break;
				default:
					break;
		}
	}
}
