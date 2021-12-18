package org.kol.JdbcApp;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

//Using Statement Interface
public class InsertMultipleRecord {


	public static void main(String[] args) {

		Connection con=null;
		Statement stmt=null;

		String qry1="insert into kol.student values(1,'PALASH',25.5)";
		String qry2="insert into kol.student values(2,'AKSHAY',35.5)";
		String qry3="insert into kol.student values(3,'VENKATA',45.5)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("class Loaded & Registered");

			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection Established");

			stmt=con.createStatement();
			System.out.println("Statement Created Suceessfully");	

			stmt.executeUpdate(qry1);
			stmt.executeUpdate(qry2);
			stmt.executeUpdate(qry3);

			System.out.println("Statement Executed Suceessfully");



		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally {

			if(stmt!=null)
			{
				try {
					stmt.close();
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

		System.out.println("Closed All Costly Resources");
	}

}



