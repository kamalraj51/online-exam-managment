package com.vastpro.onlineexam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vastpro.onlineexam.db.DBConnection;

import jakarta.servlet.http.HttpServletRequest;

public class CreateAnswerDAO {
	public static boolean addAnswer(HttpServletRequest request) {
		int question_id = Integer.parseInt(request.getParameter("question_id"));
		int answer_id = Integer.parseInt(request.getParameter("answer_id"));
		String option_text = request.getParameter("option_text");
		boolean is_correct=Boolean.valueOf(request.getParameter("is_correct"));
		
		StringBuilder sql = new StringBuilder();
		boolean flag = false;
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
