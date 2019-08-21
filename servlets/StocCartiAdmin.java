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
import info.java.model.Carte;

/**
 * Servlet implementation class StocCartiAdmin
 */
@WebServlet("/StocCartiAdmin")
public class StocCartiAdmin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Stoc Carti</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("NavigareAdministrator.html").include(request, response);
		
		out.println("<div class='container'>");
		List<Carte> list = AdministratorDAO.stoc_carti();
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Id_carte</th><th>Nume</th><th>Autor</th><th>Editor</th><th>Cantitate</th><th>Carti_imprumutate</th><th>Stergere</th></tr>");
		for(Carte carte:list){
			out.println("<tr><td>"+carte.getId_carte()+"</td><td>"+carte.getNume()+"</td><td>"+carte.getAutor()+"</td><td>"+carte.getEditor()+"</td><td>"+carte.getCantitate()+"</td><td>"+carte.getCarti_imprumutate()+"</td><td><a href='DeleteCarte?id_carte="+carte.getId_carte()+"'>Stergere</a></td></tr>");
		}
		out.println("</table>");
		
		out.println("</div>");
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
