package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegistracijaDAO;
import validacija.ValidacijaZaRegistraciju;

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
		
		RegistracijaDAO registracijaDao = new RegistracijaDAO();
		
		System.out.println("Pozdrav iz servleta");
		
		String userName = request.getParameter("userName");		//userName uzet iz klase registracija name = "userName"
		String password = request.getParameter("password");
		String repeatPassword = request.getParameter("repeatPassword");
		
		System.out.println("Vas username je " + userName);
		System.out.println("Vas password je " + password);
		System.out.println("Vas repeatPassword je " + repeatPassword);
		
		boolean provera = ValidacijaZaRegistraciju.proveraPasworda(password, repeatPassword);
		double novcanik = 2000;
		if (provera) {
			boolean upisanUBazu = registracijaDao.upisiUseraUBazu(userName, password, novcanik); //ubaci usera u bazu
				if (upisanUBazu) {				//ako je upisan
					response.sendRedirect("index.html");
				}else {							//ako nije upisan
					response.sendRedirect("registracija.html");	
				}
		}
		else {
			response.sendRedirect("registracija.html");		//view salje response
		}
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Pozdrav iz servleta doPost");
	}

}
