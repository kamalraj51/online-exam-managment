package com.vastpro.onlineexam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.mindrot.jbcrypt.BCrypt;

import com.vastpro.onlineexam.db.DBConnection;

import jakarta.servlet.http.HttpServletRequest;
/**
 * Class Name: CreateNewUserDAO
 *
 * Description:
 * This DAO class handles the registration of new users
 * by inserting user details into the database.
 * Passwords are securely hashed using BCrypt before storage.
 */
public class CreateNewUserDAO {
	/**
     * Registers a new user in the database.
     *
     * @param request the HttpServletRequest object containing
     *                username, password, email, and role ID
     * @return true if the user is successfully inserted into the database,
     *         false otherwise
     */
	public static boolean registerUser(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String encryptPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));
		System.out.println("CreateNewUserDAO encryptPassword: "+encryptPassword);
		String email = request.getParameter("email");
		String roleId = request.getParameter("role_id");
		StringBuilder sql = new StringBuilder();
		boolean flag = false;
		sql.append("insert into users(name,password_hash,active,created_at,email,role_id)");
		sql.append("values(?,?,?,?,?,?)");

		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

			pstmt.setString(1, username);
			pstmt.setString(2, encryptPassword);
			pstmt.setBoolean(3, true);
			pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			pstmt.setString(5, email);
			pstmt.setInt(6, Integer.parseInt(roleId));

			// pstmt.executeUpdate();

			int rowsInsted = pstmt.executeUpdate();
			if (rowsInsted > 0) {
				System.out.println("Rows Inserted: " + rowsInsted);
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		}

		return flag;
	}

	static void display() {
		try (Connection conn = DBConnection.getConnection();) {

			ResultSet rs = conn.createStatement().executeQuery("select * from users");
			System.out.println("hello");
			System.out.println(rs);
			while (rs.next()) {

				System.out.println(rs.getString(1));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * public static void main(String[] args) { new CreateNewUser().registerUser("kamal", "123", "kamal raj"); display();
	 * 
	 * }
	 */
}
