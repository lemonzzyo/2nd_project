package com.hb.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hb.mybatis.CartVO;
import com.hb.mybatis.DAO;
import com.hb.mybatis.MemberVO;

public class CartDelCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberVO mem_vo = (MemberVO)session.getAttribute("mem_vo");
		String path = null;
		String[] pid = request.getParameterValues("choice");
		String id = mem_vo.getId();
		CartVO cvo = new CartVO();
		int result = 0;
		cvo.setId(id);
		for (int i = 1; i < pid.length; i++) {
			cvo.setPid(pid[i]);
			result = DAO.cartdel(cvo);
		}
		if(result>0){
			path = "/Cartcon?type=cartview";
		}else{
			path = "login.jsp";
		}

		return path;
	}
}
