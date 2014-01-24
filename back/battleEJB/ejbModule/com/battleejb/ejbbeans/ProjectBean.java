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

import com.battleejb.entities.CompetitionType_;
import com.battleejb.entities.Competition_;
import com.battleejb.entities.Project;
import com.battleejb.entities.Project_;
import com.battleejb.entities.User;
import com.battleejb.entities.User_;

/**
 * @author Lukashchuk Ivan
 * 
 */
@Stateless
@LocalBean
public class ProjectBean extends AbstractFacade<Project> {

	private static final String SORT_TYPE_ASC = "asc";
	private static final String PARAMETER_DATE = "date";
	private static final String PARAMETER_RATING = "rating";

	@PersistenceContext(unitName = "persistence")
	EntityManager em;

	public ProjectBean() {
		super(Project.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public List<Project> findLimitApprovedByCompetitionIdAndOrderByRating(
			int competitionId, int firstPosition, int size) {
		List<Project> projects = null;
		try {
			projects = em
					.createNamedQuery(
							"Project.findApprovedByCompetitionIdAndOrderByRating",
							Project.class)
					.setParameter("competitionId", competitionId)
					.setParameter("firstPosition", firstPosition)
					.setParameter("size", size).getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return projects;
	}

	public List<Project> findFilterOrderByDateOrRatingLimit(String orderBy,
			String sort, String login, String name, Date dateFrom, Date dateTo,
			Integer competitionId, String competitionType, int firstPosition,
			int size, Boolean approved) {
		List<Project> projects = null;
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Project> cq = cb.createQuery(Project.class);
			Root<Project> p = cq.from(Project.class);
			Predicate predicate = cb.and(cb.equal(p.get(Project_.user).get(User_.active), true));
			if (approved != null) {
				predicate = cb
						.and(predicate ,cb.equal(p.get(Project_.approved), approved));
			}
			if (login != null) {
				predicate = cb.and(
						predicate,
						cb.like(p.get(Project_.user).get(User_.login), login
								+ "%"));
			}
			if (name != null) {
				predicate = cb.and(cb.like(p.get(Project_.name), "%" + name
						+ "%"));
			}
			if (dateFrom != null) {
				predicate = cb.and(predicate, cb.greaterThanOrEqualTo(
						p.get(Project_.creationDate), dateFrom));
			}
			if (dateTo != null) {
				predicate = cb.and(predicate, cb.lessThanOrEqualTo(
						p.get(Project_.creationDate), dateTo));
			}
			if (competitionId != null) {
				predicate = cb.and(predicate, cb.equal(
						p.get(Project_.competition).get(Competition_.id),
						competitionId));
			}
			if (competitionType != null) {
				predicate = cb.and(predicate, cb.equal(
						p.get(Project_.competition).get(Competition_.type)
								.get(CompetitionType_.name), competitionType));
			}

			cq.where(predicate);
			Expression<?> ex = null;
			if (orderBy.equals(PARAMETER_DATE)) {
				ex = p.get(Project_.creationDate);
			} else if (orderBy.equals(PARAMETER_RATING)) {
				ex = cb.size(p.get(Project_.voices));
			}

			Order order = null;
			if (sort.equals(SORT_TYPE_ASC)) {
				order = cb.asc(ex);
			} else {
				order = cb.desc(ex);
			}
			cq.orderBy(order);
			projects = em.createQuery(cq).setFirstResult(firstPosition)
					.setMaxResults(size).getResultList();

		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return projects;
	}
	
	public List<Project> findProjectsByUser(User user){
		List<Project> listProjects=null;
		 try {
			 listProjects=em.createNamedQuery("Project.findProjectsByUser", Project.class)
				.setParameter("user", user).getResultList();
		 } catch (PersistenceException e) {
             /* LOG */
		 }
     return listProjects;
	}
}
