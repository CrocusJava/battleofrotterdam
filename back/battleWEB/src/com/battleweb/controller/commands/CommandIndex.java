package com.battleweb.controller.commands;

import java.io.IOException;
import java.util.Date;
import java.util.List;

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

import com.battleejb.ejbbeans.CommentBean;
import com.battleejb.ejbbeans.CompetitionBean;
import com.battleejb.ejbbeans.CompetitionTypeBean;
import com.battleejb.ejbbeans.PhotoBean;
import com.battleejb.ejbbeans.TextBean;
import com.battleejb.ejbbeans.URLBean;
import com.battleejb.entities.Comment;
import com.battleejb.entities.Competition;
import com.battleejb.entities.CompetitionType;
import com.battleejb.entities.Photo;
import com.battleejb.entities.URL;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolJSON;
//import org.json.simple.JSONArray

/**
 * @author marina
 * 
 */

@Stateless
@LocalBean
public class CommandIndex implements Command{
	
	@EJB
	private ToolJSON toolJSON;
	@EJB
	private TextBean textBean;
	@EJB
	private URLBean urlBean;
	@EJB
	private CompetitionBean competitionBean;
	@EJB
	private CompetitionTypeBean competitionTypeBean;
	@EJB
	private CommentBean commentBean;
	@EJB
	private PhotoBean photoBean;
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//get current competitions from db for taking dates for the timer
		Date currentDate = new Date();
		
		CompetitionType yearType = competitionTypeBean.find(1);
		CompetitionType monthType = competitionTypeBean.find(2);
		
		Competition yearCompetition = competitionBean.getCurrentCompetitionByType(yearType, currentDate);
		Competition monthCompetition = competitionBean.getCurrentCompetitionByType(monthType, currentDate);
		
		//get descriptions from db
		String battleDescriptionShort = textBean.findLocaleTextByKey(Constants.TEXT_BATTLE_DESCRIPTION_SHORT, request.getLocale());
		String battleAnimationDescription = textBean.findLocaleTextByKey(Constants.TEXT_BATTLE_ANIMATION_DESCRIPTION, request.getLocale());
		
		//get animation url from db
		String animationURL = urlBean.findByKey(Constants.URL_BATTLE_ANIMATION).getName();
		
		//get links from db
		URL link1 = urlBean.findByKey(Constants.URL_HOMEPAGE_LINK1);
		URL link2 = urlBean.findByKey(Constants.URL_HOMEPAGE_LINK2);
		URL link3 = urlBean.findByKey(Constants.URL_HOMEPAGE_LINK3);
		URL link4 = urlBean.findByKey(Constants.URL_HOMEPAGE_LINK4);
		
		//create json-objects of links
		JsonObject jsonObjectLink1 = Json.createObjectBuilder()
				.add(Constants.PARAMETER_URL_HOMEPAGE_LINK_TITLE, link1.getName())
				.add(Constants.PARAMETER_URL_HOMEPAGE_LINK_URL, link1.getValue())
				.build();
		JsonObject jsonObjectLink2 = Json.createObjectBuilder()
				.add(Constants.PARAMETER_URL_HOMEPAGE_LINK_TITLE, link2.getName())
				.add(Constants.PARAMETER_URL_HOMEPAGE_LINK_URL, link2.getValue())
				.build();
		JsonObject jsonObjectLink3 = Json.createObjectBuilder()
				.add(Constants.PARAMETER_URL_HOMEPAGE_LINK_TITLE, link3.getName())
				.add(Constants.PARAMETER_URL_HOMEPAGE_LINK_URL, link3.getValue())
				.build();
		JsonObject jsonObjectLink4 = Json.createObjectBuilder()
				.add(Constants.PARAMETER_URL_HOMEPAGE_LINK_TITLE, link4.getName())
				.add(Constants.PARAMETER_URL_HOMEPAGE_LINK_URL, link4.getValue())
				.build();
		
		JsonArray battleLinksArray = Json.createArrayBuilder()
				.add(jsonObjectLink1)
				.add(jsonObjectLink2)
				.add(jsonObjectLink3)
				.add(jsonObjectLink4)
				.build();
		
		//get comments from db 
		List<Comment> lastComments = commentBean.findLast(Constants.HOME_PAGE_COMMENTS_COUNT);
		JsonArrayBuilder lastCommentsArrayBuilder = Json.createArrayBuilder();
		for(Comment comment:lastComments){													
			JsonObject jsonObjectComment = Json.createObjectBuilder()
				.add(Constants.PARAMETER_USER_LOGIN, comment.getUser().getLogin())
				.add(Constants.PARAMETER_USER_PHOTOPATH, comment.getUser().getPhotoPath())
				.add(Constants.PARAMETER_COMMENT_DATE, comment.getCommentDate().toString())
				.add(Constants.PARAMETER_COMMENT_TEXT, comment.getCommentText())
				.build();
			lastCommentsArrayBuilder.add(jsonObjectComment);
		}
		JsonArray lastCommentsArray = lastCommentsArrayBuilder.build();
		
		
		//get photos from db 
		List<Photo> lastPhotos = photoBean.findLast(Constants.HOME_PAGE_PHOTOS_COUNT);
		JsonArrayBuilder lastPhotosArrayBuilder = Json.createArrayBuilder();
		for(Photo photo:lastPhotos){													
			JsonObject jsonObjectPhoto = Json.createObjectBuilder()
				.add(Constants.PARAMETER_PHOTO_PATH, photo.getPath())
				.add(Constants.PARAMETER_PHOTO_DESCRIPTION, photo.getDescription())
				.add(Constants.PARAMETER_LOAD_DATE, photo.getLoadDate().toString())
				.add(Constants.PARAMETER_USER_LOGIN, photo.getProject().getUser().getLogin())
				.add(Constants.PARAMETER_COMPETITION_NAME, photo.getProject().getCompetition().getName())
				.build();
			lastPhotosArrayBuilder.add(jsonObjectPhoto);
		}
		JsonArray lastPhotossArray = lastPhotosArrayBuilder.build();
		
		//create json-objects of contacts
		JsonObject jsonObjectContacts = Json.createObjectBuilder()
			.add(Constants.PARAMETER_CONTACTS_INFO_INDEX, textBean.findLocaleTextByKey(Constants.TEXT_CONTACTS_INFO_ON_INDEX, request.getLocale()))
			.add(Constants.PARAMETER_CONTACTS_ADDRESS, textBean.findLocaleTextByKey(Constants.TEXT_CONTACTS_ADDRESS, request.getLocale()))
			.add(Constants.PARAMETER_CONTACTS_EMAIL, textBean.findLocaleTextByKey(Constants.TEXT_CONTACTS_EMAIL, request.getLocale()))
			.add(Constants.PARAMETER_CONTACTS_PHONE, textBean.findLocaleTextByKey(Constants.TEXT_CONTACTS_PHONE, request.getLocale()))
			.add(Constants.PARAMETER_CONTACTS_FAX, textBean.findLocaleTextByKey(Constants.TEXT_CONTACTS_FAX, request.getLocale()))
			.add(Constants.PARAMETER_CONTACTS_SKYPE, textBean.findLocaleTextByKey(Constants.TEXT_CONTACTS_SKYPE, request.getLocale()))
			.build();
		
		//create final ison-object
		JsonObject jsonObjectResponse=Json.createObjectBuilder()
				.add(Constants.PARAMETER_BATTLE_YEAR_FINISH_DATE,yearCompetition.getDateEnd().toString())
				.add(Constants.PARAMETER_BATTLE_MONTH_FINISH_DATE,monthCompetition.getDateEnd().toString())
				.add(Constants.PARAMETER_TEXT_BATTLE_DESCRIPTION_SHORT, battleDescriptionShort)
				.add(Constants.PARAMETER_TEXT_BATTLE_ANIMATION_DESCRIPTION, battleAnimationDescription)
				.add(Constants.PARAMETER_URL_BATTLE_ANIMATION, animationURL)
				.add(Constants.PARAMETER_BATTLE_LINKS, battleLinksArray)
				.add(Constants.PARAMETER_LAST_COMMENTS_LIST, lastCommentsArray)
				.add(Constants.PARAMETER_LAST_PHOTOS_LIST, lastPhotossArray)
				.add(Constants.PARAMETER_CONTACTS, jsonObjectContacts)
				.build();
		
		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);
		return null;
	}

}
