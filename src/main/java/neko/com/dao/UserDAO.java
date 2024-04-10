package neko.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
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

			entityMan.merge(user);

			entityTran.commit();
		} catch (Exception e) {
			// TODO: handle exception

			entityTran.rollback();
		}

	}
	
	
	public void delete(String id) throws Exception {
		try {
			entityTran.begin();
			Users user =  entityMan.find(Users.class, id);
			entityMan.remove(user);

			entityTran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			entityTran.rollback();
			throw new Exception();
		}

	}
	

	public Users findUsersByToken(String inputToken) {
		Users use = null ;
		String querySQL = "Select o from Users o where o.token =:token ";

		TypedQuery<Users> query = entityMan.createQuery(querySQL, Users.class);

		query.setParameter("token", inputToken);
		
		try {
			use = query.getSingleResult();
			return use;
		} catch (Exception e) {
			// TODO: handle exception
			return use;
		}

		

	}

	public Users findUsersByEmail(String email) {
	    try {
	        String querySQL = "SELECT u FROM Users u WHERE u.emailUser = :email";
	        TypedQuery<Users> query = entityMan.createQuery(querySQL, Users.class);
	        query.setParameter("email", email);
	        return query.getSingleResult();
	    } catch (NoResultException e) {
	     
	        return null;
	    } catch (NonUniqueResultException e) {

	        e.printStackTrace(); 
	        return null;
	    } catch (Exception e) {
	        
	        e.printStackTrace(); 
	        return null;
	    }
	}
	
	
	
	
	
	public List<Users> findAll(){
		TypedQuery<Users> query = entityMan.createNamedQuery("Users.findAll", Users.class);
		return query.getResultList();
	}

	public boolean exists(String email) {

		Users user = entityMan.find(Users.class, email);

		return user != null;
	}

}
