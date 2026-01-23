package com.vastpro.onlineexam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.vastpro.onlineexam.db.DBConnection;
import com.vastpro.onlineexam.dto.ExamDTO;

import jakarta.servlet.http.HttpServletRequest;

public class ListExamDAO {
	public static boolean getActiveExams(HttpServletRequest request) {

        List<ExamDTO> exams = new ArrayList<>();

        String sql = "SELECT exam_id, exam_name, description, duration_minutes, pass_min_correct "
                   + "FROM exam WHERE status = 'ACTIVE' and  exam_topic=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
        		
             ) {
        		String topic = request.getParameter("userSelectedOption");
        		ps.setString(1, topic);
        		ResultSet rs = ps.executeQuery();
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
            request.setAttribute("examList", exams);
            return false;
        }
        request.setAttribute("examList", exams);
        return true;
    }

}
