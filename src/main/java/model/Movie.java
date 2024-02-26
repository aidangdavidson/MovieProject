package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author aidan - agdavidson
 * CIS175 - Spring 2024
 * Feb 22, 2024
 */
@Entity
@Table(name="movies")
public class Movie {

	@Id
	@GeneratedValue
	private int movieId;
	private String movieTitle;
	private String movieGenre;
	private int movieLength;
	private double movieRating;
	
	public Movie() {
		super();
	}

	public Movie(String movieTitle) {
		super();
		this.movieTitle = movieTitle;
	}

	public Movie(String movieTitle, int movieLength) {
		super();
		this.movieTitle = movieTitle;
		this.movieLength = movieLength;
	}

	public Movie(String movieTitle, String movieGenre, int movieLength) {
		super();
		this.movieTitle = movieTitle;
		this.movieGenre = movieGenre;
		this.movieLength = movieLength;
	}

	public Movie(String movieTitle, String movieGenre, int movieLength, double movieRating) {
		super();
		this.movieTitle = movieTitle;
		this.movieGenre = movieGenre;
		this.movieLength = movieLength;
		this.movieRating = movieRating;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public int getMovieLength() {
		return movieLength;
	}

	public void setMovieLength(int movieLength) {
		this.movieLength = movieLength;
	}

	public double getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(double movieRating) {
		this.movieRating = movieRating;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieTitle=" + movieTitle + ", movieGenre=" + movieGenre
				+ ", movieLength=" + movieLength + ", movieRating=" + movieRating + "]";
	}
	
	
	
}
