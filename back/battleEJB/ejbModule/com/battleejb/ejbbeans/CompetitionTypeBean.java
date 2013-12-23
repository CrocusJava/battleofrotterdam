/**
 * 
 */
package com.battleejb.ejbbeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.battleejb.entities.CompetitionType;

/**
 * @author marina
 *
 */

@Stateless
@LocalBean
public class CompetitionTypeBean extends AbstractFacade<CompetitionType> {

	@PersistenceContext(unitName = "persistence")
	EntityManager em;
	
	public CompetitionTypeBean() {
		super(CompetitionType.class);
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
}
