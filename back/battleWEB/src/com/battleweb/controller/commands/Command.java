package com.battleweb.controller.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author rtkachuk
 * 
 * Command interface is used to realize Command pattern. Classes that implement
 * this interface should implement a single method execute.
 */
public interface Command {
	
    /**
     * Depending on request parameters and attributes values should do
     * appropriate operations and return the results of these operations as
     * request attribute values. Returns response like the result of page's path
     * or other additional info
     * 
     * @param request servlet request
     * @param response servlet response
     * @return response like the result of page's path or other additional info
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
