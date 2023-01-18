package com.groupeisi.securiteweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.groupeisi.securiteweb.dao.AppCompteImp;
import com.groupeisi.securiteweb.dao.AppDroitImpl;

@WebServlet(urlPatterns = {"/compte/list", "/compte/add"})
public class ComptesSevlet extends HttpServlet {
	private AppCompteImp comptedao = new AppCompteImp();
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
			case "/compte/add":
				List<Droit> listdroit = droitdao.getAll();
				req.setAttribute("listdroit", listdroit);
				req.getRequestDispatcher("../WEB-INF/view/comptes/add.jsp").forward(req, resp);
				break;
			case "/compte/logout":
				RequestDispatcher dispatcher = req.getRequestDispatcher("/LogoutServlet");
				dispatcher.forward(req, resp);
	
				break;
			default:
				List<Comptedto> listCompte = comptedao.ListCompteToListCompteDto(comptedao.getAll());
				req.setAttribute("listCompte", listCompte);
	
				req.getRequestDispatcher("../WEB-INF/view/comptes/list.jsp").forward(req, resp);
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
			Comptes compte = new Comptes();
			String[] idDroits = req.getParameterValues("droit");
			List<Droit> listDroit = new ArrayList<>();
		    for (String idDroit : idDroits) {
		    	listDroit.add(droitdao.getOne(Integer.parseInt(idDroit)));
		      }
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			compte.setUserName(username);
			compte.setPassword(password);
			compte.setDroits(listDroit);
			comptedao.save(compte);
			
			List<Comptedto> listCompte = comptedao.ListCompteToListCompteDto(comptedao.getAll());
			req.setAttribute("listCompte", listCompte);
	
			req.getRequestDispatcher("../WEB-INF/view/comptes/list.jsp").forward(req, resp);
        }
		
	}	 

}