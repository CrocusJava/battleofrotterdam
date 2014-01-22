package com.battleweb.controller;
/**
 * @author rtkachuk
 * @author marina
 *
 * Constants contains names of all path to web pages or elements of web pages
 */
public interface Constants {
	//Parameters for the home-page view
	public static final Integer HOME_PAGE_LAST_NEWS_COUNT = 3;
	public static final Integer HOME_PAGE_LAST_COMMENTS_COUNT = 5;
	public static final Integer HOME_PAGE_LAST_PHOTOS_COUNT = 3;
	public static final Integer FOOTER_GALLERY_PHOTOS_COUNT = 12;
	
	
	//Parameter for all request
	public static final String COMMAND = "command";
	
	//Set of name commands for CommandRequest
	public static final String COMMAND_LOGIN = "login";
	public static final String COMMAND_LOGOUT = "logout";
	public static final String COMMAND_REGISTRATION = "registration";
	public static final String COMMAND_FORGOTPASSWORD = "forgotpassword";
	public static final String COMMAND_APPROVEREGISTRATION = "approveregistration";
	public static final String COMMAND_INDEX = "index";
	public static final String COMMAND_TERMS = "terms";
	public static final String COMMAND_NEWS = "news";
	public static final String COMMAND_ABOUT_BATTLE = "aboutbattle";
	public static final String COMMAND_FAQ = "faq";
	public static final String COMMAND_GET_FAQ = "getfaq";
	public static final String COMMAND_UPLOAD_AVATAR = "uploadavatar";
	public static final String COMMAND_UPLOAD_PHOTO = "uploadphoto";
	public static final String COMMAND_CURRENTRANKINGS = "currentrankings";
	public static final String COMMAND_VIEWPROJECT = "viewproject";
	public static final String COMMAND_VIEW_PROJECT_COMMENTS = "viewprojectcomments";
	public static final String COMMAND_VIEW_PROJECT_PHOTOS = "viewprojectphotos";
	public static final String COMMAND_VIEW_PHOTO_COMMENTS = "viewphotocomments";
	public static final String COMMAND_FOOTER = "footer";
	public static final String COMMAND_CREATE_PROJECT = "createproject";
	public static final String COMMAND_VOTE = "vote";
	public static final String COMMAND_SEND_COMMENT = "sendcomment";
	public static final String COMMAND_PROJECTS = "projects";
	public static final String COMMAND_COMPETITIONS = "competitions";
	public static final String COMMAND_GET_PHOTO = "getphoto";
	public static final String COMMAND_EDIT_COMMENT = "editcomment";
	public static final String COMMAND_WAS_APPROVED_REGISTRATION = "wasapproveredgistration";
	public static final String COMMAND_SHOW_USERS = "showusers";
	public static final String COMMAND_FIND_USER = "finduser";
	public static final String COMMAND_EDIT_USER_APPLY = "edituserapply";
	public static final String COMMAND_SEND_EMAIL = "sendemail";
	public static final String COMMAND_ACCAUNT = "accaunt";
	public static final String COMMAND_CHANGE_PROJECT_STATUS = "changeprojectstatus";
	public static final String COMMAND_CREATE_COMPETITON = "createcompetition";
	public static final String COMMAND_EDIT_COMPETITON = "editcompetition";
	
	
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
	public static final String PARAMETER_MIDDLENAME = "middlename";
	public static final String PARAMETER_LASTNAME = "lastname";
	public static final String PARAMETER_TOWN = "town";
	public static final String PARAMETER_STREET = "street";
	public static final String PARAMETER_HOUSENUMBER = "housenumber";
	public static final String PARAMETER_POSTCODE = "postcode";
	public static final String PARAMETER_BIRTHDAY = "birthday";
	public static final String PARAMETER_PHONE = "phone";
	public static final String PARAMETER_EMAIL = "email";
	public static final String PARAMETER_STATUSMAIL = "statusemail";
	public static final String PARAMETER_STATUSLOFIN = "statuslogin";
	public static final String PARAMETER_REGISTRATIONMESSAGE = "registrationmessage";	
	public static final String PARAMETER_NEWPASSWORDMESSAGE = "newpasswordmessage";	
	public static final String PARAMETER_USERNAME = "username";	
	public static final String PARAMETER_APPROVEREGISTRATIONMESSAGE = "approveregistrationmessage";	
	public static final String PARAMETER_APPROVE_REGISTRATION = "approveregistration";	
	
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
	public static final String PARAMETER_LAST_NEWS = "lastnews";
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
	public static final String PARAMETER_COMPETITION_TYPE = "competitiontype";
	public static final String PARAMETER_DATE_FROM = "datefrom";
	public static final String PARAMETER_DATE_TO = "dateto";
	public static final String PARAMETER_FILTER = "filter";
	public static final String PARAMETER_ORDER_BY = "orderby";
	public static final String PARAMETER_SORT = "sort";
	
	public static final String PARAMETER_ABOUT_BATTLE = "aboutbattle";
	public static final String PARAMETER_ABOUT_US = "aboutus";
	public static final String PARAMETER_RULES = "rules";
	public static final String PARAMETER_INFORMATION = "information";
	public static final String PARAMETER_TITLE = "title";
	public static final String PARAMETER_TERMS_TITLE = "termstitle";
	public static final String PARAMETER_TERMS_TEXT = "termstext";

	public static final String PARAMETER_FAQ_LIST = "faqlist";
	public static final String PARAMETER_FAQ_LIST_EN = "faqlisten";
	public static final String PARAMETER_FAQ_LIST_NL = "faqlistnl";
	public static final String PARAMETER_FAQ_QUESTION = "faqquestion";
	public static final String PARAMETER_FAQ_ANSVER = "faqansver";
	
	public static final String PARAMETER_YEAR_PROJECTS = "yearprojects";
	public static final String PARAMETER_NAME = "name";
	public static final String PARAMETER_RATING = "rating";
	public static final String PARAMETER_VOTES_QUANTITY = "votesquantity";
	public static final String PARAMETER_CREATION_DATE = "creationdate";
	public static final String PARAMETER_LAST_PHOTO = "lastphoto";
	public static final String PARAMETER_ID = "id";
	public static final String PARAMETER_PATH = "path";
	public static final String PARAMETER_DESCRIPTION = "description";
	public static final String PARAMETER_AVATAR_PATH = "avatarpath";
	public static final String PARAMETER_USER = "user";
	public static final String PARAMETER_COMMENT_QUANTITY = "commentquantity";
	public static final String PARAMETER_PHOTOS = "photos";
	public static final String PARAMETER_PROJECT = "project";
	public static final String PARAMETER_PROJECTS = "projects";
	public static final String PARAMETER_TYPE = "type";
	public static final String PARAMETER_COMPETITION = "competition";
	public static final String PARAMETER_FIRST_PHOTO = "firstphoto";
	public static final String PARAMETER_PHOTO_QUANTITY = "photoquantity";
	public static final String PARAMETER_PROJECT_ID = "projectid";
	public static final String PARAMETER_PHOTO_ID = "photoid";
	public static final String PARAMETER_FIRST_POSITION = "firstposition";
	public static final String PARAMETER_SIZE = "size";
	public static final String PARAMETER_COMMENTS = "comments";
	public static final String PARAMETER_TEXT = "text";
	public static final String PARAMETER_DATE = "date";
	public static final String PARAMETER_VOTE_ABLE = "voteable";
	public static final String PARAMETER_COMPETITION_ID = "competitionid";
	public static final String PARAMETER_VOTE_RESULT = "voteresult";
	public static final String PARAMETER_COMMENT_RESULT = "commentresult";

	public static final String PARAMETER_CONTACTS = "contacts";
	public static final String PARAMETER_CONTACTS_INFO_INDEX = "contactsinfoindex";
	public static final String PARAMETER_CONTACTS_ADDRESS = "contactsaddress";
	public static final String PARAMETER_CONTACTS_EMAIL = "contactsemail";
	public static final String PARAMETER_CONTACTS_PHONE = "contactsphone";
	public static final String PARAMETER_CONTACTS_FAX = "contactsfax";
	public static final String PARAMETER_CONTACTS_SKYPE = "contactsskype";
	public static final String PARAMETER_FOOTER_GALLERY = "footergallery";
	public static final String PARAMETER_CREATE_PROJECT_MESSAGE = "createprojectmessage";
	public static final String PARAMETER_COMMENT_ID = "commentid";
	
	public static final String PARAMETER_TYPE_PROJECT = "typeproject";
	public static final String PARAMETER_PHOTO_NAME="photoname";
	public static final String PARAMETER_AVATAR_NAME="avatarname";
	public static final String PARAMETER_ID_PHOTO = "idphoto";
	
	public static final String PARAMETER_SHOW_DESCRIPTION = "showdescription";
	public static final String PARAMETER_START_DATE_FROM="startdatefrom";
	public static final String PARAMETER_START_DATE_TO = "startdateto";
	public static final String PARAMETER_END_DATE_FROM="enddatefrom";
	public static final String PARAMETER_END_DATE_TO = "enddateto";
	public static final String PARAMETER_REG_DEADLINE_FROM="regdeadlinefrom";
	public static final String PARAMETER_REG_DEADLINE_TO="regdeadlineto";
	public static final String PARAMETER_WINNER_ID="winnerid";
	public static final String PARAMETER_WINNER="winner";
	public static final String PARAMETER_START_DATE="startdate";
	public static final String PARAMETER_END_DATE="enddate";
	public static final String PARAMETER_REG_DEADLINE="regdeadline";	
	public static final String PARAMETER_COMPETITIONS = "competitions";
	
	public static final String PARAMETER_COMMENT_ABLE = "commentable";
	public static final String PARAMETER_STATUS = "status";
	public static final String PARAMETER_ACTIVE = "active";
	public static final String PARAMETER_MESSAGE = "message";
	public static final String PARAMETER_ROLE = "role";
	public static final String PARAMETER_USERS = "users";
	public static final String PARAMETER_ERROR_MESSAGE = "errormessage";
	public static final String PARAMETER_USER_ID = "userid";
	public static final String PARAMETER_APPROVED = "approved";
			
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
	public static final Integer TEXT_TERMS = 560;
	public static final Integer TEXT_TITLE_BATTLE_RULES = 521;
	public static final Integer TEXT_TITLE_BATTLE_DESCRIPTION = 531;
	public static final Integer TEXT_TITLE_ABOUT_US = 541;
	public static final Integer TEXT_TITLE_INFO = 551;
	public static final Integer TEXT_TITLE_TERMS = 561;
	
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
	public static final Integer TEXT_Q6 = 650;
	public static final Integer TEXT_A6 = 655;
	public static final Integer TEXT_Q7 = 660;
	public static final Integer TEXT_A7 = 665;
	public static final Integer TEXT_Q8 = 670;
	public static final Integer TEXT_A8 = 675;
	public static final Integer TEXT_Q9 = 680;
	public static final Integer TEXT_A9 = 685;
	public static final Integer TEXT_Q10 = 690;
	public static final Integer TEXT_A10 = 695;

	public static final Integer TEXT_NEWS1 = 10;
	public static final Integer TEXT_NEWS2 = 20;
	public static final Integer TEXT_NEWS3 = 30;
	public static final Integer TEXT_NEWS4 = 40;
	public static final Integer TEXT_NEWS5 = 50;
	public static final Integer TEXT_NEWS6 = 60;
	public static final Integer TEXT_NEWS7 = 70;
	public static final Integer TEXT_NEWS8 = 80;
	public static final Integer TEXT_NEWS9 = 90;
	
	public static final Integer TEXT_CONTACTS_INFO_ON_INDEX = 700;
	public static final Integer TEXT_CONTACTS_ADDRESS = 710;
	public static final Integer TEXT_CONTACTS_EMAIL = 720;
	public static final Integer TEXT_CONTACTS_PHONE = 730;
	public static final Integer TEXT_CONTACTS_FAX = 740;
	public static final Integer TEXT_CONTACTS_SKYPE = 750;
	
	public static final Integer TEXT_MESSAGE_CREATE_PROJECT = 800;
	
	public static final Integer TEXT_MESSAGE_ADMIN_SEND_EMAIL = 1000;
	public static final Integer TEXT_MESSAGE_ADMIN_EDIT_USER = 1010;

	//Set key of value URL
	public static final Integer URL_BATTLE_ANIMATION = 100;
	public static final Integer URL_HOMEPAGE_LINK1 = 110;
	public static final Integer URL_HOMEPAGE_LINK2 = 120;
	public static final Integer URL_HOMEPAGE_LINK3 = 130;
	public static final Integer URL_HOMEPAGE_LINK4 = 140;

	//Set some constants
	public static final String COMPETITION_TYPE_YEAR = "year";
	public static final String COMPETITION_TYPE_MONTH = "month";
	public static final String SORT_TYPE_ASC = "asc";
	public static final String SORT_TYPE_DESC = "desc";
	public static final String ORDER_BY_START_DATE = "startdate";
	public static final String ORDER_BY_END_DATE = "enddate";
	public static final String ORDER_BY_REG_DEADLINE = "regdeadline";
	
	//Path
	public static final String PATH_SAVE_AVATAR = "/usr/app/jboss/photo/avatar";
	public static final String PATH_SAVE_PHOTO = "/usr/app/jboss/photo";
	
	public static final String PATH_GET_PHOTO="controller?command=getphoto&photoname=";
	public static final String PATH_GET_AVATAR="controller?command=getphoto&avatarname=";	
}
