package com.hb.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hb.mybatis.CartVO;
import com.hb.mybatis.DAO;
import com.hb.mybatis.ProductVO;
import com.hb.mybatis.MemberVO;

public class CartViewCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberVO mem_vo = (MemberVO)session.getAttribute("mem_vo");
		
		List<CartVO> cartlist = DAO.cartallbyid(mem_vo.getId());
		for(CartVO k : cartlist){
				ProductVO  pvo = DAO.p_search(k.getPid());
				k.setPname(pvo.getPname());
				k.setPimg(pvo.getImg());
				k.setTotal(pvo.getSaleprice()*k.getCnt());
				k.setPoint((int)(pvo.getSaleprice()*k.getCnt()*0.1));

			}

		session.setAttribute("cartlist", cartlist);

		return "cart.jsp";
	}
}
