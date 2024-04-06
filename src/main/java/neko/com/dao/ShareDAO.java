package neko.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import neko.com.jpa.JpaHelper;
import neko.com.model.Share;
import neko.com.model.Users;

public class ShareDAO {

	
	private EntityManager entityMan = JpaHelper.getEntityManager();
	private EntityTransaction entityTran = entityMan.getTransaction();


	public void insert(Share share) {
		try {
			entityTran.begin();

			entityMan.persist(share);

			entityTran.commit();
		} catch (Exception e) {
			// TODO: handle exception

			entityTran.rollback();
		}

	}
	
	public void update(Share share) {
		try {
			entityTran.begin();

			entityMan.merge(share);

			entityTran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			entityTran.rollback();
		}

	}
	public void delete(String id) {
		try {
			entityTran.begin();
			Share share =  entityMan.find(Share.class, id);
			entityMan.remove(share);

			entityTran.commit();
		} catch (Exception e) {
			// TODO: handle exception

			entityTran.rollback();
		}

	}
	
}
