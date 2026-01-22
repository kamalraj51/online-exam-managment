package com.vastpro.onlineexam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.vastpro.onlineexam.db.DBConnection;
import com.vastpro.onlineexam.dto.ExamDTO;

public class ExamDAO {
	public static List<ExamDTO> getActiveExams() {

        List<ExamDTO> exams = new ArrayList<>();

        String sql = "SELECT exam_id, exam_name, description, duration_minutes, pass_min_correct "
                   + "FROM exam WHERE status = 'ACTIVE'";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
        	
            while (rs.next()) {
                ExamDTO exam = new ExamDTO();
                exam.setExamId(rs.getInt("exam_id"));
                exam.setExamName(rs.getString("exam_name"));
                
                exam.setDescription(rs.getString("description"));
                exam.setDuration(rs.getInt("duration_minutes"));
                exam.setPassMarks(rs.getInt("pass_min_correct"));
                exams.add(exam);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return exams;
    }

}
