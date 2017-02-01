package com.hb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.Blackcommand;
import com.hb.model.Listcommand;

@WebServlet("/Blackcon")
public class Blackcon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Blackcon() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		Blackcommand comm=new Blackcommand();
		String path = comm.exec(request, response);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
