package com.battleejb.ejbbeans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaQuery;

import com.battleejb.entities.User;
import com.battleejb.interceptors.FaultBarrierInterceptor;

/**
 * @author rtkachuk
 * @author Lukashchuk Ivan
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

	public User findByEmail(String email) {
		User user = null;
		try {
			user = em.createNamedQuery("User.findByEmail", User.class)
					.setParameter("email", email).getSingleResult();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean chackLoginExist(String login) {
		long result = (Long) em.createNamedQuery("User.getCountOfUserByLogin")
				.setParameter("login", login).getSingleResult();
		if (result > 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean chackEmailExist(String email) {
		long result = (Long) em.createNamedQuery("User.getCountOfUserByEmail")
				.setParameter("email", email).getSingleResult();
		if (result > 0) {
			return false;
		} else {
			return true;
		}
	}

	public List<User> findAllLimit(Integer firstPosition, Integer size) {
		List<User> users = null;
		try {
			CriteriaQuery<User> cq = em.getCriteriaBuilder().createQuery(
					User.class);
			cq.select(cq.from(User.class));
			users = getEntityManager().createQuery(cq)
					.setFirstResult(firstPosition).setMaxResults(size)
					.getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return users;
	}

	public List<User> findByLoginLimit(String login, Integer firstPosition,
			Integer size) {
		List<User> users = null;
		if (login != null) {
			login += "%";
		} else {
			login = "%";
		}
		try {
			users = em.createNamedQuery("User.findByLoginPattern", User.class)
					.setParameter("login", login).setFirstResult(firstPosition)
					.setMaxResults(size).getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return users;
	}

	public long getCountByLogin(String login) {
		long count = 0;
		if (login != null) {
			login += "%";
		} else {
			login = "%";
		}
		try {
			count = (Long) em.createNamedQuery("User.getCountByLoginPattern")
					.setParameter("login", login).getSingleResult();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return count;
	}
}
