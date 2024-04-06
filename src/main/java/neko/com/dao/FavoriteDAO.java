package neko.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import neko.com.jpa.JpaHelper;
import neko.com.model.Favorite;
import neko.com.model.Users;

public class FavoriteDAO {
	private EntityManager entityMan = JpaHelper.getEntityManager();
	private EntityTransaction entityTran = entityMan.getTransaction();

	public void insert(Favorite favorite) {
		try {
			entityTran.begin();

			entityMan.persist(favorite);

			entityTran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entityTran.rollback();
		}

	}

	public void update(Favorite favorite) {
		try {
			entityTran.begin();

			entityMan.merge(favorite);

			entityTran.commit();
		} catch (Exception e) {
			// TODO: handle exception

			entityTran.rollback();
		}

	}

	public void delelte(Long id) {
		try {
			entityTran.begin();
			Favorite favorite = entityMan.find(Favorite.class, id);
			entityMan.remove(favorite);
			entityTran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entityTran.rollback();
		}

	}

	public void deleteByIdUserAndIdVideo(String idUser, String idVideo) {
		try {
			entityTran.begin();

			String querySql = "Select o from Favorite o where o.user.emailUser =:idUser and o.video.idVideo =:idVideo";
			TypedQuery<Favorite> query = entityMan.createQuery(querySql, Favorite.class);
			query.setParameter("idUser", idUser);
			query.setParameter("idVideo", idVideo);
			Favorite favorite = query.getSingleResult();
			entityMan.remove(favorite);
			entityTran.commit();
		} catch (Exception e) {
			// TODO: handle exception

			entityTran.rollback();
		}

	}

	public List<Favorite> SeleteByIdUser(String idUser) {

		String querySql = "Select o from Favorite o where o.user.emailUser =:idUser ";
		TypedQuery<Favorite> query = entityMan.createQuery(querySql, Favorite.class);
		query.setParameter("idUser", idUser);

		return query.getResultList();
	}

	public Favorite findByIdUserAndIdVideo(String idUser, String idVideo) {
		try {
			String querySql = "Select o from Favorite o where o.user.emailUser =:idUser and o.video.idVideo =:idVideo";
			TypedQuery<Favorite> query = entityMan.createQuery(querySql, Favorite.class);
			query.setParameter("idUser", idUser);
			query.setParameter("idVideo", idVideo);
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}

}
