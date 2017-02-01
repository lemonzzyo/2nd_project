package com.hb.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hb.mybatis.CartVO;
import com.hb.mybatis.DAO;
import com.hb.mybatis.ProductVO;
import com.hb.mybatis.MemberVO;

public class CartCntCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberVO mem_vo = (MemberVO)session.getAttribute("mem_vo");
		String pid = request.getParameter("pid");
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		int page = Integer.parseInt(request.getParameter("cPage"));
		CartVO cvo = new CartVO();
		cvo.setPid(pid);
		cvo.setCnt(cnt);
		cvo.setId(mem_vo.getId());
		
		String path = null;
		
		CartVO cvo1 = DAO.cartone(cvo);
		ProductVO pvo = DAO.p_search(pid);
		cvo1.setPoint((int)(pvo.getSaleprice()*cnt*0.1));
		cvo1.setTotal(pvo.getSaleprice()*cnt);
		cvo1.setId(mem_vo.getId());
		cvo1.setPid(pid);
		cvo1.setCnt(cnt);
		int res = DAO.cartcnt_update(cvo1);
		if(res>0){
			path = "/Cartcon?type=cartview";
		}else{
			path = "mypage.jsp";
		}
		return path;
	}
}
