package com.hb.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.mybatis.DAO;
import com.hb.mybatis.MemberVO;

public class Selectcommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		MemberVO mvo=DAO.m_search(id);
		request.setAttribute("mvo", mvo);
		return "admin_user_modify.jsp";
	}
}
