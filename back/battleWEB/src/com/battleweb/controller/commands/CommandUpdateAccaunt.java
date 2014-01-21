package com.battleweb.controller.commands;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleejb.ejbbeans.TextBean;
import com.battleejb.ejbbeans.UserBean;
import com.battleejb.entities.Address;
import com.battleejb.entities.Role;
import com.battleejb.entities.User;
import com.battleweb.controller.Constants;
import com.battleweb.logger.Log;
import com.battleweb.tools.ToolEmail;
import com.battleweb.tools.ToolJSON;
import com.battleweb.tools.ToolMD5;

/**
 * @author rtkachuk
 * 
 */
@Stateless
@LocalBean
public class CommandUpdateAccaunt implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//TODO
		
		return null;
	}
}
