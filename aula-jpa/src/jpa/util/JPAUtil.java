package jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAUtil {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("ifg-poo2");
	
	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	} 
	
}
