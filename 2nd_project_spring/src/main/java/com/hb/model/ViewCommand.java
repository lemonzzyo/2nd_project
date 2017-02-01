package com.hb.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.mybatis.DAO;
import com.hb.mybatis.ProductVO;
import com.hb.mybatis.QnaVO;
import com.hb.mybatis.ReplyVO;

public class ViewCommand{

	public String exec(HttpServletRequest request, HttpServletResponse response, String pid) {
		ProductVO vo = DAO.getView(pid);
		List<QnaVO> qnalist = DAO.getQna(pid);
		List<ReplyVO> rlist=DAO.r_list();
		request.setAttribute("qnalist", qnalist);
		request.setAttribute("replylist", rlist);
		request.setAttribute("view", vo);
		return "view.jsp";
	}

}
