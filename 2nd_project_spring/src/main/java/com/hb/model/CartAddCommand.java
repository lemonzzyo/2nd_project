package com.hb.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hb.mybatis.CartVO;
import com.hb.mybatis.DAO;
import com.hb.mybatis.MemberVO;
import com.hb.mybatis.ProductVO;
import com.hb.mybatis.VO;

public class CartAddCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberVO mem_vo = (MemberVO)session.getAttribute("mem_vo");
		ProductVO pvo=DAO.p_search(request.getParameter("pid"));
		CartVO cvo=new CartVO(); // 삽입용
		String path = null;
		
		cvo.setPid(request.getParameter("pid"));
		cvo.setId(mem_vo.getId());
		cvo.setCnt(Integer.parseInt(request.getParameter("cnt")));
		cvo.setPsize(request.getParameter("psize"));
		cvo.setSaleprice(pvo.getSaleprice());
		cvo.setPimg(pvo.getImg());
		int result = DAO.cartadd(cvo);
		
		if(result>0){
			path = "/Cartcon?type=cartview";
		}
		
		return path;
	}
}
