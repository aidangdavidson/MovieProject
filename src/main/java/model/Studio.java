package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author aidan - agdavidson
 * CIS175 - Spring 2024
 * Feb 22, 2024
 */

@Entity
public class Studio {

	@Id
	@GeneratedValue
	private int studioId;
	
	private String studioName;
	private LocalDate foundingDate;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Movie movie;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable
	private List<Movie> listOfMovies;
	
	public Studio() {
		super();
	}

	public Studio(String studioName) {
		super();
		this.studioName = studioName;
	}

	public Studio(int studioId, String studioName) {
		super();
		this.studioId = studioId;
		this.studioName = studioName;
	}

	public Studio(int studioId, String studioName, LocalDate foundingDate) {
		super();
		this.studioId = studioId;
		this.studioName = studioName;
		this.foundingDate = foundingDate;
	}

	public Studio(int studioId, String studioName, LocalDate foundingDate, Movie movie) {
		super();
		this.studioId = studioId;
		this.studioName = studioName;
		this.foundingDate = foundingDate;
		this.movie = movie;
	}

	public Studio(int studioId, String studioName, LocalDate foundingDate, Movie movie, List<Movie> listOfMovies) {
		super();
		this.studioId = studioId;
		this.studioName = studioName;
		this.foundingDate = foundingDate;
		this.movie = movie;
		this.listOfMovies = listOfMovies;
	}

	public int getStudioId() {
		return studioId;
	}

	public void setStudioId(int studioId) {
		this.studioId = studioId;
	}

	public String getStudioName() {
		return studioName;
	}

	public void setStudioName(String studioName) {
		this.studioName = studioName;
	}

	public LocalDate getFoundingDate() {
		return foundingDate;
	}

	public void setFoundingDate(LocalDate foundingDate) {
		this.foundingDate = foundingDate;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public List<Movie> getListOfMovies() {
		return listOfMovies;
	}

	public void setListOfMovies(List<Movie> listOfMovies) {
		this.listOfMovies = listOfMovies;
	}

	@Override
	public String toString() {
		return "Studio [studioId=" + studioId + ", studioName=" + studioName + ", foundingDate=" + foundingDate
				+ ", movie=" + movie + ", listOfMovies=" + listOfMovies + "]";
	}
	
	
	
}
