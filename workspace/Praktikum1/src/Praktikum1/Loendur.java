package Praktikum1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Loendur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		   response.setContentType("text/html");
		   PrintWriter out = response.getWriter();
		   Integer count = new Integer(0);
		   String head;
		   if (session.isNew()) {
		   head = "Uus Session";
		   } else {
		   head = "Vana Session";
		   Integer oldcount =(Integer)session.getAttribute("count"); 
		   if (oldcount != null) {
		   count = new Integer(oldcount.intValue() + 1);
		   }
		   }
		   session.setAttribute("count", count);
		   out.println("<HTML><BODY BGCOLOR=\"#FDF5E6\">\n" +
		   "<H2 ALIGN=\"LEFT\">" + head + "</H2>\n" + 
		   "<TABLE BORDER=1 ALIGN=LEFT>\n"
		   + "<TR BGCOLOR=\"#FFAD00\">\n" 
		   +"  <TH>Info<TH>Sessioonide Arv\n" 
		   +"<TR>\n" +" <TD>Kokku sessioone\n" +
		   "<TD>" + count + "\n" +
		   "</TABLE>\n" 
		   +"</BODY></HTML>" );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
