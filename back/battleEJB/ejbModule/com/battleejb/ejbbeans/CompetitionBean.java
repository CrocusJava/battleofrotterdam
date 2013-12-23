/**
 * 
 */
package com.battleejb.ejbbeans;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.battleejb.entities.Competition;
import com.battleejb.entities.CompetitionType;

/**
 * @author marina
 *
 */

@Stateless
@LocalBean
public class CompetitionBean extends AbstractFacade<Competition> {

	@PersistenceContext(unitName = "persistence")
	EntityManager em;
	
	public CompetitionBean() {
		super(Competition.class);
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public Competition getCurrentCompetitionByType(CompetitionType type, Date currentDate){
		Competition competition = null;
		try {
			competition = em.createNamedQuery("Competition.findCurrentYearCompetition", Competition.class)
					.setParameter("type", type)
					.setParameter("currentDate", currentDate)
					.getSingleResult();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return competition;
	}
}
