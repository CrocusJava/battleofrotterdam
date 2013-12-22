package com.battleweb.controller;
/**
 * @author rtkachuk
 *
 * Constants contains names of all path to web pages or elements of web pages
 */
public interface Constants {
	
	//Parameter for all request
	public static final String COMMAND = "command";
	
	//Set of name commands for CommandRequest
	public static final String COMMAND_LOGIN = "login";
	public static final String COMMAND_REGISTRATION = "registration";
	public static final String COMMAND_FORGOTPASSWORD = "forgotpassword";
	public static final String COMMAND_APPROVEREGISTRATION = "approveregistration";
	
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
	
	//Set key of value Text
	public static final Integer TEXT_MESSAGE_NEW_PASSWORD = 100;
	public static final Integer TEXT_MESSAGE_REGISTRATION = 200;
	public static final Integer TEXT_MESSAGE_APPROVEREGISTRATION_TRUE = 300;
	public static final Integer TEXT_MESSAGE_APPROVEREGISTRATION_FALSE = 310;
}
