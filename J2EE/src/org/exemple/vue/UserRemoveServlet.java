package org.exemple.vue;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.exemple.model.UtilisateurManager;

/**
 * Servlet implementation class UserRemoveServlet
 */
@WebServlet("/user/remove")
public class UserRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRemoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		removeUser(request, response, Integer.parseInt(request.getParameter("id")));
		afficher(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void removeUser(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		UtilisateurManager.getInstance().remove(UtilisateurManager.getInstance().getById(id));
	}
	
	protected void afficher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>List</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Remove user</h1>");
		out.println("<p>User deleted</p>");
		out.println("<a href='list'>Back to list</a>");
	}

}
