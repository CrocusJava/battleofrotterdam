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
import com.battleejb.ejbbeans.TextBean;
import com.battleejb.entities.Photo;
import com.battleweb.controller.Constants;
import com.battleweb.logger.Log;
import com.battleweb.tools.ToolCookie;
import com.battleweb.tools.ToolJSON;

/**
 * @author marina
 * 
 */

@Stateless
@LocalBean
public class CommandDeletePhoto implements Command {

	@EJB
	private ToolJSON toolJSON;
	@EJB
	private PhotoBean photoBean;
	@EJB
	private TextBean textBean;
	@EJB
	private ToolCookie toolCookie;
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean deleteResult = false;
		String message="";
		
		JsonObject jsonObjectRequest = toolJSON.getJsonObjectRequest(request);
		
		int photoId = jsonObjectRequest.getInt(Constants.PARAMETER_PHOTO_ID);
		Photo photo = photoBean.find(photoId);
		
		if (photo.getProject().getUser().getId() == request.getSession().getAttribute(Constants.PARAMETER_SESSION_IDUSER)){
			photoBean.remove(photo);
			deleteResult = true;
			Log.debug(this, "Photo id="+photoId+" was deleted");
			message=textBean.findLocaleTextByKey(Constants.TEXT_MESSAGE_DELETE_DATA_SUCCESS,
					toolCookie.getLocaleName(request));
		}else {
			deleteResult = false;
			Log.debug(this, "Access error while deleting Photo id="+photoId);
			message=textBean.findLocaleTextByKey(Constants.TEXT_MESSAGE_ACCESS_ERROR,
					toolCookie.getLocaleName(request));
		}

		JsonObject jsonObjectResponse = Json.createObjectBuilder()
				.add(Constants.PARAMETER_MESSAGE, message)
				.add(Constants.PARAMETER_STATUS, deleteResult).build();

		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);
		
		
		return null;
	}

}
