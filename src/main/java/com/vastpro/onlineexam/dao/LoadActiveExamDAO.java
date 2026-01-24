package com.vastpro.onlineexam.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vastpro.onlineexam.db.DBConnection;

public class LoadActiveExamDAO {

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
