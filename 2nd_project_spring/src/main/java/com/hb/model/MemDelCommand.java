package com.hb.model;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hb.mybatis.DAO;
import com.hb.mybatis.VO;

public class MemDelCommand implements Command{
	public String exec(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		int result= DAO.memdel(id);
		String path = null;
		HttpSession session = request.getSession();
		session.invalidate();
		if(result>0){
			
			path = "login.jsp";
		}
		return path;
	}
	
	
}
