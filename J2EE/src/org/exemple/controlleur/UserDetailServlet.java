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
		afficher(request,response,UtilisateurManager.getInstance().getById(Integer.parseInt(request.getParameter("id"))));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void afficher(HttpServletRequest request, HttpServletResponse response, Utilisateur u) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>List</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>User List</h1>");
		out.println("<form action='update' method ='POST'>");
			out.println("<table>");
			out.println("<tr><td><label>Id</label></td><td><input type='TEXT' name='id' value ='" + u.getId() + "'></td></tr>");
			out.println("<tr><td><label>Prenom</label></td><td><input type='TEXT' name='prenom' value ='" + u.getPrenom() + "'></td></tr>");
			out.println("<tr><td><label>Nom</label></td><td><input type='TEXT' name='nom' value='" + u.getNom() + "'></td></tr>");
			out.println("<tr><td><label>Adresse</label></td><td><input type='TEXT' name='adresse' value='" + u.getAdresse() + "'></td></tr></table>");
			out.println("<br><button>Update</button></form>");
			out.println("<br><a href='list'>Back to list</a>");
		out.println("</body>");
		out.println("</html");
	}

}
