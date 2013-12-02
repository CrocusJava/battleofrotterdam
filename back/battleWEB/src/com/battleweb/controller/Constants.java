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
	public static final String COMMAND_OTHER1 = "COMMAND_OTHER1";
	public static final String COMMAND_OTHER2 = "COMMAND_OTHER2";
	public static final String COMMAND_OTHER3 = "COMMAND_OTHER3";
	
	//Set of name parameters JSON objects
	public static final String PARAMETER_LOGIN = "login";
	public static final String PARAMETER_PASSWORD = "password";
	public static final String PARAMETER_IDUSER = "IDuser";
	public static final String PARAMETER_IDROLE = "IDrole";
	
	public static final String PARAMETER_OTHER1 = "PARAMETER_OTHER1";
	public static final String PARAMETER_OTHER2 = "PARAMETER_OTHER2";
	public static final String PARAMETER_OTHER3 = "PARAMETER_OTHER3";
}
