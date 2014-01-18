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

import com.battleejb.ejbbeans.CommentBean;
import com.battleejb.ejbbeans.PhotoBean;
import com.battleejb.ejbbeans.ProjectBean;
import com.battleejb.ejbbeans.UserBean;
import com.battleejb.ejbbeans.VoiceBean;
import com.battleejb.entities.Comment;
import com.battleejb.entities.Photo;
import com.battleejb.entities.Project;
import com.battleejb.entities.Voice;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolJSON;

/**
 * @author Lukashchuk Ivan
 * 
 */
@Stateless
@LocalBean
public class CommandEditComment implements Command {

	@EJB
	private ToolJSON toolJSON;
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

		JsonObject jsonObjectRequest = toolJSON.getJsonObjectRequest(request);

		int commentId = jsonObjectRequest
				.getInt(Constants.PARAMETER_COMMENT_ID);
		String commentText = jsonObjectRequest
				.getString(Constants.PARAMETER_COMMENT_TEXT);

		Comment comment = commentBean.find(commentId);
		if (comment.getUser().getId() == request.getSession().getAttribute(
				Constants.PARAMETER_SESSION_IDUSER)) {
			comment.setCommentText(commentText);
			commentBean.edit(comment);
			
		} else {
			commentResult = false;
		}

		JsonObject jsonObjectResponse = Json.createObjectBuilder()
				.add(Constants.PARAMETER_COMMENT_ID, comment.getId())
				.add(Constants.PARAMETER_VOTE_RESULT, commentResult).build();

		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);

		return null;
	}
}
