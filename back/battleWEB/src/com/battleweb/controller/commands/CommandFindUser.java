package com.battleweb.controller.commands;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.battleejb.ejbbeans.UserBean;
import com.battleejb.ejbbeans.VoiceBean;
import com.battleejb.entities.Competition;
import com.battleejb.entities.CompetitionType;
import com.battleejb.entities.Photo;
import com.battleejb.entities.Project;
import com.battleejb.entities.User;
import com.battleweb.controller.Constants;
import com.battleweb.logger.Log;
import com.battleweb.tools.ToolJSON;

/**
 * @author Lukashchuk Ivan
 * 
 */
@Stateless
@LocalBean
public class CommandFindUser implements Command {

	@EJB
	private ToolJSON toolJSON;
	@EJB
	private UserBean userBean;	

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		JsonObjectBuilder jsonObjectResponseBuilder = Json
				.createObjectBuilder();

		Integer roleId = (Integer) request.getSession().getAttribute(
				Constants.PARAMETER_SESSION_IDROLE);
		if (roleId != null && roleId == 1) {

			JsonObject jsonObjectRequest = toolJSON
					.getJsonObjectRequest(request);
			String login = jsonObjectRequest
					.getString(Constants.PARAMETER_LOGIN);			

			User user = userBean.checkByLogin(login);
			
				JsonObjectBuilder jsonUserBuilder = Json
						.createObjectBuilder()
						.add(Constants.PARAMETER_IDUSER, user.getId())
						.add(Constants.PARAMETER_USER_LOGIN, user.getLogin())
						.add(Constants.PARAMETER_EMAIL, user.getEmail())
						.add(Constants.PARAMETER_FIRSTNAME, user.getFirstname())
						.add(Constants.PARAMETER_MISSLENAME,
								user.getMiddlename())
						.add(Constants.PARAMETER_LASTNAME, user.getLastname())
						.add(Constants.PARAMETER_STATUS, user.getCommentAble())
						.add(Constants.PARAMETER_ACTIVE, user.getActive())
						.add(Constants.PARAMETER_ROLE, user.getRole().getName());
						
			
			jsonObjectResponseBuilder.add(Constants.PARAMETER_USER,
					jsonUserBuilder.build());

		} else {
			Log.error(this, "Command invoked not by admin");
			jsonObjectResponseBuilder.add(Constants.PARAMETER_ERROR_MESSAGE,
					"Command invoked not by admin");
		}

		toolJSON.setJsonObjectResponse(response,
				jsonObjectResponseBuilder.build());

		return null;

	}
}
