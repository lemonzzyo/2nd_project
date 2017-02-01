package com.hb.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.mybatis.DAO;
import com.hb.mybatis.Paging;
import com.hb.mybatis.ProductVO;

public class HomeCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		//////////////////////////////////////////////////////////
		Paging pvo = new Paging();
		// list 무조건 cPage 부터 받기
		// cPage는 현재 페이지롤 변경, null 이면 현재페이지가 기본값 1이된다.
			String cPage = request.getParameter("cPage");
			if(cPage != null){
				pvo.setNowPage(Integer.parseInt(cPage));
			}
		// 전체 게시물의 수
			pvo.setTotalRecord(DAO.getTotalCount());
			pvo.setTotalPage();
		// 현재 페이지의 시작번호와 끝번호를 구하기
		    pvo.setBegin((pvo.getNowPage() - 1) * pvo.getNumPerPage() + 1);
			pvo.setEnd((pvo.getBegin() - 1) + pvo.getNumPerPage());	
		// 현재 페이지를 이용한 블록의 시작번호와 끝번호
			pvo.setBeginPage((int) (((pvo.getNowPage() - 1) / pvo.getPagePerBlock()) * pvo.getPagePerBlock() + 1));
			pvo.setEndPage(pvo.getBeginPage() + pvo.getPagePerBlock() - 1);
		// 주의 사항 ; endPage가 totalPage보다 클수 있다.
			if (pvo.getEndPage() > pvo.getTotalPage()) {
				pvo.setEndPage(pvo.getTotalPage());
			}
		// 여러개의 파라미터값을 vo와 상관없이 매개변수로 사용하는 방법 :map형식 
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("begin", pvo.getBegin());
			map.put("end", pvo.getEnd());

			List<ProductVO> list = DAO.getList(map);
		
			request.setAttribute("pvo", pvo);
			request.setAttribute("cPage", cPage);
		
		
		
		request.setAttribute("list", list);
		return "home.jsp";
	}

}
