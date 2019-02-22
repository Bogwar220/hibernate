package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import base.Usuario;
import baseDeDatos.Modelo;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	public JTextField tfUsuario;
	public JPasswordField tfContrasena;
	public JButton btLog;
	public JButton btCrear;

	
	private String usuario;
	private String contrasena;
	
	private Modelo modelo;

	public Login(Modelo modelo) {
		this.modelo = modelo;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(42, 60, 46, 14);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Contrasena");
		lblNewLabel_1.setBounds(42, 149, 73, 14);
		contentPanel.add(lblNewLabel_1);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(151, 60, 174, 20);
		contentPanel.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		tfContrasena = new JPasswordField();
		tfContrasena.setBounds(151, 146, 174, 20);
		contentPanel.add(tfContrasena);
		tfContrasena.setColumns(10);
		
		btLog = new JButton("Login");
		btLog.setBounds(42, 210, 89, 23);
		contentPanel.add(btLog);
		
		btCrear = new JButton("Crear");
		btCrear.setBounds(254, 210, 89, 23);
		contentPanel.add(btCrear);
		

		actioners();
		listeners();
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setModal(true);
		setVisible(true);
		
	}
	
	public void actioners() {
		btLog.setActionCommand("log");
		btCrear.setActionCommand("crear");
	}
	
	public void listeners() {
		btLog.addActionListener(this);
		btCrear.addActionListener(this);
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public String getContrasena() {
		return contrasena;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch(e.getActionCommand()) {
		case "log":
			usuario = tfUsuario.getText();
			contrasena = String.valueOf(tfContrasena.getPassword());
			setVisible(false);
			break;
		case "crear":
			Usuario usuario = new Usuario();
			usuario.setNombre(tfUsuario.getText());
			usuario.setPassword(tfContrasena.getText());
			
			modelo.guardar(usuario);			
			break;
			default:
				break;
		}		
	}
}
