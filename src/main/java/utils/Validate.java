package utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import bean.User;
import conn.DbConnection;

/**
 * Class that will be use when the
 * user press the login button,
 * it will validate if the inputed
 * username and password already exists
 * @author jelica60589
 */
public class Validate {
  /**
   * PreparedStatement
   */
  private PreparedStatement ps;
  /**
   * Create an instance of the DbConnection class.
   */
  DbConnection dbcon = new DbConnection();
  /**
   * check if we inserted data into the database.
   */
  private boolean status = false;
  final Logger logger = Logger.getLogger(Validate.class.getName());
  /**
   * resutlset
   */
  private ResultSet rs;
  /**
   * method that check if the username and password
   * given exist in the database or not
   * @param user
   * @return user
   */
  public boolean findUser(User user){
    /*
     * calls the database connection
     */
    dbcon.getConnection();
    //then try to do a select statement to check the user info against the database.
    try {
      ps = dbcon.getCon().prepareStatement("SELECT "
          + "* "
          + "FROM t_user "
          + "WHERE "
          + "username= ? "
          + "AND pass= ? ");
      ps.setString(1, user.getUsername());
      ps.setString(2, user.getPassword());
      
      rs = ps.executeQuery();
      status = rs.next();
      
    } catch (SQLException e) {
     logger.log(Level.SEVERE,"Please check your SQL query.", e);
    } finally {
      try {
        if (ps != null) {
          ps.close();
        }
      } catch (Exception exp) {
        logger.log(Level.SEVERE, "Can't close the preparedstatment", exp);
      }
      try {
        if (rs != null) {
          rs.close();
        }
      } catch (Exception e){
        logger.log(Level.SEVERE, "Can't close the Resultser", e);
      }
    }
    return status;
  }
  
  public boolean registerCheck(User user) {
	  /*
	     * calls the database connection
	     */
	    dbcon.getConnection();
	    //then try to do a select statement to check the user info against the database.
	    try {
	      ps = dbcon.getCon().prepareStatement("SELECT "
	          + "* "
	          + "FROM t_user "
	          + "WHERE "
	          + "username= ? ");
	      ps.setString(1, user.getUsername());
	       rs = ps.executeQuery();
	      status = rs.next();
	      
	    } catch (SQLException e) {
	     logger.log(Level.SEVERE,"Please check your SQL query.", e);
	    } finally {
	      try {
	        if (ps != null) {
	          ps.close();
	        }
	      } catch (Exception exp) {
	        logger.log(Level.SEVERE, "Can't close the preparedstatment", exp);
	      }
	      try {
	        if (rs != null) {
	          rs.close();
	        }
	      } catch (Exception e){
	        logger.log(Level.SEVERE, "Can't close the Resultser", e);
	      }
	    }
	    return status;
  }
}
