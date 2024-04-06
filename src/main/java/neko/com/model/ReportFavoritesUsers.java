package neko.com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReportFavoritesUsers {
	@Id
	private String email;
	private String fullname;
	private Date favoriteDate;
	public ReportFavoritesUsers(String email, String fullname, Date favoriteDate) {
		super();
		this.email = email;
		this.fullname = fullname;
		this.favoriteDate = favoriteDate;
	}
	
	public ReportFavoritesUsers() {
		super();
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Date getFavoriteDate() {
		return favoriteDate;
	}
	public void setFavoriteDate(Date favoriteDate) {
		this.favoriteDate = favoriteDate;
	}

	@Override
	public String toString() {
		return "ReportFavoritesUsers [email=" + email + ", fullname=" + fullname + ", favoriteDate=" + favoriteDate
				+ "]";
	}
	
	
	
	
}
