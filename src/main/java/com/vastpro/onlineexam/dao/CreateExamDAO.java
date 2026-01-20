package com.vastpro.onlineexam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import com.vastpro.onlineexam.db.DBConnection;

import jakarta.servlet.http.HttpServletRequest;

public class CreateExamDAO {
	public static boolean createExam(HttpServletRequest request) {
		int examId = Integer.parseInt(request.getParameter("exam_id"));
		String examTopic = request.getParameter("exam_topic");
		String examName = request.getParameter("exam_name");
		String description = request.getParameter("description");
		String status = request.getParameter("status");
		int pass_min_correct = Integer.parseInt(request.getParameter("pass_min_correct"));
		double total_marks = Double.parseDouble(request.getParameter("total_marks"));
		int duration_minutes =Integer.parseInt(request.getParameter("duration_minutes"));
		int created_by = Integer.parseInt(request.getParameter("user_id"));

		String sql = "insert into exam"
						+ " (exam_id,exam_topic,exam_name,description,status,pass_min_correct,total_marks,duration_minutes,created_by,created_at)"
						+ "values(?,?,?,?,?,?,?,?,?,?)";
		try (Connection conn = DBConnection.getConnection();
						PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, examId);
			pstmt.setString(2, examTopic);
			pstmt.setString(3, examName);
			pstmt.setString(4, description);
			pstmt.setString(5, status);
			pstmt.setInt(6, pass_min_correct);
			pstmt.setDouble(7, total_marks);
			pstmt.setInt(8, duration_minutes);
			pstmt.setInt(9, created_by);
			pstmt.setTimestamp(10, new Timestamp(System.currentTimeMillis()));
			int updatedRows=pstmt.executeUpdate();
			if(updatedRows>0) {
				System.out.println("Rows Updated: "+updatedRows);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
