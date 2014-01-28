package com.battleweb.tools;

import java.util.Locale;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.battleweb.controller.Constants;
import com.battleweb.logger.Log;

/**
 * @author rtkachuk
 *
 */
@Stateless
@LocalBean
public class ToolCookie {
	
	public boolean isExistLocale(ServletRequest request){
		Cookie[] cookieArray = ((HttpServletRequest)request).getCookies();
		if (null!=cookieArray && cookieArray.length!=0){
			for (Cookie cookie : cookieArray) {
				if (cookie.getName().equals(Constants.PARAMETER_LOCALE)){
					return true; 
				}	
			}
		}
		Log.info(this, "Cookie: localization is not exist");
		return false;
	}
	
	public void setLocaleDefault(ServletRequest request, ServletResponse response){
		Locale locale=request.getLocale();
		if (locale.getLanguage().equals(new Locale(Constants.PARAMETER_LOCALE_NL).getLanguage())){
			((HttpServletResponse)response).addCookie(new Cookie(Constants.PARAMETER_LOCALE, Constants.PARAMETER_LOCALE_NL));
			Log.info(this, "Cookie: set default localization - "+ Constants.PARAMETER_LOCALE_NL);
		}else{
			((HttpServletResponse)response).addCookie(new Cookie(Constants.PARAMETER_LOCALE, Constants.PARAMETER_LOCALE_EN));
			Log.info(this, "Cookie: set default localization - "+ Constants.PARAMETER_LOCALE_EN);
		}
	}
	
	public void changeLocale(ServletRequest request, String locale){
		Cookie[] cookieArray = ((HttpServletRequest)request).getCookies();
		for (Cookie cookie : cookieArray) {
			if (cookie.getName().equals(Constants.PARAMETER_LOCALE)){
				cookie.setValue(locale);
				Log.info(this, "Cookie: change localization - "+ locale);
				return;
			}	
		}
	}
	
	public String getLocaleName(ServletRequest request){
		Cookie[] cookieArray = ((HttpServletRequest)request).getCookies();
		for (Cookie cookie : cookieArray) {
			if (cookie.getName().equals(Constants.PARAMETER_LOCALE)){
				return cookie.getValue();
			}	
		}
		return request.getLocale().getLanguage();
	}
}
