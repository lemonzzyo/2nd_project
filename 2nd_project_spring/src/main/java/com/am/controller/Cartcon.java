package com.hb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.CartAddCommand;
import com.hb.model.CartBuyCommand;
import com.hb.model.CartCntCommand;
import com.hb.model.CartDelAllCommand;
import com.hb.model.CartDelCommand;
import com.hb.model.CartViewCommand;
import com.hb.model.Cartduplicatecommad;
import com.hb.model.Command;

@WebServlet("/Cartcon")
public class Cartcon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Cartcon() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String type = request.getParameter("type");
		Command comm = null;
		String path = null;
		
		if(type.equals("cartview")){
			comm = new CartViewCommand();
			path = comm.exec(request, response);
		}else if(type.equals("cartadd")) {
			comm=new CartAddCommand();
			path=comm.exec(request, response);
		}else if(type.equals("cartchk")) {
			comm=new Cartduplicatecommad();
			path=comm.exec(request, response);
		}else if(type.equals("cartdel")){
			comm = new CartDelCommand();
			path = comm.exec(request, response);
		}else if(type.equals("cartalldel")){
			comm = new CartDelAllCommand();
			path = comm.exec(request, response);
		}else if(type.equals("cartbuy")){
			comm = new CartBuyCommand();
			path = comm.exec(request, response);
		}else if(type.equals("updatecnt")){
			comm = new CartCntCommand();
			path = comm.exec(request, response);
		}	
		
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
