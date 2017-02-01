package com.hb.model;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.mybatis.DAO;
import com.hb.mybatis.ProductVO;

public class Prod_searchcommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		List<ProductVO> list=DAO.p_list();
		request.setAttribute("p_list", list);
		return "admin_prodlist.jsp";
	}
}
