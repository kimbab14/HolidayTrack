package utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import bean.User;
import conn.DbConnection;
/**
 * This class is used to register
 * a user. 
 * @author jelica60589
 *
 */
public class InsertRegistrationInfo {
  private PreparedStatement ps = null;
  //create a DbConnection object
  DbConnection db = new DbConnection();
  private boolean isInserted = false;
  final Logger logger = Logger.getLogger(InsertHolidayInfo.class.getName());
  
  /**
   * Insert data into the t_user when the user
   * pressed the user click on the register button.
   * @param user
   * @return user
   */
  public User insertRegistration(User user) {
    try {
    //get connection
    db.getConnection();
    //insert data
    ps = db.getCon().prepareStatement("INSERT "
        + "INTO t_user "
        + "(username, pass) "
        + "VALUES (?,?)");
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        int check = ps.executeUpdate();
        if(check!=0){ 
          isInserted = true;
          logger.log(Level.INFO, "Record has been inserted");
        }  else {
          logger.log(Level.INFO, "No record inserted at this time");
        }
      } catch (SQLException exp) {
        logger.log(Level.SEVERE, "Can't connect to the MySQL database.", exp);
      } finally {
        try {
          if (ps != null) {
            ps.close();
          }
        } catch (Exception e) {
          logger.log(Level.SEVERE, "Exception", e);
        }
      }
        return user;     
  }
  
  /**
   * check if the isInserted is true or false.
   * @return
   */
 public boolean getInsertedValue(){
  return isInserted;
 }
}
