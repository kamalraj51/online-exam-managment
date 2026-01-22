package com.vastpro.onlineexam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.vastpro.onlineexam.db.DBConnection;

import jakarta.servlet.http.HttpServletRequest;

public class RetireExamDAO {
	public static boolean retireExam(HttpServletRequest request) {
		int exam_id =Integer.parseInt(request.getParameter("exam_id"));
		boolean flag=false;
        String sql = "update exam  "
                   + "set status='RETIRED' where exam_id = ?";
        
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
        		pstmt.setInt(1, exam_id);
        		int rowsInsted = pstmt.executeUpdate();
    			if (rowsInsted > 0) {
    				System.out.println("Retired Rows Inserted: " + rowsInsted);
    				flag = true;
    				return flag;
    			}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
	}
}
