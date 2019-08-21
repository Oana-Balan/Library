package info.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.java.dao.ClientDAO;

/**
 * Servlet implementation class ReturnareCarte
 */
@WebServlet("/ReturnareCarte")
public class ReturnareCarte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Formular Returnare Carte</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("NavigareClient.html").include(request, response);
		
		out.println("<div class='container'>");
		String id_carteS = request.getParameter("id_carte");
		int id_carte = Integer.parseInt(id_carteS);
		String id_clientS = request.getParameter("id_client");
		int id_client = Integer.parseInt(id_clientS);
		int i = ClientDAO.returnare_carte(id_carte, id_client);
		if(i > 0){
			out.println("<h3 align='center'>Carte returnata!</h3>");
		}else{
			out.println("<h3 align='center'>Cartea nu se poate returna!</h3>");
		}
		out.println("</div>");
	
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
