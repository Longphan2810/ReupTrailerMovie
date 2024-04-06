package neko.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import neko.com.jpa.JpaHelper;
import neko.com.model.ReportFavoritesUsers;
import neko.com.model.ReportShareVideo;
import neko.com.model.reportFavorites;

public class ReportDAO {
	
	private EntityManager entityMan = JpaHelper.getEntityManager();

	public List<reportFavorites> getListFavorite(){
		
		String querySql = " Select new reportFavorites(o.video.title, COUNT(o.video.idVideo), MAX(o.likeDate),MIN(o.likeDate)) from Favorite o group by o.video.title order by COUNT(o.video.idVideo) desc  ";
		TypedQuery<reportFavorites> query = entityMan.createQuery(querySql, reportFavorites.class);

		return query.getResultList();
	}
	
	public List<ReportFavoritesUsers> getListFavoriteUser(String titleVideo){
		
		String querySql ="Select new ReportFavoritesUsers(o.user.emailUser, o.user.fullname, o.likeDate) from Favorite o where o.video.title like :inputTitle ";
		TypedQuery<ReportFavoritesUsers> query = entityMan.createQuery(querySql,ReportFavoritesUsers.class);
		query.setParameter("inputTitle", "%"+titleVideo+"%");
		
		return query.getResultList();
	}
	
public List<ReportShareVideo> getListShareVideo(String titleVideo){
		
		String querySql ="Select new ReportShareVideo(o.user.fullname, o.user.emailUser, o.email, o.shareDate) from Share o where o.video.title like :inputTitle ";
		TypedQuery<ReportShareVideo> query = entityMan.createQuery(querySql,ReportShareVideo.class);
		query.setParameter("inputTitle", "%"+titleVideo+"%");
		
//		ReportShareVideo x = new ReportShareVideo(querySql, titleVideo, querySql, null)
		
		return query.getResultList();
	}
	
	

}
