package org.exemple.controlleur;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Page1
 */
@WebServlet("/Page1")
public class Page1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Page1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Page 1</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello Page 1</h1>");
		out.println("<p>Entrez votre nom et prenom :</p>");
		out.println("<form action='Page2' method ='POST'>");
		out.println("Prénom : <br>");
		out.println("<input type='TEXT' name='firstName'>");
		out.println("<br>");
		out.println("Nom : <br>");
		out.println("<input type='TEXT' name='lastName'>");
		out.println("<br>");
		out.println("<br>");
		out.println("<button>Envoi</button>");
		out.println("</form>");

		/*out.println("<p>Entrez votre prénom :</p>");
		out.println("<form action='Page2' method ='POST'>");
		out.println("	<input type='TEXT' name='firstName'>");
		out.println("</form>");*/
		out.println("</body>");
		out.println("</html");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
