package fr.acceis.forum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.acceis.forum.classe.Utilisateur;
import fr.acceis.forum.dao.DAOUser;

public class DescriptionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getParameter("login");
		if (param == null || param == "") {
			resp.sendRedirect("/forum/home");
		} else {
			HttpSession session = req.getSession();
			if (DAOUser.existUser(param)) {
				Utilisateur user = DAOUser.getUser(param);
				if (user == null) {
					user = new Utilisateur(param);
				}
				session.setAttribute("user", user);
				req.getRequestDispatcher("/WEB-INF/jsp/description.jsp").forward(req, resp);
			} else {
				resp.sendRedirect("/forum/home");
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
