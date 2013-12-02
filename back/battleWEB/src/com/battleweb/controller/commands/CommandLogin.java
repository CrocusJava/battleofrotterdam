package com.battleweb.controller.commands;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonString;
import javax.json.JsonValue;
import javax.json.JsonWriter;
import javax.json.JsonValue.ValueType;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleejb.businesslogic.CheckUserExist;
import com.battleejb.entities.User;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolJSON;
import com.battleweb.tools.ToolSession;

import org.glassfish.json.*;

/**
 * 
 * @author rtkachuk
 * 
 */
@Stateless
@LocalBean
public class CommandLogin implements Command {

	@EJB 
	private CheckUserExist checkUserExist;
	@EJB
	private ToolSession toolSession;
	@EJB
	private ToolJSON toolJSON;
	
	private User user;
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		JsonObject jsonObjectRequest=toolJSON.getJsonObjectRequest(request);
		String login=jsonObjectRequest.getString(Constants.PARAMETER_LOGIN);
		String password=jsonObjectRequest.getString(Constants.PARAMETER_PASSWORD);


		if (login!=null && password!=null && login.length()!=0 && password.length()!=0){
			user=checkUserExist.checkExistUserLoginPassword(login, password);	
		}
		
		if (null!=user){
			toolSession.addUserSession(request, user);

			JsonObject jsonObjectResponse=Json.createObjectBuilder()
					.add(Constants.PARAMETER_IDUSER, user.getId())
					.add(Constants.PARAMETER_IDROLE, user.getRole().getId())
					.build();
			
			toolJSON.setJsonObjectResponse(response, jsonObjectResponse);
			
		} else {
			
			JsonObject jsonObjectResponse=Json.createObjectBuilder()
					.add(Constants.PARAMETER_IDUSER, 0)
					.add(Constants.PARAMETER_IDROLE, 0)
					.build();
			
			toolJSON.setJsonObjectResponse(response, jsonObjectResponse);
			
		}
		
		return null;
	}
}
