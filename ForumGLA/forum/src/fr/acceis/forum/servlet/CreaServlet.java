package fr.acceis.forum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.acceis.forum.dao.DAOUser;

public class CreaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/creationCompte.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		if (DAOUser.addUser(user, pass)) {
			int err = 0;
			session.setAttribute("err", err);
			resp.sendRedirect("/forum/login");
		} else {
			int err = 1;
			session.setAttribute("err", err);
			doGet(req, resp);
		}
	}
	
	
}
