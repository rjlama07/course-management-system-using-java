package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

	public Connection connection(String url) throws SQLException {
		return DriverManager.getConnection(url, "root", "");
	}

}
