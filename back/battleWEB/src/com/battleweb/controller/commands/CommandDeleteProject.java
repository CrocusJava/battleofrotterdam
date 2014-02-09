package com.battleweb.controller.commands;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleejb.ejbbeans.ProjectBean;
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
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		JsonObject jsonObjectRequest = toolJSON.getJsonObjectRequest(request);
		
		int projectId = jsonObjectRequest.getInt(Constants.PARAMETER_PROJECT_ID);
		projectBean.remove(projectBean.find(projectId));
		Log.debug(this, "Project id="+projectId+" was deleted");
		return null;
	}

}
