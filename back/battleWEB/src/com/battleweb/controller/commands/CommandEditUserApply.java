package com.battleweb.controller.commands;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import com.battleejb.ejbbeans.RoleBean;
import com.battleejb.ejbbeans.TextBean;
import com.battleejb.ejbbeans.UserBean;
import com.battleejb.entities.Role;
import com.battleejb.entities.User;
import com.battleweb.controller.Constants;
import com.battleweb.logger.Log;
import com.battleweb.tools.ToolCookie;
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
	@EJB
	private TextBean textBean;
	@EJB
	private ToolCookie toolCookie;
	
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
			Boolean status = jsonObjectRequest
					.getBoolean(Constants.PARAMETER_LASTNAME);
			Boolean active = jsonObjectRequest
					.getBoolean(Constants.PARAMETER_LASTNAME);
			String roleS = jsonObjectRequest
					.getString(Constants.PARAMETER_LASTNAME);

			Role role = roleBean.findByName(roleS);
			User user = userBean.find(userId);
			user.setCommentAble(status);
			user.setActive(active);
			user.setRole(role);

			userBean.edit(user);

			jsonObjectResponseBuilder.add(Constants.PARAMETER_STATUS, state)
					.add(Constants.PARAMETER_MESSAGE,
							textBean.findLocaleTextByKey(
									Constants.TEXT_MESSAGE_ADMIN_EDIT_USER,
									toolCookie.getLocaleName(request)));
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
