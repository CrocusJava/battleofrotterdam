package com.battleejb.ejbbeans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.battleejb.entities.Photo;

@Stateless
@LocalBean
public class PhotoBean extends AbstractFacade<Photo> {

	@PersistenceContext(unitName = "persistence")
	EntityManager em;

	public PhotoBean() {
		super(Photo.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public List<Photo> findLast(Integer n) {
		return em.createNamedQuery("Photo.findLast", Photo.class)
				.setMaxResults(n).getResultList();
	}

	public List<Photo> findAll() {
		return em.createNamedQuery("Photo.findAll", Photo.class)
				.getResultList();
	}

	public List<Photo> findLimitByProjectId(int projectId,
			int firstPosition, int size) {
		List<Photo> photos = null;
		try {
			photos = em.createNamedQuery("Photo.findByProjectId", Photo.class)
					.setParameter("projectId", projectId)
					.setFirstResult(firstPosition).setMaxResults(size).getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return photos;
	}
	
	public long getCountByProjectId(int projectId){
		long count = 0;
		try {
			count = (Long) em.createNamedQuery("Photo.getCountByProjectId")
					.setParameter("projectId", projectId)
					.getSingleResult();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return count;
	}

	public long getCount(){
		long count = 0;
		try {
			count = (Long) em.createNamedQuery("Photo.getCount")
					.getSingleResult();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return count;
	}
}
