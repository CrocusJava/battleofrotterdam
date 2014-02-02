package com.battleweb.beans;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.battleejb.ejbbeans.RoleBean;
import com.battleejb.ejbbeans.UserBean;
import com.battleejb.entities.Role;
import com.battleejb.entities.User;
import com.battleweb.tools.ToolEmail;

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
	@EJB
	private RoleBean roleBean;
	@EJB
	private ToolEmail toolEmail;
	
	private LazyDataModel<User> dataModel;
	
	private User selectedUser = new User();
	
	private String subject;
	private String text;

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
	
	public void closeDialog(){
		RequestContext.getCurrentInstance().closeDialog(null);
	}
	
	public void sendEmail(){
		toolEmail.send(subject, text, selectedUser.getEmail());
	}
	
	public void changeRole(User user){
		Role role = null;
		if (user.getRole().getName().equals("user")){
			role = roleBean.findByName("admin");
		} else {
			role = roleBean.findByName("user");
		}
		user.setRole(role);
		userBean.edit(user);
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

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
		
}
