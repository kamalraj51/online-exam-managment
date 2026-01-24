package com.vastpro.onlineexam.dao;


import java.sql.*;
import java.util.*;

import com.vastpro.onlineexam.db.DBConnection;
import com.vastpro.onlineexam.dto.ExamDTO;
import com.vastpro.onlineexam.dto.ExamResponseDTO;

public class ExamResultDAO {

    // Get Exam details
    public ExamDTO getExamById(int examId) throws Exception {
        String sql = "SELECT * FROM exam WHERE exam_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, examId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ExamDTO exam = new ExamDTO();
                exam.setExamId(rs.getInt("exam_id"));
                exam.setExamName(rs.getString("exam_name"));
                exam.setPassMarks(rs.getInt("pass_min_correct"));
                exam.setTotalMarks(rs.getInt("total_marks"));
                return exam;
            }
        }
        return null;
    }

    // Get all responses for a given attempt
    public static List<ExamResponseDTO> getResponsesByAttempt(int attemptId) throws Exception {
        List<ExamResponseDTO> responses = new ArrayList<>();
        String sql = "SELECT r.response_id, r.question_id, r.selected_option_id, r.is_correct, " +
                     "q.question_text, a.option_text as selected_option_text, ac.option_text as correct_option_text " +
                     "FROM exam_response r " +
                     "JOIN question q ON r.question_id = q.question_id " +
                     "LEFT JOIN answers a ON r.selected_option_id = a.answer_id " +
                     "JOIN answers ac ON ac.question_id = r.question_id AND ac.is_correct = true " +
                     "WHERE r.attempt_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, attemptId);
            System.out.println("ExamResultDAO attemptId: "+attemptId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ExamResponseDTO resp = new ExamResponseDTO();
                resp.setResponseId(rs.getInt("response_id"));
                resp.setQuestionId(rs.getInt("question_id"));
                resp.setSelectedOptionId(rs.getObject("selected_option_id") != null ? rs.getInt("selected_option_id") : null);
                resp.setCorrect(rs.getObject("is_correct") != null ? rs.getBoolean("is_correct") : false);
                resp.setQuestionText(rs.getString("question_text"));
                resp.setSelectedOptionText(rs.getString("selected_option_text"));
                resp.setCorrectOptionText(rs.getString("correct_option_text"));

                responses.add(resp);
            }
        }
        System.out.println("ExamResultDAO responses: "+responses);
        return responses;
    }

}
