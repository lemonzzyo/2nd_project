package com.hb.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hb.mybatis.DAO;
import com.hb.mybatis.MemberVO;
import com.hb.mybatis.QnaVO;

public class QnaCommand implements Command{
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		MemberVO mvo=(MemberVO)session.getAttribute("mem_vo");
		String pid=request.getParameter("pid");
		if(mvo == null) {
			return "mypageFail.jsp";
		}
		
		QnaVO qvo = new QnaVO();
		qvo.setPid(pid);
		qvo.setContent(request.getParameter("content"));
		qvo.setChk("NO");
		qvo.setId(mvo.getId());
		
//		request.setAttribute("qvo", vo);
		
		DAO.insertQna(qvo);
		return "Viewcon?pid="+qvo.getPid();
	}
}
