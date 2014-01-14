package com.battleweb.controller.commands;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleejb.ejbbeans.TextBean;
import com.battleejb.ejbbeans.URLBean;
import com.battleejb.entities.URL;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolJSON;

/**
 * @author marina
 * 
 */

@Stateless
@LocalBean
public class CommandFooter implements Command {

	@EJB
	private ToolJSON toolJSON;
	@EJB
	private TextBean textBean;
	@EJB
	private URLBean urlBean;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// get links from db
		URL link1 = urlBean.findByKey(Constants.URL_HOMEPAGE_LINK1);
		URL link2 = urlBean.findByKey(Constants.URL_HOMEPAGE_LINK2);
		URL link3 = urlBean.findByKey(Constants.URL_HOMEPAGE_LINK3);
		URL link4 = urlBean.findByKey(Constants.URL_HOMEPAGE_LINK4);

		// create json-objects of links
		JsonObject jsonObjectLink1 = Json
				.createObjectBuilder()
				.add(Constants.PARAMETER_URL_HOMEPAGE_LINK_TITLE,
						link1.getName())
				.add(Constants.PARAMETER_URL_HOMEPAGE_LINK_URL,
						link1.getValue()).build();
		JsonObject jsonObjectLink2 = Json
				.createObjectBuilder()
				.add(Constants.PARAMETER_URL_HOMEPAGE_LINK_TITLE,
						link2.getName())
				.add(Constants.PARAMETER_URL_HOMEPAGE_LINK_URL,
						link2.getValue()).build();
		JsonObject jsonObjectLink3 = Json
				.createObjectBuilder()
				.add(Constants.PARAMETER_URL_HOMEPAGE_LINK_TITLE,
						link3.getName())
				.add(Constants.PARAMETER_URL_HOMEPAGE_LINK_URL,
						link3.getValue()).build();
		JsonObject jsonObjectLink4 = Json
				.createObjectBuilder()
				.add(Constants.PARAMETER_URL_HOMEPAGE_LINK_TITLE,
						link4.getName())
				.add(Constants.PARAMETER_URL_HOMEPAGE_LINK_URL,
						link4.getValue()).build();

		JsonArray battleLinksArray = Json.createArrayBuilder()
				.add(jsonObjectLink1).add(jsonObjectLink2).add(jsonObjectLink3)
				.add(jsonObjectLink4).build();

		// create json-objects of contacts
		JsonObject jsonObjectContacts = Json
				.createObjectBuilder()
				.add(Constants.PARAMETER_CONTACTS_INFO_INDEX,
						textBean.findLocaleTextByKey(
								Constants.TEXT_CONTACTS_INFO_ON_INDEX,
								request.getLocale()))
				.add(Constants.PARAMETER_CONTACTS_ADDRESS,
						textBean.findLocaleTextByKey(
								Constants.TEXT_CONTACTS_ADDRESS,
								request.getLocale()))
				.add(Constants.PARAMETER_CONTACTS_EMAIL,
						textBean.findLocaleTextByKey(
								Constants.TEXT_CONTACTS_EMAIL,
								request.getLocale()))
				.add(Constants.PARAMETER_CONTACTS_PHONE,
						textBean.findLocaleTextByKey(
								Constants.TEXT_CONTACTS_PHONE,
								request.getLocale()))
				.add(Constants.PARAMETER_CONTACTS_FAX,
						textBean.findLocaleTextByKey(
								Constants.TEXT_CONTACTS_FAX,
								request.getLocale()))
				.add(Constants.PARAMETER_CONTACTS_SKYPE,
						textBean.findLocaleTextByKey(
								Constants.TEXT_CONTACTS_SKYPE,
								request.getLocale())).build();

		// create list of photos for gallery in footer
		
		
		// create final ison-object
		JsonObject jsonObjectResponse = Json.createObjectBuilder()
				.add(Constants.PARAMETER_BATTLE_LINKS, battleLinksArray)
				.add(Constants.PARAMETER_CONTACTS, jsonObjectContacts).build();

		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);
		return null;
	}

}
