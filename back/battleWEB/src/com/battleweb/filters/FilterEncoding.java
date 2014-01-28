package com.battleweb.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 
 * @author Lukashchuk Ivan
 *
 */
@WebFilter("/*")
public class FilterEncoding implements Filter{
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			request.setCharacterEncoding("UTF-8");
			if (null != chain) {
	            chain.doFilter(request, response);
		    }
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
