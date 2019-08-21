package info.java.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.java.dao.AdministratorDAO;
import info.java.model.Client;

/**
 * Servlet implementation class EditClient
 */
@WebServlet("/EditClient")
public class EditClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_clientS = request.getParameter("id_client");
		int id_client = Integer.parseInt(id_clientS);
		String nume = request.getParameter("nume");
		String parola = request.getParameter("parola");
		String email = request.getParameter("email");
		String telefon = request.getParameter("telefon");
		Client client = new Client(id_client,nume,parola,email,telefon);
		AdministratorDAO.update(client);
		response.sendRedirect("StocClienti");
	}

}
