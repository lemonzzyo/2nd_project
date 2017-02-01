package com.hb.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hb.mybatis.DAO;
import com.hb.mybatis.MemberVO;
import com.hb.mybatis.ReplyVO;

public class ReplyCommand implements Command{
   public String exec(HttpServletRequest request, HttpServletResponse response) {
      HttpSession session=request.getSession();
      MemberVO mvo=(MemberVO)session.getAttribute("mem_vo");
      String pid=request.getParameter("pid");
      if(mvo == null) {
         return "mypageFail.jsp";
      }
      
      
      ReplyVO rvo = new ReplyVO();
      rvo.setPid(pid);
      rvo.setRcontent(request.getParameter("content"));
      rvo.setEval(request.getParameter("eval"));
      rvo.setId(mvo.getId());
      
      DAO.insertReply(rvo);
      return "Viewcon?pid="+rvo.getPid();
   }
}