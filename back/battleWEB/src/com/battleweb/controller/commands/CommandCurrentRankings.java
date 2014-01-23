package com.battleweb.controller.commands;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.servlet.ServletException;
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
import com.battleejb.ejbbeans.VoiceBean;
import com.battleejb.entities.Photo;
import com.battleejb.entities.Project;
import com.battleejb.entities.User;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolJSON;

/**
 * @author Lukashchuk Ivan
 * 
 */
@Stateless
@LocalBean
public class CommandCurrentRankings implements Command {

	@EJB
	private ToolJSON toolJSON;
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

	private SimpleDateFormat dateFormat = new SimpleDateFormat(
			"dd MMMM yyyy HH:mm", Locale.ENGLISH);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		JsonObjectBuilder jsonObjectResponseBuilder = Json
				.createObjectBuilder();

		addToJsonObjThreeProjects(jsonObjectResponseBuilder,
				Constants.COMPETITION_TYPE_YEAR, request);
		addToJsonObjThreeProjects(jsonObjectResponseBuilder,
				Constants.COMPETITION_TYPE_MONTH, request);

		toolJSON.setJsonObjectResponse(response,
				jsonObjectResponseBuilder.build());

		return null;
	}

	private void addToJsonObjThreeProjects(
			JsonObjectBuilder jsonObjectResponseBuilder,
			String competitionType, HttpServletRequest request) {

		List<Project> projects = null;
		projects = projectBean.findFilterOrderByDateOrRatingLimit("rating",
				"desc", null, null, null, null, null, competitionType, 0, 3,
				null);
		JsonArrayBuilder jsonProjects = Json.createArrayBuilder();
		for (Project project : projects) {

			User user = project.getUser();
			JsonObject jsonUser = Json.createObjectBuilder()
					.add(Constants.PARAMETER_ID, user.getId())
					.add(Constants.PARAMETER_LOGIN, user.getLogin())
					.add(Constants.PARAMETER_AVATAR_PATH, user.getPhotoPath())
					.build();

			JsonObjectBuilder jsonLustPhotoBuilder = Json.createObjectBuilder();
			List<Photo> photos = photoBean.findLimitByProjectId(
					project.getId(), 0, 1);
			if (photos.size() > 0) {			
				Photo photo = photos.get(0);
				jsonLustPhotoBuilder
						.add(Constants.PARAMETER_ID, photo.getId())
						.add(Constants.PARAMETER_PATH, photo.getPath())
						.add(Constants.PARAMETER_DESCRIPTION,
								photo.getDescription());
			}

			JsonObjectBuilder jsonProjectBuilder = Json
					.createObjectBuilder()
					.add(Constants.PARAMETER_ID, project.getId())
					.add(Constants.PARAMETER_NAME, project.getName())
					.add(Constants.PARAMETER_CREATION_DATE,
							dateFormat.format(project.getCreationDate()))
					.add(Constants.PARAMETER_RATING,
							voiceBean.getRatingByProject(project))
					.add(Constants.PARAMETER_COMMENT_QUANTITY,
							commentBean.getCountByProjectId(project.getId()))
					.add(Constants.PARAMETER_USER, jsonUser)
					.add(Constants.PARAMETER_LAST_PHOTO,
							jsonLustPhotoBuilder.build());

			jsonProjects.add(jsonProjectBuilder.build());
		}
		jsonObjectResponseBuilder.add(competitionType
				+ Constants.PARAMETER_PROJECTS, jsonProjects.build());
	}
}
