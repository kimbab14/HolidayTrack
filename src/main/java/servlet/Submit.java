package servlet;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import utils.InsertHolidayInfo;

/**
 * Servlet implementation class Submit.
 */
@WebServlet("/Submit")
public class Submit extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  /**
  * @see HttpServlet#HttpServlet().
  */
  public Submit() {
    super();
  }
  
  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response).
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //Do nothing because the logic is on the doPost.
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response).
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
    response.setContentType("text/html"); 
    final Logger logger = Logger.getLogger(Submit.class.getName());
    //get the user input from the form
    try {
    String name = request.getParameter("emp");
    int empid = Integer.parseInt(request.getParameter("empnum"));
    String startdate = request.getParameter("startdate");
    String enddate = request.getParameter("enddate");
    /**
     * create a User object.
     */
    User user = new User(); 
    user.setFullname(name); 
    user.setEmpId(empid); 
    user.setStartDate(startdate);
    user.setEndDate(enddate);
    /**
     * create a InsertUserInfo object
     */
    InsertHolidayInfo insert = new InsertHolidayInfo();
    /**
     * insert user information.
     */
    insert.Holiday(user);
      /**
       * check if data is inserted into the database.
       * true - if data is inserted.
       * false - if data is not inserted.
       */
      if (insert.getInsertedValue() ? true : false) {
        //redirect to confirm.jsp 
        RequestDispatcher rd = request.getRequestDispatcher("/RequestConfirmation.jsp");
        rd.forward(request, response);
      } else {
        //create some error redirect or error message.
        logger.log(Level.SEVERE, "Can't redirect");
      }
     }catch (Exception exp){
      logger.log(Level.SEVERE, "Can't parse data.", exp);
    }
   }
}
