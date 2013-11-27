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
public class CheckUserExist {
	
	@EJB
	private UserBean userBean;
	
	//TODO Added support session
	public User checkExistUserLoginPassword(String login, String password){
		User user=null;
		try {
			user=userBean.checkByLogin(login);
		} catch (NoResultException e) {
			return null;
		} 
		if (!user.getPassword().equals(password)){
			return null;
		}
		return user;
	}
}
