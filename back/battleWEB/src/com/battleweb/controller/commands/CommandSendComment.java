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
import javax.json.JsonObjectBuilder;

import com.battleejb.ejbbeans.CommentBean;
import com.battleejb.ejbbeans.PhotoBean;
import com.battleejb.ejbbeans.ProjectBean;
import com.battleejb.ejbbeans.UserBean;
import com.battleejb.entities.Comment;
import com.battleejb.entities.Photo;
import com.battleejb.entities.Project;
import com.battleejb.entities.User;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolJSON;
import com.battleweb.tools.ToolSession;

/**
 * @author Lukashchuk Ivan
 * 
 */
@Stateless
@LocalBean
public class CommandSendComment implements Command {

	@EJB
	private ToolJSON toolJSON;
	@EJB
	private ToolSession toolSession;
	@EJB
	private ProjectBean projectBean;
	@EJB
	private UserBean userBean;
	@EJB
	private PhotoBean photoBean;
	@EJB
	private CommentBean commentBean;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		boolean commentResult = true;

		JsonObjectBuilder jsonObjectResponseBuilder = Json
				.createObjectBuilder();

		User user = toolSession.getUser(request);

		if (user != null) {

			JsonObject jsonObjectRequest = toolJSON
					.getJsonObjectRequest(request);

			Photo photo = null;
			Project project = null;

			int projectId = jsonObjectRequest
					.getInt(Constants.PARAMETER_PROJECT_ID);
			project = projectBean.find(projectId);
			try {
				int photoId = jsonObjectRequest
						.getInt(Constants.PARAMETER_PHOTO_ID);
				photo = photoBean.find(photoId);
			} catch (Exception e) {
			}

			Comment comment = new Comment();
			if ((photo == null || photo.getProject().getId() == projectId)
					&& user.getCommentAble()) {

				comment.setProject(project);
				comment.setPhoto(photo);
				comment.setCommentText(jsonObjectRequest
						.getString(Constants.PARAMETER_COMMENT_TEXT));
				comment.setCommentDate(new Date());
				comment.setUser(userBean.find(Integer.parseInt(request
						.getSession()
						.getAttribute(Constants.PARAMETER_SESSION_IDUSER)
						.toString())));

				commentBean.create(comment);
				jsonObjectResponseBuilder.add(Constants.PARAMETER_COMMENT_ID,
						comment.getId());

			} else {
				commentResult = false;
			}
			
			jsonObjectResponseBuilder.add(Constants.PARAMETER_STATUS,
					commentResult);
		} else {
			jsonObjectResponseBuilder = Json.createObjectBuilder().add(
					Constants.PARAMETER_MESSAGE,
					"Invocation without authorization");
		}

		toolJSON.setJsonObjectResponse(response,
				jsonObjectResponseBuilder.build());

		return null;
	}
}
