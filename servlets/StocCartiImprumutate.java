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
import info.java.model.CarteImprumutata;

/**
 * Servlet implementation class StocCartiImprumutate
 */
@WebServlet("/StocCartiImprumutate")
public class StocCartiImprumutate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Stoc Carti Imprumutate</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("NavigareAdministrator.html").include(request, response);
		
		out.println("<div class='container'>");
		List<CarteImprumutata> list = AdministratorDAO.stoc_carti_imprumutate();
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Id_carte</th><th>Id_client</th><th>Data_imprumutare</th><th>Status_returnare</th></tr>");
		for(CarteImprumutata carte:list){
			out.println("<tr><td>"+carte.getId_carte()+"</td><td>"+carte.getId_client()+"</td><td>"+carte.getData_imprumutare()+"</td><td>"+carte.getStatus_returnare()+"</td></tr>");
		}
		out.println("</table>");
		
		out.println("</div>");
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}
	
}
