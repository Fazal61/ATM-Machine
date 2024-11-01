package atm.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Conn {

	Connection con;
	Statement s;

	Conn() throws SQLException{

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql:///BankManagementSystem",
					"root","root");
			s=con.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
