package fr.acceis.forum.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.acceis.forum.dao.DAOPage;
import fr.acceis.forum.classe.*;

public class PageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getParameter("id");
		HttpSession session = req.getSession();
		int disc = -1;
		
		try {
			disc = Integer.parseInt(param);
		} catch(Exception e) {
			System.out.println("Erreur lors de la transformation en int (PageServlet.doGet).");
			System.out.println(e.getMessage());
		}
		if (disc > 0) {
			String titre = DAOPage.getSujet(disc);
			if (titre != null) {
				ArrayList<Message> msgs =  DAOPage.getListeMessage(disc);
				session.setAttribute("titre", titre);
				session.setAttribute("messages", msgs);
				req.getRequestDispatcher("/WEB-INF/jsp/thread.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("/WEB-INF/jsp/noDiscussion.jsp").forward(req, resp); //Ceci ne sert pas (Page easter egg)
			}
		} else {
			resp.sendRedirect("/forum/home");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
