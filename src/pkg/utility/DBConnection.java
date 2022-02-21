package pkg.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
	public static Connection getConnectionObject()
	{
		Connection connection = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return connection;
	}
}