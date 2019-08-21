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
 * Servlet implementation class EditClientForm
 */
@WebServlet("/EditClientForm")
public class EditClientForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		Client client = AdministratorDAO.cautare_dupa_id(id_client);
		
		out.print("<form action='EditClient' method='post' style='width:300px'>");
		out.print("<div class='form-group'>");
		out.print("<input type='hidden' name='id_client' value='"+client.getId_client()+"'/>");
		out.print("<label for='nume1'>Nume</label>");
		out.print("<input type='text' class='form-control' value='"+client.getNume()+"' name='nume' id='nume1' placeholder='Nume'/>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='email1'>Email</label>");
		out.print("<input type='email' class='form-control' value='"+client.getEmail()+"' name='email' id='email1' placeholder='Email'/>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='password1'>Parola</label>");
		out.print("<input type='password' class='form-control' value='"+client.getParola()+"' name='parola' id='password1' placeholder='Parola'/>");
		out.print("</div>  ");
		out.print("<div class='form-group'>");
		out.print("<label for='telefon1'>Telefon</label>");
		out.print("<input type='text' class='form-control' value='"+client.getTelefon()+"' name='telefon' id='telefon1' placeholder='Telefon'/>");
		out.print("</div>");
		out.print("<button type='submit' class='btn btn-primary'>Editare</button>");
		out.print("</form>");
		
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
