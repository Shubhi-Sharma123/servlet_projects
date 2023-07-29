package customer_management_project.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

	public static Connection getConnection() {

		// load driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create connection
			String url = "jdbc:mysql://localhost:3306/customer_management_project";
			String userName = "root";
			String password = "shubhi@123";
			Connection connection = DriverManager.getConnection(url, userName, password);
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
