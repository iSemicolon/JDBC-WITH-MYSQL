package org.kol.JdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

//Using PreparedStatement Interface
public class InsertSingleRecord {

	public static void main(String[] args) {

		Connection con=null;
		PreparedStatement pstmt=null;

		String qry="insert into kol.student values(?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Load and Register Driver Class");

			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection Established");

			pstmt=con.prepareStatement(qry);
			System.out.println("Created Platform");

			pstmt.setInt(1,8);
			pstmt.setString(2,"Nanda");
			pstmt.setDouble(3,75.5);
			pstmt.executeUpdate();

			System.out.println("Data Inserted");


		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally {

			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

		}
		System.out.println("Costly Resource Closed");
	}

}

