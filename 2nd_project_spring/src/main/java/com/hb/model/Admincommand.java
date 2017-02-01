package com.hb.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hb.mybatis.DAO;
import com.hb.mybatis.ProductVO;

public class Admincommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		List<ProductVO> plist=DAO.p_list();
		session.setAttribute("plist", plist);
		return "admin_main.jsp";
	}
}
