package com.hb.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.mybatis.DAO;
import com.hb.mybatis.MemberVO;
import com.hb.mybatis.VO;

public class MemRegCommand implements Command{
	public String exec(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String email = request.getParameter("email");
		String addr = request.getParameter("addr");
		String phone = request.getParameter("phone");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setName(name);
		vo.setBirth(birth);
		vo.setEmail(email);
		vo.setAddr(addr);
		vo.setPhone(phone);
		
		int result = DAO.memreg(vo);
		return "login.jsp";
	}
}
