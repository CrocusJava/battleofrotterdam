package com.battleweb.controller.commands;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
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

import com.battleejb.ejbbeans.NewsBean;
import com.battleejb.ejbbeans.TextBean;
import com.battleejb.entities.News;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolJSON;

/**
 * @author marina
 * 
 */

@Stateless
@LocalBean
public class CommandGetNews implements Command{
	
	@EJB
	private ToolJSON toolJSON;
	@EJB
	private TextBean textBean;
	@EJB
	private NewsBean newsBean;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		List<News> allNews = newsBean.findLast(Constants.HOME_PAGE_LAST_NEWS_COUNT);
		
		JsonArrayBuilder newsArrayBuilder = Json.createArrayBuilder();
		for(News news:allNews){	
			String newsTextEn = textBean.findLocaleTextByKey(news.getKeyval(), new Locale("en"));
			String newsTextNl = textBean.findLocaleTextByKey(news.getKeyval(), new Locale("nl"));
			JsonObject jsonObjectNews = Json.createObjectBuilder()
				.add(Constants.PARAMETER_ID,news.getId())
				.add(Constants.PARAMETER_PHOTO_PATH, news.getPhotoPath())
				.add(Constants.PARAMETER_TEXT_EN, newsTextEn)
				.add(Constants.PARAMETER_TEXT_NL, newsTextNl)
				.add(Constants.PARAMETER_LOAD_DATE, dateFormat.format(news.getLoadDate()))
				.build();
			newsArrayBuilder.add(jsonObjectNews);
		}
		JsonArray newsArray = newsArrayBuilder.build();
		
		//create final ison-object
		JsonObject jsonObjectResponse=Json.createObjectBuilder()
			.add(Constants.PARAMETER_NEWS, newsArray)
			.build();
						
		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);
		return null;
	}
}
