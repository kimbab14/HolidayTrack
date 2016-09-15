package servlet;

import java.io.IOException;
import java.util.logging.Level;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.logging.Logger;


import bean.User;
import utils.InsertRegistrationInfo;
import utils.Validate;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		final Logger logger = Logger.getLogger(Register.class.getName());
		try {
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(pass);
		
		InsertRegistrationInfo reg = new InsertRegistrationInfo();
		Validate validate = new Validate();
		  
		if (validate.registerCheck(user) ? true : false ) {
			  request.setAttribute("errMsg", "Username already exists.");
		      RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");
		      rd.forward(request, response);
		  }else {
			  reg.insertRegistration(user);
		  
			  if (reg.getInsertedValue() ? true : false) {
				  logger.log(Level.INFO, "Inserted data");
				 RequestDispatcher rd = request.getRequestDispatcher("RegistrationSuccess.jsp");
				  rd.forward(request, response);
			  } else {
				  logger.log(Level.INFO, "registration unsuccessful");
			  } 
		  }
		} catch (Exception ex) {
		  logger.log(Level.SEVERE, "Error occur.", ex);
		}
		
		
	}

}
