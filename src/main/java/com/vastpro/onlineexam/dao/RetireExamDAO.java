package com.vastpro.onlineexam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.vastpro.onlineexam.db.DBConnection;

import jakarta.servlet.http.HttpServletRequest;
/**
 * Class Name: RetireExamDAO
 *
 * Description:
 * This DAO class handles updating the exam status to 'RETIRED'
 * in the database for a given exam name.
 */
public class RetireExamDAO {
	/**
     * Retires an exam by updating its status to 'RETIRED'.
     *
     * @param request the HttpServletRequest object containing
     *                the exam name to retire
     * @return true if the exam status is updated successfully,
     *         false otherwise
     */
	public static boolean retireExam(HttpServletRequest request) {
//		int exam_id =Integer.parseInt(request.getParameter("exam_id"));
		String examName =request.getParameter("exam_name");
		
		boolean flag=false;
        String sql = "update exam  "
                   + "set status='RETIRED' where exam_name = ?";
        
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
        		pstmt.setString(1, examName);
        		int rowsInsted = pstmt.executeUpdate();
    			if (rowsInsted > 0) {
    				System.out.println("RetiredExamDao Retired: " + rowsInsted);
    				flag = true;
    				return flag;
    			}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
	}
}
