package fr.epita.iam.web.controllers;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;

/**
 * Servlet implementation class Authenticate
 */
public class Authenticate extends AbstractSpringServlet  {
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LogManager.getLogger(Authenticate.class);

	@Inject
	SessionFactory sf;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authenticate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String login = request.getParameter("firstName");
		final String password = request.getParameter("password");
		LOGGER.info("trying to authenticate with that login {}", login);
		final HttpSession session = request.getSession();
		// TODO you have to implement a *REAL* authentication mechanism

		if ("ojha".equals(login)&&"ojha".equals(password)) {
			// then we are authenticated, we can move to the welcome page
			session.setAttribute("authenticated", true);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
			LOGGER.info("authenticated");


		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
			LOGGER.info("not authenticated");
			session.setAttribute("authenticated", false);
		}
	}

}
