package com.battleweb.controller.commands;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObjectBuilder;

import com.battleejb.ejbbeans.CommentBean;
import com.battleejb.ejbbeans.CompetitionBean;
import com.battleejb.ejbbeans.PhotoBean;
import com.battleejb.ejbbeans.ProjectBean;
import com.battleejb.ejbbeans.VoiceBean;
import com.battleweb.tools.ToolJSON;

/**
 * @author Lukashchuk Ivan
 * 
 */
@Stateless
@LocalBean
public class CommandProjects implements Command {

	@EJB
	private ToolJSON toolJSON;
	@EJB
	private ProjectBean projectBean;
	@EJB
	private PhotoBean photoBean;
	@EJB
	private CommentBean commentBean;
	@EJB
	private VoiceBean voiceBean;
	@EJB
	private CompetitionBean competitionBean;
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		JsonObjectBuilder jsonObjectResponseBuilder = Json
				.createObjectBuilder();

		//code here...
		
		return null;
	
	}
}
