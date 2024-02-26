package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.MovieListDetails;

/**
 * @author Jeff Johnson - jjohnson190
 * CIS175 - Spring 2024
 * Feb 26, 2024
 */

public class ListDetailsHelper {

static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TempMovieProject");
	
	public void insertNewListDetails(MovieListDetails listdeets) {
		
		EntityManager manager = emfactory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(listdeets);
		manager.getTransaction().commit();
		manager.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<MovieListDetails> getLists(){
		
		EntityManager manager = emfactory.createEntityManager();
		List<MovieListDetails> allDetails = manager.createQuery("SELECT d FROM MovieListDetails d").getResultList();
		
		return allDetails;
		
	}

	public void deleteList(MovieListDetails toDelete) {
		// TODO Auto-generated method stub
		
		EntityManager manager = emfactory.createEntityManager();
		manager.getTransaction().begin();
		TypedQuery<MovieListDetails> typedQuery = manager.createQuery("SELECT mld FROM MovieListDetails mld WHERE mld.listId = :selectedId", MovieListDetails.class);
		
		typedQuery.setParameter("selectedId", toDelete.getListId());
		typedQuery.setMaxResults(1);
		MovieListDetails result = typedQuery.getSingleResult();
		
		manager.remove(result);
		manager.getTransaction().commit();
		manager.close();
		
	}


	public MovieListDetails searchForMovieListDetailsById(Integer tempId) {
		// TODO Auto-generated method stub
		
		EntityManager manager = emfactory.createEntityManager();
		manager.getTransaction().begin();
		MovieListDetails found = manager.find(MovieListDetails.class, tempId);
		manager.close();
		
		return found;
	}

	public void updateList(MovieListDetails toUpdate) {
		// TODO Auto-generated method stub
		
		EntityManager manager = emfactory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(toUpdate);
		manager.getTransaction().commit();
		manager.close();
		
	}
	
}
