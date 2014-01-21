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
import com.battleweb.logger.Log;
import com.battleweb.tools.ToolJSON;
import com.battleweb.tools.ToolSession;
import com.battleweb.tools.ToolUpload;

/**
 * @author rtkachuk
 * 
 */
@Stateless
@LocalBean
public class CommandUploadAvatar implements Command {

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
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Log.info(this, "CommandUploadAvatar - try to load avatar");
	
		/** Get user from session and add avatar*/
		User user= userBean.find(toolSession.getUserId(request));
		/** Create new name of avatar*/
		String fileName="avatar"+user.getId()+".";
		String fileNameCorrect=toolUpload.uploadImage(request, Constants.PATH_SAVE_AVATAR, fileName);
		/** Create avatar path*/
		String filePath=Constants.PATH_GET_PHOTO+fileNameCorrect;
		/** Add avatar path to user*/
		user.setPhotoPath(filePath);
		
		JsonObject jsonObjectResponse=Json.createObjectBuilder()
				.add(Constants.PARAMETER_AVATAR_PATH, filePath)
				.build();
		
		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);
		return null;

	}

}
