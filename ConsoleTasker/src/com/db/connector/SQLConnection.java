package com.db.connector;
import java.sql.*;


public class SQLConnection {

	public static Connection getDBConnection(){
			
			Connection dbConnection = null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch(ClassNotFoundException e){
				System.out.println(e.getMessage());
			}
			
			try {
				dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tasker?useSSL=false", "root", "12345");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return dbConnection;
	
		}
}
