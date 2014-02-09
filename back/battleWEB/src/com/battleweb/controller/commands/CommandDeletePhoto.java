package com.battleweb.controller.commands;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleejb.ejbbeans.PhotoBean;
import com.battleweb.controller.Constants;
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
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		JsonObject jsonObjectRequest = toolJSON.getJsonObjectRequest(request);
		
		int photoId = jsonObjectRequest.getInt(Constants.PARAMETER_PHOTO_ID);
		System.out.println("********************* "+photoId);
		photoBean.remove(photoBean.find(photoId));
		return null;
	}

}
