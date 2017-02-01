package com.hb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.CategoryCommand;
import com.hb.model.Command;
import com.hb.model.NewCommand;

@WebServlet("/Categorycon")
public class Categorycon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Categorycon() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String category = request.getParameter("category");
		Command comm = null;
		String path = "";
		if (category.equals("new")){
			comm = new NewCommand();
		}else {
			comm=new CategoryCommand();
		}
		path = comm.exec(request, response);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
