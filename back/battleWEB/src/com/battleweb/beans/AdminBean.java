package com.battleweb.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.battleweb.tools.ToolSession;

/**
 * @author marina
 * 
 */

@ManagedBean(name="admin")
@ViewScoped
public class AdminBean {
	
	@EJB
	private ToolSession toolSession;
	
	public void exitAdministration(){
		
	}
}
