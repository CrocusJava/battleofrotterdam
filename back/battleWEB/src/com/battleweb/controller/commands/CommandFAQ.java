package com.battleweb.controller.commands;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
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
public class CommandFAQ implements Command{
	
	@EJB
	private ToolJSON toolJSON;
	@EJB
	private TextBean textBean;
	
	String question;
	String ansver;
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		question = textBean.findLocaleTextByKey(Constants.TEXT_Q1, request.getLocale());
		ansver = textBean.findLocaleTextByKey(Constants.TEXT_A1, request.getLocale());
		JsonObject jsonObjectQA1 = Json.createObjectBuilder()
				.add(Constants.PARAMETER_FAQ_QUESTION, question)
				.add(Constants.PARAMETER_FAQ_ANSVER, ansver)
				.build();
		question = textBean.findLocaleTextByKey(Constants.TEXT_Q2, request.getLocale());
		ansver = textBean.findLocaleTextByKey(Constants.TEXT_A2, request.getLocale());
		JsonObject jsonObjectQA2 = Json.createObjectBuilder()
				.add(Constants.PARAMETER_FAQ_QUESTION, question)
				.add(Constants.PARAMETER_FAQ_ANSVER, ansver)
				.build();
		question = textBean.findLocaleTextByKey(Constants.TEXT_Q3, request.getLocale());
		ansver = textBean.findLocaleTextByKey(Constants.TEXT_A3, request.getLocale());
		JsonObject jsonObjectQA3 = Json.createObjectBuilder()
				.add(Constants.PARAMETER_FAQ_QUESTION, question)
				.add(Constants.PARAMETER_FAQ_ANSVER, ansver)
				.build();
		question = textBean.findLocaleTextByKey(Constants.TEXT_Q4, request.getLocale());
		ansver = textBean.findLocaleTextByKey(Constants.TEXT_A4, request.getLocale());
		JsonObject jsonObjectQA4 = Json.createObjectBuilder()
				.add(Constants.PARAMETER_FAQ_QUESTION, question)
				.add(Constants.PARAMETER_FAQ_ANSVER, ansver)
				.build();
		question = textBean.findLocaleTextByKey(Constants.TEXT_Q5, request.getLocale());
		ansver = textBean.findLocaleTextByKey(Constants.TEXT_A5, request.getLocale());
		JsonObject jsonObjectQA5 = Json.createObjectBuilder()
				.add(Constants.PARAMETER_FAQ_QUESTION, question)
				.add(Constants.PARAMETER_FAQ_ANSVER, ansver)
				.build();
		
		JsonArrayBuilder faqListArrayBuilder = Json.createArrayBuilder();
		faqListArrayBuilder.add(jsonObjectQA1);
		faqListArrayBuilder.add(jsonObjectQA2);
		faqListArrayBuilder.add(jsonObjectQA3);
		faqListArrayBuilder.add(jsonObjectQA4);
		faqListArrayBuilder.add(jsonObjectQA5);
		JsonArray faqListArray = faqListArrayBuilder.build();
		
		
		//create final ison-object
		JsonObject jsonObjectResponse=Json.createObjectBuilder()
			.add(Constants.PARAMETER_FAQ_LIST, faqListArray)
			.build();
						
		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);
		return null;
	}

}
