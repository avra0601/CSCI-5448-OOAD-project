import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DatabaseController {
	Connection conn = null;
	  Statement stmt = null;
	   final String USER = "root";
	 final String DB_URL = "jdbc:mysql://localhost/test";
	 final String PASS = "";
	 
DatabaseController()

{
	 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	     try {
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			stmt=(Statement) conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
}
public Connection getConnection()
{
	return conn;
}
public Statement getStatement()
{
	return stmt;
}
}