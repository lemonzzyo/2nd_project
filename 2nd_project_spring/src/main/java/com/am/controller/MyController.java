package com.am.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hb.mybatis.DAO;

@Controller
public class MyController {
	private DAO dao;
	public DAO getDao() { return dao; }
	public void setDao(DAO dao) { this.dao = dao; }
	
	@RequestMapping("/admin.hb")
	public ModelAndView getAdminmain(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		
		return mv;
	}
	
}
