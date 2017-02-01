package com.hb.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.mybatis.DAO;
import com.hb.mybatis.MemberVO;

public class Listcommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		List<MemberVO> mlist=DAO.userlist();
		request.setAttribute("mlist", mlist);
		return "admin_userlist.jsp";
	}
}
