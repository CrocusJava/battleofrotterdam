package com.battleweb.controller;
/**
 * @author rtkachuk
 * @author marina
 *
 * Constants contains names of all path to web pages or elements of web pages
 */
public interface Constants {
	//Parameters for the home-page view
	public static final Integer HOME_PAGE_COMMENTS_COUNT = 5;
	public static final Integer HOME_PAGE_PHOTOS_COUNT = 3;
	
	//Parameter for all request
	public static final String COMMAND = "command";
	
	//Set of name commands for CommandRequest
	public static final String COMMAND_LOGIN = "login";
	public static final String COMMAND_REGISTRATION = "registration";
	public static final String COMMAND_FORGOTPASSWORD = "forgotpassword";
	public static final String COMMAND_APPROVEREGISTRATION = "approveregistration";
	public static final String COMMAND_INDEX = "index";
	public static final String COMMAND_ABOUT_BATTLE = "aboutbattle";
	public static final String COMMAND_FAQ = "faq";
	
	//Set name properties in session
	public static final String PARAMETER_SESSION_LOCALE= "userlocalization";
	public static final String PARAMETER_SESSION_USER= "user";
	public static final String PARAMETER_SESSION_IDUSER= "iduser";
	public static final String PARAMETER_SESSION_IDROLE= "idrole";
	
	//Set of name parameters JSON objects
	public static final String PARAMETER_LOGIN = "login";
	public static final String PARAMETER_PASSWORD = "password";
	public static final String PARAMETER_IDUSER = "iduser";
	public static final String PARAMETER_IDROLE = "idrole";
	public static final String PARAMETER_FIRSTNAME = "firstname";
	public static final String PARAMETER_MISSLENAME = "middlename";
	public static final String PARAMETER_LASTNAME = "lastname";
	public static final String PARAMETER_TOWN = "town";
	public static final String PARAMETER_STREET = "street";
	public static final String PARAMETER_HOUSENUMBER = "housenumber";
	public static final String PARAMETER_POSTCODE = "postcode";
	public static final String PARAMETER_BIRSTAY = "birthday";
	public static final String PARAMETER_PHONE = "phone";
	public static final String PARAMETER_EMAIL = "email";
	public static final String PARAMETER_STATUSMAIL = "statusemail";
	public static final String PARAMETER_STATUSLOFIN = "statuslogin";
	public static final String PARAMETER_REGISTRATIONMESSAGE = "registrationmessage";	
	public static final String PARAMETER_NEWPASSWORDMESSAGE = "newpasswordmessage";	
	public static final String PARAMETER_USERNAME = "username";	
	public static final String PARAMETER_APPROVEREGISTRATIONMESSAGE = "approveregistrationmessage";	
	
	public static final String PARAMETER_TEXT_MESSAGE_NEW_PASSWORD = "newpasswordmessage";
	public static final String PARAMETER_TEXT_MESSAGE_REGISTRATION = "registrationmessage";
	public static final String PARAMETER_TEXT_MESSAGE_APPROVEREGISTRATION = "approveregistrationmessage";
	
	public static final String PARAMETER_TEXT_BATTLE_DESCRIPTION_SHORT = "battledescriptionshort";
	public static final String PARAMETER_TEXT_BATTLE_ANIMATION_DESCRIPTION = "battleanimationdescription";
	public static final String PARAMETER_BATTLE_YEAR_FINISH_DATE = "battleyearfinishdate";
	public static final String PARAMETER_BATTLE_MONTH_FINISH_DATE = "battlemonthfinishdate";
	public static final String PARAMETER_URL_BATTLE_ANIMATION = "battleanimationurl";
	public static final String PARAMETER_URL_HOMEPAGE_LINK_TITLE = "linktitle";
	public static final String PARAMETER_URL_HOMEPAGE_LINK_URL = "linkurl";
	public static final String PARAMETER_BATTLE_LINKS = "battlelinks";
	public static final String PARAMETER_LAST_COMMENTS_LIST = "lastcommentslist";
	public static final String PARAMETER_USER_LOGIN = "userlogin";
	public static final String PARAMETER_USER_PHOTOPATH = "userphotopath";
	public static final String PARAMETER_COMMENT_DATE = "commentdate";
	public static final String PARAMETER_COMMENT_TEXT = "commenttext";
	public static final String PARAMETER_LAST_PHOTOS_LIST = "lastphotoslist";
	public static final String PARAMETER_PHOTO_PATH = "photopath";
	public static final String PARAMETER_PHOTO_DESCRIPTION = "photodescription";
	public static final String PARAMETER_LOAD_DATE = "loaddate";
	public static final String PARAMETER_COMPETITION_NAME = "competitionname";

	public static final String PARAMETER_ABOUT_BATTLE = "aboutbattle";
	public static final String PARAMETER_ABOUT_US = "aboutbus";
	public static final String PARAMETER_RULES = "rules";
	public static final String PARAMETER_INFORMATION = "information";
	public static final String PARAMETER_TITLE = "title";
	public static final String PARAMETER_BATTLE_DESCRIPTION_FULL = "battledescriptionfull";
	public static final String PARAMETER_US_DESCRIPTION = "usdescription";
	public static final String PARAMETER_RULES_DESCRIPTION = "rulesdescription";
	public static final String PARAMETER_INFO_DESCRIPTION = "infodescription";

	public static final String PARAMETER_FAQ_LIST = "faqlist";
	public static final String PARAMETER_FAQ_QUESTION = "faqquestion";
	public static final String PARAMETER_FAQ_ANSVER = "faqansver";
	
	
	
	//Set key of value Text
	public static final Integer TEXT_MESSAGE_NEW_PASSWORD = 100;
	public static final Integer TEXT_MESSAGE_YOUR_LOGIN = 110;
	public static final Integer TEXT_MESSAGE_YOUR_PASSWORD = 111;
	public static final Integer TEXT_MESSAGE_EMAIL_NOT_EXIST = 120;
	
	public static final Integer TEXT_MESSAGE_REGISTRATION = 200;
	public static final Integer TEXT_MESSAGE_REGISTRATION_MAIL = 210;
	
	public static final Integer TEXT_MESSAGE_APPROVEREGISTRATION_TRUE = 300;
	public static final Integer TEXT_MESSAGE_APPROVEREGISTRATION_FALSE = 310;
	
	public static final Integer TEXT_BATTLE_DESCRIPTION_SHORT = 500;
	public static final Integer TEXT_BATTLE_ANIMATION_DESCRIPTION = 510;
	public static final Integer TEXT_BATTLE_RULES_DESCRIPTION = 520;
	public static final Integer TEXT_BATTLE_DESCRIPTION_FULL = 530;
	public static final Integer TEXT_ABOUT_US_DESCRIPTION = 540;
	public static final Integer TEXT_INFO_DESCRIPTION = 550;
	public static final Integer TEXT_TITLE_BATTLE_RULES = 521;
	public static final Integer TEXT_TITLE_BATTLE_DESCRIPTION = 531;
	public static final Integer TEXT_TITLE_ABOUT_US = 541;
	public static final Integer TEXT_TITLE_INFO = 551;
	
	
	public static final Integer TEXT_Q1 = 600;
	public static final Integer TEXT_A1 = 605;
	public static final Integer TEXT_Q2 = 610;
	public static final Integer TEXT_A2 = 615;
	public static final Integer TEXT_Q3 = 620;
	public static final Integer TEXT_A3 = 625;
	public static final Integer TEXT_Q4 = 630;
	public static final Integer TEXT_A4 = 635;
	public static final Integer TEXT_Q5 = 640;
	public static final Integer TEXT_A5 = 645;
	
	

	//Set key of value URL
	public static final Integer URL_BATTLE_ANIMATION = 100;
	public static final Integer URL_HOMEPAGE_LINK1 = 110;
	public static final Integer URL_HOMEPAGE_LINK2 = 120;
	public static final Integer URL_HOMEPAGE_LINK3 = 130;
	public static final Integer URL_HOMEPAGE_LINK4 = 140;
	
		
}
