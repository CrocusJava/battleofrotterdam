package com.battleejb.businesslogic;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

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
	//TODO
	public boolean checkExistUser(String login, String password){
//		User user=null;
//		userBean.checkByLogin(login);
//		return 
	}
}
