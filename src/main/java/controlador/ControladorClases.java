package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import base.Clase;
import baseDeDatos.Modelo;
import vista.PanelClases;

public class ControladorClases implements ActionListener, MouseListener{
	
	private PanelClases<Clase> paneC;
	private Modelo modelo;
	
	public ControladorClases(PanelClases paneC, Modelo modelo) {
		this.paneC = paneC;
		this.modelo = modelo;
		
		actioners();
		listeners();
		paneC.panelLista.inicializar(modelo.getClases());
	}
	
	public void actioners() {
		paneC.btGuardar.setActionCommand("guardar");
		paneC.btBorrar.setActionCommand("eliminar");
		paneC.btModificar.setActionCommand("modificar");
		paneC.btBuscar.setActionCommand("buscar");
	}
	
	public void listeners() {
		paneC.btGuardar.addActionListener(this);
		paneC.btBorrar.addActionListener(this);
		paneC.btModificar.addActionListener(this);
		paneC.btBuscar.addActionListener(this);
		
		paneC.panelLista.addListener(this);
	}
	
	public void cargar(Clase clase) {
		paneC.tfNombre.setText(clase.getNombre());
		paneC.tfDefensa.setText(String.valueOf(clase.getDefensa()));
		paneC.tfMana.setText(String.valueOf(clase.getMana()));
		paneC.tfMagia.setText(String.valueOf(clase.getMagia()));
		
		//Faltan personajes
	}
	
	public void machacar(Clase clase) {
		clase.setNombre(paneC.tfNombre.getText());
		clase.setDefensa(Integer.parseInt(paneC.tfDefensa.getText()));
		clase.setMana(Integer.parseInt(paneC.tfMana.getText()));
		clase.setMagia(Integer.parseInt(paneC.tfMagia.getText()));
		
		//Faltan personajes
	}
	
	public void verificarExistencia (Clase clase) {
		for(Clase claseBusq : modelo.getClases()) {
			if(claseBusq.getNombre().equals(clase.getNombre()))
				return;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Clase clase = new Clase();
		
		switch(e.getActionCommand()) {
			case "guardar":
				machacar(clase);
				verificarExistencia(clase);
				modelo.guardar(clase);
				paneC.panelLista.inicializar(modelo.getClases());
				break;
			case "eliminar":
				if(!paneC.panelLista.estaSeleccionado())
					return;
				clase = paneC.panelLista.getSeleccionado();
				modelo.eliminar(clase);
				paneC.panelLista.inicializar(modelo.getClases());
				break;
			case "modificar":
				if(!paneC.panelLista.estaSeleccionado())
					return;
				
				clase = paneC.panelLista.getSeleccionado();
				machacar(clase);
				verificarExistencia(clase);
				modelo.guardar(clase);
				
				paneC.panelLista.inicializar(modelo.getClases());
				break;
			case "buscar":
				if(paneC.panelLista.tfNombre.getText().equals(""))
					paneC.panelLista.inicializar(modelo.getClases());
				else
					paneC.panelLista.inicializar(modelo.getClases
							(paneC.panelLista.tfNombre.getText()));
				break;
				default:
					break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		Clase clase = paneC.panelLista.getSeleccionado();
		
		if(clase == null)
			return;
		
		cargar(clase);
	}
}
