package customer_management_project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import customer_management_project.connection.JdbcConnection;


public class OwnerDao {

	// ownerId method
	public int ownerId(int ownerId) {
		int ownerPasscode = 0;

		// call the getConnection method and store the connection in Connection
		// interface
		Connection connection = JdbcConnection.getConnection();
		String select = "select ownerPasscode from owner where ownerId=? ";
		// create statement(PrepartedStatement)
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(select);

			preparedStatement.setInt(1, ownerId);
			// execute query
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ownerPasscode = resultSet.getInt("ownerPasscode");
			}
			return ownerPasscode;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// close connection
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ownerPasscode;
	}

	// ownerPassword method
	public int ownerPassword(String ownerPassword) {

		int ownerPasscode = 1;

		// call the getConnection method and store the connection in Connection
		// interface
		Connection connection = JdbcConnection.getConnection();
		String select = "select ownerPasscode from owner where ownerPassword=? ";
		// create statement(PrepartedStatement)
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(select);

			preparedStatement.setString(1, ownerPassword);
			// execute query
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ownerPasscode = resultSet.getInt("ownerPasscode");
			}
			return ownerPasscode;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// close connection
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ownerPasscode;
	}

	// displayOwners method
	public void displayOwners() {

		// call the getConnection method and store the connection in Connection
		// interface
		Connection connection = JdbcConnection.getConnection();
		String select = "select * from owner ";
		// create statement(PrepartedStatement)
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(select);

			// execute query
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getString("ownerName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// close connection
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}