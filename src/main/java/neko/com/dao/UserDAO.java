package neko.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import neko.com.jpa.JpaHelper;
import neko.com.model.Users;

public class UserDAO {
	private EntityManager entityMan = JpaHelper.getEntityManager();
	private EntityTransaction entityTran = entityMan.getTransaction();

	public void insert(Users user) {
		try {
			entityTran.begin();
			
			entityMan.persist(user);
			
			entityTran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			
			entityTran.rollback();
		}
		
	}
	
	public void update(Users user) {
		try {
			entityTran.begin();
			
			entityMan.persist(user);
			
			entityTran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			
			entityTran.rollback();
		}
		
	}
	
	public Users findUsersByToken(String inputToken) {
		
		String querySQL = "Select o from Users o where o.token =:token ";
		
		TypedQuery<Users> query = entityMan.createQuery(querySQL, Users.class);
		
		query.setParameter("token", inputToken);
		
		return query.getSingleResult();
		
	}
	
public Users findUsersByEmail(String email) {
		
		// email user la id 
		
		return entityMan.find(Users.class, email);
		
	}
	
	public boolean exists(String email) {
		
		Users user = entityMan.find(Users.class, email);
		
		return user!=null;
	}
	



}
