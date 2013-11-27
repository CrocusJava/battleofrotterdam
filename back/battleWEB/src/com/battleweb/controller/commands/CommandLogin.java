package com.battleweb.controller.commands;

import java.io.IOException;
import java.io.StringReader;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleejb.businesslogic.CheckUserExist;
import com.battleejb.entities.User;
import com.battleweb.tools.ToolSession;

/**
 * 
 * @author rtkachuk
 * 
 */
@Stateless
@LocalBean
public class CommandLogin implements Command {

	@EJB 
	private CheckUserExist checkUserExist;
	@EJB
	private ToolSession toolSession;
	
	private User user;
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		JsonReader jsonLoginReaderRequest=Json.createReader(new StringReader(request.getParameter("jsonLoginRequest")));
		JsonObject jsonLoginObjectRequest=jsonLoginReaderRequest.readObject();
		jsonLoginReaderRequest.close();
		
		String login=jsonLoginObjectRequest.getString("login");
		String password=jsonLoginObjectRequest.getString("password");

		if (login!=null && password!=null && login.length()!=0 && password.length()!=0){
			user=checkUserExist.checkExistUserLoginPassword(login, password);	
		}
		
		if (null!=user){
			toolSession.addUserSession(request, user);
			
			request.setAttribute("state", "true");
			response.setContentType("application/json");
			
			JsonWriter jsonLoginWriterResponse=Json.createWriter(response.getWriter());
			JsonObject jsonLoginObjectResponse=Json.createObjectBuilder()
					.add("idUser", user.getId())
					.add("idRole", user.getRole().getId())
					.build();
			jsonLoginWriterResponse.writeObject(jsonLoginObjectResponse);
			jsonLoginWriterResponse.close();
		}

		return null;
	}
}
