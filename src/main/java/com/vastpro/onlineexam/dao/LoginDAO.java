package com.vastpro.onlineexam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

import com.vastpro.onlineexam.db.DBConnection;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * Class Name: LoginDAO
 *
 * Description: This DAO class handles validation of user login credentials.
 * 
 * It connects to the database, retrieves the hashed password for the given email, and verifies the input password using BCrypt.
 */
public class LoginDAO {

	/**
	 * Validates user login credentials.
	 *
	 * @param request
	 *            the HttpServletRequest object containing parameters: "email" and "password"
	 * @return true if the email exists, the account is active, and the password matches, false otherwise
	 */
	public static boolean validateLogin(HttpServletRequest request) {
		System.out.println("login called");
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String dbPassword;
		/*
		 * sql changed by kamal added String sql = "SELECT name,role_id,user_id FROM users " +
		 * "WHERE email = ? AND password_hash = ? AND active = true";
		 */
		String sql = "SELECT password_hash,name,role_id,user_id FROM users " + "WHERE email = ? AND active = true";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("name"));
				dbPassword = rs.getString("password_hash");
				// the if condition logic && added by kamal
				boolean flag = BCrypt.checkpw(password, dbPassword);
				System.out.println("LoginDAO password flag: " + flag);
				if (flag) {

					System.out.println(rs.getString("name"));
					session.setAttribute("username", rs.getString("name"));
					session.setAttribute("role", rs.getInt("role_id"));
					session.setAttribute("user_id", rs.getInt("user_id"));
					return true;
				} else {

					System.out.println("LoginDAO: Invalid password");
					request.setAttribute("loginErrorPassword", "Invalid password");
					return false;
				}
			}
			System.out.println("LoginDAO: Invalid email");
			request.setAttribute("loginErrorEmail", "Email not found");

		} catch (Exception e) {
			System.out.println("catched");
			System.out.println(e.getMessage());
		}
		return false;
	}

}
