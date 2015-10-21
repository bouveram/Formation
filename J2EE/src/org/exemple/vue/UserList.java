package org.exemple.vue;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.exemple.model.Utilisateur;
import org.exemple.model.UtilisateurManager;

/**
 * Servlet implementation class UserList
 */
@WebServlet("/user/list")
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		afficher(request, response, UtilisateurManager.getInstance().getAll());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void afficher(HttpServletRequest request, HttpServletResponse response, List<Utilisateur> users) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>List</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>User List</h1>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td> delete</td>");
		out.println("<td> Id</td>");
		out.println("<td> Prenom</td>");
		out.println("<td> Nom</td>");
		out.println("<td> Adresse</td>");
		out.println("<td> details</td>");
		out.println("</tr>");
		
		for(Utilisateur u : users){
			out.println("<tr>");
			out.println("<td><a href='remove?id="+u.getId()+"'> Del</a></td>");
			out.println("<td>#" + u.getId() + "</td>");
			out.println("<td>" + u.getPrenom() + "</td>");
			out.println("<td>" + u.getNom() + "</td>");
			out.println("<td>" + u.getAdresse() + "</td>");
			out.println("<td><a href='detail?id="+u.getId()+"'> detail</a></td>");
			out.println("</tr>");
		}
		out.println("<td><a href='add'>add user</a></td>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html");
	}

}
