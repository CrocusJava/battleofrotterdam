package com.battleweb.controller.commands;

import java.io.IOException;
import java.util.Locale;

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
public class CommandGetFAQ implements Command{
	
	@EJB
	private ToolJSON toolJSON;
	@EJB
	private TextBean textBean;
	
	private String question;
	private String ansver;
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			
		JsonArray faqListArrayEn = getFAQListByLocale(new Locale("en"));
		JsonArray faqListArrayNl = getFAQListByLocale(new Locale("nl"));
		
		//create final ison-object
		JsonObject jsonObjectResponse=Json.createObjectBuilder()
			.add(Constants.PARAMETER_FAQ_LIST_EN, faqListArrayEn)
			.add(Constants.PARAMETER_FAQ_LIST_NL, faqListArrayNl)
			.build();
						
		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);
		return null;
	}
	
	private JsonArray getFAQListByLocale(Locale locale){
		question = textBean.findLocaleTextByKey(Constants.TEXT_Q1, locale);
		ansver = textBean.findLocaleTextByKey(Constants.TEXT_A1, locale);
		JsonObject jsonObjectQA1 = Json.createObjectBuilder()
				.add(Constants.PARAMETER_FAQ_QUESTION, question)
				.add(Constants.PARAMETER_FAQ_ANSVER, ansver)
				.build();
		question = textBean.findLocaleTextByKey(Constants.TEXT_Q2, locale);
		ansver = textBean.findLocaleTextByKey(Constants.TEXT_A2, locale);
		JsonObject jsonObjectQA2 = Json.createObjectBuilder()
				.add(Constants.PARAMETER_FAQ_QUESTION, question)
				.add(Constants.PARAMETER_FAQ_ANSVER, ansver)
				.build();
		question = textBean.findLocaleTextByKey(Constants.TEXT_Q3, locale);
		ansver = textBean.findLocaleTextByKey(Constants.TEXT_A3, locale);
		JsonObject jsonObjectQA3 = Json.createObjectBuilder()
				.add(Constants.PARAMETER_FAQ_QUESTION, question)
				.add(Constants.PARAMETER_FAQ_ANSVER, ansver)
				.build();
		question = textBean.findLocaleTextByKey(Constants.TEXT_Q4, locale);
		ansver = textBean.findLocaleTextByKey(Constants.TEXT_A4, locale);
		JsonObject jsonObjectQA4 = Json.createObjectBuilder()
				.add(Constants.PARAMETER_FAQ_QUESTION, question)
				.add(Constants.PARAMETER_FAQ_ANSVER, ansver)
				.build();
		question = textBean.findLocaleTextByKey(Constants.TEXT_Q5, locale);
		ansver = textBean.findLocaleTextByKey(Constants.TEXT_A5, locale);
		JsonObject jsonObjectQA5 = Json.createObjectBuilder()
				.add(Constants.PARAMETER_FAQ_QUESTION, question)
				.add(Constants.PARAMETER_FAQ_ANSVER, ansver)
				.build();
		question = textBean.findLocaleTextByKey(Constants.TEXT_Q6, locale);
		ansver = textBean.findLocaleTextByKey(Constants.TEXT_A6, locale);
		JsonObject jsonObjectQA6 = Json.createObjectBuilder()
				.add(Constants.PARAMETER_FAQ_QUESTION, question)
				.add(Constants.PARAMETER_FAQ_ANSVER, ansver)
				.build();
		question = textBean.findLocaleTextByKey(Constants.TEXT_Q7, locale);
		ansver = textBean.findLocaleTextByKey(Constants.TEXT_A7, locale);
		JsonObject jsonObjectQA7 = Json.createObjectBuilder()
				.add(Constants.PARAMETER_FAQ_QUESTION, question)
				.add(Constants.PARAMETER_FAQ_ANSVER, ansver)
				.build();
		question = textBean.findLocaleTextByKey(Constants.TEXT_Q8, locale);
		ansver = textBean.findLocaleTextByKey(Constants.TEXT_A8, locale);
		JsonObject jsonObjectQA8 = Json.createObjectBuilder()
				.add(Constants.PARAMETER_FAQ_QUESTION, question)
				.add(Constants.PARAMETER_FAQ_ANSVER, ansver)
				.build();
		question = textBean.findLocaleTextByKey(Constants.TEXT_Q9, locale);
		ansver = textBean.findLocaleTextByKey(Constants.TEXT_A9, locale);
		JsonObject jsonObjectQA9 = Json.createObjectBuilder()
				.add(Constants.PARAMETER_FAQ_QUESTION, question)
				.add(Constants.PARAMETER_FAQ_ANSVER, ansver)
				.build();
		question = textBean.findLocaleTextByKey(Constants.TEXT_Q10, locale);
		ansver = textBean.findLocaleTextByKey(Constants.TEXT_A10, locale);
		JsonObject jsonObjectQA10 = Json.createObjectBuilder()
				.add(Constants.PARAMETER_FAQ_QUESTION, question)
				.add(Constants.PARAMETER_FAQ_ANSVER, ansver)
				.build();
		
		JsonArrayBuilder faqListArrayBuilder = Json.createArrayBuilder();
		faqListArrayBuilder.add(jsonObjectQA1);
		faqListArrayBuilder.add(jsonObjectQA2);
		faqListArrayBuilder.add(jsonObjectQA3);
		faqListArrayBuilder.add(jsonObjectQA4);
		faqListArrayBuilder.add(jsonObjectQA5);
		faqListArrayBuilder.add(jsonObjectQA6);
		faqListArrayBuilder.add(jsonObjectQA7);
		faqListArrayBuilder.add(jsonObjectQA8);
		faqListArrayBuilder.add(jsonObjectQA9);
		faqListArrayBuilder.add(jsonObjectQA10);
		JsonArray faqListArray = faqListArrayBuilder.build();
		
		return faqListArray;
	}
}
