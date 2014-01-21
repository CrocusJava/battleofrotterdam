package com.battleweb.controller.commands;

import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleweb.controller.Constants;
import com.battleweb.logger.Log;

/**
 * @author rtkachuk
 * 
 */
@Stateless
@LocalBean
public class CommandGetPhoto implements Command {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		/**Get file with image*/
		File file = getFile(request);
		if (null==file){
			Log.error(this, "Not exist needed parameter - File=NULL");
			throw new IOException();
		}
		/**Try to find file and send it inside response*/
		response.reset();
		response.setContentType("image/jpeg");

		BufferedOutputStream outStream = null;
		FileInputStream inStream = null;
		try {
			inStream = new FileInputStream(file);
			outStream = new BufferedOutputStream(response.getOutputStream());
			int i = 0;
			while ((i = inStream.read()) != -1) {
				outStream.write(i);
			}

		} catch (Exception e) {
			Log.error(this, e, "Can't find file on server. File name - "+ file);
		} finally {
			close(outStream);
			close(inStream);
		}

		return null;
	}

	private void close(Closeable resource) {
		if (resource != null) {
			try {
				resource.close();
			} catch (IOException e) {
				Log.error(this, e, "Can't close stream.");
			}
		}
	}

	private File getFile(HttpServletRequest request) {
		/** Get names of all parameters */
		Enumeration<String> enumParametersNames = request.getParameterNames();
		while (enumParametersNames.hasMoreElements()) {
			String parameterName = enumParametersNames.nextElement();
			switch (parameterName) {
			case Constants.PARAMETER_PHOTO_NAME: {
				String photoName = request.getParameter(Constants.PARAMETER_PHOTO_NAME);
				File photoFile = new File(Constants.PATH_SAVE_PHOTO + "/"+ photoName);
				return photoFile;
			}
			case Constants.PARAMETER_AVATAR_NAME: {
				String photoName = request.getParameter(Constants.PARAMETER_AVATAR_NAME);
				File photoFile = new File(Constants.PATH_SAVE_AVATAR + "/"+ photoName);
				return photoFile;
			}
			default:
				break;
			}
		}
		return null;
	}
}
