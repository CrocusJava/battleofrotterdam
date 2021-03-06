package com.battleweb.controller.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleejb.ejbbeans.PhotoBean;
import com.battleejb.ejbbeans.TextBean;
import com.battleejb.ejbbeans.URLBean;
import com.battleejb.entities.Photo;
import com.battleejb.entities.URL;
import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolCookie;
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
	@EJB
	private PhotoBean photoBean;
	@EJB
	private ToolCookie toolCookie;
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// get links from db
		URL link1 = urlBean.findByKey(Constants.URL_HOMEPAGE_LINK1);
		URL link2 = urlBean.findByKey(Constants.URL_HOMEPAGE_LINK2);
		URL link3 = urlBean.findByKey(Constants.URL_HOMEPAGE_LINK3);
		URL link4 = urlBean.findByKey(Constants.URL_HOMEPAGE_LINK4);

		// create json-objects of links
		JsonObject jsonObjectLink1 = Json.createObjectBuilder()
				.add(Constants.PARAMETER_URL_HOMEPAGE_LINK_TITLE, link1.getName())
				.add(Constants.PARAMETER_URL_HOMEPAGE_LINK_URL,link1.getValue()).build();
		JsonObject jsonObjectLink2 = Json.createObjectBuilder()
				.add(Constants.PARAMETER_URL_HOMEPAGE_LINK_TITLE,link2.getName())
				.add(Constants.PARAMETER_URL_HOMEPAGE_LINK_URL,link2.getValue()).build();
		JsonObject jsonObjectLink3 = Json.createObjectBuilder()
				.add(Constants.PARAMETER_URL_HOMEPAGE_LINK_TITLE,link3.getName())
				.add(Constants.PARAMETER_URL_HOMEPAGE_LINK_URL,link3.getValue()).build();
		JsonObject jsonObjectLink4 = Json.createObjectBuilder()
				.add(Constants.PARAMETER_URL_HOMEPAGE_LINK_TITLE,link4.getName())
				.add(Constants.PARAMETER_URL_HOMEPAGE_LINK_URL,link4.getValue()).build();

		JsonArray battleLinksArray = Json.createArrayBuilder()
				.add(jsonObjectLink1).add(jsonObjectLink2).add(jsonObjectLink3)
				.add(jsonObjectLink4).build();

		// create json-objects of contacts
		JsonObject jsonObjectContacts = Json
				.createObjectBuilder()
				.add(Constants.PARAMETER_CONTACTS_INFO_INDEX,
						textBean.findLocaleTextByKey(
								Constants.TEXT_CONTACTS_INFO_ON_INDEX,
								toolCookie.getLocaleName(request)))
				.add(Constants.PARAMETER_CONTACTS_ADDRESS,
						textBean.findLocaleTextByKey(
								Constants.TEXT_CONTACTS_ADDRESS,
								toolCookie.getLocaleName(request)))
				.add(Constants.PARAMETER_CONTACTS_EMAIL,
						textBean.findLocaleTextByKey(
								Constants.TEXT_CONTACTS_EMAIL,
								toolCookie.getLocaleName(request)))
				.add(Constants.PARAMETER_CONTACTS_PHONE,
						textBean.findLocaleTextByKey(
								Constants.TEXT_CONTACTS_PHONE,
								toolCookie.getLocaleName(request)))
				.add(Constants.PARAMETER_CONTACTS_FAX,
						textBean.findLocaleTextByKey(
								Constants.TEXT_CONTACTS_FAX,
								toolCookie.getLocaleName(request)))
				.add(Constants.PARAMETER_CONTACTS_SKYPE,
						textBean.findLocaleTextByKey(
								Constants.TEXT_CONTACTS_SKYPE,
								toolCookie.getLocaleName(request))).build();

		// create list of photos for gallery in footer
		List<Photo> photosGallery = new ArrayList<Photo>();
		long photosCount = photoBean.getCount();
		if (photosCount<=Constants.FOOTER_GALLERY_PHOTOS_COUNT){
			photosGallery = photoBean.findAll();
			int i  = (int) photosCount;
			int j = 0;
			while(i<Constants.FOOTER_GALLERY_PHOTOS_COUNT){
				photosGallery.add(photosGallery.get(j));
				i++;
				j++;
			}
		}else{
			photosGallery = photoBean.findRamdom(Constants.FOOTER_GALLERY_PHOTOS_COUNT);
		}
		
		JsonArrayBuilder photosGalleryArrayBuilder = Json.createArrayBuilder();
		for(Photo photo:photosGallery){
			JsonObject jsonObjectPhoto = Json.createObjectBuilder()
					.add(Constants.PARAMETER_PHOTO_PATH, photo.getPath())
					.add(Constants.PARAMETER_LOAD_DATE, photo.getLoadDate().toString())
					.add(Constants.PARAMETER_USER_LOGIN, photo.getProject().getUser().getLogin())
					.add(Constants.PARAMETER_COMPETITION_NAME, photo.getProject().getCompetition().getName())
					.add(Constants.PARAMETER_PROJECT_ID, photo.getProject().getId())
					.add(Constants.PARAMETER_PROJECT_NAME, photo.getProject().getName())
					.add(Constants.PARAMETER_PHOTO_ID, photo.getId())
					.build();
			photosGalleryArrayBuilder.add(jsonObjectPhoto);
			}
			JsonArray photosGalleryArray = photosGalleryArrayBuilder.build();
		
		// create final ison-object
		JsonObject jsonObjectResponse = Json.createObjectBuilder()
				.add(Constants.PARAMETER_BATTLE_LINKS, battleLinksArray)
				.add(Constants.PARAMETER_CONTACTS, jsonObjectContacts)
				.add(Constants.PARAMETER_FOOTER_GALLERY, photosGalleryArray)
				.build();

		toolJSON.setJsonObjectResponse(response, jsonObjectResponse);
		return null;
	}

}
