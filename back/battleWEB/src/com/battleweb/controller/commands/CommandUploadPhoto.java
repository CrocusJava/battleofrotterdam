package com.battleweb.controller.commands;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
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
import com.battleweb.tools.ToolJSON;
import com.battleweb.tools.ToolSession;
import com.battleweb.tools.ToolUpload;

/**
 * @author rtkachuk
 * 
 */

@Stateless
@LocalBean
public class CommandUploadPhoto implements Command {

	@EJB
	UserBean userBean;
	@EJB
	PhotoBean photoBean;
	@EJB
	ProjectBean projectBean;
	@EJB
	ToolUpload toolUpload;
	@EJB
	ToolSession toolSession;
	@EJB
	private ToolJSON toolJSON;

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String filePath=null;
		
		/** Define user project, from session info*/
		User user= userBean.find(toolSession.getUserId(request));
		List<Project> projectList=user.getProjects();
		for (Project project : projectList) {
			if (null!=request.getParameter(Constants.PARAMETER_TYPE_PROJECT) && request.getParameter(Constants.PARAMETER_TYPE_PROJECT).equals(project.getCompetition().getType().getName())){
				String competitionName=project.getCompetition().getType().getName();
				int countPhotos=project.getPhotos().size();
				/** Create new name of photo*/
				String fileName="photo"+user.getId()+(countPhotos+1)+competitionName+".";
				String fileNameCorrect=toolUpload.uploadImage(request, Constants.PATH_SAVE_PHOTO, fileName);
				/** Create photo path*/
				filePath=Constants.PATH_GET_PHOTO+fileNameCorrect;
				/** Save photo*/
				Photo photo=new Photo();
				photo.setLoadDate(new Date());
				photo.setProject(project);
				photo.setPath(filePath);
				photoBean.create(photo);
			}
		}
		
		JsonObject jsonObjectResponse=Json.createObjectBuilder()
				.add(Constants.PARAMETER_PHOTO_PATH, filePath)
				.build();
		
		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);
		return null;
	}

}