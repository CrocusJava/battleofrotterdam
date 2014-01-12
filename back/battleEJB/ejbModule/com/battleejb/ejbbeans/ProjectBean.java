package com.battleejb.ejbbeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
