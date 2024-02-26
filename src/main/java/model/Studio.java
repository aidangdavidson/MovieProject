package model;

import java.time.LocalDate;
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
@Table(name="studio")
public class Studio {

	@Id
	@GeneratedValue
	private int studioId;
	
	private String studioName;
	private LocalDate foundingDate;
	
	public Studio() {
		super();
	}

	public Studio(String studioName) {
		super();
		this.studioName = studioName;
	}

	public Studio(String studioName, LocalDate foundingDate) {
		super();
		this.studioName = studioName;
		this.foundingDate = foundingDate;
	}

	public Studio(int studioId, String studioName, LocalDate foundingDate) {
		super();
		this.studioId = studioId;
		this.studioName = studioName;
		this.foundingDate = foundingDate;
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

	@Override
	public String toString() {
		return "Studio [studioId=" + studioId + ", studioName=" + studioName + ", foundingDate=" + foundingDate + "]";
	}
	
}
