package fr.acceis.forum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.acceis.forum.classe.*;
import fr.acceis.forum.dao.*;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("username") != null) {
			resp.sendRedirect(req.getContextPath() + "/home");
		} else {
			req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("username") != null) {
			resp.sendRedirect("/forum/home");
		} else {
			String user = req.getParameter("username");
			String pass = req.getParameter("password");
			if (DAOUser.match(user, pass)) {
				session.setAttribute("username", user);
				session.setMaxInactiveInterval(3600);
				resp.sendRedirect("/forum/home");
			}else {
				doGet(req, resp);
			}
		}
	}

}
