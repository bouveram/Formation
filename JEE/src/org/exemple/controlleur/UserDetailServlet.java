package org.exemple.controlleur;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.exemple.model.Utilisateur;
import org.exemple.model.UtilisateurManager;

/**
 * Servlet implementation class UserDetailServlet
 */
@WebServlet("/user/detail")
public class UserDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		afficher(request,response,UtilisateurManager.getInstance().getById(Integer.parseInt(request.getParameter("id"))));
		//doGet(request, response);
	}

	protected void afficher(HttpServletRequest request, HttpServletResponse response, Utilisateur u) throws ServletException, IOException {
		System.out.println(request.getParameter("format"));

		if(request.getParameter("format") !=null) {
			PrintWriter out = response.getWriter();
			switch(request.getParameter("format")){
			case "json":
				response.setContentType("application/json");
				out.println(u.toJson());
				break;
			case "xml":
				response.setContentType("application/xml");
				out.println(u.toXml());
				break;
			default :
				break;
			}
		} else {
			request.setAttribute("user", u);
			request.getRequestDispatcher("/userDetail.jsp").forward(request, response);
		}
	}

}
