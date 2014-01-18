/**
 * 
 */
package com.battleejb.ejbbeans;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.battleejb.entities.Competition;
import com.battleejb.entities.CompetitionType;
import com.battleejb.entities.CompetitionType_;
import com.battleejb.entities.Competition_;
import com.battleejb.entities.Project;
import com.battleejb.entities.Project_;
import com.battleejb.entities.User_;

/**
 * @author marina
 * 
 */

@Stateless
@LocalBean
public class CompetitionBean extends AbstractFacade<Competition> {

	private static final String SORT_TYPE_ASC = "asc";
	private static final String SORT_TYPE_DESC = "desc";
	private static final String ORDER_BY_START_DATE = "startdate";
	private static final String ORDER_BY_END_DATE = "enddate";
	private static final String ORDER_BY_REG_DEADLINE = "regdeadline";

	@PersistenceContext(unitName = "persistence")
	EntityManager em;

	public CompetitionBean() {
		super(Competition.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public Competition getCurrentCompetitionByType(CompetitionType type,
			Date currentDate) {
		Competition competition = null;
		try {
			competition = em
					.createNamedQuery(
							"Competition.findCurrentCompetitionByType",
							Competition.class).setParameter("type", type)
					.setParameter("currentDate", currentDate).getSingleResult();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return competition;
	}

	public Competition getCurrentCompetitionByType(String type) {
		Competition competition = null;
		try {
			competition = em
					.createNamedQuery(
							"Competition.findCurrentCompetitionByTypeName",
							Competition.class).setParameter("type", type)
					.getSingleResult();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return competition;
	}

	public List<Competition> findFilterOrderByDateLimit(String orderBy,
			String sort, Date startDateFrom, Date startDateTo,
			Date endDateFrom, Date endDateTo, Date regDeadlineFrom,
			Date regDeadlineTo, Integer id, Integer winnerId, String type,
			int firstPosition, int size) {
		List<Competition> competitions = null;
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Competition> cq = cb.createQuery(Competition.class);
			Root<Competition> p = cq.from(Competition.class);

			Predicate predicate = null;

			if (startDateFrom != null) {
				predicate = cb.and(predicate, cb.greaterThanOrEqualTo(
						p.get(Competition_.dateStart), startDateFrom));
			}
			if (startDateTo != null) {
				predicate = cb.and(predicate, cb.lessThanOrEqualTo(
						p.get(Competition_.dateStart), startDateTo));
			}
			if (endDateFrom != null) {
				predicate = cb.and(predicate, cb.greaterThanOrEqualTo(
						p.get(Competition_.dateEnd), endDateFrom));
			}
			if (endDateTo != null) {
				predicate = cb.and(predicate, cb.lessThanOrEqualTo(
						p.get(Competition_.dateEnd), endDateTo));
			}
			if (regDeadlineFrom != null) {
				predicate = cb.and(predicate, cb.greaterThanOrEqualTo(
						p.get(Competition_.registerDeadline), regDeadlineFrom));
			}
			if (regDeadlineTo != null) {
				predicate = cb.and(predicate, cb.lessThanOrEqualTo(
						p.get(Competition_.registerDeadline), regDeadlineTo));
			}
			if (id != null) {
				predicate = cb.and(predicate,
						cb.equal(p.get(Competition_.id), id));
			}
			if (type != null) {
				predicate = cb.and(
						predicate,
						cb.equal(
								p.get(Competition_.type).get(
										CompetitionType_.name), type));
			}
			if (winnerId != null) {
				predicate = cb.and(predicate, cb.equal(p.get(Competition_.user)
						.get(User_.id), winnerId));
			}
			if (predicate != null) {
				cq.where(predicate);
			}

			Expression<?> ex = null;
			if (orderBy.equals(ORDER_BY_START_DATE)) {
				ex = p.get(Competition_.dateStart);
			} else if (orderBy.equals(ORDER_BY_END_DATE)) {
				ex = p.get(Competition_.dateEnd);
			} else if (orderBy.equals(ORDER_BY_REG_DEADLINE)) {
				ex = p.get(Competition_.registerDeadline);
			}

			Order order = null;
			if (sort.equals(SORT_TYPE_ASC)) {
				order = cb.asc(ex);
			} else {
				order = cb.desc(ex);
			}
			cq.orderBy(order);
			competitions = em.createQuery(cq).setFirstResult(firstPosition)
					.setMaxResults(size).getResultList();

		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return competitions;
	}
}
