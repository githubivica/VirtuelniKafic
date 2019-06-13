package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class - RegistracioniServlet 
 */

									//PutanjaServletaZaRegistraciju - ovo je mesto gde se nalazi server

@WebServlet(description = "ovo je servlet za registraciju usera", urlPatterns = { "/PutanjaServletaZaRegistraciju" })
public class RegistracioniServlet extends HttpServlet {		//registracioni servlet
	private static final long serialVersionUID = 1L;		//long - dupli int
															//serialVersionUID - vazano za serijalizaciju
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 		request - je formirao tomcat
	 * 		response - je formirao tomcat
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Pozdrav iz servleta");
		
		String userName = request.getParameter("userName");		//userName uzet iz klase registracija name = "userName"
		String password = request.getParameter("password");
		String repeatPassword = request.getParameter("repeatPassword");
		
		System.out.println("Vas username je " + userName);
		System.out.println("Vas password je " + password);
		System.out.println("Vas repeatPassword je " + repeatPassword);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Pozdrav iz servleta doPost");
	}

}
