package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
	static Connection con=null;
 public static Connection con() throws SQLException
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver is register Successfully");
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
    System.out.println("Connection is created");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
}
	
}
