package org.kol.JdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionEstablished {

	public static void main(String[] args) {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded and Registered");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection Established With Db server");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally
		{
			if(con !=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			System.out.println("Costly Resources Closed");
		}
	}

}
