package com.vastpro.onlineexam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.vastpro.onlineexam.db.DBConnection;
import com.vastpro.onlineexam.dto.QuestionDTO;

public class ExamAttemptDAO {

    public int insertExamAttempt(int examId, int userId,
                                 int total, int correct, int incorrect,
                                 int unanswered, boolean passed,Timestamp startTime, Timestamp endTime) throws Exception {
   
        String sql = """
            INSERT INTO exam_attempt
            (exam_id, user_id, start_time, end_time,
             total_questions, correct_answers, incorrect_answers,
             unanswered, passed, score)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            RETURNING attempt_id
        """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, examId);
            ps.setInt(2, userId);
            ps.setTimestamp(3, startTime);
            ps.setTimestamp(4, endTime);
            ps.setInt(5, total);
            ps.setInt(6, correct);
            ps.setInt(7, incorrect);
            ps.setInt(8, unanswered);
            ps.setBoolean(9, passed);
            ps.setInt(10, correct);

            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
    }

    public void insertResponses(int attemptId,
                                List<QuestionDTO> questions,
                                Map<Integer, Integer> userAnswers) throws Exception {

        String sql = """
            INSERT INTO exam_response
            (attempt_id, question_id, selected_option_id, is_correct)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            for (QuestionDTO q : questions) {

                Integer selectedAnswerId =
                    (userAnswers != null) ? userAnswers.get(q.getQuestionId()) : null;

                boolean isCorrect = false;

                if (selectedAnswerId != null) {
                    isCorrect = q.getAnswers().stream()
                        .anyMatch(a -> a.getAnswerId() == selectedAnswerId && a.isCorrect());
                }

                ps.setInt(1, attemptId);
                ps.setInt(2, q.getQuestionId());

                if (selectedAnswerId == null)
                    ps.setNull(3, Types.INTEGER);
                else
                    ps.setInt(3, selectedAnswerId);

                ps.setBoolean(4, isCorrect);
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }
}
