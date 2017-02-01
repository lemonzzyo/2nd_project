package com.hb.model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.mybatis.DAO;
import com.hb.mybatis.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Prod_updatecommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		ProductVO pvo=new ProductVO();
		String path=request.getServletContext().getRealPath("/img");
		MultipartRequest mr;
		try {
			mr = new MultipartRequest(request, path, 500*1024*1024,"utf-8",new DefaultFileRenamePolicy());
			pvo.setPid(mr.getParameter("pid"));
			String[] size=mr.getParameterValues("p_size");
			String str="";
			String img="";
			String cnt="";
			
			pvo.setPname(mr.getParameter("p_name"));
			pvo.setPrice(Integer.parseInt(mr.getParameter("p_price")));
			pvo.setSaleprice(Integer.parseInt(mr.getParameter("p_saleprice")));
			if(pvo.getPrice() == pvo.getSaleprice()) {
				pvo.setEvent("x");
			}
			else {
				pvo.setEvent("o");
			}
			
			if (mr.getFile("big_img") != null) {
				pvo.setImg(mr.getFilesystemName("big_img"));
			} else {
				pvo.setImg("");
			}
			
			String[] imgarr={"small_img",
					"img1",
					"img2",
					"img3",
					"img4"};
			
			for(int i=0; i<imgarr.length;i++) {
				if(mr.getFile(imgarr[i]) != null) {
					img+=mr.getFilesystemName(imgarr[i])+", ";
				}
				else {
					img+=", ";
				}
			}
			pvo.setSubimg(img);
			
			pvo.setCategory(mr.getParameter("p_category"));
			
			for(int i=0;i<size.length; i++) {
				str+=size[i]+", ";
			}
			pvo.setPsize(str);
			
			pvo.setContent(mr.getParameter("p_content"));
			
			String[] cntarr={mr.getParameter("p_num_s"),
					mr.getParameter("p_num_m"),
					mr.getParameter("p_num_l")};
			for(int i=0; i<cntarr.length; i++) {
				if(cntarr[i]==null) continue;
				else cnt+=cntarr[i]+", ";
			}
			pvo.setCnt(cnt);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("pvo", pvo);
		int result=DAO.p_update(pvo);
		
		return "admin_main.jsp";
	}
}
