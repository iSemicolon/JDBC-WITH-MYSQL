package org.kol.JdbcApp;

public class LoadAndRegister {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("Driver Class Loaded and Registered");
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
