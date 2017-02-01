package com.hb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.SearchCommand;

@WebServlet("/Searchcon")
public class Searchcon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Searchcon() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String pname = request.getParameter("pname");
		SearchCommand comm = new SearchCommand();
		String path = comm.exec(request, response, pname);
		request.getRequestDispatcher(path).forward(request, response);
	}


}
