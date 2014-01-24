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

import com.battleejb.ejbbeans.NewsBean;
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
public class CommandUploadPhotoNews implements Command {

	@EJB
	NewsBean newsBean;
	@EJB
	ToolUpload toolUpload;
	private ToolJSON toolJSON;

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Log.info(this, "CommandUploadPhotoNews - try to load photo news");
		int count=newsBean.count();
		String fileName="photonews"+(count+1)+".";
		String fileNameCorrect = toolUpload.uploadImage(request, Constants.PATH_SAVE_PHOTO_NEWS, fileName);
		/** Create photo path */
		String filePath = Constants.PATH_GET_PHOTO_NEWS + fileNameCorrect;

		JsonObject jsonObjectResponse = Json.createObjectBuilder()
				.add(Constants.PARAMETER_PHOTO_PATH, filePath).build();

		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);
		return null;
	}

}
