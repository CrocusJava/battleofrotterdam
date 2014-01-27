package com.battleweb.filters;

import java.io.IOException;
import java.util.Locale;

import javax.ejb.EJB;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.battleweb.tools.ToolSession;

/**
 * @author rtkachuk
 *
 */
@WebFilter("/*")
public class FilterLocalization implements Filter{
	
	@EJB
	private ToolSession toolSession;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse responce,
			FilterChain chain) throws IOException, ServletException {
	   
		if (null==toolSession.getUserLocalization(request)){
	    	toolSession.setUserLocalization(request);
	    }
		
	    if (null != chain) {
            chain.doFilter(request, responce);
	    }
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
