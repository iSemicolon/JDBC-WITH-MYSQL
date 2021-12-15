package org.kol.JdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 CREATE TABLE `kol`.`student` (
  `Id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `perc` DECIMAL(4,2) NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC) VISIBLE);
 
 */
public class PreparedStatementCreate {

	public static void main(String[] args) {
		
		Connection con=null;
		PreparedStatement pstmt=null;

		String qry="insert into kol.STUDENT values(?,?,?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded and Registered");

			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection Established With Db server");

			pstmt=con.prepareStatement(qry);;
			System.out.println("PreparedStatement Created Sucessfully");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally
		{
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

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
