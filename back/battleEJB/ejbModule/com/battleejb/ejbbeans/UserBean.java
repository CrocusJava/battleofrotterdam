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
			//TODO LOG
		}
		return user;
	}
}