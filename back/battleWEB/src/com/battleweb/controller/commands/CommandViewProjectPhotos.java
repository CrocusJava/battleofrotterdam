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
import com.battleejb.entities.Photo;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolJSON;

/**
 * @author Lukashchuk Ivan
 * 
 */
@Stateless
@LocalBean
public class CommandViewProjectPhotos implements Command {

	@EJB
	private ToolJSON toolJSON;
	@EJB
	private PhotoBean photoBean;
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

		List<Photo> photos = photoBean.findLimitByProjectId(projectId,
				firstPosition, size);
		JsonArrayBuilder jsonPhotos = Json.createArrayBuilder();
		for (Photo photo : photos) {
			JsonObject jsonPhoto = Json
					.createObjectBuilder()
					.add(Constants.PARAMETER_ID, photo.getId())
					.add(Constants.PARAMETER_PHOTO_PATH, photo.getPath())
					.add(Constants.PARAMETER_DATE,
							photo.getLoadDate().toString())
					.add(Constants.PARAMETER_DESCRIPTION,
							photo.getDescription())
					.add(Constants.PARAMETER_COMMENT_QUANTITY,
							commentBean.getCountByPhotoId(photo.getId()))
					.build();
			jsonPhotos.add(jsonPhoto);
		}
		
		JsonObject jsonObjectResponse = Json.createObjectBuilder()
				.add(Constants.PARAMETER_PHOTOS, jsonPhotos.build()).build();

		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);
		
		return null;
	}
}
