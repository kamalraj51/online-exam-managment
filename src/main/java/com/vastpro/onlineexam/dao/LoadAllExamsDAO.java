package com.vastpro.onlineexam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.vastpro.onlineexam.db.DBConnection;
import com.vastpro.onlineexam.dto.ExamDTO;

import jakarta.servlet.http.HttpServletRequest;

public class LoadAllExamsDAO {
	public static boolean getAllExams(HttpServletRequest request) {
		List<ExamDTO> allExams = new ArrayList<ExamDTO>();
		String sqlAllExam = "SELECT exam_id, exam_name, status FROM exam ORDER BY exam_name";
		String sqlTotalQuestion = "SELECT COUNT(*) FROM question WHERE exam_id=?";

		try (Connection conn = DBConnection.getConnection();
						PreparedStatement ps = conn.prepareStatement(sqlAllExam);
						PreparedStatement pstmt = conn.prepareStatement(sqlTotalQuestion);) {
			ResultSet resultExam = ps.executeQuery();

			while (resultExam.next()) {
				ExamDTO exam = new ExamDTO();
				int examId = resultExam.getInt("exam_id");
				pstmt.setInt(1, examId);
				ResultSet resultQuestion = pstmt.executeQuery();
				while (resultQuestion.next()) {
					exam.setNumberOfQuestion(resultQuestion.getInt("count"));
				}
				exam.setExamId(resultExam.getInt("exam_id"));
				exam.setExamName(resultExam.getString("exam_name"));
				exam.setStatus(resultExam.getString("status"));
				allExams.add(exam);
			}

		} catch (Exception e) {
			System.out.println("LoadAllExamsDAO - getAllExams" + e.getMessage());
			request.getSession().setAttribute("examList", allExams);
			return false;
		}
		request.getSession().setAttribute("examList", allExams);
		return true;
	}

}
