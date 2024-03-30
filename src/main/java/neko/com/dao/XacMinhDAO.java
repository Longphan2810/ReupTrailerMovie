package neko.com.dao;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import neko.com.jpa.JpaHelper;
import neko.com.model.XacMinh;

public class XacMinhDAO {

	public void insert(String mail, int codeXacMinh) {
		EntityManager entityMan = JpaHelper.getEntityManager();
		EntityTransaction entityTran = entityMan.getTransaction();

		try {
			entityTran.begin();

			XacMinh xacMinh = new XacMinh();
			xacMinh.setMail(mail);
			xacMinh.setCodeXacMinh(codeXacMinh);
			entityMan.persist(xacMinh);

			entityTran.commit();

		} catch (Exception e) {
			// TODO: handle exception
			entityTran.rollback();
		}

	}

	public void Update(String mail, int codeXacMinh) {
		EntityManager entityMan = JpaHelper.getEntityManager();
		EntityTransaction entityTran = entityMan.getTransaction();

		try {
			entityTran.begin();

			XacMinh xacMinh = new XacMinh();
			xacMinh.setMail(mail);
			xacMinh.setCodeXacMinh(codeXacMinh);
			entityMan.merge(xacMinh);

			entityTran.commit();

		} catch (Exception e) {
			// TODO: handle exception
			entityTran.rollback();
		}

	}

	public boolean checkExists(String mail) {
		EntityManager entityMan = JpaHelper.getEntityManager();

		XacMinh xacMinh = entityMan.find(XacMinh.class, mail);

		if (xacMinh == null) {

			return false;

		}

		return true;
	}

}
