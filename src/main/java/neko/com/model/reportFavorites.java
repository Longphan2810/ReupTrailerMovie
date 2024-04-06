package neko.com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class reportFavorites {
	@Id
	private String videoTilte; 
	private long favoriteCount;
	private Date lastDate;
	private Date oldDate;
	public String getVideoTilte() {
		return videoTilte;
	}
	public void setVideoTilte(String videoTilte) {
		this.videoTilte = videoTilte;
	}
	public long getFavoriteCount() {
		return favoriteCount;
	}
	public void setFavoriteCount(long favoriteCount) {
		this.favoriteCount = favoriteCount;
	}
	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	public Date getOldDate() {
		return oldDate;
	}
	public void setOldDate(Date oldDate) {
		this.oldDate = oldDate;
	}
	public reportFavorites(String videoTilte, long favoriteCount, Date lastDate, Date oldDate) {
		super();
		this.videoTilte = videoTilte;
		this.favoriteCount = favoriteCount;
		this.lastDate = lastDate;
		this.oldDate = oldDate;
	}
	public reportFavorites() {
		super();
	}
	@Override
	public String toString() {
		return "reportFavorites [videoTilte=" + videoTilte + ", favoriteCount=" + favoriteCount + ", lastDate="
				+ lastDate + ", oldDate=" + oldDate + "]";
	}
	
	
	
}
