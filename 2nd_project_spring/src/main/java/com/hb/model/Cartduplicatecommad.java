package com.hb.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hb.mybatis.CartVO;
import com.hb.mybatis.DAO;
import com.hb.mybatis.MemberVO;

public class Cartduplicatecommad implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		CartVO cart = new CartVO();
		MemberVO mvo=(MemberVO)session.getAttribute("mem_vo");
		String path="";
		String pid=request.getParameter("pid");
		cart.setPid(pid);
		cart.setId(mvo.getId());
		CartVO cvo=DAO.cartone(cart);
		if(cvo==null) {
			path="/Cartcon?type=cartadd&pid="+pid;
		}
		else {
			path="cart_duplicate.jsp";
		}
		return path;
	}
}
