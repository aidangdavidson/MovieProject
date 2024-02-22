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
@Table(name = "movies")
public class Movie {
@Id
@GeneratedValue
private int movieID;

private String movieTitle;

private String movieGenre; // Added this and additional constructor 

private int movieLength;

private double movieRating;

/**
 * @return the movieID
 */
public int getMovieID() {
	return movieID;
}

/**
 * @param movieID the movieID to set
 */
public void setMovieID(int movieID) {
	this.movieID = movieID;
}

/**
 * @return the movieLength
 */
public int getMovieLength() {
	return movieLength;
}

/**
 * @param movieLength the movieLength to set
 */
public void setMovieLength(int movieLength) {
	this.movieLength = movieLength;
}

/**
 * @return the movieRating
 */
public double getMovieRating() {
	return movieRating;
}

/**
 * @param movieRating the movieRating to set
 */
public void setMovieRating(double movieRating) {
	this.movieRating = movieRating;
}

/**
 * @return the movieTitle
 */
public String getMovieTitle() {
	return movieTitle;
}

/**
 * @param movieTitle the movieTitle to set
 */
public void setMovieTitle(String movieTitle) {
	this.movieTitle = movieTitle;
}

public String getMovieGenre() {
	return movieGenre;
}

/**
 * @param movieTitle the movieTitle to set
 */
public void setMovieGenre(String movieGenre) {
	this.movieGenre = movieGenre;
}


@Override
public String toString() {
	return "Movie [movieID=" + movieID + ", movieLength=" + movieLength + ", movieRating=" + movieRating + "]";
}

public Movie() {
	super();
}

public Movie(String title) {
	this.movieTitle = title;
}

public Movie(String title, int length) {
	this.movieTitle = title;
	this.movieLength = length;
}

public Movie(String title, int length, double rating) {
	this.movieTitle = title;
	this.movieLength = length;
	this.movieRating = rating;
}

public Movie(String title, int length, double rating, String genre) {
	this.movieTitle = title;
	this.movieLength = length;
	this.movieRating = rating;
	this.movieGenre = genre;
}

}
