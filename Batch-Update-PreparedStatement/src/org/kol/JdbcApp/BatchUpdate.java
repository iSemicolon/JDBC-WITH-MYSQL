package org.kol.JdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchUpdate {


	public static void main(String[] args) {

		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		
		String inqry="INSERT INTO kol.student values(38,'joker',72.32)";
		String delqry="DELETE FROM kol.login where Name ='NANDA'";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Load and Registered ");

			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection Established ");

			pstmt=con.prepareStatement(inqry);
			System.out.println("Prepared Statement Created ");

			pstmt.addBatch();
			System.out.println("Batch Created ");

			int arr1[]=pstmt.executeBatch();
			System.out.println("Batch Executed ");

			for(int i: arr1) {
				System.out.println(i);
			}


			pstmt1=con.prepareStatement(delqry);
			pstmt.addBatch();

			int arr2[]=pstmt1.executeBatch();
			for(int j: arr2) {
				System.out.println(j);
			}


		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

				if(pstmt1!=null) {
					try {
						pstmt1.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}


					if(con!=null) {
						try {
							con.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			}
			System.out.println("Closed All Costly Resources ");
		}

	}
}
