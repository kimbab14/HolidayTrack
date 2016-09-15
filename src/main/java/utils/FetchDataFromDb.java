package utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import bean.User;
import conn.DbConnection;
/**
 * Class that will fetch data from db
 * to be use in the datatable.
 */
public class FetchDataFromDb {
  /**
   * private constructor.
   */
  private FetchDataFromDb(){
    //private default constructor
  }
  /**
   * get a list of all data from the database
   * @return ls
   */
  public static List<User> getHolsData() {
    /**
     * Create an instance of a class DbConnection
     */
    DbConnection db = new DbConnection();
    /*
     * get database connection
     */
    db.getConnection();
    final Logger logger = Logger.getLogger(FetchDataFromDb.class.getName());
    /**
     * list all the data from the query.
     */
    List<User> ls = new LinkedList<>();
    try {
      ResultSet rs = db.getCon().prepareStatement("SELECT * FROM t_holiday ORDER BY ID DESC").executeQuery();
      while (rs.next()) {
        User n = new User(rs.getInt(1),rs.getInt(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6) );
        ls.add(n);
      }
    } catch (SQLException e) {
      logger.log(Level.SEVERE, "Please check your MySQL syntax", e);
    }
    return ls;
  }
  /*
  private User populateUserVO() {
	// TODO Auto-generated method stub
	  User user = new User();
	  user.setEmpId(rs.getInt(2));	
  }*/
  
}
