import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	
	public int checkAuthentication(Bean b) throws SQLException {
		int flag = 0;
		String usr = b.getUsername();
		String psw = b.getPassword();
		Connection con= DBConnection.createConnection();
		PreparedStatement stmt=con.prepareStatement("select * from users where username = ? and password = ?");
		stmt.setString(1,usr);
		stmt.setString(2,psw);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			flag = 1;
		}
		else {
			flag = 0;
		}
		return flag;
	}

}
