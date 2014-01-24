package com.battleweb.controller.commands;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleejb.ejbbeans.NewsBean;
import com.battleejb.ejbbeans.TextBean;
import com.battleejb.entities.News;
import com.battleejb.entities.Text;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolJSON;

/**
 * @author marina
 * 
 */

@Stateless
@LocalBean
public class CommandCreateNews implements Command{
	
	@EJB
	private ToolJSON toolJSON;
	@EJB
	private TextBean textBean;
	@EJB
	private NewsBean newsBean;
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//replaces the older news by created
		News news = newsBean.findOlder().get(0);
		JsonObject jsonObjectRequest = toolJSON.getJsonObjectRequest(request);
		Integer keyval = news.getKeyval();
		Text text = textBean.findByKey(keyval);
		text.setValueEn(jsonObjectRequest.getString(Constants.PARAMETER_TEXT_EN));
		text.setValueNl(jsonObjectRequest.getString(Constants.PARAMETER_TEXT_NL));
		textBean.edit(text);
		news.setText(text);
		news.setPhotoPath(jsonObjectRequest.getString(Constants.PARAMETER_PHOTO_PATH));
		news.setLoadDate(new Date());
		newsBean.edit(news);
		return null;
	}

}
