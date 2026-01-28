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

/**
 * Class Name: ExamHistoryDAO
 *
 * Description:
 * This DAO class provides methods to retrieve the exam history of a user.
 *
 * It queries the database to fetch exam attempts, including exam details,
 * scores, pass/fail status, and active exam topics.
 */
public class ExamHistoryDAO {

    /**
     * Retrieves all exam history for the logged-in user and sets it
     * in the request attributes.
     *
     * @param request the HttpServletRequest object containing the user's session
     * @return true if exam history and topics are successfully retrieved,
     *         false otherwise
     */
	public static boolean getExamsHistoryByUserId(HttpServletRequest request) {
		List<UserBasedHistoryDTO> history = new ArrayList<>();
		List<String> topics = new ArrayList<>();
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("user_id");

//		int userId = id;

		System.out.println("exam history dao userId: " + userId);
		String sqlUserHistory = """
				SELECT e.exam_id, e.exam_name,
				to_char(a.start_time,'DD-MM-YYYY') as start_date, to_char(a.start_time,'HH24:MI') as start_time, a.correct_answers, a.incorrect_answers, a.unanswered, a.score, a.passed, a.user_id
				FROM exam e join exam_attempt a
				on e.exam_id = a.exam_id
				where a.user_id=?;
				     """;
		//sql for display topics
		String sql = "SELECT DISTINCT exam_topic FROM exam WHERE status = 'ACTIVE'";
		
		
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement psmtHistory = conn.prepareStatement(sqlUserHistory);
				Statement stmt = conn.createStatement();) {

			psmtHistory.setInt(1, userId);
			ResultSet result = stmt.executeQuery(sql);
			ResultSet rs = psmtHistory.executeQuery();

		
			while (rs.next()) {
				UserBasedHistoryDTO examHistory = new UserBasedHistoryDTO();

				examHistory.setExamName(rs.getString("exam_name"));
				examHistory.setDate(rs.getString("start_date"));
				examHistory.setTimeStamp(rs.getString("start_time"));
				examHistory.setYourMarks(rs.getInt("score"));
				examHistory.setCorrect(rs.getString("correct_answers"));
				examHistory.setIncorrect(rs.getString("incorrect_answers"));
				examHistory.setUnanswered(rs.getString("unanswered"));

				//
				if (rs.getBoolean("passed")) {
					examHistory.setResult("Pass");
				} else {
					examHistory.setResult("Fail");
				}	
				history.add(examHistory);
			}
			
			//this while for get all topics
			while (result.next()) {
				topics.add(result.getString("exam_topic"));
			}
			
			request.setAttribute("history", history);
			request.setAttribute("topics", topics);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("history", history);
			return false;
		}

	}

}
