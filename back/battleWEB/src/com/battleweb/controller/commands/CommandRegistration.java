package com.battleweb.controller.commands;

import java.io.IOException;

import javax.ejb.EJB;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleejb.ejbbeans.UserBean;
import com.battleejb.entities.Address;
import com.battleejb.entities.Role;
import com.battleejb.entities.User;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolJSON;
import com.battleweb.tools.ToolMD5;

public class CommandRegistration implements Command {

	@EJB
	private UserBean userBean;
	@EJB
	private ToolJSON toolJSON;
	@EJB
	private ToolMD5 toolMD5;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		JsonObject jsonObjectRequest = toolJSON.getJsonObjectRequest(request);
		String login = jsonObjectRequest.getString(Constants.PARAMETER_LOGIN);
		String password = jsonObjectRequest
				.getString(Constants.PARAMETER_PASSWORD);
		String firstname = jsonObjectRequest
				.getString(Constants.PARAMETER_FIRSTNAME);
		String middlename = jsonObjectRequest
				.getString(Constants.PARAMETER_MISSLENAME);
		String lastname = jsonObjectRequest
				.getString(Constants.PARAMETER_LASTNAME);
		String town = jsonObjectRequest.getString(Constants.PARAMETER_TOWN);
		String street = jsonObjectRequest.getString(Constants.PARAMETER_STREET);
		String housenumber = jsonObjectRequest
				.getString(Constants.PARAMETER_HOUSENUMBER);
		String postcode = jsonObjectRequest
				.getString(Constants.PARAMETER_POSTCODE);
		String birthday = jsonObjectRequest
				.getString(Constants.PARAMETER_BIRSTAY);
		String phone = jsonObjectRequest.getString(Constants.PARAMETER_PHONE);
		String email = jsonObjectRequest.getString(Constants.PARAMETER_EMAIL);
		
		Role role = new Role();
		role.setName("user");
		
		Address address = new Address();
		address.setStreet(street);
		address.setHouseNumber(housenumber);
		//town
		
		User user = new User();
		user.setAddress(address);
		user.setRole(role);
		user.setLogin(login);
		user.setPassword(toolMD5.generateMD5(password));
		user.setName(firstname);
		user.setSurname(lastname);
		//middlename
		user.setEmail(email);
//		user.setPhotoPath("default");
		
		userBean.create(user);
		
		//+ отправка на email...
		
		return null;  //page path???
	}

}
