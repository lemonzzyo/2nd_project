package com.hb.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hb.mybatis.CartVO;
import com.hb.mybatis.DAO;
import com.hb.mybatis.ProductVO;
import com.hb.mybatis.MemberVO;

public class CartBuyCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberVO mem_vo = (MemberVO)session.getAttribute("mem_vo");
		
		String path = null;
		String[] pid = request.getParameterValues("choice");
		CartVO cvo = new CartVO();
		
		ProductVO pvo = null;
		CartVO cvo1 = null;
		int res1 = 0;
		int res2 = 0;
		int res3 = 0;
		cvo.setId(mem_vo.getId());
		
		for (int j = 1; j < pid.length; j++) {
			cvo.setPid(pid[j]);
			cvo1 = DAO.cartone(cvo); // id와 pid로 CartVO 가져옴
			pvo = DAO.p_search(cvo.getPid()); // pid로 ProductVO 얻어옴
		
			mem_vo.setPoint(mem_vo.getPoint()+(int)(pvo.getSaleprice()*cvo1.getCnt()*0.1)); 
			res2 = DAO.mempoint(mem_vo); // MemberVO 포인트 업데이트
			
			pvo.setSalecnt(pvo.getSalecnt()+cvo1.getCnt());
			
			String[] cntarr=pvo.getCnt().split(", ");
			String[] sizearr=pvo.getSizearr();
			String cnt_chg="";
			for(int i=0; i<sizearr.length; i++) {
				if(sizearr[i].equalsIgnoreCase(cvo1.getPsize())) {
					System.out.println("사이즈 : "+sizearr[i]);
					System.out.println("수량 : "+cntarr[i]);
					cntarr[i]=String.valueOf(Integer.parseInt(cntarr[i])-cvo1.getCnt());
				}
				cnt_chg+=cntarr[i]+", ";
			}
			pvo.setCnt(cnt_chg);
			res3 = DAO.cartprod_update(pvo); // ProductVO cnt/sellcnt 변경
		}
		
		
		
		for (int i = 0; i < pid.length; i++) {
			cvo.setPid(pid[i]);
			res1 = DAO.cartdel(cvo);
		}
		
		
		
		
		
			
		if(res1>0){
			path = "/Cartcon?type=cartview";
		}else{
			path = "login.jsp";
		}
		
		
		
		
		

		return path;
	}
}
