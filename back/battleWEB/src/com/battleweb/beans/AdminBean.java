package com.battleweb.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.battleweb.tools.ToolSession;

/**
 * @author marina
 * 
 */

@ManagedBean(name="admin")
@SessionScoped
public class AdminBean {
	
	@EJB
	private ToolSession toolSession;
	
	public String exitAdministration(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		session.invalidate();
		return "administration";
	}
}
