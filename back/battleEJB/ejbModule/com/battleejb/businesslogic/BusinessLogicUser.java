package com.battleejb.businesslogic;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;

import com.battleejb.ejbbeans.UserBean;
import com.battleejb.entities.User;

/**
 * @author rtkachuk
 *
 */
@Stateless
@LocalBean
public class BusinessLogicUser {
	
	@EJB
	private UserBean userBean;

	public User checkExistUserLoginPassword(String login, String password){
		User user=userBean.checkByLogin(login);
		if (null!=user && !user.getPassword().equals(password)){
			return null;
		}
		return user;
	}
}
