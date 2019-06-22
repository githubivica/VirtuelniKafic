package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDAO;
import model.User;

@WebServlet(description = "Servlet za logovanje", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userName = request.getParameter("userName");		//userName uzet iz klase registracija name = "userName"
		String password = request.getParameter("password");
		
		LoginDAO loginDAO = new LoginDAO();		//povezuje loginServlet i loginDAO
		
		User user = new User();
		
		boolean proveriUsera = loginDAO.daLiPostojiUserUBazi(userName);
			if (proveriUsera) {
				
				boolean proveriPassword = loginDAO.daLiPasswordOdgovaraUseru(userName, password);
					if (proveriPassword) {	
						user = loginDAO.vratiUsera(userName);
						if (user.getRola().getUloga().equals("administrator")) {
							//posalji ga na admin page
						}else {
							//posalji ga na user page
						}
					}else {
						response.sendRedirect("login.html");
					}

			}else {
				response.sendRedirect("login.html");
			}
			
		
		
	}

}
