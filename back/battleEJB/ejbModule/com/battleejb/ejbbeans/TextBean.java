package com.battleejb.ejbbeans;

import java.util.Locale;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.battleejb.entities.Text;

/**
 * @author rtkachuk
 * @author Lukashchuk Ivan
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

	public String findLocaleTextByKey(Integer keyval, String locale) {
		String queryName = "User.findEnTextByKey";
		if (locale.equalsIgnoreCase("nl")) {
			queryName = "User.findNlTextByKey";
		}
		return (String) em.createNamedQuery(queryName)
				.setParameter("keyval", keyval).getSingleResult();
	}
}
