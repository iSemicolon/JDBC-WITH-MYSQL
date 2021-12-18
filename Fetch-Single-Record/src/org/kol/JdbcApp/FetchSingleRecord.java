package org.kol.JdbcApp;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//Using PreparedStatement Interface

public class FetchSingleRecord {

	public static void main(String[] args) {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String qry="Select * from kol.Student";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Load and Register Driver");

			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection Established");

			pstmt=con.prepareStatement(qry);
			System.out.println("Platfrom Created");

			rs=pstmt.executeQuery();
			System.out.println("SQL query Executed");

			if(rs.next())
			{
				int id= rs.getInt("id");
				String name=rs.getString(2);
				double perc=rs.getDouble(3);
				System.out.println(id+" "+name+" "+perc);
			}



		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}


		finally {
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

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

		System.out.println("Costly Resources Closed");
	}

}
