package Praktikum1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Vastaja extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print(
				"<form method='POST' action='/Praktikum1/Vastaja'>" +
				" <input name='name' />" +
				" <input type='submit' value='Sisesta nimi ja vajuta'/>" +
				"</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		   String nimi = request.getParameter("name");
		   response.getWriter().println("Tere  "+nimi);
	}

}
