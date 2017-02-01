package com.hb.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.mybatis.DAO;
import com.hb.mybatis.ProductVO;

public class CategoryCommand implements Command{
	
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String category=request.getParameter("category");
		List<ProductVO> list = null;
		if(category.equals("sale")){
			list = DAO.getSale();
		} else {
			list = DAO.getCategory(category);
		}
		request.setAttribute("newlist", list);
		return "category.jsp";
	}

}
