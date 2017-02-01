package com.hb.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hb.mybatis.DAO;
import com.hb.mybatis.MemberVO;
import com.hb.mybatis.QnaVO;

public class ReQnaCommand implements Command{
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		QnaVO vo = new QnaVO();
		MemberVO mvo=(MemberVO)session.getAttribute("mem_vo");
		String pid=request.getParameter("pid");
		String groups=request.getParameter("groups");
		vo.setPid(pid);
		vo.setContent(request.getParameter("content"));
		vo.setChk("NO");
		vo.setId(mvo.getId());
		vo.setAdmin_num(groups);
		
		DAO.insertReQna(vo);
		return "Viewcon?pid="+vo.getPid();
	}
}
