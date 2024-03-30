package neko.com.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaHelper {

	public static EntityManagerFactory getEntityManagerFactory() {
		
		return Persistence.createEntityManagerFactory("ReupTrailerMovie");
		
	}
	
	public static EntityManager getEntityManager() {
		
		return getEntityManagerFactory().createEntityManager();
		
	}
	
}
