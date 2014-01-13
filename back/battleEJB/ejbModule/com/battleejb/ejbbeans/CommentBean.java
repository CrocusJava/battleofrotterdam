package com.battleejb.ejbbeans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.battleejb.entities.Comment;

/**
 * @author marina
 * 
 */

@Stateless
@LocalBean
public class CommentBean extends AbstractFacade<Comment> {

	@PersistenceContext(unitName = "persistence")
	EntityManager em;

	public CommentBean() {
		super(Comment.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public List<Comment> findLast(Integer n){
		return em.createNamedQuery("Comment.findLast", Comment.class).setMaxResults(n).getResultList();
	}
	
	public List<Comment> findLimitByProjectId(int projectId,
			int firstPosition, int size) {
		List<Comment> photos = null;
		try {
			photos = em.createNamedQuery("Comment.findByProjectId", Comment.class)
					.setParameter("projectId", projectId)
					.setFirstResult(firstPosition).setMaxResults(size).getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return photos;
	}
	
	public List<Comment> findLimitByPhotoId(int photoId,
			int firstPosition, int size) {
		List<Comment> photos = null;
		try {
			photos = em.createNamedQuery("Comment.findByPhotoId", Comment.class)
					.setParameter("photoId", photoId)
					.setFirstResult(firstPosition).setMaxResults(size).getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return photos;
	}
	
	public long getCountByProjectId(int projectId){
		long count = 0;
		try {
			count = (Long) em.createNamedQuery("Comment.getCountByProjectId")
					.setParameter("projectId", projectId)
					.getSingleResult();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public long getCountByPhotoId(int photoId){
		long count = 0;
		try {
			System.out.println(photoId);
			count = (Long) em.createNamedQuery("Comment.getCountByPhotoId")
					.setParameter("photoId", photoId)
					.getSingleResult();			
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		System.out.println(count);
		return count;
	}

}
