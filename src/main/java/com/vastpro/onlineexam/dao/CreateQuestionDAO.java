package com.vastpro.onlineexam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vastpro.onlineexam.db.DBConnection;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * Class Name: CreateQuestionDAO
 *
 * Description: This class is responsible for creating questions and corresponding answers in the database.
 */
public class CreateQuestionDAO {

	/**
	 * AddsQuestion by getting details from request and storing into database
	 *
	 * @param req
	 *            the HttpServletRequest object containing the exam Id, mark, question text and and question number in session
	 * @return true if the questions successfully inserted, false otherwise
	 */
	public static boolean addQuestion(HttpServletRequest request) {
		boolean flag = false;
		HttpSession session = request.getSession();
		int noOfQuestion = (Integer) session.getAttribute("noOfQuestions");
		int marks = (Integer) session.getAttribute("marks");
		System.out.println("CreateQuestionDAO - no of question " + noOfQuestion);
		System.out.println("CreateQuestionDAO - each question answer " + marks);

		for (int i = 1; i <= noOfQuestion; i++) {
			String questionText = request.getParameter("question_text" + i);
			System.out.println("CreateQuestionDAO question "+i+" " + questionText);
			int examId = (Integer) (request.getSession().getAttribute("examId"));
			System.out.println("CreateQuestionDAO examId "+ examId);
			int correctOption = Integer.parseInt(request.getParameter("correct_option"+i));
			System.out.println("CreateQuestionDAO option "+i+": " + correctOption);
			StringBuilder sql = new StringBuilder();

			sql.append("insert into question(exam_id,question_text,marks)");
			sql.append("values(?,?,?)");
			sql.append("RETURNING question_id");

			try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

				pstmt.setInt(1, examId);
				pstmt.setString(2, questionText);
				pstmt.setInt(3, marks);

				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					int questionId = rs.getInt(1);
					System.out.println("Question Rows Updated: Question Id " + questionId);
					for (int j = 1; j <= 4; j++) {
						String optionText = request.getParameter("option_" + j + i);
						System.out.println("CreateQuestionDAO option text: "+j+" "+optionText);
						boolean isCorrect = j == correctOption;
						System.out.println("CreateQuestionDAO isCorrect "+isCorrect);
						StringBuilder sqlAnswer = new StringBuilder();
						sqlAnswer.append("insert into answers(question_id,option_text,is_correct)");
						sqlAnswer.append("values(?,?,?)");

						PreparedStatement pstmt2 = conn.prepareStatement(sqlAnswer.toString());

						pstmt2.setInt(1, questionId);
						pstmt2.setString(2, optionText);
						pstmt2.setBoolean(3, isCorrect);

						int rows = pstmt2.executeUpdate();
						if (rows > 0) {
							System.out.println("Answer Rows Updated : CreateQuestionDAO:" + rows);
							flag = true;
						}
					}

				}
			} catch (SQLException e) {
				System.out.println("CreateQuestionDAO addQuestion"+e.getMessage());
			
				flag = false;
			}
		}
		session.removeAttribute("marks");
		session.removeAttribute("examId");
		return flag;
	}

}
