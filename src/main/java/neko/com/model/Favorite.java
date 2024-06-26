package neko.com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the Favorite database table.
 * 
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "EmailUser","idVideo" }))
@NamedQuery(name="Favorite.findAll", query="SELECT f FROM Favorite f")
public class Favorite implements Serializable {
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long idFavorite;
	
	@Temporal(TemporalType.DATE)
	private Date likeDate;

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

	public Date getLikeDate() {
		return this.likeDate;
	}

	public void setLikeDate(Date likeDate) {
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