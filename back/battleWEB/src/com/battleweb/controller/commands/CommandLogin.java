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

import com.battleejb.businesslogic.BusinessLogicUser;
import com.battleejb.entities.User;
import com.battleweb.controller.Constants;
import com.battleweb.logger.Log;
import com.battleweb.tools.ToolJSON;
import com.battleweb.tools.ToolMD5;
import com.battleweb.tools.ToolSession;

/**
 * 
 * @author rtkachuk
 * 
 */
@Stateless
@LocalBean
public class CommandLogin implements Command {

	@EJB 
	private BusinessLogicUser businessLogicUser;
	@EJB
	private ToolSession toolSession;
	@EJB
	private ToolJSON toolJSON;
	@EJB
	private ToolMD5 toolMD5;
	
	private User user;
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		JsonObject jsonObjectRequest=toolJSON.getJsonObjectRequest(request);
		String login=jsonObjectRequest.getString(Constants.PARAMETER_LOGIN);
		String password=toolMD5.generateMD5(jsonObjectRequest.getString(Constants.PARAMETER_PASSWORD));


		if (login!=null && password!=null && login.length()!=0 && password.length()!=0){
			user=businessLogicUser.checkExistUserLoginPassword(login, password);	
		}
		
		if (null!=user){
			Log.debug(this, "User exist in database");
			
			toolSession.addUserSession(request, user);

			JsonObject jsonObjectResponse=Json.createObjectBuilder()
					.add(Constants.PARAMETER_IDUSER, user.getId())
					.add(Constants.PARAMETER_IDROLE, user.getRole().getId())
					.build();
			
			toolJSON.setJsonObjectResponse(response, jsonObjectResponse);
			
		} else {
			Log.debug(this, "User is not exist in database");
			JsonObject jsonObjectResponse=Json.createObjectBuilder()
					.add(Constants.PARAMETER_IDUSER, 0)
					.add(Constants.PARAMETER_IDROLE, 0)
					.build();
			
			toolJSON.setJsonObjectResponse(response, jsonObjectResponse);
			
		}
		Log.debug(this, "NO redirects!");
		return null;
	}
}
