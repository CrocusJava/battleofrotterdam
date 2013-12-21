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
	public static final String COMMAND_OTHER1 = "COMMAND_OTHER1";
	public static final String COMMAND_OTHER2 = "COMMAND_OTHER2";
	public static final String COMMAND_OTHER3 = "COMMAND_OTHER3";
	
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
	
	public static final String PARAMETER_OTHER1 = "PARAMETER_OTHER1";
	public static final String PARAMETER_OTHER2 = "PARAMETER_OTHER2";
	public static final String PARAMETER_OTHER3 = "PARAMETER_OTHER3";
}
