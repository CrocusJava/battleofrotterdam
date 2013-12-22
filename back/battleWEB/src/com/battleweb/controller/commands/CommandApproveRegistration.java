package com.battleweb.controller.commands;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleejb.ejbbeans.UserBean;
import com.battleejb.entities.Address;
import com.battleejb.entities.User;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolEmail;
import com.battleweb.tools.ToolJSON;
import com.battleweb.tools.ToolMD5;

/**
 * @author Lukashchuk Ivan
 * 
 */
@Stateless
@LocalBean
public class CommandApproveRegistration implements Command {

	@EJB
	private UserBean userBean;	
	@EJB
	private ToolJSON toolJSON;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String approveRegistrationMessage = "bla bla ����������� ������������";
		
		Integer userId = Integer.parseInt(request.getParameter(Constants.PARAMETER_IDUSER));

		User user = userBean.find(userId);
		user.setApproveregistration(true);
		userBean.edit(user);
		
		JsonObject jsonObjectResponse=Json.createObjectBuilder()
				.add(Constants.PARAMETER_APPROVEREGISTRATIONMESSAGE, approveRegistrationMessage)
				.build();
		
		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);		
			
		return null;
	}
}
