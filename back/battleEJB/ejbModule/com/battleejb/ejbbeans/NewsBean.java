package com.battleejb.ejbbeans;

import java.util.Locale;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.battleejb.entities.News;
import com.battleejb.entities.Text;


/**
 * @author marina
 * 
 */
@Stateless
@LocalBean
public class NewsBean  extends AbstractFacade<News> {

	@PersistenceContext(unitName = "persistence")
	EntityManager em;
	
	public NewsBean() {
		super(News.class);
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public News findByKey(Integer keyval) {
		News news = null;
		try {
			news = em.createNamedQuery("News.findByKey", News.class)
					.setParameter("keyval", keyval).getSingleResult();
		} catch (PersistenceException e) {
			// TODO LOG
		}
		return news;
	}

	public String findLocaleTextByKey(Integer keyval, Locale locale) {
		String loc = locale.toString();
		String queryName = "User.findEnNewsByKey";
		if (loc.equalsIgnoreCase("nl")) {
			queryName = "User.findNlNewsByKey";
		}
		return (String) em.createNamedQuery(queryName)
				.setParameter("keyval", keyval).getSingleResult();
	}
}
