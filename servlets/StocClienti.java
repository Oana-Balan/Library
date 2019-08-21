package info.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.java.dao.AdministratorDAO;
import info.java.model.Client;

/**
 * Servlet implementation class StocClienti
 */
@WebServlet("/StocClienti")
public class StocClienti extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Stoc Clienti</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("NavigareAdministrator.html").include(request, response);
		
		out.println("<div class='container'>");
		List<Client> list = AdministratorDAO.stoc_clienti();
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Id_client</th><th>Nume</th><th>Parola</th><th>Email</th><th>Telefon</th><th>Editare</th><th>Stergere</th></tr>");
		for(Client client:list){
			out.println("<tr><td>"+client.getId_client()+"</td><td>"+client.getNume()+"</td><td>"+client.getParola()+"</td><td>"+client.getEmail()+"</td><td>"+client.getTelefon()+"</td><td><a href='EditClientForm?id_client="+client.getId_client()+"'>Editare</a></td><td><a href='DeleteClient?id_client="+client.getId_client()+"'>Stergere</a></td></tr>");
		}
		out.println("</table>");
		
		out.println("</div>");
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
