package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import baseDeDatos.Modelo;
import vista.Login;
import vista.PanelArmas;
import vista.PanelClases;
import vista.PanelPersonajes;
import vista.Vista;

public class Controlador implements ActionListener {

	private Vista vista;
	private Modelo modelo;
	
	public Controlador(Vista vista, Modelo modelo) {
		this.vista=vista;
		this.modelo=modelo;
		
		iniciarSession();
		actioners();
		listeners();
	}
	
	public void actioners() {
		vista.mnPersonaje.setActionCommand("personaje");
		vista.mnArma.setActionCommand("arma");
		vista.mnClases.setActionCommand("clase");
	}
	
	public void listeners() {	
		vista.mnPersonaje.addActionListener(this);
		vista.mnArma.addActionListener(this);
		vista.mnClases.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		
		switch(e.getActionCommand()){
		case "personaje":
			PanelPersonajes panelPersonajes = new PanelPersonajes(modelo);
			vista.tpPaneles.addTab("Personajes", panelPersonajes);
			ControladorPersonajes controladorPersonajes = 
					new ControladorPersonajes(panelPersonajes, modelo);
			break;
		case "arma":
			PanelArmas panelArma = new PanelArmas(modelo);
			vista.tpPaneles.addTab("Armas", panelArma);
			ControladorArmas controladorArmas = 
					new ControladorArmas(panelArma, modelo);
			break;
		case "clase":
			PanelClases panelClase = new PanelClases(modelo);
			vista.tpPaneles.addTab("Clases", panelClase);
			ControladorClases controladorClases = new ControladorClases(panelClase, modelo);
			default:
				break;
		}
	}
	
	public void iniciarSession() {
		
		boolean autenticado = false;
		
		while(!autenticado) {
			Login login = new Login(modelo); 
			String usuario = login.getUsuario();
			String contrasena = login.getContrasena();
			
			autenticado = modelo.iniciarSession(usuario, contrasena);
			
			if(!autenticado) {
				continue;
			}
		}
	}
}
