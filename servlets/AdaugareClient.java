package info.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.java.dao.AdministratorDAO;
import info.java.model.Client;

/**
 * Servlet implementation class AdaugareClient
 */
@WebServlet("/AdaugareClient")
public class AdaugareClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Formular Adaugare Client</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("NavigareAdministrator.html").include(request, response);
		
		out.println("<div class='container'>");
		String id_clientS = request.getParameter("id_client");
		int id_client = Integer.parseInt(id_clientS);
		String nume = request.getParameter("nume");
		String parola = request.getParameter("parola");
		String email = request.getParameter("email");
		String telefon = request.getParameter("telefon");
		Client client = new Client(id_client,nume,parola,email,telefon);
		int i = AdministratorDAO.adaugare_client(client);
		if(i > 0){
			out.println("<h3 align='center'>Client adaugat!</h3>");
		}
		
		request.getRequestDispatcher("AdaugareClientForm.html").include(request, response);
		out.println("</div>");
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
		
	}

}
