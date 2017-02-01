package com.hb.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.mybatis.DAO;
import com.hb.mybatis.ProductVO;

public class SearchCommand{

	public String exec(HttpServletRequest request, HttpServletResponse response, String name) {
		List<ProductVO> list = DAO.getSearch(name);
		request.setAttribute("searchlist", list);
		return "search.jsp";
	}

}
