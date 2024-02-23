package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Movie;

/**
 * @author aidan - agdavidson
 * CIS175 - Spring 2024
 * Feb 23, 2024
 */
public class MovieHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MovieDatabase");
	
	public void insertMovie(Movie movie) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(movie);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<Movie> getAllMovies(){
		EntityManager em = emfactory.createEntityManager();
		List<Movie> allMovies = em.createQuery("SELECT m FROM Movie m").getResultList();
		return allMovies;
	}
	
	public void deleteMovie(Movie movie) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Movie> typedQuery = em.createQuery("SELECT m FROM Movie WHERE m.movieTitle = :title AND m.movieGenre = :genre AND m.movieLength = :length AND m.movieRating = :rating", Movie.class);
		
		typedQuery.setParameter("title", movie.getMovieTitle());
		typedQuery.setParameter("genre", movie.getMovieGenre());
		typedQuery.setParameter("length", movie.getMovieLength());
		typedQuery.setParameter("rating", movie.getMovieRating());
		typedQuery.setMaxResults(1);
		
		Movie result = typedQuery.getSingleResult();
		em.remove(result);
		
		em.getTransaction().commit();
		em.close();
	}
}
