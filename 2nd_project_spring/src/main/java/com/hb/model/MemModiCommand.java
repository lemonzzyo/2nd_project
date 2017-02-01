package com.hb.model;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hb.mybatis.DAO;
import com.hb.mybatis.MemberVO;
import com.hb.mybatis.VO;

public class MemModiCommand implements Command{
	public String exec(HttpServletRequest request, HttpServletResponse response){
		MemberVO vo = new MemberVO();
		int result = 0;
		vo.setId(request.getParameter("id"));
		vo.setAddr(request.getParameter("addr"));
		vo.setBirth(request.getParameter("birth"));
		vo.setEmail(request.getParameter("email"));
		vo.setPhone(request.getParameter("phone"));
		String pwd = request.getParameter("pwdchg");
		if(pwd!=""){
			vo.setPwd(request.getParameter("pwdchg"));
			result = DAO.memupdate(vo);
		}else if(pwd==""){
			vo.setPwd(request.getParameter("pwd"));
			result = DAO.memupdate(vo);
		}
		String path = null;
		MemberVO mem_vo = DAO.login(vo);
		HttpSession session = request.getSession();
		session.setAttribute("mem_vo", mem_vo);
		if(result>0){
			path = "mypage.jsp";
		}
		return path;
	}
	
	
}
