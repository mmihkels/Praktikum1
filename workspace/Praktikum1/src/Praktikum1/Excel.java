package Praktikum1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Excel extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        response.setContentType("application/vnd.ms-excel");
		        response.setHeader("Content-Disposition: attachment", 
				"filename=\"numbers.xls\"");
				response.getWriter().println("Arv1\tArv2\tSumma\tKorrutis");
				response.getWriter().println("1\t2\t=SUM(A2:B2)\t=A2*B2");
				response.getWriter().println("11\t12\t=SUM(A3:B3)\t=A3*B3");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
