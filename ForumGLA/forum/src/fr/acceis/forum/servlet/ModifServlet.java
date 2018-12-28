package fr.acceis.forum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.acceis.forum.classe.Utilisateur;
import fr.acceis.forum.dao.DAOUser;

public class ModifServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		Utilisateur user = DAOUser.getUser(username);
		session.setAttribute("user", user);
		req.getRequestDispatcher("/WEB-INF/jsp/modif.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String pseudo = (String) session.getAttribute("username");
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String ageStr = req.getParameter("age");
		String descr = req.getParameter("descr");
		int age = 0;
		try {
			age = Integer.parseInt(ageStr);
		}catch(Exception e) {
			System.out.println("Erreur lors de la transformation en int (ModifServlet.doPost).");
			System.out.println(e.getMessage());
		}
		if (DAOUser.setDescription(pseudo, nom, prenom, age, descr)) {
			resp.sendRedirect("/forum/profil?login=" + pseudo);
		} else {
			resp.sendRedirect("/forum/modif");
		}
	}
	
	

}
