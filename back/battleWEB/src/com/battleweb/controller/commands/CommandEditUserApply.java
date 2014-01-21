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
import com.battleejb.ejbbeans.RoleBean;
import com.battleejb.ejbbeans.UserBean;
import com.battleejb.ejbbeans.VoiceBean;
import com.battleejb.entities.Competition;
import com.battleejb.entities.CompetitionType;
import com.battleejb.entities.Photo;
import com.battleejb.entities.Project;
import com.battleejb.entities.Role;
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
public class CommandEditUserApply implements Command {

	@EJB
	private ToolJSON toolJSON;
	@EJB
	private UserBean userBean;
	@EJB
	private RoleBean roleBean;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		JsonObjectBuilder jsonObjectResponseBuilder = Json
				.createObjectBuilder();

		Integer roleId = (Integer) request.getSession().getAttribute(
				Constants.PARAMETER_SESSION_IDROLE);
		if (roleId != null && roleId == 1) {
			boolean state = true;

			JsonObject jsonObjectRequest = toolJSON
					.getJsonObjectRequest(request);
			Integer userId = jsonObjectRequest.getInt(Constants.PARAMETER_ID);
			String firstname = jsonObjectRequest
					.getString(Constants.PARAMETER_FIRSTNAME);
			String middlename = jsonObjectRequest
					.getString(Constants.PARAMETER_MISSLENAME);
			String lastname = jsonObjectRequest
					.getString(Constants.PARAMETER_LASTNAME);
			Boolean status = jsonObjectRequest
					.getBoolean(Constants.PARAMETER_LASTNAME);
			Boolean active = jsonObjectRequest
					.getBoolean(Constants.PARAMETER_LASTNAME);
			String roleS = jsonObjectRequest
					.getString(Constants.PARAMETER_LASTNAME);
			
			Role role = roleBean.findByName(roleS);
			User user = userBean.find(userId);
			user.setFirstname(firstname);
			user.setMiddlename(middlename);
			user.setLastname(lastname);
			user.setCommentAble(status);
			user.setActive(active);
			user.setRole(role);
			
			userBean.edit(user);
			
			jsonObjectResponseBuilder.add(Constants.PARAMETER_STATUS, state)
					.add(Constants.PARAMETER_MESSAGE, "");
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
