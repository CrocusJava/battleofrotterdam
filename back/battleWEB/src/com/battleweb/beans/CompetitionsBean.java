package com.battleweb.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.battleejb.ejbbeans.CompetitionBean;
import com.battleejb.ejbbeans.CompetitionTypeBean;
import com.battleejb.entities.Competition;
import com.battleejb.entities.CompetitionType;

/**
 * 
 * @author Lukashchuk Ivan
 * 
 */
@ManagedBean
@SessionScoped
@FacesConverter("userConvertor")
public class CompetitionsBean implements Converter{

	@EJB
	private CompetitionBean competitionBean;
	@EJB
	private CompetitionTypeBean competitionTypeBean;

	private LazyDataModel<Competition> dataModel;

	private Competition competition = new Competition();
	
	private List<CompetitionType> competitionTypes;
	
	@PostConstruct
	private void init() {
		dataModel = new LazyDataModel<Competition>() {

			private static final long serialVersionUID = 1L;

			@Override
			public List<Competition> load(int first, int pageSize,
					String sortField, SortOrder sortOrder,
					Map<String, String> filters) {
				String name = filters.get("name");
				Date startDateFrom = null;
				Date startDateTo = null;
				Date endDateFrom = null;
				Date endDateTo = null;
				Date regDeadlineFrom = null;
				Date regDeadlineTo = null;
				Integer id = null;
				Integer winnerId = null;
				String sort = "asc";
				String type = null;
				if (sortOrder.equals(SortOrder.DESCENDING)) {
					sort = "desc";
				}
				String orderBy = "startdate";
				if (sortField != null) {
					orderBy = sortField;
				}
				Integer competitionId = null;
				setRowCount((int) competitionBean
						.findCountFilterOrderByDateLimit(orderBy, name, sort,
								startDateFrom, startDateTo, endDateFrom,
								endDateTo, regDeadlineFrom, regDeadlineTo,
								competitionId, winnerId, type));

				return competitionBean.findFilterOrderByDateLimit(orderBy,
						name, sort, startDateFrom, startDateTo, endDateFrom,
						endDateTo, regDeadlineFrom, regDeadlineTo, id,
						winnerId, type, first, pageSize);
			}
		};
		competitionTypes = new ArrayList<CompetitionType>();
		competitionTypes.add(competitionTypeBean.findByName("year"));
		competitionTypes.add(competitionTypeBean.findByName("month"));
	}
		
	public void edit(){
		System.out.println(competition);
		competitionBean.edit(competition);
	}
	
	public LazyDataModel<Competition> getDataModel() {
		return dataModel;
	}

	public void setDataModel(LazyDataModel<Competition> dataModel) {
		this.dataModel = dataModel;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}
	
	

	public List<CompetitionType> getCompetitionTypes() {
		return competitionTypes;
	}

	public void setCompetitionTypes(List<CompetitionType> competitionTypes) {
		this.competitionTypes = competitionTypes;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {		
		return competitionTypeBean.findByName(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		return ((CompetitionType) value).getName();
	}

}
