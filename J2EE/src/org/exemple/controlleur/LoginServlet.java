package org.exemple.controlleur;

import java.io.IOException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.exemple.model.Utilisateur;
import org.exemple.model.UtilisateurManager;
import org.exemple.service.Validate;

/**
 * Servlet implementation class Login
 */
@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String login = request.getParameter("login");
		String pwd = request.getParameter("password");
		Utilisateur u = Validate.checkUser(login, pwd);
		
		if (u!=null) {
			request.getSession().setAttribute("user", u);
			//if(request.getRequestURI() == "/J2EE/user/login") {
				response.sendRedirect("list");
			//} else {
			//	System.out.println(request.getRequestURI());
			//	response.sendRedirect(request.getRequestURI());
			//}
			//request.getRequestDispatcher("/user/list").forward(request, response);
		} else {

			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
