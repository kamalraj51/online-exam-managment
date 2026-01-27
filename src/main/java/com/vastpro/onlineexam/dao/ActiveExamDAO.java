package com.vastpro.onlineexam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.vastpro.onlineexam.db.DBConnection;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Class Name: ActiveExamDAO
 *
 * Description:
 * This class is responsible for updating the exam status
 * to 'ACTIVE' in the database.
 */

public class ActiveExamDAO {
	
	 /**
     * Activates an exam by updating its status to 'ACTIVE'.
     *
     * @param req the HttpServletRequest object containing the exam name
     * @return true if the exam status is updated successfully,
     *         false otherwise
     */
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
