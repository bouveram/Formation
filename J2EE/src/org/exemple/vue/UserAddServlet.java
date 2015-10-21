package org.exemple.vue;

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
 * Servlet implementation class UserAddServlet
 */
@WebServlet("/user/add")
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		addUser(request, response,Integer.parseInt(request.getParameter("id")), request.getParameter("prenom"),
				request.getParameter("nom"),request.getParameter("adresse"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void addUser(HttpServletRequest request, HttpServletResponse response,int id, String firstName, String lastName, String adress) throws ServletException, IOException {
		Utilisateur user = new Utilisateur();
		user.setId(id);
		user.setAdresse(adress);
		user.setNom(lastName);
		user.setPrenom(firstName);
		
		UtilisateurManager.getInstance().add(user);
		
		afficher(request, response);
	}
	
	protected void afficher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>List</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Add user</h1>");
		out.println("<p>User added</p>");
		out.println("<a href='list'>Back to list</a>");
	}

}
