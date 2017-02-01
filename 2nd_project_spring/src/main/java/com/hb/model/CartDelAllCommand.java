package com.hb.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.mybatis.DAO;

public class CartDelAllCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String path = null;
		int result = DAO.cartdelall(id);
		if(result>0){
			path = "/Cartcon?type=cartview";
		}else{
			path = "mypage.jsp";
		}
		return path;
	}
}
