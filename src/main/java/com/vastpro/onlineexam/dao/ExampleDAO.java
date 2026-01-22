package com.vastpro.onlineexam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.vastpro.onlineexam.db.DBConnection;

import jakarta.servlet.http.HttpServletRequest;

public class ExampleDAO {

	public static boolean createExam(HttpServletRequest request) {
		boolean flag = false;
		// create exam
		int examId = Integer.parseInt(request.getParameter("exam_id"));
		String examTopic = request.getParameter("exam_topic");
		String examName = request.getParameter("exam_name");
		String description = request.getParameter("description");
		String status = request.getParameter("status");
		int pass_min_correct = Integer.parseInt(request.getParameter("pass_min_correct"));
		double total_marks = Double.parseDouble(request.getParameter("total_marks"));
		int duration_minutes = Integer.parseInt(request.getParameter("duration_minutes"));
		int created_by = Integer.parseInt(request.getParameter("user_id"));

		// create question
		int questionId = Integer.parseInt(request.getParameter("question_id"));
		// int examId = Integer.parseInt(request.getParameter("exam_id"));
		String question = request.getParameter("question_text");
		int marks = Integer.parseInt(request.getParameter("marks"));

		// create answer

		int question_id = Integer.parseInt(request.getParameter("question_id"));
		int answer_id = Integer.parseInt(request.getParameter("answer_id"));
		String option_text = request.getParameter("option_text");
		boolean is_correct = Boolean.valueOf(request.getParameter("is_correct"));

		String sqlExam = "insert into exam"
				+ " (exam_id,exam_topic,exam_name,description,status,pass_min_correct,total_marks,duration_minutes,created_by,created_at)"
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sqlExam)) {
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
			int updatedRows = pstmt.executeUpdate();
			if (updatedRows > 0) {
				System.out.println("Exam Rows Inserted: " + updatedRows);
				flag=true;
			}
		} catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}
		
		//question insertion
		
		StringBuilder sqlQuestion = new StringBuilder();
		sqlQuestion.append("insert into question(question_id,exam_id,question_text,marks)");
		sqlQuestion.append("values(?,?,?,?)");
		
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sqlQuestion.toString())) {

			pstmt.setInt(1, questionId);
			pstmt.setInt(2, examId);
			pstmt.setString(3, question);
			pstmt.setInt(4,marks);

			// pstmt.executeUpdate();

			int rowsInsted = pstmt.executeUpdate();
			if (rowsInsted > 0) {
				System.out.println("Question Rows Inserted: " + rowsInsted);
				flag=true;
			}

		} catch (SQLException e) {
			flag=false;
			e.printStackTrace();
		}
		
	//answer insertion
		StringBuilder sql = new StringBuilder();
		
		sql.append("insert into answers(answer_id,question_id,option_text,is_correct)");
		sql.append("values(?,?,?,?)");
		
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

			pstmt.setInt(1,answer_id );
			pstmt.setInt(2, question_id);
			pstmt.setString(3, option_text);
			pstmt.setBoolean(4,is_correct);

			// pstmt.executeUpdate();

			int rowsInsted = pstmt.executeUpdate();
			if (rowsInsted > 0) {
				System.out.println("Answers Rows Inserted: " + rowsInsted);
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		}
		

		return flag;
	}

}
