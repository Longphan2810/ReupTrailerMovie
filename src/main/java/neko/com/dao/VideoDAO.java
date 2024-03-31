package neko.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import neko.com.jpa.JpaHelper;
import neko.com.model.Video;

public class VideoDAO {
	private EntityManager entityMan = JpaHelper.getEntityManager();
	private EntityTransaction entityTran = entityMan.getTransaction();

	public void insert(Video video) {

		try {
			entityTran.begin();
			entityMan.persist(video);
			entityTran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			entityTran.rollback();
		}

	}

	public void update(Video video) {

		try {
			entityTran.begin();
			entityMan.merge(video);
			entityTran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			entityTran.rollback();
		}

	}
	public void delete(Video video) {

		try {
			entityTran.begin();
			entityMan.remove(video);
			entityTran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			entityTran.rollback();
		}

	}
	
	public Video findById(String id) {
		
		return entityMan.find(Video.class, id);
	}

}
