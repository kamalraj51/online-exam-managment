package com.vastpro.onlineexam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

import com.vastpro.onlineexam.db.DBConnection;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;


/**
 * Class Name: LoginDAO
 *
 * Description:
 * This DAO class handles validation of user login credentials.
 * 
 * It connects to the database, retrieves the hashed password for the given email,
 * and verifies the input password using BCrypt.
 */
public class LoginDAO {
	
    /**
     * Validates user login credentials.
     *
     * @param request the HttpServletRequest object containing parameters:
     *                "email" and "password"
     * @return true if the email exists, the account is active, and the password matches,
     *         false otherwise
     */
	public static boolean validateLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String dbPassword;
        /*sql changed by kamal added 
        String sql = "SELECT name,role_id,user_id FROM users "
                   + "WHERE email = ? AND password_hash = ? AND active = true";
  */
        String sql = "SELECT password_hash,name,role_id,user_id FROM users "
                + "WHERE email = ? AND active = true";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
//            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	System.out.println(rs.getString("name"));
            	dbPassword = rs.getString("password_hash");
            	//the if condition logic && added by kamal
            	boolean flag = BCrypt.checkpw( password,dbPassword);
            	System.out.println("LoginDAO password flag: "+flag);
            	if(BCrypt.checkpw( password,dbPassword)) {
            	
            		System.out.println(rs.getString("name"));
            		session.setAttribute("username", rs.getString("name"));
            		session.setAttribute("role", rs.getInt("role_id"));
            		session.setAttribute("user_id", rs.getInt("user_id"));
            		return true;
            	}
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
