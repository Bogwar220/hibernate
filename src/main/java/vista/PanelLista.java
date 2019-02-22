package vista;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class PanelLista<T> extends JPanel {
	public JTextField tfNombre;
	public JScrollPane scrollPane;
	public JList<T> lista;
	public DefaultListModel<T> modeloLista;
	
	private List<T> datos;

	public PanelLista() {
		setLayout(new BorderLayout(0, 0));
		
		tfNombre = new JTextField();
		add(tfNombre, BorderLayout.SOUTH);
		tfNombre.setColumns(10);
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		lista = new JList();
		scrollPane.setViewportView(lista);
		modeloLista = new DefaultListModel<>();
		lista.setModel(modeloLista);

		this.setVisible(true);
	}
	
	public void inicializar(List<T> datos) {
		this.datos = datos;
		
		modeloLista = new DefaultListModel<>();
		lista.setModel(modeloLista);
		
		refrescar();
	}
	
	public void refrescar() {
		limpiar();
		listar();
	}
	
	public void limpiar() {
		modeloLista.removeAllElements();
	}
	
	public void listar() {
		if(datos == null) 
			return;		
		else
			for(T dato : datos)
				modeloLista.addElement(dato); 
	}
	
	public T getSeleccionado() {
		return lista.getSelectedValue();
	}	
	
	public boolean estaSeleccionado() {
		return lista.getSelectedIndex() != -1;
	}
	
	public void addListener(MouseListener listener) {
		lista.addMouseListener(listener);
	}
}
