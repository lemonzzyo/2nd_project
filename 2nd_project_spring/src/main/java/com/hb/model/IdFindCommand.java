package com.hb.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.mybatis.DAO;
import com.hb.mybatis.MemberVO;
import com.hb.mybatis.VO;

public class IdFindCommand{
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberVO vo = new MemberVO();
		vo.setName(request.getParameter("name"));
		vo.setPhone(request.getParameter("phone"));
		String result = DAO.idfind(vo);
		
		return result;
	}
}
