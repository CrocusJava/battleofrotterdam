package com.battleejb.ejbbeans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
	public List<Photo> findLast(Integer n){
		return em.createNamedQuery("Photo.findLast", Photo.class).setMaxResults(n).getResultList();
	}
	
}
