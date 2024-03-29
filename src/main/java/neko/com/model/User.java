package neko.com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the User database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idUser;

	private boolean admin;

	private String email;

	@Column(name="Fullname")
	private String fullname;

	private String password;

	//bi-directional many-to-one association to Favorite
	@OneToMany(mappedBy="user")
	private List<Favorite> favorites;

	//bi-directional many-to-one association to Share
	@OneToMany(mappedBy="user")
	private List<Share> shares;

	public User() {
	}

	public String getIdUser() {
		return this.idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public boolean getAdmin() {
		return this.admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Favorite> getFavorites() {
		return this.favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public Favorite addFavorite(Favorite favorite) {
		getFavorites().add(favorite);
		favorite.setUser(this);

		return favorite;
	}

	public Favorite removeFavorite(Favorite favorite) {
		getFavorites().remove(favorite);
		favorite.setUser(null);

		return favorite;
	}

	public List<Share> getShares() {
		return this.shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}

	public Share addShare(Share share) {
		getShares().add(share);
		share.setUser(this);

		return share;
	}

	public Share removeShare(Share share) {
		getShares().remove(share);
		share.setUser(null);

		return share;
	}

}