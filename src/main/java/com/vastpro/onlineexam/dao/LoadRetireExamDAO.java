package com.vastpro.onlineexam.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vastpro.onlineexam.db.DBConnection;

import jakarta.servlet.http.HttpServletRequest;

public class LoadRetireExamDAO {
	public static List<String> loadAllRetiredExam() {
		List<String> retiredExam = new ArrayList<>();
		// sql for display topics

		String sqlRetire = "SELECT exam_name FROM exam WHERE status = 'RETIRED'";

		try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement();) {

			ResultSet retiredResult = stmt.executeQuery(sqlRetire);

			while (retiredResult.next()) {
				retiredExam.add(retiredResult.getString("exam_name"));
			}

			System.out.println("LoadRetireExamDAO retiredExam : " + retiredExam);

			return retiredExam;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retiredExam;

	}

}
