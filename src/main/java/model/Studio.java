package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author aidan - agdavidson
 * CIS175 - Spring 2024
 * Feb 22, 2024
 */

@Entity
@Table(name = "studios") // Table wasnt mentioned in project doc but I was not sure so I added this
public class Studio {
@Id
@GeneratedValue
private int studioID;

private String studioName;

private LocalDate foundingDate;

// private Genre genreName -- Unsure if studio objects still need genre attribute


@OneToMany(cascade = CascadeType.PERSIST, fetch=FetchType.EAGER) 
@JoinTable
private List<Movie> listOfMovies;

/**
 * @return the studioID
 */
public int getStudioID() {
	return studioID;
}

/**
 * @param studioID the studioID to set
 */
public void setStudioID(int studioID) {
	this.studioID = studioID;
}

/**
 * @return the studioName
 */
public String getStudioName() {
	return studioName;
}

/**
 * @param studioName the studioName to set
 */
public void setStudioName(String studioName) {
	this.studioName = studioName;
}

/**
 * @return the foundingDate
 */
public LocalDate getFoundingDate() {
	return foundingDate;
}

/**
 * @param foundingDate the foundingDate to set
 */
public void setFoundingDate(LocalDate foundingDate) {
	this.foundingDate = foundingDate;
}

/**
 * @return the listOfMovies
 */
public List<Movie> getListOfMovies() {
	return listOfMovies;
}

/**
 * @param listOfMovies the listOfMovies to set
 */
public void setListOfMovies(List<Movie> listOfMovies) {
	this.listOfMovies = listOfMovies;
}

@Override
public String toString() {
	return "Studio [studioID=" + studioID + ", studioName=" + studioName + ", foundingDate=" + foundingDate
			+ ", listOfMovies=" + listOfMovies + "]";
}

public Studio() {
	super();
}

public Studio(String name) {
	this.studioName = name;
}

public Studio(int studioID, String name) {
	this.studioID = studioID;
	this.studioName = name;
}

public Studio(int studioID, String name, LocalDate founded) {
	this.studioID = studioID;
	this.studioName = name;
	this.foundingDate = founded;
}

/*
 * public Studio(int studioID, String name, LocalDate founded, String genreName) Again, not entirely sure about how we are including genre
 * { this.studioID = studioID; 
 * this.studioName = name; 
 * this.foundingDate = founded;
 *  this.genreName = genreName; 
 *  }
 */

/*
 * public Studio(int studioID, String name, LocalDate founded, String genreName, List<Movie> movieList) Again, not entirely sure about how we are including genre
 * { this.studioID = studioID; 
 * this.studioName = name; 
 * this.foundingDate = founded;
 *  this.genreName = genreName; 
 *  this.listOfMovies = movieList;
 *  }
 */

public Studio(int studioID, String name, LocalDate founded, List<Movie> movieList) {
	this.studioID = studioID;
	this.studioName = name;
	this.foundingDate = founded;
	this.listOfMovies = movieList;

}

}