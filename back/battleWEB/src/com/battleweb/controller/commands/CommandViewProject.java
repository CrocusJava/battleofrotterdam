package com.battleweb.controller.commands;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import com.battleejb.ejbbeans.CommentBean;
import com.battleejb.ejbbeans.PhotoBean;
import com.battleejb.ejbbeans.ProjectBean;
import com.battleejb.entities.Competition;
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
public class CommandViewProject implements Command {

	@EJB
	private ToolJSON toolJSON;
	@EJB
	private ProjectBean projectBean;
	@EJB
	private CommentBean commentBean;
	@EJB
	private PhotoBean photoBean;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		JsonObject jsonObjectRequest = toolJSON.getJsonObjectRequest(request);
		int projectId = jsonObjectRequest
				.getInt(Constants.PARAMETER_PROJECT_ID);

		Project project = projectBean.find(projectId);
		
		User user = project.getUser();
		Competition competition = project.getCompetition();
		System.out.println(competition);
		List<Photo> photos = project.getPhotos();
		int rating = 0; 								//discussed!!!

		JsonObject jsonCompetition = Json.createObjectBuilder()
				.add(Constants.PARAMETER_ID, competition.getId())
				.add(Constants.PARAMETER_TYPE, competition.getType().getName())
				.add(Constants.PARAMETER_NAME, competition.getName()).build();
		
		JsonObject jsonUser = Json.createObjectBuilder()
				.add(Constants.PARAMETER_ID, user.getId())
				.add(Constants.PARAMETER_FIRSTNAME, user.getFirstname())
				.add(Constants.PARAMETER_MISSLENAME, user.getMiddlename())
				.add(Constants.PARAMETER_LOGIN, user.getLogin())
				.add(Constants.PARAMETER_AVATAR_PATH, user.getPhotoPath())
				.add(Constants.PARAMETER_LASTNAME, user.getLastname()).build();
		
		JsonObjectBuilder jsonObjectBuilder = Json
				.createObjectBuilder()
				.add(Constants.PARAMETER_NAME, project.getName())
				.add(Constants.PARAMETER_CREATION_DATE, project.getCreationDate().toString())
				.add(Constants.PARAMETER_DESCRIPTION, project.getDescription())
				.add(Constants.PARAMETER_COMPETITION, jsonCompetition)
				.add(Constants.PARAMETER_RATING, rating)
				.add(Constants.PARAMETER_VOTES_QUANTITY, project.getVoices().size())
				.add(Constants.PARAMETER_COMMENT_QUANTITY, commentBean.getCountByProjectId(projectId))
				.add(Constants.PARAMETER_PHOTO_QUANTITY, photoBean.getCountByProjectId(projectId));

		int size = photos.size();
		JsonObject jsonFirstPhoto = null;
		JsonObject jsonLastPhoto = null;
		if (size != 0) {
			Photo firstPhoto = photos.get(0);
			jsonFirstPhoto = Json
					.createObjectBuilder()
					.add(Constants.PARAMETER_ID, firstPhoto.getId())
					.add(Constants.PARAMETER_PATH, firstPhoto.getPath())
					.add(Constants.PARAMETER_DESCRIPTION,
							firstPhoto.getDescription()).build();
			jsonObjectBuilder.add(Constants.PARAMETER_FIRST_PHOTO, jsonFirstPhoto);

			if (size > 1) {
				Photo lastPhoto = photos.get(size - 1);
				jsonLastPhoto = Json
						.createObjectBuilder()
						.add(Constants.PARAMETER_ID, lastPhoto.getId())
						.add(Constants.PARAMETER_PATH, lastPhoto.getPath())
						.add(Constants.PARAMETER_DESCRIPTION,
								lastPhoto.getDescription()).build();
				jsonObjectBuilder.add(Constants.PARAMETER_LAST_PHOTO, jsonLastPhoto);
			}
		}

		toolJSON.setJsonObjectResponse(response, jsonObjectBuilder.build());

		return null;
	}
}
