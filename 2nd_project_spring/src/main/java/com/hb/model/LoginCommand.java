package com.hb.model;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hb.mybatis.DAO;
import com.hb.mybatis.MemberVO;
import com.hb.mybatis.VO;

public class LoginCommand implements Command{
	public String exec(HttpServletRequest request, HttpServletResponse response){
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPwd(request.getParameter("pwd"));
		String result = null;
		MemberVO mem_vo = DAO.login(vo);
		
		HttpSession session = request.getSession();
		session.setAttribute("mem_vo", mem_vo);
		
		if(mem_vo != null){
			result = "/Homecon";
		}else{
			result = "loginfail.jsp";
		}
		return result;
	}
	
	
}
