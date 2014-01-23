package com.battleweb.controller.commands;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleejb.ejbbeans.TextBean;
import com.battleejb.entities.Text;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolJSON;


/**
 * @author marina
 * 
 */

@Stateless
@LocalBean
public class CommandEditFAQ implements Command{
	
	@EJB
	private ToolJSON toolJSON;
	@EJB
	private TextBean textBean;
	
	private String questionen;
	private String ansveren;
	private String questionnl;
	private String ansvernl;
	private Text text;
	
	private void updateQuestion(JsonArray faqListArrayEn,JsonArray faqListArrayNl,Text text, int i){
		questionen = faqListArrayEn.getJsonObject(i).getString(Constants.PARAMETER_FAQ_QUESTION);
		questionnl = faqListArrayNl.getJsonObject(i).getString(Constants.PARAMETER_FAQ_QUESTION);
		text.setValueEn(questionen);
		text.setValueNl(questionnl);
		textBean.edit(text);
	}
	private void updateAnsver(JsonArray faqListArrayEn,JsonArray faqListArrayNl,Text text, int i){
		ansveren = faqListArrayEn.getJsonObject(i).getString(Constants.PARAMETER_FAQ_ANSVER);
		ansvernl = faqListArrayNl.getJsonObject(i).getString(Constants.PARAMETER_FAQ_ANSVER);
		text.setValueEn(ansveren);
		text.setValueNl(ansvernl);
		textBean.edit(text);
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		JsonObject jsonObjectRequest = toolJSON.getJsonObjectRequest(request);
		JsonArray faqListArrayEn = jsonObjectRequest.getJsonArray(Constants.PARAMETER_FAQ_LIST_EN);
		JsonArray faqListArrayNl = jsonObjectRequest.getJsonArray(Constants.PARAMETER_FAQ_LIST_NL);
		
		text = textBean.findByKey(Constants.TEXT_Q1);
		updateQuestion(faqListArrayEn,faqListArrayNl,text,0);
		text = textBean.findByKey(Constants.TEXT_Q2);
		updateQuestion(faqListArrayEn,faqListArrayNl,text,1);
		text = textBean.findByKey(Constants.TEXT_Q3);
		updateQuestion(faqListArrayEn,faqListArrayNl,text,2);
		text = textBean.findByKey(Constants.TEXT_Q4);
		updateQuestion(faqListArrayEn,faqListArrayNl,text,3);
		text = textBean.findByKey(Constants.TEXT_Q5);
		updateQuestion(faqListArrayEn,faqListArrayNl,text,4);
		text = textBean.findByKey(Constants.TEXT_Q6);
		updateQuestion(faqListArrayEn,faqListArrayNl,text,5);
		text = textBean.findByKey(Constants.TEXT_Q7);
		updateQuestion(faqListArrayEn,faqListArrayNl,text,6);
		text = textBean.findByKey(Constants.TEXT_Q8);
		updateQuestion(faqListArrayEn,faqListArrayNl,text,7);
		text = textBean.findByKey(Constants.TEXT_Q9);
		updateQuestion(faqListArrayEn,faqListArrayNl,text,8);
		text = textBean.findByKey(Constants.TEXT_Q10);
		updateQuestion(faqListArrayEn,faqListArrayNl,text,9);
		
		text = textBean.findByKey(Constants.TEXT_A1);
		updateAnsver(faqListArrayEn,faqListArrayNl,text,0);
		text = textBean.findByKey(Constants.TEXT_A2);
		updateAnsver(faqListArrayEn,faqListArrayNl,text,1);
		text = textBean.findByKey(Constants.TEXT_A3);
		updateAnsver(faqListArrayEn,faqListArrayNl,text,2);
		text = textBean.findByKey(Constants.TEXT_A4);
		updateAnsver(faqListArrayEn,faqListArrayNl,text,3);
		text = textBean.findByKey(Constants.TEXT_A5);
		updateAnsver(faqListArrayEn,faqListArrayNl,text,4);
		text = textBean.findByKey(Constants.TEXT_A6);
		updateAnsver(faqListArrayEn,faqListArrayNl,text,5);
		text = textBean.findByKey(Constants.TEXT_A7);
		updateAnsver(faqListArrayEn,faqListArrayNl,text,6);
		text = textBean.findByKey(Constants.TEXT_A8);
		updateAnsver(faqListArrayEn,faqListArrayNl,text,7);
		text = textBean.findByKey(Constants.TEXT_A9);
		updateAnsver(faqListArrayEn,faqListArrayNl,text,8);
		text = textBean.findByKey(Constants.TEXT_A10);
		updateAnsver(faqListArrayEn,faqListArrayNl,text,9);
		
		return null;
	}
}
