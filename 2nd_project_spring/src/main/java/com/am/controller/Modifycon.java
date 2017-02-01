package com.hb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.Modifycommand;
import com.hb.model.Prod_newcommand;
import com.hb.model.Prod_searchcommand;

@WebServlet("/Modifycon")
public class Modifycon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Modifycon() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		
		Modifycommand comm=new Modifycommand();
		String path=comm.exec(request, response);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
