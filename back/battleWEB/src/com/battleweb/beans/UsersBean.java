package com.battleweb.beans;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.battleejb.ejbbeans.UserBean;
import com.battleejb.entities.User;

/**
 * 
 * @author Lukashchuk Ivan
 *
 */
@ManagedBean
@ViewScoped
public class UsersBean {

	@EJB
	private UserBean userBean;

	private LazyDataModel<User> dataModel;

	@PostConstruct
	private void init(){
		dataModel = new LazyDataModel<User>() {
			
			private static final long serialVersionUID = 1L;
			
			@Override
			public List<User> load(int first, int pageSize, String sortField,
					SortOrder sortOrder, Map<String, String> filters) {					
				setRowCount((int) userBean.getCountByLogin(filters.get("login")));
				return userBean.findByLoginLimit(filters.get("login"), first, pageSize);
			}
		};
	}
	
	public void changeCommandAble(User user){
		user.setCommentAble(!user.getCommentAble());
		userBean.edit(user);
	}
	
	public void changeActive(User user){
		user.setActive(!user.getActive());
		userBean.edit(user);
	}

	public LazyDataModel<User> getDataModel() {
		return dataModel;
	}

	public void setDataModel(LazyDataModel<User> dataModel) {
		this.dataModel = dataModel;
	}
	
	
}
