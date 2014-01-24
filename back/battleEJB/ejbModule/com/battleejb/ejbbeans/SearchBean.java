package com.battleejb.ejbbeans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.battleejb.entities.Search;

/**
 * @author Lukashchuk Ivan
 * 
 */
@Stateless
@LocalBean
public class SearchBean {

	@PersistenceContext(unitName = "persistence")
	EntityManager em;

	public List<Search> search(String text, int firstPosition, int size) {
		List<Search> projects = null;
		StringBuilder regStr = new StringBuilder();
		regStr.append(">\"").append(text).append("\" <(");
		for (String word : text.split(" ")) {
			regStr.append(word.substring(0, word.length() - 1)).append("* ");
		}
		regStr.append(")");
		try {
			projects = em.createNamedQuery("Search.search", Search.class)
					.setParameter("text", regStr.toString())
					.setFirstResult(firstPosition).setMaxResults(size)
					.getResultList();
		} catch (PersistenceException e) {
			// LOG
		}
		return projects;
	}

}
