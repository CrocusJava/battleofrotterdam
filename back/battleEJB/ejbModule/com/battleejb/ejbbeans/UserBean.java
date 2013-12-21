package com.battleejb.ejbbeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.battleejb.entities.User;
import com.battleejb.interceptors.FaultBarrierInterceptor;

/**
 * @author rtkachuk
 * 
 */
@Stateless
@LocalBean
public class UserBean extends AbstractFacade<User> {

	@PersistenceContext(unitName = "persistence")
	EntityManager em;

	public UserBean() {
		super(User.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public User checkByLogin(String login) {
		User user = null;
		try {
			user = em.createNamedQuery("User.findByLogin", User.class)
					.setParameter("login", login).getSingleResult();
		} catch (PersistenceException e) {
			// TODO LOG
		}
		return user;
	}

	public boolean chackLoginExist(String login) {
		int result = (Integer) em.createQuery("SELECT COUNT(u) FROM User u WHERE login=:login")
				.setParameter("login", login).getSingleResult();
		if(result > 0){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean chackEmailExist(String email) {
		int result = (Integer) em.createQuery("SELECT COUNT(u) FROM User u WHERE email=:email")
				.setParameter("email", email).getSingleResult();
		if(result > 0){
			return false;
		}else{
			return true;
		}
	}
}
