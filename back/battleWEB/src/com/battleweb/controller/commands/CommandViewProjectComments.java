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
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;

import com.battleejb.ejbbeans.CommentBean;
import com.battleejb.ejbbeans.PhotoBean;
import com.battleejb.entities.Comment;
import com.battleejb.entities.Photo;
import com.battleejb.entities.User;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolJSON;

/**
 * @author Lukashchuk Ivan
 * 
 */
@Stateless
@LocalBean
public class CommandViewProjectComments implements Command {

	@EJB
	private ToolJSON toolJSON;
	@EJB
	private CommentBean commentBean;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		JsonObject jsonObjectRequest = toolJSON.getJsonObjectRequest(request);
		int projectId = jsonObjectRequest
				.getInt(Constants.PARAMETER_PROJECT_ID);
		int firstPosition = jsonObjectRequest
				.getInt(Constants.PARAMETER_FIRST_POSITION);
		int size = jsonObjectRequest.getInt(Constants.PARAMETER_SIZE);

		List<Comment> comments = commentBean.findLimitByProjectId(projectId,
				firstPosition, size);
		JsonArrayBuilder jsonPhotos = Json.createArrayBuilder();
		for (Comment comment : comments) {
			
			User user = comment.getUser();
			JsonObject jsonUser = Json
					.createObjectBuilder()
					.add(Constants.PARAMETER_ID, user.getId())
					.add(Constants.PARAMETER_LOGIN, user.getLogin())
					.add(Constants.PARAMETER_AVATAR_PATH,
							user.getPhotoPath()).build();
			
			JsonObject jsonPhoto = Json
					.createObjectBuilder()
					.add(Constants.PARAMETER_ID, comment.getId())
					.add(Constants.PARAMETER_TEXT, comment.getCommentText())
					.add(Constants.PARAMETER_DATE,
							comment.getCommentDate().toString())
					.add(Constants.PARAMETER_USER, jsonUser).build();
			jsonPhotos.add(jsonPhoto);
		}

		JsonObject jsonObjectResponse = Json.createObjectBuilder()
				.add(Constants.PARAMETER_COMMENTS, jsonPhotos.build()).build();

		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);

		return null;
	}
}
