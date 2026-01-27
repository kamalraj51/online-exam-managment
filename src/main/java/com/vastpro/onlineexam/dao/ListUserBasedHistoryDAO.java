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
import com.vastpro.onlineexam.dto.UsersDTO;

import jakarta.servlet.http.HttpServletRequest;

public class ListUserBasedHistoryDAO {
	public static boolean getAllUsers(HttpServletRequest request) {

		// =============================================================
		List<UserBasedHistoryDTO> history = new ArrayList<>();
		List<UsersDTO> userList = new ArrayList<>();
		String userIdString = (request.getParameter("userSelectedOption") != null)
				? (request.getParameter("userSelectedOption"))
				: "00";
		Integer userId = Integer.parseInt(userIdString);

		System.out.println("userbasedHistorydao userId called: "+userId);
		String sqlUserHistory = """
				SELECT e.exam_id, e.exam_topic, e.exam_name, e.description, e.duration_minutes, e.total_marks, e.pass_min_correct, e.created_by, e.status,
				a.start_time, a.correct_answers, a.incorrect_answers, a.unanswered,a.start_time, a.end_time, a.score, a.passed, a.user_id
				FROM exam e join exam_attempt a
				on e.exam_id = a.exam_id
				where a.user_id=?;
				     """;
		// sql for display username
		String sql = "SELECT name, user_id FROM users where role_id=2";

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

				examHistory.setStatus(rs.getString("status"));

				// actual data for history
				examHistory.setDateTime(rs.getTimestamp("start_time"));
				examHistory.setCorrect(rs.getString("correct_answers"));
				examHistory.setIncorrect(rs.getString("incorrect_answers"));
				examHistory.setUnanswered(rs.getString("unanswered"));
				//
				if (rs.getBoolean("passed")) {
					examHistory.setResult("Pass");
				} else {
					examHistory.setResult("Fail");
				}
				//

//				examHistory.setDurationTaken(rs.getDouble("start_time") - rs.getDouble("end_time"));
				examHistory.setYourMarks(rs.getInt("score"));

				examHistory.setUserId(userId);
//				System.out.println("examHistoryDao: "+examHistory);

				history.add(examHistory);
			}

			// this while for get all users
			while (result.next()) {
				userList.add(new UsersDTO(result.getString("name"), (result.getString("user_id")) + ""));
			}

			request.setAttribute("userBasedHistory", history);
			request.setAttribute("userList", userList);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("exception occured listuserbasedhistory");
			request.setAttribute("userBasedHistory", history);
			request.setAttribute("userList", userList);
			return false;
		}

	}

}
