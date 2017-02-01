package com.hb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.Command;
import com.hb.model.IdFindCommand;
import com.hb.model.IdchkCommand;
import com.hb.model.LoginCommand;
import com.hb.model.LogoutCommand;
import com.hb.model.MemDelCommand;
import com.hb.model.MemModiCommand;
import com.hb.model.MemRegCommand;
import com.hb.model.MypageCommand;
import com.hb.model.PwdFindCommand;

@WebServlet("/Memcon")
public class Memcon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Memcon() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		String path = null;
		String result = null;
		Command comm = null;
		
		if(type.equals("login")){
			comm = new LoginCommand();
			path = comm.exec(request, response);
			request.getRequestDispatcher(path).forward(request, response);
			
		}else if(type.equals("memreg")){
			comm = new MemRegCommand();
			path = comm.exec(request, response);
			request.getRequestDispatcher(path).forward(request, response);
		}else if(type.equals("idchk")){
			IdchkCommand idchk = new IdchkCommand();
			result = idchk.exec(request, response);
			out.println(result);
		}else if(type.equals("delete")){
			comm = new MemDelCommand();
			path = comm.exec(request, response);
			request.getRequestDispatcher(path).forward(request, response);
		}else if(type.equals("modify")){
			comm = new MemModiCommand();
			path = comm.exec(request, response);
			request.getRequestDispatcher(path).forward(request, response);
		}else if(type.equals("mypage")){
			comm = new MypageCommand();
			path = comm.exec(request, response);
			request.getRequestDispatcher(path).forward(request, response);
		}else if(type.equals("idfind")){
			IdFindCommand idfind = new IdFindCommand();
			result = idfind.exec(request, response);
			out.println(result);
		}else if(type.equals("pwdfind")){
			PwdFindCommand pwdfind = new PwdFindCommand();
			result = pwdfind.exec(request, response);
			out.println(result);
		}else if(type.equals("logout")){
			comm = new LogoutCommand();
			path = comm.exec(request, response);
			request.getRequestDispatcher(path).forward(request, response);
		}
		
		

	}

}
