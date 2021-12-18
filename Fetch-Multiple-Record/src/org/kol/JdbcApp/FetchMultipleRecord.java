package org.kol.JdbcApp;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//Using PreparedStatement Interface

public class FetchMultipleRecord {


	public static void main(String[] args) {

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String qry="select * from kol.student";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Load Register Class");

			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Established Connection");

			pstmt=con.prepareStatement(qry);
			System.out.println("Create Platform");

			rs=pstmt.executeQuery();
			System.out.println("Execute SQL queries");

			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString("name");
				double perc=rs.getDouble("perc");

				System.out.println(id+" "+" "+name+" "+perc);
			}


		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally
		{
			if(con!=null)
			{
				try {
					con.close();
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
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Close All Costly Resources");
	}

}
