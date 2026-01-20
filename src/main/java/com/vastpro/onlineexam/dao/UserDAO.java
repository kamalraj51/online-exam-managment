package com.vastpro.onlineexam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.vastpro.onlineexam.db.DBConnection;

import jakarta.servlet.http.HttpServletRequest;

public class UserDAO {
	
	public static boolean validateLogin(HttpServletRequest request) {
			
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String sql = "SELECT name,role_id FROM users "
                   + "WHERE email = ? AND password_hash = ? AND active = true";
  
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	System.out.println(rs.getString("name"));
            	if(rs.getString("name")!=null) {
            		System.out.println(rs.getString("name"));
            		request.setAttribute("role", rs.getInt("role_id"));
            		return true;
            	}
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
