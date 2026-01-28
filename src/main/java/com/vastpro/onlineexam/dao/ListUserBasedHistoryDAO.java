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
import com.vastpro.onlineexam.dto.UserDTO;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Class Name: ListUserBasedHistoryDAO
 *
 * Description: This DAO class provides methods to retrieve all users with
 * role_id=2 (students) and their corresponding exam history from the database.
 *
 * It fetches user information from the 'users' table and exam attempts from the
 * 'exam_attempt' table.
 */
public class ListUserBasedHistoryDAO {

	/**
	 * Retrieves all users with role_id=2 and the exam history of a specific user
	 * (based on userSelectedOption parameter from the request).
	 *
	 * @param request the HttpServletRequest object where the retrieved data will be
	 *                set as request attributes "userList" and "userBasedHistory"
	 * @return true if users and their exam histories are successfully retrieved,
	 *         false otherwise
	 */
	public static boolean getAllUsers(HttpServletRequest request) {

		// =============================================================
		List<UserBasedHistoryDTO> history = new ArrayList<>();
		List<UserDTO> userList = new ArrayList<>();
		String userIdString = (request.getParameter("userSelectedOption") != null)
				? (request.getParameter("userSelectedOption"))
				: "00";
		Integer userId = Integer.parseInt(userIdString);

		System.out.println("userbasedHistorydao userId called: " + userId);
		String getDateSql="""
						select 
						t
						""";
		String sqlUserHistory = """
				SELECT e.exam_id, e.exam_topic, e.exam_name, e.description, e.duration_minutes, e.total_marks, e.pass_min_correct, e.created_by, e.status,
				to_char(a.start_time,'DD-MM-YYYY') as start_date, to_char(a.start_time,'HH24:MI') as start_time, a.correct_answers, a.incorrect_answers, a.unanswered, a.score, a.passed, a.user_id
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

				examHistory.setExamName(rs.getString("exam_name"));
				examHistory.setDate(rs.getString("start_date"));
				examHistory.setTimeStamp(rs.getString("start_time"));
				examHistory.setCorrect(rs.getString("correct_answers"));
				examHistory.setIncorrect(rs.getString("incorrect_answers"));
				examHistory.setUnanswered(rs.getString("unanswered"));
				if (rs.getBoolean("passed")) {
					examHistory.setResult("Pass");
				} else {
					examHistory.setResult("Fail");
				}
				examHistory.setYourMarks(rs.getInt("score"));

				history.add(examHistory);
			}

			// this while for get all users
			while (result.next()) {
				UserDTO user = new UserDTO();
				user.setUserId(result.getInt("user_id"));
				user.setUsername(result.getString("name"));
				userList.add(user);
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
