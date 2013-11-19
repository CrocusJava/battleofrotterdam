package com.battleejb.ejbbeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.battleejb.entities.User;

/**
 * @author rtkachuk
 *
 */
@Stateless
@LocalBean
public class UserBean extends AbstractFacade<User>{

	@PersistenceContext(unitName="persistence")
	EntityManager em;
	
	public UserBean() {
		super(User.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public User checkByLogin(String login) throws NoResultException {
        User user=em.createNamedQuery("User.findByLogin",User.class).setParameter("login", login).getSingleResult();
        return user;
    }
}
