package com.battleejb.ejbbeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.battleejb.entities.Text;

/**
 * @author rtkachuk
 * 
 */
@Stateless
@LocalBean
public class TextBean extends AbstractFacade<Text> {

	@PersistenceContext(unitName = "persistence")
	EntityManager em;

	public TextBean() {
		super(Text.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public Text findByKey(Integer keyval) {
		Text text = null;
		try {
			text = em.createNamedQuery("Text.findByKey", Text.class)
					.setParameter("keyval", keyval).getSingleResult();
		} catch (PersistenceException e) {
			// TODO LOG
		}
		return text;
	}
}
