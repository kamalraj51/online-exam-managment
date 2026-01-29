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
		String sql = "SELECT exam_id, exam_name, status FROM exam";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ExamDTO exam = new ExamDTO();
				exam.setExamId(rs.getInt("exam_id"));
				exam.setExamName(rs.getString("exam_name"));
				exam.setStatus(rs.getString("status"));
				allExams.add(exam);
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("examList", allExams);
			return false;
		}
		request.getSession().setAttribute("examList", allExams);
		return true;
	}

}
