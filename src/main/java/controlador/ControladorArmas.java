package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import base.Arma;
import baseDeDatos.Modelo;
import vista.PanelArmas;

public class ControladorArmas implements ActionListener, MouseListener {

	private PanelArmas<Arma> paneP;
	private Modelo modelo;
	
	public ControladorArmas(PanelArmas paneP, Modelo modelo) {
		this.paneP = paneP;
		this.modelo = modelo;
		
		actioners();
		listeners();
		paneP.panelLista.inicializar(modelo.getArmas());
	}
	
	public void actioners() {
		paneP.btGuardar.setActionCommand("guardar");
		paneP.btBorrar.setActionCommand("eliminar");
		paneP.btModificar.setActionCommand("modificar");
		paneP.btBuscar.setActionCommand("buscar");
	}
	
	public void listeners() {
		paneP.btGuardar.addActionListener(this);
		paneP.btBorrar.addActionListener(this);
		paneP.btModificar.addActionListener(this);
		paneP.btBuscar.addActionListener(this);
		
		paneP.panelLista.addListener(this);
	}
	
	public void cargar (Arma arma) {
		paneP.tfNombre.setText(arma.getNombre());
		paneP.tfAtaque.setText(String.valueOf(arma.getAtaque()));
		paneP.tfDuracion.setText(String.valueOf(arma.getDuracion()));
	}
	
	public void machacar(Arma arma) {
		arma.setNombre(paneP.tfNombre.getText());
		arma.setAtaque(Integer.parseInt(paneP.tfAtaque.getText()));
		arma.setDuracion(Integer.parseInt(paneP.tfDuracion.getText()));
	}
	
	public void verificarExistencia(Arma arma) {
		
		for(Arma armaBusq : modelo.getArmas()) {
			if(armaBusq.getNombre().equals(arma.getNombre()))
				return;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Arma arma = new Arma();
		
		switch(e.getActionCommand()) {
			case "guardar":
				machacar(arma);
				for(Arma armaBusq : modelo.getArmas()) {
					if(armaBusq.getNombre().equals(arma.getNombre()))
						return;
				}
				modelo.guardar(arma);
				paneP.panelLista.inicializar(modelo.getArmas());
				break;
			case "eliminar":
				if(!paneP.panelLista.estaSeleccionado())
					return;
				
				arma = paneP.panelLista.getSeleccionado();
				modelo.eliminar(arma);
				paneP.panelLista.inicializar(modelo.getArmas());				
				break;
			case "modificar":
				if(!paneP.panelLista.estaSeleccionado())
					return;
				
				arma = paneP.panelLista.getSeleccionado();
				
				machacar(arma);
				verificarExistencia(arma);
				modelo.guardar(arma);
				
				paneP.panelLista.inicializar(modelo.getArmas());				
				break;
			case "buscar":
				if(paneP.panelLista.tfNombre.getText().equals(""))
					paneP.panelLista.inicializar(modelo.getArmas());
				else
					paneP.panelLista.inicializar(modelo.getArmas
							(paneP.panelLista.tfNombre.getText()));
				break;
				default:
					break;
		}		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Arma arma = paneP.panelLista.getSeleccionado();
		
		if(arma == null)
			return;
		
		cargar(arma);
		
	}
}
