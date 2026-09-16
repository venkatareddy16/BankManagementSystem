package com.banksystem.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import java.sql.Connection;

//Example of singleton class
public class DBConnection {
	private static Connection con; // here null

	private DBConnection() {

	}

	public static Connection getConnection() throws SQLException {
		try {
			if (con == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/casestudydb", "root", "root");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	
	public static void closeConnection() {
	    try {
	        if (con != null) {  
	            con.close();
	            System.out.println("DB connection is closed");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
