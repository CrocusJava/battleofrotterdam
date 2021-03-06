package com.battleweb.tools;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.battleejb.entities.User;
import com.battleweb.controller.Constants;
import com.battleweb.logger.Log;

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
		Log.info(this, "Session: "+Constants.PARAMETER_SESSION_IDUSER+"-"+user.getId());
		Log.info(this, "Session: "+Constants.PARAMETER_SESSION_IDROLE+"-"+user.getRole().getId());
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
	
	public ServletContext getServletContext(ServletRequest request){
		HttpSession session = ((HttpServletRequest)request).getSession();
		return session.getServletContext();
	}
	
	public Integer getUserId(ServletRequest request){
		HttpSession session = ((HttpServletRequest)request).getSession();
		Integer userId = (Integer)session.getAttribute(Constants.PARAMETER_SESSION_IDUSER);
		if(userId == null){
			return 0;
		}
		return userId;
	}
	public User getUser(ServletRequest request){
		HttpSession session = ((HttpServletRequest)request).getSession();
		return (User)session.getAttribute(Constants.PARAMETER_SESSION_USER);
	}
	public Integer getRoleId(ServletRequest request){
		HttpSession session = ((HttpServletRequest) request).getSession();
		Integer roleId = (Integer)session.getAttribute(Constants.PARAMETER_SESSION_IDROLE);
		if(roleId == null){
			return 0;
		}
		return roleId;
	}
	public boolean isAdmin(ServletRequest request){
		Integer roleId = getRoleId(request);
		return roleId != null && roleId == 1;
	}
	
	public void updateUser(HttpServletRequest request, User user){
		HttpSession session = ((HttpServletRequest)request).getSession();
		session.removeAttribute(Constants.PARAMETER_SESSION_USER);
		session.setAttribute(Constants.PARAMETER_SESSION_USER, user);
	}
}
