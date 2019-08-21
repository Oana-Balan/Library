package info.java.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.java.dao.AdministratorDAO;

/**
 * Servlet implementation class DeleteCarte
 */
@WebServlet("/DeleteCarte")
public class DeleteCarte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_carteS = request.getParameter("id_carte");
		int id_carte = Integer.parseInt(id_carteS);
		AdministratorDAO.stergere_carte(id_carte);
		response.sendRedirect("StocCartiAdmin");
	}
}
