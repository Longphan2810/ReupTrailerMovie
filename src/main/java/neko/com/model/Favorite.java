package neko.com.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Favorite database table.
 * 
 */
@Entity
@NamedQuery(name="Favorite.findAll", query="SELECT f FROM Favorite f")
public class Favorite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idFavorite;

	private String likeDate;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="EmailUser")
	private Users user;

	//bi-directional many-to-one association to Video
	@ManyToOne
	@JoinColumn(name="idVideo")
	private Video video;

	public Favorite() {
	}

	public long getIdFavorite() {
		return this.idFavorite;
	}

	public void setIdFavorite(long idFavorite) {
		this.idFavorite = idFavorite;
	}

	public String getLikeDate() {
		return this.likeDate;
	}

	public void setLikeDate(String likeDate) {
		this.likeDate = likeDate;
	}

	public Users getUser() {
		return this.user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Video getVideo() {
		return this.video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

}