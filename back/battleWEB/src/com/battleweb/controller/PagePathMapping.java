package com.battleweb.controller;

import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * @author rtkachuk
 *
 */
@Singleton
@Startup
@LocalBean
public class PagePathMapping {
	
	 private ResourceBundle resource;
     
     private final String PAGE_PATH_MAPPING_PROPERTIES = "com.battleweb.properties.pagepath";
     
     @PostConstruct
     public void init() {
             resource = ResourceBundle.getBundle(PAGE_PATH_MAPPING_PROPERTIES);
     }
         
     public String getPage(String pathName) {
             return resource.getString(pathName);
     }
}
