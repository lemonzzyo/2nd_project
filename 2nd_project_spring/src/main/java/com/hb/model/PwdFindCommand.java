package com.hb.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.mybatis.DAO;
import com.hb.mybatis.MemberVO;
import com.hb.mybatis.VO;

public class PwdFindCommand{
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberVO mvo = new MemberVO();
		mvo.setId(request.getParameter("id"));
		mvo.setName(request.getParameter("pwdname"));
		mvo.setPhone(request.getParameter("pwdphone"));
		String result = DAO.pwdfind(mvo);
		
		return result;
	}
}
