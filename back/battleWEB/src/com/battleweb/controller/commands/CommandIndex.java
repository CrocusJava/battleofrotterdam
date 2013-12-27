package com.battleweb.controller.commands;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleejb.ejbbeans.CompetitionBean;
import com.battleejb.ejbbeans.CompetitionTypeBean;
import com.battleejb.ejbbeans.TextBean;
import com.battleejb.ejbbeans.URLBean;
import com.battleejb.entities.Competition;
import com.battleejb.entities.CompetitionType;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolJSON;
//import org.json.simple.JSONArray

/**
 * @author marina
 * 
 */

@Stateless
@LocalBean
public class CommandIndex implements Command{
	
	@EJB
	private ToolJSON toolJSON;
	@EJB
	private TextBean textBean;
	@EJB
	private URLBean urlBean;
	@EJB
	private CompetitionBean competitionBean;
	@EJB
	private CompetitionTypeBean competitionTypeBean;
	
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//get current competitions from db for taking dates for the timer
		Date currentDate = new Date();
		
		CompetitionType yearType = competitionTypeBean.find(1);
		CompetitionType monthType = competitionTypeBean.find(2);
		
		Competition yearCompetition = competitionBean.getCurrentCompetitionByType(yearType, currentDate);
		Competition monthCompetition = competitionBean.getCurrentCompetitionByType(monthType, currentDate);
		
		//get descriptions from db
		String battleDescriptionShort = textBean.findLocaleTextByKey(Constants.TEXT_BATTLE_DESCRIPTION_SHORT, request.getLocale());
		String battleAnimationDescription = textBean.findLocaleTextByKey(Constants.TEXT_BATTLE_ANIMATION_DESCRIPTION, request.getLocale());
		
		//get animation url from db
		String animationURL = urlBean.findByKey(Constants.URL_BATTLE_ANIMATION).getName();
		
		//get links from db
		
		JsonArray battlelinksArray = Json.createArrayBuilder().build();
		
		
		//get projects from db
		//***
		
		//create final ison-object
		JsonObject jsonObjectResponse=Json.createObjectBuilder()
				.add("testCurrentDate",currentDate.toString())
				.add(Constants.PARAMETER_BATTLE_YEAR_FINISH_DATE,yearCompetition.getDateEnd().toString())
				.add(Constants.PARAMETER_BATTLE_MONTH_FINISH_DATE,monthCompetition.getDateEnd().toString())
				.add(Constants.PARAMETER_TEXT_BATTLE_DESCRIPTION_SHORT, battleDescriptionShort)
				.add(Constants.PARAMETER_TEXT_BATTLE_ANIMATION_DESCRIPTION, battleAnimationDescription)
				.add(Constants.PARAMETER_URL_BATTLE_ANIMATION, animationURL)
				.build();
		
		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);
		return null;
	}

}
