package com.battleweb.controller.commands;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.battleejb.ejbbeans.CompetitionBean;
import com.battleejb.ejbbeans.CompetitionTypeBean;
import com.battleejb.ejbbeans.TextBean;
import com.battleejb.entities.Competition;
import com.battleejb.entities.CompetitionType;
import com.battleweb.controller.Constants;
import com.battleweb.logger.Log;
import com.battleweb.tools.ToolCookie;
import com.battleweb.tools.ToolJSON;
import com.battleweb.tools.ToolSession;

/**
 * @author Lukashchuk Ivan
 * 
 */
@Stateless
@LocalBean
public class CommandCreateCompetition implements Command {

	@EJB
	private ToolJSON toolJSON;
	@EJB
	private ToolSession toolSession;
	@EJB
	private CompetitionBean competitionBean;
	@EJB
	private CompetitionTypeBean competitionTypeBean;
	@EJB
	private TextBean textBean;
	@EJB
	private ToolCookie toolCookie;
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		JsonObjectBuilder jsonObjectResponseBuilder = Json
				.createObjectBuilder();

		if (toolSession.isAdmin(request)) {

			JsonObject jsonObjectRequest = toolJSON
					.getJsonObjectRequest(request);
			String name = jsonObjectRequest.getString(Constants.PARAMETER_NAME);
			String description = jsonObjectRequest
					.getString(Constants.PARAMETER_DESCRIPTION);
			String typeStr = jsonObjectRequest
					.getString(Constants.PARAMETER_TYPE);
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy");
			Date startDate = null;
			Date endDate = null;
			Date regDeadline = null;
			try {
				String date = jsonObjectRequest
						.getString(Constants.PARAMETER_START_DATE);
				startDate = format.parse(date);
			} catch (ParseException e) {
				Log.error(this, e, "Can't parse date");
			}
			try {
				String date = jsonObjectRequest
						.getString(Constants.PARAMETER_END_DATE);
				endDate = format.parse(date);
			} catch (ParseException e) {
				Log.error(this, e, "Can't parse date");
			}
			try {
				String date = jsonObjectRequest
						.getString(Constants.PARAMETER_REG_DEADLINE);
				regDeadline = format.parse(date);
			} catch (ParseException e) {
				Log.error(this, e, "Can't parse date");
			}

			if (startDate.before(endDate) && startDate.before(regDeadline)
					&& regDeadline.before(endDate)) {
				CompetitionType type = competitionTypeBean.findByName(typeStr);

				Competition competition = new Competition();
				competition.setName(name);
				competition.setDescription(description);
				competition.setType(type);
				competition.setDateStart(startDate);
				competition.setDateEnd(endDate);
				competition.setRegisterDeadline(regDeadline);

				competitionBean.create(competition);

				jsonObjectResponseBuilder
						.add(Constants.PARAMETER_COMPETITION_ID,
								competition.getId())
						.add(Constants.PARAMETER_STATUS, true)
						.add(Constants.PARAMETER_MESSAGE,
								textBean.findLocaleTextByKey(
										Constants.TEXT_MESSAGE_ADMIN_EDIT_USER,
										toolCookie.getLocaleName(request)));

			} else {
				jsonObjectResponseBuilder
						.add(Constants.PARAMETER_STATUS, false).add(
								Constants.PARAMETER_MESSAGE, "Invalid dates");
			}
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
