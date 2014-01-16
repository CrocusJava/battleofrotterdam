package com.battleejb.ejbbeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.battleejb.entities.Project;
import com.battleejb.entities.User;
import com.battleejb.entities.Voice;

/**
 * @author Lukashchuk Ivan
 * 
 */
@Stateless
@LocalBean
public class VoiceBean extends AbstractFacade<Voice> {

	@PersistenceContext(unitName = "persistence")
	EntityManager em;

	public VoiceBean() {
		super(Voice.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public long getCountByProject(Project project) {
		return getCountByProjectId(project.getId());
	}

	public long getCountByProjectId(int projectId) {
		long count = 0;
		try {
			count = (Long) em.createNamedQuery("Voice.getCountByProjectId")
					.setParameter("projectId", projectId).getSingleResult();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return count;
	}

	public long getRatingByProjectId(int projectId) {
		return getCountByProjectId(projectId);
	}

	public long getRatingByProject(Project project) {
		return getRatingByProjectId(project.getId());
	}

	public Voice findByProjecAndUser(Project project, User user) {
		Voice voice = null;
		try {
			voice = em
					.createNamedQuery("Voice.findByProjectAndUser", Voice.class)
					.setParameter("project", project)
					.setParameter("user", user).getSingleResult();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return voice;
	}

}
