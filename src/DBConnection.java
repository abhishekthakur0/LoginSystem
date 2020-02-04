import java.sql.DriverManager;
import java.sql.*;

public class DBConnection {
	
	public static Connection  createConnection() {
		Connection con = null;
		String DriverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/CollegeDatabase";
		String usr = "root";
		String psw = "root";
		try {
			
			try {
				Class.forName(DriverName);
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			con = DriverManager.getConnection(url,usr,psw);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
		
	}
	

}
