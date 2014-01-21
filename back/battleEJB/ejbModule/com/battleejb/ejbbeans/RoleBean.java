/**
 * 
 */
package com.battleejb.ejbbeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.battleejb.entities.Role;

/**
 * @author marina
 * 
 */

@Stateless
@LocalBean
public class RoleBean extends AbstractFacade<Role> {

	@PersistenceContext(unitName = "persistence")
	EntityManager em;

	public RoleBean() {
		super(Role.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public Role findByName(String name) {
		Role role = null;
		try {
			role = em
					.createNamedQuery("Role.findByName",
							Role.class).setParameter("role", name)
					.getSingleResult();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return role;
	}
}
