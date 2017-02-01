package com.hb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.ViewCommand;

@WebServlet("/Viewcon")
public class Viewcon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Viewcon() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String pid = request.getParameter("pid");
		ViewCommand comm = new ViewCommand();
		String path = comm.exec(request, response, pid);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
