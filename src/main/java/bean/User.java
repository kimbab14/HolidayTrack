package bean;
/**
 * User Bean that will holds the user
 * information.
 * @author jelica60589
 *
 */

public class User {
  
  /**
   * Variables.
   */
  private String username;
  private String password;
  private String fullName;
  private int empid;
  private String startDate;
  private String endDate;
  private String submittedDate;
  private int id;
  
  /**
   * Constructor for User that will be use for the 
   * fetching of the data to be displayed on the datatable.
   * @param fullname - fullname of the user
   * @param empID - employee id
   * @param startDate - start date
   * @param endDate - end date
   * @param dbID - ID
   * @param submittedDate - 
   */
  public User(int dbID , int empID, String fullname, String startDate, String endDate, String submittedDate) {
    this.fullName = fullname;
    this.empid = empID;
    this.startDate = startDate;
    this.endDate = endDate;
    this.submittedDate = submittedDate;
    this.id = dbID;
  }
  
  /**
   * another default constructor that is used
   * in the Login and Submit class.
   */
  
  public User() {
    //default constructor 
  }
 
  /**
   * set username.
   */
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  /**
   * get username.
   */
  
  public String getUsername() {
    return username;
  }
  
  /**
   * set password.
   */
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  /**
   * get password.
   */
  
  public String getPassword() {
    return password;
  }
  
  /**
   * set fullname.
   */
  
  public void setFullname(String fullname) {
    this.fullName = fullname;
  }
  
  /**
   * get fullname.
   */
  
  public String getFullname() {
    return fullName;
  }
  
  /**
   * set empid.
   */
  
  public void setEmpId(int empid) {
    this.empid = empid;
  }
  
  /**
   * get empid.
   */
  
  public int getEmpId() {
    return empid;
  }
  
  /**
   * set startdate.
   */
  
  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }
  
  /**
   * get username.
   */
  
  public String getStartDate() {
    return startDate;
  }
  
  /**
   * set enddate.
   */
  
  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }
  
  /**
   * get enddate.
   */
  
  public String getEndDate() {
    return endDate;
  }
  
  /**
   * get Submitted Date.
   * @return submittedDate
   */
  
  public String getDateSubmitted() {
    return submittedDate;
  }
  
  /**
   * Get ID from the database.
   * @return id
   */
  
  public int getID(){
    return id;
  }
}
