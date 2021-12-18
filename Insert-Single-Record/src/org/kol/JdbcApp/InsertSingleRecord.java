package org.kol.JdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//Using Statement Interface
public class InsertSingleRecord {

	public static void main(String[] args) {

				
				Connection con=null;
				Statement stmt=null;
				String qry="insert into kol.student values(3,'Tiya',95.5)";
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("class Loaded & Registered");
					
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
					System.out.println("Connection Established");
					
					stmt=con.createStatement();
					System.out.println("Statement Created Suceessfully");
					
					stmt.executeUpdate(qry);
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

