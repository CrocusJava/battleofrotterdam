package com.battleweb.beans;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.battleejb.ejbbeans.ProjectBean;
import com.battleejb.entities.Project;

/**
 * 
 * @author Lukashchuk Ivan
 * 
 */
@ManagedBean
@SessionScoped
public class ProjectsBean {

	@EJB
	private ProjectBean projectBean;

	private LazyDataModel<Project> dataModel;

	@PostConstruct
	private void init() {
		dataModel = new LazyDataModel<Project>() {

			private static final long serialVersionUID = 1L;

			@Override
			public List<Project> load(int first, int pageSize,
					String sortField, SortOrder sortOrder,
					Map<String, String> filters) {			
				Date dateFrom = null;
				Date dateTo = null;
				String sort = "asc";
				if (sortOrder.equals(SortOrder.DESCENDING)){
					sort = "desc";
				}
				String orderBy = "date";
				Integer competitionId = null;
				setRowCount((int) projectBean
						.findCountFilterOrderByDateOrRatingLimit(orderBy,
								sort, filters.get("login"), filters.get("name"),
								dateFrom, dateTo, competitionId,
								filters.get("competitionId"), null));
				
				return projectBean.findFilterOrderByDateOrRatingLimit(orderBy,
						sort, filters.get("login"), filters.get("name"),
						dateFrom, dateTo, competitionId,
						filters.get("competitionId"), first, pageSize, null);
			}
		};
	}

	public void changeApprove(Project project){
		project.setApproved(!project.getApproved());
		projectBean.edit(project);
	}
	
	public LazyDataModel<Project> getDataModel() {
		return dataModel;
	}

	public void setDataModel(LazyDataModel<Project> dataModel) {
		this.dataModel = dataModel;
	}

}
