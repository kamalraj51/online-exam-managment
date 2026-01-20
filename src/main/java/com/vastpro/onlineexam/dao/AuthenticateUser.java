package com.vastpro.onlineexam.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthenticateUser {
	public static String checkAccount(String username) {
		try (Connection conn = CreateConnection.getConnection();) {
			PreparedStatement ps = conn
					.prepareStatement("select password from users where username = ?");
			ps.setString(1, username);
			
			
			ResultSet rs =  ps.executeQuery();
			rs.next();
			
			String passworddb=rs.getString("password");
			return passworddb;
			
		
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			return null;
		}
		

	}
}
