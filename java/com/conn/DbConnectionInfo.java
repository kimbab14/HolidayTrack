package com.conn;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * class which is used to get the info
 * from the config.properties.
 */
public class DbConnectionInfo {
  /**
  * String variables use to hold the 
  * value of the key
  */
  private String driver;
  private String dburl;
  private String dbusername;
  private String dbpass;

  /**
  * Method that will get value of the key in the
  * config.properties
  */
  public void connectTodb() {
    Properties prop = new Properties();
    InputStream input;
    /**
     * name of the config.properties.
     */
    String propFileName = "config.properties";
    /**
     * Logger to use to log error.
     */
    final Logger logger = Logger.getLogger(DbConnectionInfo.class.getName());
    /*
     * get .properties file location
     */
    input = getClass().getClassLoader().getResourceAsStream(propFileName);
    // load a properties file
    try {
      prop.load(input);
    } catch (IOException exp) {
      logger.log(Level.SEVERE, "Please check your config.properties location", exp);
    }
    // get the property value
    driver = prop.getProperty("DRIVER_CLASS_NAME");
    dburl = prop.getProperty("URL_CONNECTION");
    dbusername = prop.getProperty("DB_USERNAME");
    dbpass = prop.getProperty("DB_PASSWORD");
  }

  /*
   * get driver value
  */
  public String getDriver() {
    return this.driver;
  }

  /*
   * get dburl value
  */
  public String getDbUrl() {
    return this.dburl;
  }

  /*
  * get dbusername value
  */
  public String getDbUsername() {
    return this.dbusername;
  }

  /*
  * get dbpass value
  */
  public String getDbPass() {
    return this.dbpass;
  }

}
