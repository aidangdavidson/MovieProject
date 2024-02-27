package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Studio;

/**
 * @author Jeff Johnson - jjohnson190
 * CIS175 - Spring 2024
 * Feb 26, 2024
 */

public class StudioHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MovieProject");
	
	public void insertStudio(Studio studio) {
		
		EntityManager manager = emfactory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(studio);
		manager.getTransaction().commit();
		manager.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Studio> showAllStudios(){
		
		EntityManager manager = emfactory.createEntityManager();
		List<Studio> allStudios = manager.createQuery("SELECT s FROM Studio s").getResultList();
		
		return allStudios;
		
	}

	public Studio findStudio(String studioToFind) {
		// TODO Auto-generated method stub
		
		EntityManager manager = emfactory.createEntityManager();
		manager.getTransaction().begin();
		TypedQuery<Studio> typedQuery = manager.createQuery("SELECT s FROM Studio s WHERE s.studioName = :selectedName", Studio.class);
		
		typedQuery.setParameter("selectedName", studioToFind);
		typedQuery.setMaxResults(1);
		
		Studio foundStudio;
		
		try {
			
			foundStudio = typedQuery.getSingleResult();
			
		} catch (NoResultException ex) {
			
			foundStudio = new Studio(studioToFind);
			
		}
		
		return foundStudio;
	}

}
