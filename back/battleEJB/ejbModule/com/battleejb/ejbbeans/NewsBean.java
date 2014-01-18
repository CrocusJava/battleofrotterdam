package com.battleejb.ejbbeans;

import java.util.List;
import java.util.Locale;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.battleejb.entities.News;


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
	
	public List<News> findAll(){
		return em.createNamedQuery("News.findAll",News.class).getResultList();
	}

	public List<News> findLast(Integer n){
		return em.createNamedQuery("News.findAll",News.class).setMaxResults(n).getResultList();
	}
	
	
}