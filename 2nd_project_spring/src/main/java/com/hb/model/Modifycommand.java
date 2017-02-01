package com.hb.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.mybatis.DAO;
import com.hb.mybatis.ProductVO;

public class Modifycommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String pid=request.getParameter("pid");
		ProductVO pvo=DAO.p_search(pid);
		request.setAttribute("pvo", pvo);
		return "admin_prod_modify.jsp";
	}
}
