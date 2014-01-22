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
public class CommandTerms implements Command{
	
	@EJB
	private ToolJSON toolJSON;
	@EJB
	private TextBean textBean;
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//get terms&conditions from db
		String termsAndConditionsTitle = textBean.findLocaleTextByKey(Constants.TEXT_TITLE_TERMS, request.getLocale());
		String termsAndConditionsText = textBean.findLocaleTextByKey(Constants.TEXT_TERMS, request.getLocale());
		
		//create final ison-object
		JsonObject jsonObjectResponse=Json.createObjectBuilder()
			.add(Constants.PARAMETER_TERMS_TITLE,termsAndConditionsTitle)
			.add(Constants.PARAMETER_TERMS_TEXT, termsAndConditionsText)
			.build();
				
		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);		
		return null;
	}
}
