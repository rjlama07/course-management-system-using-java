package Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnector {
	public PreparedStatement  pst(String qur) throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/coursemanagementsystem", "root", "");
		String query=qur;
		PreparedStatement pst=con.prepareStatement(query);
		return pst;	
	}
}
