package neko.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import neko.com.jpa.JpaHelper;
import neko.com.model.reportFavorites;

public class ReportDAO {
	
	private EntityManager entityMan = JpaHelper.getEntityManager();

	public List<reportFavorites> getListFavorite(){
		
		String querySql = " Select new reportFavorites(o.video.title, COUNT(o.video.idVideo), MAX(o.likeDate),MIN(o.likeDate)) from Favorite o group by o.video.title order by COUNT(o.video.idVideo) desc  ";
		TypedQuery<reportFavorites> query = entityMan.createQuery(querySql, reportFavorites.class);

		return query.getResultList();
	}
	

}
