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

import com.battleejb.ejbbeans.ProjectBean;
import com.battleejb.ejbbeans.TextBean;
import com.battleejb.entities.Project;
import com.battleweb.controller.Constants;
import com.battleweb.logger.Log;
import com.battleweb.tools.ToolJSON;

/**
 * @author marina
 * 
 */

@Stateless
@LocalBean
public class CommandDeleteProject implements Command {

	@EJB
	private ToolJSON toolJSON;
	@EJB
	private ProjectBean projectBean;
	@EJB
	private TextBean textBean;
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean deleteResult = false;
		String message="";
		
		JsonObject jsonObjectRequest = toolJSON.getJsonObjectRequest(request);
		
		int projectId = jsonObjectRequest.getInt(Constants.PARAMETER_PROJECT_ID);
		Project project = projectBean.find(projectId);
		
		if (project.getUser().getId() == request.getSession().getAttribute(Constants.PARAMETER_SESSION_IDUSER)){
			projectBean.remove(project);
			deleteResult = true;
			Log.debug(this, "Project id="+projectId+" was deleted");
			message=textBean.findLocaleTextByKey(Constants.TEXT_MESSAGE_DELETE_DATA_SUCCESS,
					request.getLocale());
		}else {
			deleteResult = false;
			Log.debug(this, "Access error while deleting Project id="+projectId);
			message=textBean.findLocaleTextByKey(Constants.TEXT_MESSAGE_ACCESS_ERROR,
					request.getLocale());
		}

		JsonObject jsonObjectResponse = Json.createObjectBuilder()
				.add(Constants.PARAMETER_MESSAGE, message)
				.add(Constants.PARAMETER_STATUS, deleteResult).build();

		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);
		return null;
	}

}
