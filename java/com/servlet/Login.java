package com.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.utils.Validate;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 //all code will be on the doPost
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
  @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    Validate validate = new Validate();
    final Logger logger = Logger.getLogger(Login.class.getName());
  
    String username =  request.getParameter("username");
    String password = request.getParameter("pass");
    
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    
    if (validate.findUser(user) ? true : false ) {
      //if true then redirect to holiday tracker page
      RequestDispatcher rs = request.getRequestDispatcher("/SelectButton.jsp");
      try {
      rs.forward(request, response);
      } catch (Exception e) {
        logger.log(Level.WARNING, "Can't forward request and response.", e);
      }
    } else {
      //else Register or stay on the same, tell
      //the user that we can't find the information 
      //on the database and do register.
      logger.log(Level.WARNING, "Can't validate user.");
    }
	}

}
