package info.java.servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogareAdministrator
 */
@WebServlet("/LogareAdministrator")
public class LogareAdministrator extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Administrator</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		String email = request.getParameter("email");
		String parola = request.getParameter("parola");
		if(email.equals("oana.alexandra1609@yahoo.com")&&parola.equals("admin")){
			HttpSession session = request.getSession();
			session.setAttribute("admin","true");
			request.getRequestDispatcher("NavigareAdministrator.html").include(request, response);
			request.getRequestDispatcher("AdministratorCarousel.html").include(request, response);
			
		}else{
			request.getRequestDispatcher("LogareGresita.html").include(request, response);
			out.println("<div class='container'>");
			out.println("<h3 align='center'>Email incorect sau parola incorecta!</h3>");
			out.println("<h3 align='center'>Incercati din nou:</h3>");
			request.getRequestDispatcher("AdminLogareForm.html").include(request, response);
			out.println("</div>");
		}
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}
}
