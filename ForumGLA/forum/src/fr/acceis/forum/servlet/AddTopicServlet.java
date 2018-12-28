package fr.acceis.forum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.acceis.forum.dao.DAOPage;
import fr.acceis.forum.dao.DAOThreads;

public class AddTopicServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/addTopic.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("username") == null) {
			resp.sendRedirect("/forum/login");
		} else {
			
			try {
				String user = session.getAttribute("username").toString();
				String subject = req.getParameter("subject");
				DAOThreads.addDiscussion(subject, user);
				
				int disc = DAOThreads.idDiscussion(subject, user, -1);
				String text = req.getParameter("messageContent");
				
				DAOPage.addMessage(disc, user, text);
				resp.sendRedirect("/forum/page?id=" + Integer.toString(disc));
			} catch(Exception e) {
				System.out.println("Erreur lors de la transformation en int (addTopicServlet.doPost).");
				System.out.println(e.getMessage());
				resp.sendRedirect("/forum/home");
			}
		}
	}

	
}
