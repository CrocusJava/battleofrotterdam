package com.battleweb.controller.commands;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleejb.entities.User;
import com.battleweb.controller.Constants;
import com.battleweb.logger.Log;
import com.battleweb.tools.ToolJSON;
import com.battleweb.tools.ToolSession;

/**
 * @author rtkachuk
 * 
 */
@Stateless
@LocalBean
public class CommandAccaunt implements Command {

	@EJB
	private ToolJSON toolJSON;
	@EJB
	private ToolSession toolSession;
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		User user=toolSession.getUser(request);
		if (null!=user){
			Log.debug(this, "Get all information about user");
			
			JsonObject jsonObjectResponse=Json.createObjectBuilder()
					.add(Constants.PARAMETER_LOGIN, user.getLogin())
					.add(Constants.PARAMETER_FIRSTNAME, user.getFirstname())
					.add(Constants.PARAMETER_MIDDLENAME, user.getMiddlename())
					.add(Constants.PARAMETER_LASTNAME, user.getLastname())
					.add(Constants.PARAMETER_BIRTHDAY, getDateString(user.getBirthday()))
					.add(Constants.PARAMETER_PHOTO_PATH, user.getPhotoPath())
					.add(Constants.PARAMETER_PHONE, user.getPhone())
					.add(Constants.PARAMETER_EMAIL, user.getEmail())
					.add(Constants.PARAMETER_TOWN, user.getAddress().getTown())
					.add(Constants.PARAMETER_STREET, user.getAddress().getStreet())
					.add(Constants.PARAMETER_HOUSENUMBER, user.getAddress().getHouseNumber())
					.add(Constants.PARAMETER_POSTCODE, user.getAddress().getPostcode())
					.build();
			//TODO Add array projects
			toolJSON.setJsonObjectResponse(response, jsonObjectResponse);
			
		} else {
			Log.debug(this, "User is not exist in session");
		}
		return null;
	}
	
	private String getDateString(Date date){
		SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyy");
		String dateString=format.format(date);
		return dateString;
	}
}
