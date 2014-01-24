package com.battleweb.controller.commands;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleejb.ejbbeans.TextBean;
import com.battleejb.ejbbeans.URLBean;
import com.battleejb.entities.Text;
import com.battleejb.entities.URL;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolJSON;

/**
 * @author marina
 * 
 */

@Stateless
@LocalBean
public class CommandEditHome implements Command{
	
	@EJB
	private ToolJSON toolJSON;
	@EJB
	private TextBean textBean;
	@EJB
	private URLBean urlBean;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		JsonObject jsonObjectRequest = toolJSON.getJsonObjectRequest(request);
		
		String battleDescriptionShortEn = jsonObjectRequest.getJsonObject(Constants.PARAMETER_EN).getString(Constants.PARAMETER_TEXT_BATTLE_DESCRIPTION_SHORT);
		String battleDescriptionShortNl = jsonObjectRequest.getJsonObject(Constants.PARAMETER_NL).getString(Constants.PARAMETER_TEXT_BATTLE_DESCRIPTION_SHORT);
		String battleAnimationDescriptionEn = jsonObjectRequest.getJsonObject(Constants.PARAMETER_EN).getString(Constants.PARAMETER_TEXT_BATTLE_ANIMATION_DESCRIPTION);
		String battleAnimationDescriptionNl = jsonObjectRequest.getJsonObject(Constants.PARAMETER_NL).getString(Constants.PARAMETER_TEXT_BATTLE_ANIMATION_DESCRIPTION);
		String animationURL = jsonObjectRequest.getString(Constants.PARAMETER_URL_BATTLE_ANIMATION);
		
		URL url = urlBean.findByKey(Constants.URL_BATTLE_ANIMATION);
		url.setValue(animationURL);
		urlBean.edit(url);
		
		Text text = textBean.findByKey(Constants.TEXT_BATTLE_DESCRIPTION_SHORT);
		text.setValueEn(battleDescriptionShortEn);
		text.setValueNl(battleDescriptionShortNl);
		textBean.edit(text);

		text = textBean.findByKey(Constants.TEXT_BATTLE_ANIMATION_DESCRIPTION);
		text.setValueEn(battleAnimationDescriptionEn);
		text.setValueNl(battleAnimationDescriptionNl);
		textBean.edit(text);
		
		return null;
	}

}
