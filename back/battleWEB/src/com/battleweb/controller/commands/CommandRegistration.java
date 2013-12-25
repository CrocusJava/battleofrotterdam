package com.battleweb.controller.commands;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.battleweb.tools.ToolEmail;
import com.battleweb.tools.ToolJSON;
import com.battleweb.tools.ToolMD5;

/**
 * @author Lukashchuk Ivan
 * 
 */
@Stateless
@LocalBean
public class CommandRegistration implements Command {

	@EJB
	private UserBean userBean;
	@EJB
	private ToolJSON toolJSON;
	@EJB
	private ToolMD5 toolMD5;
	@EJB
	private ToolEmail toolEmail;
	@EJB
	private TextBean textBean;
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Locale locale = request.getLocale();
		String registrationMessage = textBean.findLocaleTextByKey(
				Constants.TEXT_MESSAGE_REGISTRATION, locale);

		boolean statusMail = false;
		boolean statusLogin = false;

		JsonObject jsonObjectRequest = toolJSON.getJsonObjectRequest(request);
		String login = jsonObjectRequest.getString(Constants.PARAMETER_LOGIN);
		String email = jsonObjectRequest.getString(Constants.PARAMETER_EMAIL);

		statusMail = userBean.chackEmailExist(email);
		statusLogin = userBean.chackLoginExist(login);

		if (statusLogin && statusMail) {
			String password = jsonObjectRequest
					.getString(Constants.PARAMETER_PASSWORD);
			String firstname = jsonObjectRequest
					.getString(Constants.PARAMETER_FIRSTNAME);
			String middlename = jsonObjectRequest
					.getString(Constants.PARAMETER_MISSLENAME);
			String lastname = jsonObjectRequest
					.getString(Constants.PARAMETER_LASTNAME);
			String town = jsonObjectRequest.getString(Constants.PARAMETER_TOWN);
			String street = jsonObjectRequest
					.getString(Constants.PARAMETER_STREET);
			String housenumber = jsonObjectRequest
					.getString(Constants.PARAMETER_HOUSENUMBER);
			String postcode = jsonObjectRequest
					.getString(Constants.PARAMETER_POSTCODE);
			String birthday = jsonObjectRequest
					.getString(Constants.PARAMETER_BIRSTAY);
			String phone = jsonObjectRequest
					.getString(Constants.PARAMETER_PHONE);

			Address address = new Address();
			address.setStreet(street);
			address.setHouseNumber(housenumber);
			address.setTown(town);
			address.setPostcode(postcode);

			Role role = new Role();
			role.setId(2);
			role.setName("user");

			User user = new User();
			user.setAddress(address);
			user.setRole(role);
			user.setLogin(login);
			user.setPassword(toolMD5.generateMD5(password));
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setMiddlename(middlename);
			user.setEmail(email);
			user.setPhone(phone);
			user.setApproveregistration(false);
			user.setActive(true);
			user.setCommentAble(true);
			user.setPhotoPath("default");
			
			try {
				SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyy");
				user.setBirthday(format.parse(birthday));
			} catch (ParseException e) {
				//TODO Log
			}
			
			userBean.create(user);
		
			StringBuilder message = new StringBuilder();
			message.append(textBean.findLocaleTextByKey(Constants.TEXT_MESSAGE_REGISTRATION_MAIL, locale));
			message.append(" http://edu.bionic-university.com:1120/battleWEB/controller?command=approveregistration&iduser=");
			message.append(user.getId());
			message.append("&value=");
			message.append(toolMD5.generateMD5(user.getLogin()));
			
			toolEmail.send("Battle of Rotterdam registration",
					message.toString(), "battleofrotterdam@gmail.com", email);
		}

		JsonObject jsonObjectResponse = Json
				.createObjectBuilder()
				.add(Constants.PARAMETER_STATUSMAIL, statusMail)
				.add(Constants.PARAMETER_STATUSLOFIN, statusLogin)
				.add(Constants.PARAMETER_EMAIL, email)
				.add(Constants.PARAMETER_REGISTRATIONMESSAGE,
						registrationMessage).build();

		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);

		return null;
	}
}
