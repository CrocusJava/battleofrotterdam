package com.battleweb.controller.commands;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * @author rtkachuk
 * 
 */
@Stateless
@LocalBean
public class CommandUpload implements Command {

	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			
			for (FileItem item : items) {
				
				if (item.isFormField()) {
					
				} else {
					File file;
					String filePath="./../photo";
					String fileName=item.getName();
					file=new File(filePath, fileName);
					item.write(file);
				}
			}
		} catch (FileUploadException e) {
			throw new ServletException("Parsing file upload failed.", e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


}
