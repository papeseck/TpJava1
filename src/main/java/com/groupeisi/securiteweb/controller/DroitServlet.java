package com.groupeisi.securiteweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.groupeisi.securiteweb.dao.AppDroitImpl;

@WebServlet(urlPatterns = {"/droit/list", "/droit/add"})
public class DroitServlet extends HttpServlet {
	private AppDroitImpl droitdao = new AppDroitImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
        	resp.sendRedirect("../index.jsp");
        } 
        
        if (session.getAttribute("username") == null) {
        	resp.sendRedirect("../index.jsp");
        } else {
			String action = req.getServletPath();
	
			switch (action) {
			case "/droit/add":
				req.getRequestDispatcher("../WEB-INF/view/droits/add.jsp").forward(req, resp);
				break;
			case "/droit/logout":
				RequestDispatcher dispatcher = req.getRequestDispatcher("/LogoutServlet");
				dispatcher.forward(req, resp);
	
				break;
			default:
				List<Droitdto> listDroit  = droitdao.ListDriotToListDriotDto(droitdao.getAll());
				req.setAttribute("listDroit", listDroit);
	
				req.getRequestDispatcher("../WEB-INF/view/droits/list.jsp").forward(req, resp);
				break;
			}
        }
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null) {
        	resp.sendRedirect("../index.jsp");
        } 

        if (session.getAttribute("username") == null) {
        	resp.sendRedirect("../index.jsp");
        } else {		 
			String name = req.getParameter("name");
			
			Droit droit = new Droit();
			droit.setName(name);
			droitdao.save(droit);
			List<Droitdto> listDroit  = droitdao.ListDriotToListDriotDto(droitdao.getAll());
			req.setAttribute("listDroit", listDroit);
	
			req.getRequestDispatcher("../WEB-INF/view/droits/list.jsp").forward(req, resp);
        }
	
	}

}