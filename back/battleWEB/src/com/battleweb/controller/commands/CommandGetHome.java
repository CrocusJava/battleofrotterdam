package com.battleweb.controller.commands;

import java.io.IOException;
import java.util.Locale;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleejb.ejbbeans.TextBean;
import com.battleejb.ejbbeans.URLBean;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolJSON;

/**
 * @author marina
 * 
 */

@Stateless
@LocalBean
public class CommandGetHome implements Command{
	
	@EJB
	private ToolJSON toolJSON;
	@EJB
	private TextBean textBean;
	@EJB
	private URLBean urlBean;
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String animationURL = urlBean.findByKey(Constants.URL_BATTLE_ANIMATION).getValue();
		JsonObject jsonObjectEn=getJsonObject(Constants.PARAMETER_LOCALE_EN);
		JsonObject jsonObjectNl=getJsonObject(Constants.PARAMETER_LOCALE_NL);
		
		//create final ison-object
		JsonObject jsonObjectResponse=Json.createObjectBuilder()
			.add(Constants.PARAMETER_EN,jsonObjectEn)
			.add(Constants.PARAMETER_NL,jsonObjectNl)
			.add(Constants.PARAMETER_URL_BATTLE_ANIMATION, animationURL)
			.build();
				
		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);
		return null;
	}
	
	private JsonObject getJsonObject(String locale){
		String battleDescriptionShort = textBean.findLocaleTextByKey(Constants.TEXT_BATTLE_DESCRIPTION_SHORT, locale);
		String battleAnimationDescription = textBean.findLocaleTextByKey(Constants.TEXT_BATTLE_ANIMATION_DESCRIPTION, locale);
		JsonObject jsonObject = Json.createObjectBuilder()
				.add(Constants.PARAMETER_TEXT_BATTLE_DESCRIPTION_SHORT, battleDescriptionShort)
				.add(Constants.PARAMETER_TEXT_BATTLE_ANIMATION_DESCRIPTION, battleAnimationDescription)
				.build();
		return jsonObject;
	}
}
