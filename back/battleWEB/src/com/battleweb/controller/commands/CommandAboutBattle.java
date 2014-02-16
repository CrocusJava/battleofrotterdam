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
import com.battleweb.tools.ToolCookie;
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
	@EJB
	private ToolCookie toolCookie;
	
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//create json-objects of information
		String titleBattleDescription = textBean.findLocaleTextByKey(Constants.TEXT_TITLE_BATTLE_DESCRIPTION, toolCookie.getLocaleName(request));
		String battleDescriptionFull = textBean.findLocaleTextByKey(Constants.TEXT_BATTLE_DESCRIPTION_FULL, toolCookie.getLocaleName(request));
		JsonObject jsonObjectAboutBattle = Json.createObjectBuilder()
			.add(Constants.PARAMETER_TITLE, titleBattleDescription)
			.add(Constants.PARAMETER_DESCRIPTION, battleDescriptionFull)
			.build();
		
		String titleAboutbUs = textBean.findLocaleTextByKey(Constants.TEXT_TITLE_ABOUT_US, toolCookie.getLocaleName(request));
		String aboutbUsDescription = textBean.findLocaleTextByKey(Constants.TEXT_ABOUT_US_DESCRIPTION, toolCookie.getLocaleName(request));
		JsonObject jsonObjectAboutUs = Json.createObjectBuilder()
				.add(Constants.PARAMETER_TITLE, titleAboutbUs)
				.add(Constants.PARAMETER_DESCRIPTION, aboutbUsDescription)
				.build();

		String titleRules = textBean.findLocaleTextByKey(Constants.TEXT_TITLE_BATTLE_RULES, toolCookie.getLocaleName(request));
		String rulesDescription = textBean.findLocaleTextByKey(Constants.TEXT_BATTLE_RULES_DESCRIPTION, toolCookie.getLocaleName(request));
		JsonObject jsonObjectRules = Json.createObjectBuilder()
				.add(Constants.PARAMETER_TITLE, titleRules)
				.add(Constants.PARAMETER_DESCRIPTION, rulesDescription)
				.build();

		String titleInformation = textBean.findLocaleTextByKey(Constants.TEXT_TITLE_INFO, toolCookie.getLocaleName(request));
		String informationDescription = textBean.findLocaleTextByKey(Constants.TEXT_INFO_DESCRIPTION, toolCookie.getLocaleName(request));
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
