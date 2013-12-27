package com.battleejb.ejbbeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.battleejb.entities.URL;

/**
 * @author marina
 * 
 */

@Stateless
@LocalBean
public class URLBean extends AbstractFacade<URL> {

	@PersistenceContext(unitName = "persistence")
	EntityManager em;

	public URLBean() {
		super(URL.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public URL findByKey(Integer keyval) {
		URL url = null;
		try {
			url = em.createNamedQuery("URL.findByKey", URL.class)
					.setParameter("keyval", keyval).getSingleResult();
		} catch (PersistenceException e) {
			// TODO LOG
		}
		return url;
	}

	
}
