package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JMenuItem;

public class Vista extends JFrame {

	private JPanel contentPane;
	public JMenuBar menuBar;
	public JMenu mnArchivos;
	public JMenuItem mnPersonaje;
	public JTabbedPane tpPaneles;
	public JMenuItem mnArma;
	public JMenuItem mnClases;

	public Vista() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 650);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivos = new JMenu("Archivos");
		menuBar.add(mnArchivos);
		
		mnPersonaje = new JMenuItem("Personaje");
		mnArchivos.add(mnPersonaje);
		
		mnArma = new JMenuItem("Arma");
		mnArchivos.add(mnArma);
		
		mnClases = new JMenuItem("Clases");
		mnArchivos.add(mnClases);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tpPaneles = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tpPaneles, BorderLayout.CENTER);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

}
