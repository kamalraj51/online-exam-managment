package com.vastpro.onlineexam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vastpro.onlineexam.db.DBConnection;

import jakarta.servlet.http.HttpServletRequest;

public class CreateQuestionDAO {
	public static boolean addQuestion(HttpServletRequest request) {
		int questionId = Integer.parseInt(request.getParameter("question_id"));
		int examId = Integer.parseInt(request.getParameter("exam_id"));
		String question = request.getParameter("question_text");
		int marks =  Integer.parseInt(request.getParameter("marks"));
		StringBuilder sql = new StringBuilder();
		boolean flag = false;
		sql.append("insert into question(question_id,exam_id,question_text,marks)");
		sql.append("values(?,?,?,?)");

		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

			pstmt.setInt(1, questionId);
			pstmt.setInt(2, examId);
			pstmt.setString(3, question);
			pstmt.setInt(4,marks);

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

}
