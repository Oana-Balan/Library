package info.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.java.dao.AdministratorDAO;
import info.java.model.Carte;

/**
 * Servlet implementation class AdaugareCarte
 */
@WebServlet("/AdaugareCarte")
public class AdaugareCarte extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Formular Adaugare Carte</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("NavigareAdministrator.html").include(request, response);
		
		out.println("<div class='container'>");
		String id_carteS = request.getParameter("id_carte");
		int id_carte = Integer.parseInt(id_carteS);
		String nume = request.getParameter("nume");
		String autor = request.getParameter("autor");
		String editor = request.getParameter("editor");
		String cantitateS = request.getParameter("cantitate");
		int cantitate = Integer.parseInt(cantitateS);
		Carte carte = new Carte(id_carte,nume,autor,editor,cantitate);
		
		int i = AdministratorDAO.adaugare_carte(carte);
		if(i > 0){
			out.println("<h3 align='center'>Carte adaugata!</h3>");
		}
		request.getRequestDispatcher("AdaugareCarteForm.html").include(request, response);
		out.println("</div>");
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
		
	}

}
