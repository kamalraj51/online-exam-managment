package com.vastpro.onlineexam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vastpro.onlineexam.db.DBConnection;
import com.vastpro.onlineexam.dto.ExamBasedHistoryDTO;
import com.vastpro.onlineexam.dto.ExamDTO;

import jakarta.servlet.http.HttpServletRequest;

public class ListExamBasedHistoryDAO {
	public static boolean getAllUsers(HttpServletRequest request) {

		List<ExamBasedHistoryDTO> history = new ArrayList<>();
		List<ExamDTO> listOfExams=new ArrayList<ExamDTO>();
		String examIdString = (request.getParameter("adminSelectedOption") != null) ? (request.getParameter("adminSelectedOption")) : "00";
		Integer examId = Integer.parseInt(examIdString);

		System.out.println("ExamBasedHistoryDAO ExamId called: "+examId);
		String sqlExamHistory = """
					SELECT  u.name , a.start_time,  a.score, a.passed
					FROM users u join exam_attempt a
					on u.user_id = a.user_id
					where a.exam_id=?;
						     """;
		String sql = "SELECT exam_id,exam_name FROM exam";
		try (Connection conn = DBConnection.getConnection();
						PreparedStatement psmtHistory = conn.prepareStatement(sqlExamHistory);
						Statement stmt = conn.createStatement();) {

			psmtHistory.setInt(1, examId);
			
			ResultSet rs = psmtHistory.executeQuery();
			ResultSet examResult=stmt.executeQuery(sql);
			while (rs.next()) {
				ExamBasedHistoryDTO examHistory = new ExamBasedHistoryDTO();
				examHistory.setUserName(rs.getString("name"));
				examHistory.setDateTime(rs.getTimestamp("start_time"));
				examHistory.setScore(rs.getInt("score"));
				examHistory.setResult(rs.getBoolean("passed"));
				history.add(examHistory);
			}
			while(examResult.next()) {
				ExamDTO exam=new ExamDTO();
				exam.setExamId(examResult.getInt("exam_id"));
				exam.setExamName(examResult.getString("exam_name"));
				listOfExams.add(exam);
			}
			

			request.setAttribute("examBasedHistory", history);
			request.setAttribute("listOfExams", listOfExams);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("exception occured exambasedhistory");
			request.setAttribute("examBasedHistory", history);
			return false;
		}

	}
}
