package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection con=null;
	
	public void connectingDB() throws SQLException {
//step 1: Register the driver.
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	
//step 2: Get connection for database.
	con = DriverManager.getConnection(IPathConstant.DBURL, IPathConstant.DBusername, IPathConstant.DBpassword);
	}
	
	public void executeAndGetData(String query, int colIndex, String expData) throws SQLException {
//step 3: Create statement.
	Statement state = con.createStatement();
	
//step 4: Execute Query.
	ResultSet result = state.executeQuery(query);
	boolean flag = false;
	while(result.next())
	{
		String actual = result.getString(colIndex);
		if(actual.contains(expData))
		{
			flag=true;
			break;
		}
	}
	if(flag==true)
	{
		System.out.println("--data is verified--");
	}
	else {
		System.out.println("--data not verified--");
	}
	}
	public void closeDB() throws SQLException {
//step 5: Close connection.
	con.close();
	}

}
