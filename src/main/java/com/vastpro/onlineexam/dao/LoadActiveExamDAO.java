package com.vastpro.onlineexam.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vastpro.onlineexam.db.DBConnection;


/**
 * Class Name: LoadActiveExamDAO
 *
 * Description:
 * This DAO class provides methods to retrieve all active exams
 * from the database.
 *
 * It connects to the database using DBConnection and executes
 * SQL queries to fetch exam names where the status is 'ACTIVE'.
 */
public class LoadActiveExamDAO {

    /**
     * Retrieves the list of all active exam names from the database.
     *
     * @return a List of Strings containing the names of active exams;
     *         returns an empty list if no exams are active or in case of error.
     */
	public static List<String> loadAllActiveExam() {
		List<String> activeExam = new ArrayList<>();
		// sql for display topics

		

		try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement();) {

			String sqlActive = "SELECT exam_name FROM exam WHERE status = 'ACTIVE'";
			ResultSet activeResult = stmt.executeQuery(sqlActive);

			while (activeResult.next()) {
				activeExam.add(activeResult.getString("exam_name"));
			}

			System.out.println("LoadActiveExamDAO activeExam: " + activeExam);

			return activeExam;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return activeExam;

	}

}
