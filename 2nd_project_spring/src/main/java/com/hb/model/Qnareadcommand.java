package com.hb.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.mybatis.DAO;
import com.hb.mybatis.QnaVO;

public class Qnareadcommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String groups=request.getParameter("groups");
		QnaVO qvo=DAO.qnaread(groups);
		
		request.setAttribute("qvo", qvo);
		return "qnaread.jsp";
	}
}
