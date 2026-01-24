package com.vastpro.onlineexam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.vastpro.onlineexam.db.DBConnection;

import jakarta.servlet.http.HttpServletRequest;

public class ActiveExamDAO {

	public static boolean activeExam(HttpServletRequest req) {
		String examName =req.getParameter("exam_name");
		
		boolean flag=false;
        String sql = "update exam  "
                   + "set status='ACTIVE' where exam_name = ?";
        
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
        		pstmt.setString(1, examName);
        		int rowsInsted = pstmt.executeUpdate();
    			if (rowsInsted > 0) {
    				System.out.println("ActiveExamDao Retired: " + rowsInsted);
    				flag = true;
    				return flag;
    			}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
	}
		
}
