package com.hb.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.mybatis.DAO;

public class Blackcommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		String chk=request.getParameter("chk");
		int result=0;
		if(chk.equals("o")) {
			result=DAO.blackon(id);
		}
		else if(chk.equals("x")) {
			result=DAO.blackoff(id);
		}
		return "admin_main.jsp";
	}
}
