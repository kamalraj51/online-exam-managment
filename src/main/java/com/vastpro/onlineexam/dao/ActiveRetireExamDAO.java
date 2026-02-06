package com.vastpro.onlineexam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.vastpro.onlineexam.db.DBConnection;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Class Name: ActiveRetireExamDAO
 *
 * Description: This class is responsible for updating the exam status to 'ACTIVE' in the database.
 */

public class ActiveRetireExamDAO {

	/**
	 * Activates an exam by updating its status to 'ACTIVE'.
	 *
	 * @param req
	 *            the HttpServletRequest object containing the exam name
	 * @return true if the exam status is updated successfully, false otherwise
	 */
	public static boolean activeRetireExam(HttpServletRequest req) {
		String examName = req.getParameter("examName");
		String status = req.getParameter("actions");
		System.out.println("ActiveExamDAO - examName:" + examName);
		boolean flag = false;
		String sql = "update exam set status=? where exam_name = ?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			if (status.equalsIgnoreCase("active")) {
				pstmt.setString(1, status.toUpperCase());
				pstmt.setString(2, examName);
			} else {
				pstmt.setString(1, status);
				pstmt.setString(2, examName);
			}
			int rowsInsted = pstmt.executeUpdate();
			if (rowsInsted > 0) {
				System.out.println("ActiveExamDao Retired: " + rowsInsted);
				flag = true;
				return flag;
			}
		} catch (Exception e) {
			System.out.println("ActiveRetireExamDAO - activeRetireExam : ");
			e.printStackTrace();
		}
		return flag;
	}
}
