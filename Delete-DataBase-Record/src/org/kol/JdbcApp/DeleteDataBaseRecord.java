package org.kol.JdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 CREATE TABLE `kol`.`student` (
  `Id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `perc` DECIMAL(4,2) NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC) VISIBLE);

 */
public class DeleteDataBaseRecord {


	public static void main(String[] args) {

		Connection con=null;
		Statement stmt=null;
		String qry="delete from  kol.student where id=29";


		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Load and Registered Successfully");


			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connected Successfully");


			stmt=con.createStatement();
			System.out.println("PlatForm connected");

			stmt.executeUpdate(qry);
			System.out.println("Deleted SucessFully");




		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally {

			if(stmt!=null)
			{
				try {
					stmt.close();
				} 
				catch (SQLException e) {
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

		System.out.println("Close Costly Resources");
	}

}
