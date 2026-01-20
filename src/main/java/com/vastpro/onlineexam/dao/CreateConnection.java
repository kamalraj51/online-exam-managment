package com.vastpro.onlineexam.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CreateConnection {
	
	public static Connection getConnection() throws SQLException, IOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties p = new Properties();
//		p.load(new FileInputStream("jdbc/connectionstring.properties"));
//		System.out.println(p.getProperty("g"));
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/onlineexam_db",
				"postgres","postgres");
		return conn;

	}
	
	public static void closeConnection(Connection c) {
		
		if(c!=null) {
			try {
				c.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
public static void closeStatement(Statement s) {
		
		if(s!=null) {
			try {

//			PreparedStatement s1 = 	(PreparedStatement)s;
			s.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
}