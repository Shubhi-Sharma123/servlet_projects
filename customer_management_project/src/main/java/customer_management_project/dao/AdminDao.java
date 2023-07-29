package customer_management_project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import customer_management_project.dto.Admin;

public class AdminDao {
	// insertAdmin method
	public void insertAdmin(Admin admin) {
		Connection connection = null;
		try {// step-1 load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// step-2 create connection
			String url = "jdbc:mysql://localhost:3306/customer_management_project";
			String username = "root";
			String password = "shubhi@123";
			connection = DriverManager.getConnection(url, username, password);
			/*
			 * since we are using preparedStatement instead of Statement. so the normal flow
			 * of program will be diverted.
			 */
			String insert = "insert into admin values(?,?,?)";
			// step-3 create preparedStatement
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setInt(1, admin.getAdminId());
			preparedStatement.setString(2, admin.getAdminName());
			preparedStatement.setString(3, admin.getAdminEmail());

			// step-4 execute query
			preparedStatement.execute();
		System.out.println("data............inserted");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// getById method to check passed id is present in database or not
	public int getById(int adminId) {
		int id1 = 0;
		Connection connection = null;
		try {// step-1 load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// step-2 create connection
			String url = "jdbc:mysql://localhost:3306/customer_management_project";
			String username = "root";
			String password = "shubhi@123";
			connection = DriverManager.getConnection(url, username, password);
			/*
			 * since we are using preparedStatement instead of Statement. so the normal flow
			 * of program will be diverted.
			 */
			String select = "select adminId from admin where adminId=?";
			// step-3 create preparedStatement
			PreparedStatement preparedStatement = connection.prepareStatement(select);
			preparedStatement.setInt(1, adminId);
			// step-4 execute query
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				id1 = resultSet.getInt("adminId");
			}
			return id1;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return id1;
	}

	// updateAdmin method with name and email
	public String updateAdmin(int adminId, String adminName, String adminEmail) {
		Connection connection = null;
		try {// step-1 load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// step-2 create connection
			String url = "jdbc:mysql://localhost:3306/customer_management_project";
			String username = "root";
			String password = "shubhi@123";
			connection = DriverManager.getConnection(url, username, password);
			/*
			 * since we are using preparedStatement instead of Statement. so the normal flow
			 * of program will be diverted.
			 */
			String update = "update  admin set adminName=?,adminEmail=? where adminId=?";
			// step-3 create preparedStatement
			PreparedStatement preparedStatement = connection.prepareStatement(update);
			preparedStatement.setInt(3, adminId);
			preparedStatement.setString(1, adminName);
			preparedStatement.setString(2, adminEmail);

			// step-4 execute query
			boolean b=preparedStatement.execute();
			if(b=true) {
			return "<h3 style='color:green'>data.............updated successfully</h3>";
			}
			else {
				return "<h3 style='color:red'>data........not updated successfully</h3>";
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	// deleteAdmin method
	public String deleteAdmin(int adminId) {
		Connection connection = null;
		try {// step-1 load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// step-2 create connection
			String url = "jdbc:mysql://localhost:3306/customer_management_project";
			String username = "root";
			String password = "shubhi@123";
			connection = DriverManager.getConnection(url, username, password);
			/*
			 * since we are using preparedStatement instead of Statement. so the normal flow
			 * of program will be diverted.
			 */
			String delete = "delete from admin where adminId=?";
			// step-3 create preparedStatement
			PreparedStatement preparedStatement = connection.prepareStatement(delete);
			preparedStatement.setInt(1, adminId);
			// step-4 execute query
			boolean b=preparedStatement.execute();
			if(b=true) {
			return "<h3 style='color:green'>data.............deleted</h3>";
			}else
			{
				return "<h3 style='color:red'>data....not......deleted</h3>";
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	/*
	 * loginAdmin with name and email
	 */
	// return adminId by passing adminName
	public int adminName(String adminName) {
		int id1 = 0;
		Connection connection = null;
		try {// step-1 load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// step-2 create connection
			String url = "jdbc:mysql://localhost:3306/customer_management_project";
			String username = "root";
			String password = "shubhi@123";
			connection = DriverManager.getConnection(url, username, password);
			/*
			 * since we are using preparedStatement instead of Statement. so the normal flow
			 * of program will be diverted.
			 */
			String select = "select  adminId from admin where adminName=?";
			// step-3 create preparedStatement
			PreparedStatement preparedStatement = connection.prepareStatement(select);
			preparedStatement.setString(1, adminName);
			// step-4 execute query
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				id1 = resultSet.getInt("adminId");
			}
			return id1;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return id1;
	}

	// return adminId by passing adminEmail
	public int adminEmail(String adminEmail) {
		int id2 = -1;
		Connection connection = null;
		try {// step-1 load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// step-2 create connection
			String url = "jdbc:mysql://localhost:3306/customer_management_project";
			String username = "root";
			String password = "shubhi@123";
			connection = DriverManager.getConnection(url, username, password);
			/*
			 * since we are using preparedStatement instead of Statement. so the normal flow
			 * of program will be diverted.
			 */
			String select = "select  adminId from admin where adminEmail=?";
			// step-3 create preparedStatement
			PreparedStatement preparedStatement = connection.prepareStatement(select);
			preparedStatement.setString(1, adminEmail);
			// step-4 execute query
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				id2 = resultSet.getInt("adminId");
			}
			return id2;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return id2;
	}

}