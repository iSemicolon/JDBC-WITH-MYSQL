package org.kol.JdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdate {


	public static void main(String[] args) {

		Connection con=null;
		Statement stmt=null;
		String inqry="insert into kol.student values(39,'Google',88.9)";
		String upqry="update kol.STUDENT set perc=76.8 where id=39";
		String delqry="Delete from kol.student where perc=88.9 ";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Load and Registered ");

			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection Established ");

			stmt=con.createStatement();
			System.out.println("Statement Created ");

			stmt.addBatch(inqry);
			stmt.addBatch(delqry);
			stmt.addBatch(upqry);

			int arr[]=stmt.executeBatch();

			for(int i:arr)
			{
				System.out.print(arr[i]+" ");
			}
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
			System.out.println("\nClosed all costly Resources");
		}

	}

}
