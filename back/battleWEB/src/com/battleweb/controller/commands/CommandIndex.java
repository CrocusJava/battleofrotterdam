package com.battleweb.controller.commands;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolCookie;
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
	@EJB
	private ToolCookie toolCookie;
	
	private SimpleDateFormat dateFormatTimer = new SimpleDateFormat("MM/dd/yyyy");
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy HH:mm", Locale.ENGLISH);
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//get current competitions from db for taking dates for the timer
		Date currentDate = new Date();
		
		CompetitionType yearType = competitionTypeBean.find(1);
		CompetitionType monthType = competitionTypeBean.find(2);
		
		Competition yearCompetition = competitionBean.getCurrentCompetitionByType(yearType, currentDate);
		Competition monthCompetition = competitionBean.getCurrentCompetitionByType(monthType, currentDate);
		
		Date yearCompetitionDate = currentDate;
		Date monthCompetitionDate = currentDate;
		if(yearCompetition!=null){
			yearCompetitionDate = yearCompetition.getDateEnd();
		}
		if(monthCompetition!=null){
			monthCompetitionDate = monthCompetition.getDateEnd();
		}
		
		//get descriptions from db
		String battleDescriptionShort = textBean.findLocaleTextByKey(Constants.TEXT_BATTLE_DESCRIPTION_SHORT, toolCookie.getLocaleName(request));
		String battleAnimationDescription = textBean.findLocaleTextByKey(Constants.TEXT_BATTLE_ANIMATION_DESCRIPTION, toolCookie.getLocaleName(request));
		
		//get animation url from db
		String animationURL = urlBean.findByKey(Constants.URL_BATTLE_ANIMATION).getName();
		
		
		
		//get comments from db 
		List<Comment> lastComments = commentBean.findLast(Constants.HOME_PAGE_LAST_COMMENTS_COUNT);
		JsonArrayBuilder lastCommentsArrayBuilder = Json.createArrayBuilder();
		for(Comment comment:lastComments){													
			JsonObject jsonObjectComment = Json.createObjectBuilder()
				.add(Constants.PARAMETER_USER_LOGIN, comment.getUser().getLogin())
				.add(Constants.PARAMETER_USER_ID, comment.getUser().getId())
				.add(Constants.PARAMETER_USER_PHOTOPATH, comment.getUser().getPhotoPath())
				.add(Constants.PARAMETER_COMMENT_DATE, dateFormat.format(comment.getCommentDate()))
				.add(Constants.PARAMETER_COMMENT_TEXT, comment.getCommentText())
				.add(Constants.PARAMETER_PROJECT_ID, comment.getProject().getId())
				.build();
			lastCommentsArrayBuilder.add(jsonObjectComment);
		}
		JsonArray lastCommentsArray = lastCommentsArrayBuilder.build();
		
		
		//get photos from db 
		List<Photo> lastPhotos = photoBean.findLast(Constants.HOME_PAGE_LAST_PHOTOS_COUNT);
		JsonArrayBuilder lastPhotosArrayBuilder = Json.createArrayBuilder();
		for(Photo photo:lastPhotos){													
			JsonObject jsonObjectPhoto = Json.createObjectBuilder()
				.add(Constants.PARAMETER_PHOTO_PATH, photo.getPath())
				.add(Constants.PARAMETER_PHOTO_DESCRIPTION, photo.getDescription())
				.add(Constants.PARAMETER_LOAD_DATE, dateFormat.format(photo.getLoadDate()))
				.add(Constants.PARAMETER_USER_LOGIN, photo.getProject().getUser().getLogin())
				.add(Constants.PARAMETER_COMPETITION_NAME, photo.getProject().getCompetition().getName())
				.add(Constants.PARAMETER_PROJECT_NAME, photo.getProject().getName())
				.add(Constants.PARAMETER_PROJECT_ID, photo.getProject().getId())
				.add(Constants.PARAMETER_PHOTO_ID, photo.getId())
				.build();
			lastPhotosArrayBuilder.add(jsonObjectPhoto);
		}
		JsonArray lastPhotossArray = lastPhotosArrayBuilder.build();
		
		
		
		//create final ison-object
		JsonObject jsonObjectResponse=Json.createObjectBuilder()
				.add(Constants.PARAMETER_BATTLE_YEAR_FINISH_DATE,dateFormatTimer.format(yearCompetitionDate))
				.add(Constants.PARAMETER_BATTLE_MONTH_FINISH_DATE,dateFormatTimer.format(monthCompetitionDate))
				.add(Constants.PARAMETER_TEXT_BATTLE_DESCRIPTION_SHORT, battleDescriptionShort)
				.add(Constants.PARAMETER_TEXT_BATTLE_ANIMATION_DESCRIPTION, battleAnimationDescription)
				.add(Constants.PARAMETER_URL_BATTLE_ANIMATION, animationURL)
				.add(Constants.PARAMETER_LAST_COMMENTS_LIST, lastCommentsArray)
				.add(Constants.PARAMETER_LAST_PHOTOS_LIST, lastPhotossArray)
				.build();
		
		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);
		return null;
	}

}
