package com.battleweb.controller.commands;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;

import com.battleejb.ejbbeans.ProjectBean;
import com.battleejb.ejbbeans.UserBean;
import com.battleejb.ejbbeans.VoiceBean;
import com.battleejb.entities.Voice;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolJSON;

/**
 * @author Lukashchuk Ivan
 * 
 */
@Stateless
@LocalBean
public class CommandVote implements Command {

	@EJB
	private ToolJSON toolJSON;
	@EJB
	private ProjectBean projectBean;
	@EJB
	private VoiceBean voiceBean;
	@EJB
	private UserBean userBean;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		JsonObject jsonObjectRequest = toolJSON.getJsonObjectRequest(request);
		int projectId = jsonObjectRequest
				.getInt(Constants.PARAMETER_PROJECT_ID);

		boolean voteResult = false;
		if (projectId != 0) {
			Voice voice = new Voice();
			voice.setLevel(1);
			voice.setVoiceDate(new Date());
			voice.setUser(userBean.find(Integer.parseInt(request.getSession()
					.getAttribute(Constants.PARAMETER_SESSION_IDUSER)
					.toString())));
			voice.setProject(projectBean.find(projectId));

			if (voiceBean.findByProjecAndUserId(voice.getProject(), voice
					.getUser().getId()) == null) {
				voiceBean.create(voice);
				voteResult = true;
			}
		}

		JsonObject jsonObjectResponse = Json.createObjectBuilder()
				.add(Constants.PARAMETER_VOTE_RESULT, voteResult).build();

		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);

		return null;
	}
}
