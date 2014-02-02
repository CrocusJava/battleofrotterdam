package com.battleweb.controller.commands;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleejb.ejbbeans.TextBean;
import com.battleejb.ejbbeans.UserBean;
import com.battleejb.entities.Address;
import com.battleejb.entities.Role;
import com.battleejb.entities.User;
import com.battleweb.controller.Constants;
import com.battleweb.logger.Log;
import com.battleweb.tools.ToolEmail;
import com.battleweb.tools.ToolJSON;
import com.battleweb.tools.ToolMD5;
import com.battleweb.tools.ToolSession;

/**
 * @author rtkachuk
 * 
 */
@Stateless
@LocalBean
public class CommandUpdateAccaunt implements Command {
	@EJB
	UserBean userBean;
	@EJB
	private ToolJSON toolJSON;
	@EJB
	private ToolMD5 toolMD5;
	@EJB
	private ToolSession toolSession;
	@EJB
	private TextBean textBean;
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		/** Define user, from session info*/
		User user= userBean.find(toolSession.getUserId(request));
		
		JsonObject jsonObjectRequest = toolJSON.getJsonObjectRequest(request);
		
		/** Check exist email in database*/
		String email=jsonObjectRequest.getString(Constants.PARAMETER_EMAIL);
		
		if (!user.getEmail().equals(email)){
			boolean statusMail=userBean.chackEmailExist(email);
			if (!statusMail){
				makeResponse(request, response, Constants.TEXT_MESSAGE_UPDATE_ACCOUNT_MAIL_EXIST_IN_DB);
				Log.debug(this, "Account is not updated. Mail exist in database.");
				return null;
			}
		}
		
		/** Compare password*/
		String password=jsonObjectRequest.getString(Constants.PARAMETER_PASSWORD);
		if (!password.equals("")){
			if (!user.getPassword().equals(toolMD5.generateMD5(password))){
					makeResponse(request, response, Constants.TEXT_MESSAGE_UPDATE_ACCOUNT_NO_CORRECT_PASSWORD);
					Log.debug(this, "Account is not updated. Incorrect password.");
					return null;
			}else {
				password=toolMD5.generateMD5(jsonObjectRequest.getString(Constants.PARAMETER_PASSWORD_NEW));
				user.setPassword(password);
			}
		}
//		String login = jsonObjectRequest.getString(Constants.PARAMETER_LOGIN);
		String firstName = jsonObjectRequest.getString(Constants.PARAMETER_FIRSTNAME);
		String middleName = jsonObjectRequest.getString(Constants.PARAMETER_MIDDLENAME);
		String lastName = jsonObjectRequest.getString(Constants.PARAMETER_LASTNAME);
		Date birthday = getDate(jsonObjectRequest.getString(Constants.PARAMETER_BIRTHDAY));
		String phone = jsonObjectRequest.getString(Constants.PARAMETER_PHONE);
		String town = jsonObjectRequest.getString(Constants.PARAMETER_TOWN);
		String street = jsonObjectRequest.getString(Constants.PARAMETER_STREET);
		String houseNumber = jsonObjectRequest.getString(Constants.PARAMETER_HOUSENUMBER);
		String postcode = jsonObjectRequest.getString(Constants.PARAMETER_POSTCODE);
		
		user.setFirstname(firstName);
		user.setMiddlename(middleName);
		user.setLastname(lastName);
		user.setBirthday(birthday);
		user.setPhone(phone);
		user.setEmail(email);
		user.getAddress().setTown(town);
		user.getAddress().setStreet(street);
		user.getAddress().setHouseNumber(houseNumber);
		user.getAddress().setPostcode(postcode);
		
		userBean.edit(user);
		makeResponse(request, response, Constants.TEXT_MESSAGE_UPDATE_ACCOUNT_SUCCESS);
		Log.debug(this, "Account success updated.");
		
		/** Update user in session*/
		toolSession.updateUser(request, user);
		Log.debug(this, "Update user in session");
		return null;
	}
	
	private Date getDate(String birthday){
		try {
			SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyy");
			return format.parse(birthday);
		} catch (ParseException e) {
			Log.error(this, e, "Can't parse date");
		}
		return null;
	}
	
	private void makeResponse(HttpServletRequest request, HttpServletResponse response, Integer messageCode) throws IOException{
		Locale locale = request.getLocale();
		String message = textBean.findLocaleTextByKey(messageCode, locale);
		
		JsonObject jsonObjectResponse = Json.createObjectBuilder()
				.add(Constants.PARAMETER_MESSAGE, message)
				.build();
		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);
	}
}
