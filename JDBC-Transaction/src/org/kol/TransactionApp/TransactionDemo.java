package org.kol.TransactionApp;
import java.util.Scanner;

import java.sql.*;

public class TransactionDemo {

	public static void main(String[] args) {

		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;

		String sedu="INSERT INTO kol.studentedu values(?,?,?)";
		String sper="Insert into btmj.studentper values(?,?,?,?)";

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Id");
		int id=sc.nextInt();

		System.out.println("Enter Name");
		String name=sc.next();

		System.out.println("Enter Percentage");
		double perc=sc.nextDouble();

		System.out.println("Enter Place");
		String place=sc.next();

		System.out.println("Enter Department");
		String dept=sc.next();
		sc.close();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");

			pstmt=con.prepareStatement(sedu);

			con.setAutoCommit(false);
			pstmt.setInt(1,id);
			pstmt.setString(2,name);
			pstmt.setDouble(3,perc);

			pstmt.executeUpdate();
			System.out.println("Student Educational details Updated");

			pstmt1=con.prepareStatement(sper);
			pstmt1.setInt(1,id);
			pstmt1.setString(2, name);
			pstmt1.setString(3, dept);
			pstmt1.setString(4, place);

			pstmt1.executeUpdate();
			System.out.println("Student Personal Details Updated");
			con.commit();

		} catch (ClassNotFoundException | SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		finally {
			if(pstmt1!=null)
			{
				try {
					pstmt1.close();
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
					System.out.println("RollBack Start");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
