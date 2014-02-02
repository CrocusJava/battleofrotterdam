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

import com.battleejb.ejbbeans.PhotoBean;
import com.battleejb.entities.Photo;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolJSON;
import com.battleweb.tools.ToolSession;

/**
 * @author Lukashchuk Ivan
 * 
 */
@Stateless
@LocalBean
public class CommandEditPhotoDescription implements Command {

	@EJB
	private ToolJSON toolJSON;
	@EJB
	private ToolSession toolSession;
	@EJB
	private PhotoBean photoBean;
	
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		boolean status = true;

		JsonObject jsonObjectRequest = toolJSON.getJsonObjectRequest(request);

		int id = jsonObjectRequest
				.getInt(Constants.PARAMETER_ID);
		String description = jsonObjectRequest
				.getString(Constants.PARAMETER_DESCRIPTION);

		Photo photo = photoBean.find(id);
		if (photo != null && photo.getProject().getUser().getId() == toolSession.getUserId(request)) {
			photo.setDescription(description);;
			photoBean.edit(photo);
			
		} else {
			status = false;
		}

		JsonObject jsonObjectResponse = Json.createObjectBuilder()
				.add(Constants.PARAMETER_STATUS, status).build();

		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);

		return null;
		
	}
}
