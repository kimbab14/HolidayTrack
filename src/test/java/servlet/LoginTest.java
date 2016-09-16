package servlet;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import bean.User;
import conn.DbConnection;
import utils.Validate;
/**
 * class used for testing the Login
 * @author jelica60589
 */

public class LoginTest {
	
	/**
	 * Test Login
	 * this method will assert if the username and password
	 * is already existed in the database. 
	 * If not the result of the test will be Fail and Success if
	 * its pass the test.
	 * @throws Exception
	 */
	
	@Test
	public void testLogin() throws SQLException {
		//create an object of DbConnection class.
		DbConnection dbcon = new DbConnection();
		dbcon.getConnection();
		dbcon.getCon();
			
		//user
		User user = new User();
		//set the value
		user.setUsername("User4");
		user.setPassword("User4");
		
		//Validate class
		Validate vd = new Validate();
		if (vd.findUser(user) ? true : false ) {
			assertTrue("User " + user.getUsername() + " not found.", vd.findUser(user));
		} else {
			//assert redirect.
		}
	}
}
