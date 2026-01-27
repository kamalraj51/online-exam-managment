package com.vastpro.onlineexam.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vastpro.onlineexam.db.DBConnection;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Class Name: LoadRetireExamDAO
 *
 * Description:
 * This DAO class provides methods to retrieve all retired exams
 * from the database.
 *
 * It connects to the database using DBConnection and executes
 * SQL queries to fetch exam names where the status is 'RETIRED'.
 */
public class LoadRetireExamDAO {
	
    /**
     * Retrieves the list of all retired exam names from the database.
     *
     * @return a List of Strings containing the names of retired exams;
     *         returns an empty list if no exams are retired or in case of error.
     */
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
