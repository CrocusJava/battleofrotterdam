package com.battleweb.controller.commands;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.battleejb.ejbbeans.PhotoBean;
import com.battleejb.ejbbeans.ProjectBean;
import com.battleejb.ejbbeans.UserBean;
import com.battleejb.entities.Photo;
import com.battleejb.entities.Project;
import com.battleejb.entities.User;
import com.battleweb.controller.Constants;
import com.battleweb.logger.Log;
import com.battleweb.tools.ToolJSON;
import com.battleweb.tools.ToolSession;

/**
 * @author rtkachuk
 * 
 */
@Stateless
@LocalBean
public class CommandAccount implements Command {

	@EJB
	private ToolJSON toolJSON;
	@EJB
	private ToolSession toolSession;
	@EJB
	private ProjectBean projectBean;
	@EJB
	private PhotoBean photoBean;
	@EJB
	private UserBean userBean;
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user=null;
		JsonObject jsonObjectRequest = toolJSON.getJsonObjectRequest(request);
		int userId = jsonObjectRequest.getInt(Constants.PARAMETER_IDUSER);
		if (userId!=0){
			user=userBean.find(userId);
		} else{
			user=toolSession.getUser(request);
		}
			
		if (null!=user){
			Log.debug(this, "Get all information about user");
			
			JsonObject jsonObjectResponse=Json.createObjectBuilder()
					.add(Constants.PARAMETER_LOGIN, user.getLogin())
					.add(Constants.PARAMETER_FIRSTNAME, user.getFirstname())
					.add(Constants.PARAMETER_MIDDLENAME, user.getMiddlename())
					.add(Constants.PARAMETER_LASTNAME, user.getLastname())
					.add(Constants.PARAMETER_BIRTHDAY, getDateStringShort(user.getBirthday()))
					.add(Constants.PARAMETER_PHOTO_PATH, user.getPhotoPath())
					.add(Constants.PARAMETER_PHONE, user.getPhone())
					.add(Constants.PARAMETER_EMAIL, user.getEmail())
					.add(Constants.PARAMETER_TOWN, user.getAddress().getTown())
					.add(Constants.PARAMETER_STREET, user.getAddress().getStreet())
					.add(Constants.PARAMETER_HOUSENUMBER, user.getAddress().getHouseNumber())
					.add(Constants.PARAMETER_POSTCODE, user.getAddress().getPostcode())
					.add(Constants.PARAMETER_PROJECTS, getProjects(user))
					.build();
			toolJSON.setJsonObjectResponse(response, jsonObjectResponse);
			
		} else {
			Log.debug(this, "User not exist");
		}
		return null;
	}
	
	public JsonArray getProjects(User user){
		JsonArrayBuilder jsonArrayBuilderProject=Json.createArrayBuilder(); 
		
		List<Project> listProjects=projectBean.findProjectsByUser(user);
		
		for (Project project : listProjects) {
			JsonObject jsonObjectResponse=Json.createObjectBuilder()
					.add(Constants.PARAMETER_PROJECT_ID, project.getId())
					.add(Constants.PARAMETER_PROJECT_NAME, project.getName())
					.add(Constants.PARAMETER_PROJECT_DESCRIPTION, project.getDescription())
					.add(Constants.PARAMETER_PROJECT_DATE_CREATION, getDateStringLong(project.getCreationDate()))
					.add(Constants.PARAMETER_COMMENTS_COUNT, project.getComments().size())
					.add(Constants.PARAMETER_VOICES_COUNT, project.getVoices().size())
					.add(Constants.PARAMETER_COMPETITION_ID, project.getCompetition().getId())
					.add(Constants.PARAMETER_COMPETITION_NAME, project.getCompetition().getName())
					.add(Constants.PARAMETER_COMPETITION_DESCRIPTION, project.getCompetition().getDescription())
					.add(Constants.PARAMETER_COMPETITION_DESCRIPTION, project.getCompetition().getDescription())
					.add(Constants.PARAMETER_COMPETITION_TYPE_ID, project.getCompetition().getType().getId())
					.add(Constants.PARAMETER_COMPETITION_TYPE_NAME, project.getCompetition().getType().getName())
					.add(Constants.PARAMETER_PHOTOS, getPhotos(project))
					.build();
			jsonArrayBuilderProject.add(jsonObjectResponse);
		}
		
		JsonArray jsonArrayProject=jsonArrayBuilderProject.build();
		return jsonArrayProject;
	}
	
	public JsonArray getPhotos(Project project){
		JsonArrayBuilder jsonArrayBuilderPhoto=Json.createArrayBuilder(); 
		
		List<Photo> listPhotos=photoBean.findLastByProject(1, project);
		
		for (Photo photo : listPhotos) {
			JsonObject jsonObjectResponse=Json.createObjectBuilder()
					.add(Constants.PARAMETER_PHOTO_ID, photo.getId())
					.add(Constants.PARAMETER_PHOTO_DESCRIPTION, photo.getDescription())
					.add(Constants.PARAMETER_PHOTO_PATH, photo.getPath())
					.build();
			jsonArrayBuilderPhoto.add(jsonObjectResponse);
		}
		
		JsonArray jsonArrayPhoto=jsonArrayBuilderPhoto.build();
		return jsonArrayPhoto;
	}
	
	private String getDateStringShort(Date date){
		if (null!=date){
			SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyy");
			String dateString=format.format(date);
			return dateString;
		}
		return "";
	}
	
	private String getDateStringLong(Date date){
		if (null!=date){
			SimpleDateFormat format=new SimpleDateFormat("dd MMMM yyyy HH:mm");
			String dateString=format.format(date);
			return dateString;
		}
		return "";
	}
}
