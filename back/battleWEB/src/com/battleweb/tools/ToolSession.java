package com.battleweb.tools;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.battleejb.entities.User;
import com.battleweb.controller.Constants;

/**
 * @author rtkachuk
 *
 */
@Stateless
@LocalBean
public class ToolSession {
	
	//TODO check if user is logined
	public void addUserSession(HttpServletRequest request, User user){
		HttpSession session = request.getSession();
		session.setAttribute(Constants.PARAMETER_SESSION_USER, user);
		session.setAttribute(Constants.PARAMETER_SESSION_IDUSER, user.getId());
		session.setAttribute(Constants.PARAMETER_SESSION_IDROLE, user.getRole().getId());
	}
	
	public void removeUserSession(HttpServletRequest request, User user){
		HttpSession session = request.getSession();
		session.setAttribute(Constants.PARAMETER_SESSION_USER, null);
		session.setAttribute(Constants.PARAMETER_SESSION_IDUSER, 0);
		session.setAttribute(Constants.PARAMETER_SESSION_IDROLE, 0);
	}
	
	public void setUserLocalization(ServletRequest request){
		HttpSession session = ((HttpServletRequest)request).getSession();
		session.setAttribute(Constants.PARAMETER_SESSION_LOCALE, request.getLocale().getLanguage());
	}
	
	public String getUserLocalization(ServletRequest request){
		HttpSession session = ((HttpServletRequest)request).getSession();
		return (String)session.getAttribute(Constants.PARAMETER_SESSION_LOCALE);
	}
}
