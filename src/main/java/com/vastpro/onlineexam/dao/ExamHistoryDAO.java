package com.vastpro.onlineexam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vastpro.onlineexam.db.DBConnection;
import com.vastpro.onlineexam.dto.UserBasedHistoryDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class ExamHistoryDAO {

	public static boolean getExamsHistoryByUserId(HttpServletRequest request) {
		List<UserBasedHistoryDTO> history = new ArrayList<>();
		List<String> topics = new ArrayList<>();
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("user_id");

//		int userId = id;

		System.out.println("exam history dao userId: " + userId);
		String sqlUserHistory = """
				        SELECT a.start_time,e.exam_id, e.exam_topic, e.exam_name, e.description, e.duration_minutes, e.total_marks, e.pass_min_correct, e.created_by, e.status,
				a.start_time, a.end_time, a.score, a.passed, a.user_id
				FROM exam e join exam_attempt a
				on e.exam_id = a.exam_id
				where a.user_id=?;
				     """;
		//sql for display topics
		String sql = "SELECT exam_topic FROM exam WHERE status = 'ACTIVE'";
		
		
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement psmtHistory = conn.prepareStatement(sqlUserHistory);
				Statement stmt = conn.createStatement();) {

			psmtHistory.setInt(1, userId);
			ResultSet result = stmt.executeQuery(sql);
			ResultSet rs = psmtHistory.executeQuery();

			while (rs.next()) {
				UserBasedHistoryDTO examHistory = new UserBasedHistoryDTO();
				examHistory.setExamId(rs.getInt("exam_id"));
				examHistory.setExamTopic(rs.getString("exam_topic"));

				examHistory.setExamName(rs.getString("exam_name"));
				examHistory.setDescription(rs.getString("description"));

				examHistory.setStatus(rs.getString("status"));
				examHistory.setDuration(rs.getInt("duration_minutes"));

				examHistory.setPassMarks(rs.getInt("pass_min_correct"));
				examHistory.setTotalMarks(rs.getInt("total_marks"));

				examHistory.setCreatedBy(rs.getInt("created_by"));
				examHistory.setDateTime(rs.getTimestamp("start_time"));
				//
				if (rs.getBoolean("passed")) {
					examHistory.setResult("Pass");
				} else {
					examHistory.setResult("Fail");
				}
				//

//					examHistory.setDurationTaken(rs.getDouble("start_time") - rs.getDouble("end_time"));
				examHistory.setYourMarks(rs.getInt("score"));

				examHistory.setUserId(userId);
//					System.out.println("examHistoryDao: "+examHistory);
				
				history.add(examHistory);
			}
			
			//this while for get all topics
			while (result.next()) {
				topics.add(result.getString("exam_topic"));
			}
			
//			System.out.println("examHistoryDao history object size: " + history.size());
//			System.out.println("examHistoryDao Topics object size: " + topics.size());
			request.setAttribute("history", history);
			request.setAttribute("topics", topics);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("history", history);
			return false;
		}

	}
	/*
	 * public static void main(String[] args) { List<ExamHistoryDTO> examHistory =
	 * ExamHistoryDAO.getExamsHistoryByUserId(4); System.out.println(examHistory); }
	 */
}
