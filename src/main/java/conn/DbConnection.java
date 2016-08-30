package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class used to validate the connection
 * information that we got from the DbConnectionInfo
 * class.
 * @author jelica60589
 */
public class DbConnection {
  /**
   * create an instance of the DbConnectionInfo class.
   */
  DbConnectionInfo dbConInfo = new DbConnectionInfo();
  /**
   * connection 
   */
  private Connection con;
  /**
   * method use to establish connection to the database.
   */
  public void getConnection(){
    dbConInfo.connectTodb();
  /**
   * Logger to use to log error.
   */
  final Logger logger = Logger.getLogger(DbConnection.class.getName());
    /**
     * get the value from the DbConnectionInfo class
     */
    String driver = dbConInfo.getDriver();
    String url = dbConInfo.getDbUrl();
    String username = dbConInfo.getDbUsername();
    String pass = dbConInfo.getDbPass();
    
    try {
      Class.forName(driver);
      con = DriverManager.getConnection(url, username, pass);
    } catch (ClassNotFoundException e) {
      logger.log(Level.SEVERE, "You don't have any suitable driver for MySQL database.", e);
    } catch (SQLException e) {
      logger.log(Level.SEVERE, "Can't connect to the database.", e);
    } 
  }
  
  /**
   * get connection
   * @return con
   */
  public Connection getCon(){
    return con;
  }
}
