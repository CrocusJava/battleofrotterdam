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

import com.battleweb.tools.ToolCookie;

/**
 * @author rtkachuk
 *
 */
@WebFilter("/*")
public class FilterLocalization implements Filter{
	
	@EJB
	private ToolCookie toolCookie;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
	   
		if (!toolCookie.isExistLocale(request)){
			toolCookie.setLocaleDefault(request, response);
		}
		
	    if (null != chain) {
            chain.doFilter(request, response);
	    }
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
