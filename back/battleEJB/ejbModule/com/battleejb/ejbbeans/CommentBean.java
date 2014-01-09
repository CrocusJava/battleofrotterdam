package com.battleejb.ejbbeans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
//		return em.createNamedQuery("Comment.findLast", Comment.class).setParameter("n", n).getResultList();
		return  em.createNamedQuery("Comment.findLast", Comment.class).getResultList();
		
	}

}
