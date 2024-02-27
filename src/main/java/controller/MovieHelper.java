package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Movie;

/**
 * @author Jeff Johnson - jjohnson190
 * CIS175 - Spring 2024
 * Feb 26, 2024
 */

public class MovieHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MovieProject");
	
	public void addMovie (Movie movie) {
		
		EntityManager manager = emfactory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(movie);
		manager.getTransaction().commit();
		manager.close();
		
	}
	
	public void deleteMovie (Movie movie) {
		
		EntityManager manager = emfactory.createEntityManager();
		manager.getTransaction().begin();
		manager.remove(manager.find(Movie.class, movie.getMovieId()));
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void updateMovie (Movie movie) {
		
		EntityManager manager = emfactory.createEntityManager();
		Movie dbEntity = manager.find(Movie.class, movie.getMovieId());
		manager.getTransaction().begin();
		dbEntity.setMovieTitle(movie.getMovieTitle());
		dbEntity.setMovieGenre(movie.getMovieGenre());
		dbEntity.setMovieLength(movie.getMovieLength());
		dbEntity.setMovieRating(movie.getMovieRating());
		manager.getTransaction().commit();
		manager.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Movie> showAllMovies() {
		
		EntityManager manager = emfactory.createEntityManager();
		List<Movie> allMovies = manager.createQuery("SELECT i FROM Movie i").getResultList();
		manager.close();
		
		return allMovies;
		
	}
	
	public Movie searchForMovieByID(Integer tempID) {
		
		EntityManager manager = emfactory.createEntityManager();
		manager.getTransaction().begin();
		Movie foundMovie = manager.find(Movie.class, tempID);
		manager.close();
		
		return foundMovie;
		
	}
	
}
