package com.vastpro.onlineexam.dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class CreateNewUser {
	public static boolean registerUser(String username, String password, String email, String roleId) {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuilder sql = new StringBuilder();
		boolean flag = false;
		sql.append("insert into users(name,password_hash,active,created_at,email,role_id)");
		sql.append("values(?,?,?,?,?,?)");
		
		try (Connection conn = CreateConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
			
			pstmt.setString(1,username);
			pstmt.setString(2,password);
			pstmt.setBoolean(3,true);
			pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			pstmt.setString(5,email);
			pstmt.setInt(6,Integer.parseInt(roleId));
			
//			pstmt.executeUpdate();
		
			 int rowsInsted = pstmt.executeUpdate(); if(rowsInsted>0) { flag=true; }
			
		}catch(SQLException e) {
			e.printStackTrace();
			flag=false;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return flag;
	}
	
	static void display() {
		try (Connection conn = CreateConnection.getConnection();){
			
			ResultSet rs =  conn.createStatement().executeQuery("select * from users");
			System.out.println("hello");
			System.out.println(rs);
			while(rs.next()) {
				
				System.out.println(rs.getString(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * public static void main(String[] args) { new
	 * CreateNewUser().registerUser("kamal", "123", "kamal raj"); display();
	 * 
	 * }
	 */
}
