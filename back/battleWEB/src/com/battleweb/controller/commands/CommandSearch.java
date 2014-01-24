package com.battleweb.controller.commands;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import com.battleejb.ejbbeans.CommentBean;
import com.battleejb.ejbbeans.CompetitionBean;
import com.battleejb.ejbbeans.PhotoBean;
import com.battleejb.ejbbeans.ProjectBean;
import com.battleejb.ejbbeans.SearchBean;
import com.battleejb.ejbbeans.VoiceBean;
import com.battleejb.entities.Search;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolJSON;

/**
 * @author Lukashchuk Ivan
 * 
 */
@Stateless
@LocalBean
public class CommandSearch implements Command {

	@EJB
	private ToolJSON toolJSON;
	@EJB
	private SearchBean searchBean;
	@EJB
	private ProjectBean projectBean;
	@EJB
	private PhotoBean photoBean;
	@EJB
	private CommentBean commentBean;
	@EJB
	private VoiceBean voiceBean;
	@EJB
	private CompetitionBean competitionBean;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		JsonObject jsonObjectRequest = toolJSON.getJsonObjectRequest(request);
		String text = jsonObjectRequest.getString(Constants.PARAMETER_TEXT);
		Integer forstPosition = jsonObjectRequest
				.getInt(Constants.PARAMETER_FIRST_POSITION);
		Integer size = jsonObjectRequest.getInt(Constants.PARAMETER_SIZE);

		List<Search> results = searchBean.search(text, forstPosition, size);

		JsonArrayBuilder jsonSearchArrayBuilder = Json.createArrayBuilder();
		if (results != null) {
			for (Search result : results) {
				JsonObjectBuilder jsonSearchObjectBuilder = Json
						.createObjectBuilder()
						.add(Constants.PARAMETER_TYPE, result.getType())
						.add(Constants.PARAMETER_ID, result.getId())
						.add(Constants.PARAMETER_NAME, result.getName())
						.add(Constants.PARAMETER_DESCRIPTION,
								result.getDescription());
				jsonSearchArrayBuilder.add(jsonSearchObjectBuilder.build());
			}
		}

		JsonObject jsonObjectResponse = Json.createObjectBuilder()
				.add("result", jsonSearchArrayBuilder.build()).build();

		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);

		return null;
	}
}
