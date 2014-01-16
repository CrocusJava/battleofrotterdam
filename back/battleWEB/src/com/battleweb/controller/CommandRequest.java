package com.battleweb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

import com.battleweb.controller.commands.Command;
import com.battleweb.controller.commands.CommandAboutBattle;
import com.battleweb.controller.commands.CommandApproveRegistration;
import com.battleweb.controller.commands.CommandCreateProject;
import com.battleweb.controller.commands.CommandCurrentRankings;
import com.battleweb.controller.commands.CommandFAQ;
import com.battleweb.controller.commands.CommandFooter;
import com.battleweb.controller.commands.CommandForgotPassword;
import com.battleweb.controller.commands.CommandIndex;
import com.battleweb.controller.commands.CommandLogin;
import com.battleweb.controller.commands.CommandLogout;
import com.battleweb.controller.commands.CommandRegistration;
import com.battleweb.controller.commands.CommandUploadAvatar;
import com.battleweb.controller.commands.CommandSendComment;
import com.battleweb.controller.commands.CommandUploadPhoto;
import com.battleweb.controller.commands.CommandViewPhotoComments;
import com.battleweb.controller.commands.CommandViewProject;
import com.battleweb.controller.commands.CommandViewProjectComments;
import com.battleweb.controller.commands.CommandViewProjectPhotos;
import com.battleweb.controller.commands.CommandVote;

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
	@EJB 
	private CommandIndex commandIndex;
	@EJB 
	private CommandAboutBattle commandAboutBattle;
	@EJB 
	private CommandFAQ commandFAQ;
	@EJB 
	private CommandUploadAvatar commandUploadAvatar;
	@EJB 
	private CommandUploadPhoto commandUploadPhoto;
	@EJB
	private CommandCurrentRankings commandCurrentRankings;
	@EJB
	private CommandViewProject commandViewProject;
	@EJB
	private CommandViewProjectPhotos commandViewProjectPhotos;
	@EJB
	private CommandViewProjectComments commandViewProjectComments;
	@EJB
	private CommandViewPhotoComments commandviewPhotoComments;
	@EJB
	private CommandFooter commandFooter;
	@EJB
	private CommandCreateProject commandCreateProject;
	@EJB
	private CommandVote commandVote;
	@EJB
	private CommandSendComment commandSendComment;
	@EJB
	private CommandLogout commandLogout;
	
	private Map<String, Command> commands = new HashMap<String, Command>();

	@PostConstruct
	public void init() {
		commands.put(Constants.COMMAND_LOGIN, commandLogin);
		commands.put(Constants.COMMAND_REGISTRATION, commandRegistration);
		commands.put(Constants.COMMAND_APPROVEREGISTRATION, commandApproveRegistration);
		commands.put(Constants.COMMAND_FORGOTPASSWORD, commandForgotPassword);
		commands.put(Constants.COMMAND_INDEX, commandIndex);
		commands.put(Constants.COMMAND_ABOUT_BATTLE, commandAboutBattle);
		commands.put(Constants.COMMAND_FAQ, commandFAQ);
		commands.put(Constants.COMMAND_UPLOAD_AVATAR, commandUploadAvatar);
		commands.put(Constants.COMMAND_UPLOAD_PHOTO, commandUploadPhoto);
		commands.put(Constants.COMMAND_CURRENTRANKINGS, commandCurrentRankings);
		commands.put(Constants.COMMAND_VIEWPROJECT, commandViewProject);
		commands.put(Constants.COMMAND_VIEW_PROJECT_PHOTOS, commandViewProjectPhotos);
		commands.put(Constants.COMMAND_VIEW_PROJECT_COMMENTS, commandViewProjectComments);
		commands.put(Constants.COMMAND_VIEW_PHOTO_COMMENTS, commandviewPhotoComments);
		commands.put(Constants.COMMAND_FOOTER, commandFooter);
		commands.put(Constants.COMMAND_CREATE_PROJECT, commandCreateProject);
		commands.put(Constants.COMMAND_VOTE, commandVote);
		commands.put(Constants.COMMAND_SEND_COMMENT, commandSendComment);
		commands.put(Constants.COMMAND_LOGOUT, commandLogout);
	}

	public Command getCommand(HttpServletRequest request) {
		String action = request.getParameter(Constants.COMMAND);
		Command command = commands.get(action);
		return command;
	}

}
