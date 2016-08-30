package utils;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import bean.User;
import conn.DbConnection;

/**
 * This class will be called when the user click on the.
 * submit button
 * @author jelica60589
 */
public class InsertHolidayInfo {
 
  private PreparedStatement ps;
  DbConnection dbcon = new DbConnection();
  /**
   * check if we inserted data into the database.
   */
  private boolean isInserted = false;
  final Logger logger = Logger.getLogger(InsertHolidayInfo.class.getName());
  /**
   * method that insert information into the database.
   * @param user
   * @return user
   */
  public User Holiday(User user) { 
    try {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date sdate = dateFormat.parse(user.getStartDate());
    java.util.Date edate = dateFormat.parse(user.getEndDate());
    java.sql.Date sqlDate = new java.sql.Date(sdate.getTime());
    java.sql.Date sqlenddate = new java.sql.Date(edate.getTime());
    java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
    //connection
    dbcon.getConnection();
    ps = dbcon.getCon().prepareStatement("INSERT "
    + "INTO t_holiday "
    + "(empid, full_name, start_date, end_date, submitted_date) "
    + "VALUES (?,?,?,?,?)");
    ps.setInt(1, user.getEmpId());
    ps.setString(2, user.getFullname());
    ps.setDate(3, sqlDate);
    ps.setDate(4, sqlenddate);
    ps.setDate(5, timeNow);
 
    int check = ps.executeUpdate();
    if(check!=0){ 
      isInserted = true;
      logger.log(Level.INFO, "Record has been inserted");
    }  else {
      logger.log(Level.INFO, "No record inserted at this time");
    }
  } catch (SQLException exp) {
    logger.log(Level.SEVERE, "Can't connect to the MySQL database.", exp);
  } catch (ParseException exp) {
    logger.log(Level.SEVERE, "Can't parse Date.", exp);
  } finally {
    try {
      if (ps != null) {
        ps.close();
      }
    } catch (Exception exp) {
      logger.log(Level.SEVERE, "Exception", exp);
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
