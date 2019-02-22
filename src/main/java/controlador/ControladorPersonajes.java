package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import base.Personaje;
import baseDeDatos.Modelo;
import vista.PanelPersonajes;

public class ControladorPersonajes implements ActionListener, MouseListener {
	
	private PanelPersonajes<Personaje> paneP;	
	private Modelo modelo;	
	
	public ControladorPersonajes(PanelPersonajes panelPersonajes, Modelo modelo) {
		this.paneP = panelPersonajes;
		this.modelo = modelo;	
		
		actioners();
		listeners();
		paneP.panelLista.inicializar(modelo.getPersonajes());
	}
	
	public void busqueda() {
		if(paneP.panelLista.tfNombre.equals(" "))
			paneP.panelLista.inicializar(modelo.getPersonajes());
		else
			paneP.panelLista.inicializar(modelo.getPersonajes(paneP.panelLista.tfNombre.getText()));
	}
	public void actioners() {
		paneP.btnGuardar.setActionCommand("guardar");
		paneP.btnBorrar.setActionCommand("eliminar");
		paneP.btnModificar.setActionCommand("modificar");
		paneP.btnBuscar.setActionCommand("buscar");
	}
	
	public void listeners() {
		paneP.btnGuardar.addActionListener(this);
		paneP.btnBorrar.addActionListener(this);
		paneP.btnModificar.addActionListener(this);
		paneP.btnBuscar.addActionListener(this);
		
		paneP.panelLista.addListener(this);
	}
	
	public void cargar(Personaje personaje) {
		paneP.tfNombre.setText(personaje.getNombre());
		paneP.tfVida.setText(String.valueOf(personaje.getVida()));
		paneP.tfAtaque.setText(String.valueOf(personaje.getAtaque()));
		paneP.taDescripcion.setText(personaje.getDescripcion());
			
		paneP.anadirArma.anadirArmas(personaje.getArmas());
		paneP.anadirClase.anadirClases(personaje.getClases());		

	}
	
	public void machacar(Personaje personaje) {
		personaje.setNombre(paneP.tfNombre.getText());
		personaje.setDescripcion(paneP.taDescripcion.getText());
		personaje.setVida(Integer.parseInt(paneP.tfVida.getText()));
		personaje.setAtaque(Integer.parseInt(paneP.tfVida.getText()));
		
		personaje.setArmas(paneP.anadirArma.getListadoArmas());
		personaje.setClases(paneP.anadirClase.getListadoClases());
		
		System.out.println(paneP.anadirArma.getListadoArmas());		

	}
	
	public void verificarExistencia(Personaje personaje) {

		for(Personaje personajeBusq : modelo.getPersonajes()) {			
			if(personajeBusq.getNombre().equals(personaje.getNombre()))
				return;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Personaje personaje = new Personaje();
		
		switch(e.getActionCommand()){		
			case "guardar":
				machacar(personaje);				
				for(Personaje personajeBusq : modelo.getPersonajes()) {
					if(personajeBusq.getNombre().equals(personaje.getNombre()))
						return;
				}
				
				modelo.guardar(personaje);
				paneP.panelLista.inicializar(modelo.getPersonajes());					
				break;
			case "eliminar":				
				if(!paneP.panelLista.estaSeleccionado())
					return;
				
				personaje = (Personaje) paneP.panelLista.getSeleccionado();
				modelo.eliminar(personaje);
				paneP.panelLista.inicializar(modelo.getPersonajes());
				break;
			case "modificar":
				if(!paneP.panelLista.estaSeleccionado())
					return;
				personaje = (Personaje) paneP.panelLista.getSeleccionado();
				
				machacar(personaje);
				verificarExistencia(personaje);
				modelo.guardar(personaje);
				
				paneP.panelLista.inicializar(modelo.getPersonajes());
				break;
			case "buscar":	
				if(paneP.panelLista.tfNombre.getText().equals(""))
					paneP.panelLista.inicializar(modelo.getPersonajes());
				else				
					paneP.panelLista.inicializar(modelo.getPersonajes
							(paneP.panelLista.tfNombre.getText()));
				
				System.out.println(paneP.panelLista.tfNombre.getText());
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
		
		Personaje personaje = (Personaje) paneP.panelLista.getSeleccionado();
		
		if(personaje == null)
			return;
		
		cargar(personaje);
	}
}
