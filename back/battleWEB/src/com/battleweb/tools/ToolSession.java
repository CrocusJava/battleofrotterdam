package com.battleweb.tools;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.battleejb.entities.User;

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
		session.setAttribute("idUser", user.getId());
		session.setAttribute("idRole", user.getRole().getId());
	}
	
	public void removeUserSession(HttpServletRequest request, User user){
		HttpSession session = request.getSession();
		session.setAttribute("idUser", 0);
		session.setAttribute("idRole", 0);
	}
}
