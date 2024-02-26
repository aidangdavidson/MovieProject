package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Jeff Johnson - jjohnson190
 * CIS175 - Spring 2024
 * Feb 26, 2024
 */

@Entity
public class MovieListDetails {

	@Id
	@GeneratedValue
	private int listId;
	private String listName;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Studio studio;
	
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable
	private List<Movie> listOfMovies;
	
	public MovieListDetails() {
		super();
	}

	public MovieListDetails(String listName, Studio studio) {
		super();
		this.listName = listName;
		this.studio = studio;
	}

	public MovieListDetails(String listName, Studio studio, List<Movie> listOfMovies) {
		super();
		this.listName = listName;
		this.studio = studio;
		this.listOfMovies = listOfMovies;
	}

	public MovieListDetails(int listId, String listName, Studio studio, List<Movie> listOfMovies) {
		super();
		this.listId = listId;
		this.listName = listName;
		this.studio = studio;
		this.listOfMovies = listOfMovies;
	}

	public int getListId() {
		return listId;
	}

	public void setListId(int listId) {
		this.listId = listId;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public Studio getStudio() {
		return studio;
	}

	public void setStudio(Studio studio) {
		this.studio = studio;
	}

	public List<Movie> getListOfMovies() {
		return listOfMovies;
	}

	public void setListOfMovies(List<Movie> listOfMovies) {
		this.listOfMovies = listOfMovies;
	}

	@Override
	public String toString() {
		return "MovieListDetails [listId=" + listId + ", listName=" + listName + ", studio=" + studio
				+ ", listOfMovies=" + listOfMovies + "]";
	}
	
	
	
}
