package com.battleweb.controller.commands;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleejb.ejbbeans.TextBean;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolJSON;

/**
 * @author marina
 * 
 */

@Stateless
@LocalBean
public class CommandAboutBattle implements Command{
	
	@EJB
	private ToolJSON toolJSON;
	@EJB
	private TextBean textBean;
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//create json-objects of information
		String titleBattleDescription = textBean.findLocaleTextByKey(Constants.TEXT_TITLE_BATTLE_DESCRIPTION, request.getLocale());
		String battleDescriptionFull = textBean.findLocaleTextByKey(Constants.TEXT_BATTLE_DESCRIPTION_FULL, request.getLocale());
		JsonObject jsonObjectAboutBattle = Json.createObjectBuilder()
			.add(Constants.PARAMETER_TITLE, titleBattleDescription)
			.add(Constants.PARAMETER_DESCRIPTION, battleDescriptionFull)
			.build();
		
		String titleAboutbUs = textBean.findLocaleTextByKey(Constants.TEXT_TITLE_ABOUT_US, request.getLocale());
		String aboutbUsDescription = textBean.findLocaleTextByKey(Constants.TEXT_ABOUT_US_DESCRIPTION, request.getLocale());
		JsonObject jsonObjectAboutUs = Json.createObjectBuilder()
				.add(Constants.PARAMETER_TITLE, titleAboutbUs)
				.add(Constants.PARAMETER_DESCRIPTION, aboutbUsDescription)
				.build();

		String titleRules = textBean.findLocaleTextByKey(Constants.TEXT_TITLE_BATTLE_RULES, request.getLocale());
		String rulesDescription = textBean.findLocaleTextByKey(Constants.TEXT_BATTLE_RULES_DESCRIPTION, request.getLocale());
		JsonObject jsonObjectRules = Json.createObjectBuilder()
				.add(Constants.PARAMETER_TITLE, titleRules)
				.add(Constants.PARAMETER_DESCRIPTION, rulesDescription)
				.build();

		String titleInformation = textBean.findLocaleTextByKey(Constants.TEXT_TITLE_INFO, request.getLocale());
		String informationDescription = textBean.findLocaleTextByKey(Constants.TEXT_INFO_DESCRIPTION, request.getLocale());
		JsonObject jsonObjectInformation = Json.createObjectBuilder()
				.add(Constants.PARAMETER_TITLE, titleInformation)
				.add(Constants.PARAMETER_DESCRIPTION, informationDescription)
				.build();
		
		//create final ison-object
		JsonObject jsonObjectResponse=Json.createObjectBuilder()
			.add(Constants.PARAMETER_ABOUT_BATTLE, jsonObjectAboutBattle)
			.add(Constants.PARAMETER_ABOUT_US, jsonObjectAboutUs)
			.add(Constants.PARAMETER_RULES, jsonObjectRules)
			.add(Constants.PARAMETER_INFORMATION, jsonObjectInformation)
			.build();
				
		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);
		
		return null;
	}

}
