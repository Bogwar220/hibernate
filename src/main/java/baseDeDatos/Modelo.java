package baseDeDatos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import base.Arma;
import base.Clase;
import base.Personaje;
import base.Usuario;
import util.HibernateUtil;

public class Modelo {
	
	public Modelo() {
		conectar();
	}
	
	@Override
	public void finalize() {		
		desconectar();
	}
	
	private void conectar() {
		HibernateUtil.buildSessionFactory();
	}
	
	private void desconectar() {
		HibernateUtil.closeSessionFactory();
	}
	
	public void guardar(Personaje personaje) {
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		session.save(personaje);
		
		for(Arma arma : personaje.getArmas()) {
			arma.setPersonaje(personaje);
			session.saveOrUpdate(arma);
		}
		
		for (Clase clase : personaje.getClases()) {
			clase.getPersonajes().add(personaje);
			session.saveOrUpdate(clase);
		}
		session.getTransaction().commit();
		session.close();
	}
	
	public void eliminar(Personaje personaje) {
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		session.delete(personaje);
		session.getTransaction().commit();
		session.close();
	}	

	public List<Personaje> getPersonajes(){
		Query query = HibernateUtil.getCurrentSession().createQuery("FROM Personaje");
		ArrayList<Personaje> personajes = (ArrayList<Personaje>) query.list();
		return personajes;
	}
	
	public void guardar(Arma arma) {
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		session.save(arma);
		session.getTransaction().commit();
		session.close();
	}
	
	public void eliminar(Arma arma) {
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		session.delete(arma);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Arma> getArmas(){
		Query query = HibernateUtil.getCurrentSession().createQuery("FROM Arma");
		ArrayList<Arma> armas = (ArrayList<Arma>) query.list();
		return armas;
	}
	
	public void guardar(Clase clase) {
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		session.save(clase);
		session.getTransaction().commit();
		session.close();
	}
	
	public void eliminar(Clase clase) {
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		session.delete(clase);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Clase> getClases(){
		Query query = HibernateUtil.getCurrentSession().createQuery("FROM Clase");
		ArrayList<Clase> clases = (ArrayList<Clase>) query.list();
		return clases;
	}
	
	public void guardar(Usuario usuario) {
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		session.save(usuario);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Usuario> getUsuarios(){
		Query query = HibernateUtil.getCurrentSession().createQuery("FROM Usuario");
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) query.list();
		return usuarios;
	}
	
	public boolean iniciarSession(String usuario, String contrasena) {
		
		for(Usuario usuarioOb : getUsuarios()) {
			if(usuarioOb.getNombre().equals(usuario) && 
					usuarioOb.getPassword().equals(contrasena))
				return true;
		}
		return false;
	}
	
	public List<Arma> getArmasDisponibles(){
		Query query = HibernateUtil.getCurrentSession().createQuery
				("FROM Arma a WHERE a.personaje IS NULL");
		ArrayList<Arma> armas = (ArrayList<Arma>) query.list();
		return armas;		
	}
	
	public List<Personaje> getPersonajes(String busqueda){
		
		Query query = HibernateUtil.getCurrentSession().createQuery
				("FROM Personaje p WHERE p.nombre =: nombre");
		query.setParameter("nombre", busqueda);
		ArrayList<Personaje> personajes = (ArrayList<Personaje>) query.list();		
		return personajes;
	}
	
	public List<Arma> getArmas(String busqueda){
		Query query = HibernateUtil.getCurrentSession().createQuery("FROM Arma a WHERE a.nombre =: nombre");
		query.setParameter("nombre", busqueda);		
		ArrayList<Arma> armas = (ArrayList<Arma>) query.list();
		return armas;		
	}
	
	public List<Clase> getClases(String busqueda){
		Query query = HibernateUtil.getCurrentSession().createQuery("FROM Clase c WHERE c.nombre =: nombre");
		query.setParameter("nombre", busqueda);
		ArrayList<Clase> clases = (ArrayList<Clase>) query.list();
		return clases;
	}
}
