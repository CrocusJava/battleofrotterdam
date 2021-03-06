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
import com.battleweb.controller.commands.CommandAccount;
import com.battleweb.controller.commands.CommandApproveRegistration;
import com.battleweb.controller.commands.CommandCangeProjectStatus;
import com.battleweb.controller.commands.CommandChangeLanguage;
import com.battleweb.controller.commands.CommandCompetitions;
import com.battleweb.controller.commands.CommandCreateCompetition;
import com.battleweb.controller.commands.CommandCreateNews;
import com.battleweb.controller.commands.CommandCreateProject;
import com.battleweb.controller.commands.CommandCurrentRankings;
import com.battleweb.controller.commands.CommandDeletePhoto;
import com.battleweb.controller.commands.CommandDeleteProject;
import com.battleweb.controller.commands.CommandEditComment;
import com.battleweb.controller.commands.CommandEditCompetition;
import com.battleweb.controller.commands.CommandEditFAQ;
import com.battleweb.controller.commands.CommandEditHome;
import com.battleweb.controller.commands.CommandEditNews;
import com.battleweb.controller.commands.CommandEditPhotoDescription;
import com.battleweb.controller.commands.CommandEditProject;
import com.battleweb.controller.commands.CommandEditUserApply;
import com.battleweb.controller.commands.CommandFAQ;
import com.battleweb.controller.commands.CommandFindUser;
import com.battleweb.controller.commands.CommandFooter;
import com.battleweb.controller.commands.CommandForgotPassword;
import com.battleweb.controller.commands.CommandGetFAQ;
import com.battleweb.controller.commands.CommandGetHome;
import com.battleweb.controller.commands.CommandGetNews;
import com.battleweb.controller.commands.CommandGetPhoto;
import com.battleweb.controller.commands.CommandIndex;
import com.battleweb.controller.commands.CommandLocale;
import com.battleweb.controller.commands.CommandLogin;
import com.battleweb.controller.commands.CommandLogout;
import com.battleweb.controller.commands.CommandNews;
import com.battleweb.controller.commands.CommandProjects;
import com.battleweb.controller.commands.CommandRegistration;
import com.battleweb.controller.commands.CommandSearch;
import com.battleweb.controller.commands.CommandSendComment;
import com.battleweb.controller.commands.CommandSendComplaint;
import com.battleweb.controller.commands.CommandSendEmail;
import com.battleweb.controller.commands.CommandShowUsers;
import com.battleweb.controller.commands.CommandTerms;
import com.battleweb.controller.commands.CommandUpdateAccaunt;
import com.battleweb.controller.commands.CommandUploadAvatar;
import com.battleweb.controller.commands.CommandUploadPhoto;
import com.battleweb.controller.commands.CommandUploadPhotoNews;
import com.battleweb.controller.commands.CommandViewPhotoComments;
import com.battleweb.controller.commands.CommandViewProject;
import com.battleweb.controller.commands.CommandViewProjectComments;
import com.battleweb.controller.commands.CommandViewProjectPhotos;
import com.battleweb.controller.commands.CommandVote;
import com.battleweb.controller.commands.CommandWasApprovedRegistration;

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
	private CommandTerms commandTerms;
	@EJB 
	private CommandNews commandNews;
	@EJB 
	private CommandAboutBattle commandAboutBattle;
	@EJB 
	private CommandFAQ commandFAQ;
	@EJB 
	private CommandGetFAQ commandGetFAQ;
	@EJB 
	private CommandEditFAQ commandEditFAQ;
	@EJB 
	private CommandGetNews commandGetNews;
	@EJB 
	private CommandEditNews commandEditNews;
	@EJB 
	private CommandGetHome commandGetHome;
	@EJB 
	private CommandEditHome commandEditHome;
	@EJB 
	private CommandCreateNews commandCreateNews;
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
	@EJB
	private CommandProjects commandProjects;
	@EJB
	private CommandCompetitions commandCompetitions;
	@EJB
	private CommandGetPhoto commandGetPhoto;
	@EJB
	private CommandEditComment commandEditComment;
	@EJB
	private CommandWasApprovedRegistration commandWasApprovedRegistration;
	@EJB
	private CommandShowUsers commandShowUsers;
	@EJB
	private CommandFindUser commandFindUser;
	@EJB
	private CommandEditUserApply commandEditUserApply;
	@EJB
	private CommandSendEmail commandSendEmail;
	@EJB
	private CommandAccount commandAccount;
	@EJB
	private CommandCangeProjectStatus commandCangeProjectStatus;
	@EJB
	private CommandCreateCompetition commandCreateCompetition;
	@EJB
	private CommandEditCompetition commandEditCompetition;
	@EJB
	private CommandSearch commandSearch;
	@EJB
	private CommandUploadPhotoNews commandUploadPhotoNews;
	@EJB
	private CommandUpdateAccaunt commandUpdateAccaunt;
	@EJB
	private CommandLocale commandLocale;
	@EJB
	private CommandEditProject commandEditProject;
	@EJB
	private CommandEditPhotoDescription commandEditPhotoDescription;
	@EJB
	private CommandDeletePhoto commandDeletePhoto;
	@EJB
	private CommandDeleteProject commandDeleteProject;
	@EJB
	private CommandChangeLanguage commandChangeLanguage;
	@EJB
	private CommandSendComplaint commandSendComplaint;
	
	private Map<String, Command> commands = new HashMap<String, Command>();

	@PostConstruct
	public void init() {
		commands.put(Constants.COMMAND_LOGIN, commandLogin);
		commands.put(Constants.COMMAND_REGISTRATION, commandRegistration);
		commands.put(Constants.COMMAND_APPROVEREGISTRATION, commandApproveRegistration);
		commands.put(Constants.COMMAND_FORGOTPASSWORD, commandForgotPassword);
		commands.put(Constants.COMMAND_INDEX, commandIndex);
		commands.put(Constants.COMMAND_TERMS, commandTerms);
		commands.put(Constants.COMMAND_NEWS, commandNews);
		commands.put(Constants.COMMAND_ABOUT_BATTLE, commandAboutBattle);
		commands.put(Constants.COMMAND_FAQ, commandFAQ);
		commands.put(Constants.COMMAND_GET_FAQ, commandGetFAQ);
		commands.put(Constants.COMMAND_EDIT_FAQ, commandEditFAQ);
		commands.put(Constants.COMMAND_GET_NEWS, commandGetNews);
		commands.put(Constants.COMMAND_EDIT_NEWS, commandEditNews);
		commands.put(Constants.COMMAND_GET_HOME, commandGetHome);
		commands.put(Constants.COMMAND_EDIT_HOME, commandEditHome);
		commands.put(Constants.COMMAND_CREATE_NEWS, commandCreateNews);
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
		commands.put(Constants.COMMAND_PROJECTS, commandProjects);
		commands.put(Constants.COMMAND_COMPETITIONS, commandCompetitions);
		commands.put(Constants.COMMAND_GET_PHOTO, commandGetPhoto);
		commands.put(Constants.COMMAND_EDIT_COMMENT, commandEditComment);
		commands.put(Constants.COMMAND_WAS_APPROVED_REGISTRATION, commandWasApprovedRegistration);
		commands.put(Constants.COMMAND_SHOW_USERS, commandShowUsers);
		commands.put(Constants.COMMAND_FIND_USER, commandFindUser);
		commands.put(Constants.COMMAND_EDIT_USER_APPLY, commandEditUserApply);
		commands.put(Constants.COMMAND_SEND_EMAIL, commandSendEmail);
		commands.put(Constants.COMMAND_ACCOUNT, commandAccount);
		commands.put(Constants.COMMAND_CHANGE_PROJECT_STATUS, commandCangeProjectStatus);
		commands.put(Constants.COMMAND_CREATE_COMPETITON, commandCreateCompetition);
		commands.put(Constants.COMMAND_EDIT_COMPETITON, commandEditCompetition);
		commands.put(Constants.COMMAND_SEARCH, commandSearch);
		commands.put(Constants.COMMAND_UPLOAD_PHOTO_NEWS, commandUploadPhotoNews);
		commands.put(Constants.COMMAND_UPDATE_ACCOUNT, commandUpdateAccaunt);
		commands.put(Constants.COMMAND_LOCALE, commandLocale);
		commands.put(Constants.COMMAND_EDIT_PROJECT, commandEditProject);
		commands.put(Constants.COMMAND_EDIT_PHOTO_DESCRIPTION, commandEditPhotoDescription);
		commands.put(Constants.COMMAND_DELETE_PHOTO, commandDeletePhoto);
		commands.put(Constants.COMMAND_DELETE_PROJECT, commandDeleteProject);
		commands.put(Constants.COMMAND_CHANGE_LANGUAGE, commandChangeLanguage);
		commands.put(Constants.COMMAND_SEND_COMPLAINT, commandSendComplaint);
	}

	public Command getCommand(HttpServletRequest request) {
		String action = request.getParameter(Constants.COMMAND);
		Command command = commands.get(action);
		return command;
	}

}
