package com.hb.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hb.mybatis.MemberVO;

public class MypageCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String path = null;
		HttpSession session = request.getSession();
		MemberVO mem_vo = (MemberVO)session.getAttribute("mem_vo");
		if(mem_vo==null){
			path = "mypageFail.jsp";
		}else if(mem_vo!=null){
			path = "mypage.jsp";
		}
		return path;
	}
}
