package com.battleejb.ejbbeans;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.battleejb.entities.Project;

/**
 * @author Lukashchuk Ivan
 * 
 */
@Stateless
@LocalBean
public class ProjectBean extends AbstractFacade<Project> {
	
	@PersistenceContext(unitName = "persistence")
	EntityManager em;

	public ProjectBean() {
		super(Project.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}	
	
	public List<Project> findLimitOrderByRatingAndCompetitionType(String competitionType, int firstPosition, int size) {
		List<Project> projects = null;
		try {
			projects = em.createNamedQuery("Project.findOrderByRatingAndCompetitionType", Project.class)
					.setParameter("competitionType", competitionType)
					.setParameter("currentDate", new Date())
					.setFirstResult(firstPosition).setMaxResults(size).getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		System.out.println(projects);
		return projects;
	}
}
