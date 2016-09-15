package servlet;

import static org.junit.Assert.*;

import java.sql.SQLException;
import org.junit.Test;

import bean.User;
import conn.DbConnection;
import utils.InsertRegistrationInfo;
import utils.Validate;

/**
 * Class used to test the Register section.
 * @author jelica60589
 *
 */

public class RegisterTest {
	//create an object of DbConnection class.
	DbConnection dbcon = new DbConnection();
	User user = new User();	
		
	@Test
	public void Register() throws SQLException  {
		
		dbcon.getConnection();
		//returns connection
		dbcon.getCon();
					
		//set the value
		user.setUsername("User4");
		user.setPassword("user4");
			
		assertNotNull(user);
		equals(user);
			
		//Validate class
		Validate vd = new Validate();
		  if (vd.registerCheck(user) ? true : false ) {
			  assertFalse("User " + user.getUsername() + " already registered.", vd.registerCheck(user));
		  }	else {
			  InsertRegistrationInfo reg = new InsertRegistrationInfo();
			  reg.insertRegistration(user);
			
			  if (reg.getInsertedValue() ? true : false) {
				  assert(reg.getInsertedValue());
			  }
		  }
	}
	
  /*@Before
	public void InsertData() throws SQLException {
		dbcon.getConnection();
		dbcon.getCon();
		
		user.setUsername("User1");
		user.setPassword("pass");
		
	  InsertRegistrationInfo reg = new InsertRegistrationInfo();
		  reg.insertRegistration(user);
		
		if (reg.getInsertedValue() ? true : false) {
			  assert(reg.getInsertedValue());
	}
  }*/
}
