package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import base.Arma;
import base.Clase;
import base.Personaje;
import base.Usuario;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static Session session;
	
	public static void buildSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure();
		
		configuration.addAnnotatedClass(Personaje.class);
		configuration.addAnnotatedClass(Arma.class);
		configuration.addAnnotatedClass(Clase.class);
		configuration.addAnnotatedClass(Usuario.class);
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
				applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static void openSession() {
		session = sessionFactory.openSession();
	}
	
	public static Session getCurrentSession() {
	
		if((session == null) || (!session.isOpen()))
			openSession();
		
		return session;
	}
	
	 public static void closeSessionFactory() {
			
	    if (session != null)
	      session.close();
			
	    if (sessionFactory != null)
	      sessionFactory.close();
	}
}
