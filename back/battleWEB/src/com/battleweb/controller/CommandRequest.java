package com.battleweb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

import com.battleweb.controller.commands.Command;
import com.battleweb.controller.commands.CommandApproveRegistration;
import com.battleweb.controller.commands.CommandForgotPassword;
import com.battleweb.controller.commands.CommandLogin;
import com.battleweb.controller.commands.CommandRegistration;

/**
 * CommandRequest class is used to get appropriate Command by the String value
 * 
 * @author rtkachuk
 * @see Command
 */
@Startup
@Stateless
@LocalBean
public class CommandRequest {

	@EJB
	private CommandLogin commandLogin;
	@EJB 
	private CommandRegistration commandRegistration;
	@EJB 
	private CommandApproveRegistration commandApproveRegistration;
	@EJB 
	private CommandForgotPassword commandForgotPassword;

	private Map<String, Command> commands = new HashMap<String, Command>();

	@PostConstruct
	public void init() {
		commands.put(Constants.COMMAND_LOGIN, commandLogin);
		commands.put(Constants.COMMAND_REGISTRATION, commandRegistration);
		commands.put(Constants.COMMAND_APPROVEREGISTRATION, commandApproveRegistration);
		commands.put(Constants.COMMAND_FORGOTPASSWORD, commandForgotPassword);
	}

	public Command getCommand(HttpServletRequest request) {
		String action = request.getParameter(Constants.COMMAND);
		Command command = commands.get(action);
		return command;
	}

}
