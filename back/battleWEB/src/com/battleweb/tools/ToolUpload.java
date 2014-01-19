package com.battleweb.tools;

import java.io.File;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.battleweb.logger.Log;

/**
 * @author rtkachuk
 *
 */
@Stateless
@LocalBean
public class ToolUpload {
			
	public String uploadImage(HttpServletRequest request, String filePath, String fileName) throws ServletException{
		String fileNameCorrect=null;

		try {
			List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			
			for (FileItem item : items) {
				//TODO refactoring
				if (item.isFormField()) {
					
				} else {
					/** Get MIME type of file*/
					String fileNameUser=item.getName();
					String [] fileNameUserSplit=fileNameUser.split("\\.");
					fileNameCorrect=fileName+fileNameUserSplit[fileNameUserSplit.length-1];
					File file=new File(filePath, fileNameCorrect);
					item.write(file);
				}
			}
		} catch (FileUploadException e) {
			Log.error(this, e, "Can't save file on server. File name - "+fileNameCorrect);
			throw new ServletException("Parsing file upload failed.", e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileNameCorrect;
	}
}
