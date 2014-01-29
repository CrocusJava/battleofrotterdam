package com.battleweb.filters;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.battleweb.controller.Constants;
import com.battleweb.tools.ToolSession;

/**
 * 
 * @author Lukashchuk Ivan
 * 
 */
@WebFilter("/battleWEB")
public class FilterSession implements Filter {

	@EJB
	private ToolSession toolSession;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletResponse resp = ((HttpServletResponse) response);
		resp.addCookie(new Cookie(Constants.PARAMETER_IDUSER, toolSession
				.getUserId(request).toString()));
		resp.addCookie(new Cookie(Constants.PARAMETER_IDROLE, toolSession
				.getRoleId(request).toString()));
		
		if (null != chain) {
            chain.doFilter(request, response);
	    }
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}
