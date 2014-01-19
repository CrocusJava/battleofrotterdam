package com.battleweb.controller.commands;

import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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

		String photoName = request.getParameter(Constants.PARAMETER_PHOTO_NAME);

		File photoFile = new File(Constants.PATH_SAVE_PHOTO + "/" + photoName);
		
		response.reset();
	    response.setContentType("image/jpeg");
		
		BufferedOutputStream outStream = null;
		FileInputStream inStream = null;
		try {
			inStream = new FileInputStream(photoFile);
			outStream = new BufferedOutputStream(response.getOutputStream());
			int i = 0;
			while ((i = inStream.read()) != -1) {
				outStream.write(i);
			}

		} catch (Exception e) {
			Log.error(this, "Can't find file on server. File name - "+photoName);
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
				e.printStackTrace();
			}
		}
	}
}
