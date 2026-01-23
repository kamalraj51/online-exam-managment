package com.vastpro.onlineexam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vastpro.onlineexam.db.DBConnection;

import jakarta.servlet.http.HttpServletRequest;

public class CreateQuestionDAO {
	public static boolean addQuestion(HttpServletRequest request) {
		boolean flag = false;
		int noOfQuestion = (Integer) request.getSession().getAttribute("questions");
		System.out.println("CreateQuestionDAO - no of question " + noOfQuestion);
		for (int i = 1; i <= noOfQuestion; i++) {
			String question = request.getParameter("question_id" + i);
			System.out.println("Question Text" + question);
			int examId = Integer.parseInt(request.getParameter("exam_id"));
			int marks = Integer.parseInt(request.getParameter("marks" + i));
			StringBuilder sql = new StringBuilder();

			sql.append("insert into question(exam_id,question_text,marks)");
			sql.append("values(?,?,?)");
			sql.append("RETURNING question_id");

			try (Connection conn = DBConnection.getConnection();
							PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

				pstmt.setInt(1, examId);
				pstmt.setString(2, question);
				pstmt.setInt(3, marks);

				// pstmt.executeUpdate();

				// int rowsInsted = pstmt.executeUpdate();
				// if (rowsInsted > 0) {
				// System.out.println("Question Rows Inserted: " + rowsInsted);
				// flag = true;
				// }
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					int questionId = rs.getInt(1);
					System.out.println("Question Rows Updated: Question Id " + questionId);
					for (int j = 1; j <=4; j++) {
						String option_text = request.getParameter("option_" + j+i);
						Boolean is_correct = Boolean.valueOf(request.getParameter("correct_option_"+j+i));
						//syso
						System.out.println("Create question before valueof(): "+request.getParameter("correct_option_"+j+i));
						System.out.println("Create question after valueof(): "+is_correct);
						//
						StringBuilder sqlAnswer = new StringBuilder();
						sqlAnswer.append("insert into answers(question_id,option_text,is_correct)");
						sqlAnswer.append("values(?,?,?)");

						PreparedStatement pstmt2 = conn.prepareStatement(sqlAnswer.toString());

						pstmt2.setInt(1, questionId);
						pstmt2.setString(2, option_text);
						pstmt2.setBoolean(3, is_correct);

						int rows = pstmt2.executeUpdate();
						if (rows > 0) {
							System.out.println("Answer Rows Updated : CreateQuestionDAO:" + rows);
							flag = true;
						}
					}

				}

			} catch (SQLException e) {
				e.printStackTrace();
				flag = false;
			}
		}
		return flag;
	}

}
