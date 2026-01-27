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
/**
 * Class Name: ExamAttemptDAO
 *
 * Description:
 * This DAO class handles database operations related
 * to exam attempts and responses.
 */
public class ExamAttemptDAO {
	
	/**
     * Inserts a new exam attempt record into the database.
     *
     * @param examId the ID of the exam being attempted
     * @param userId the ID of the user attempting the exam
     * @param total total number of questions in the exam
     * @param correct number of correctly answered questions
     * @param incorrect number of incorrectly answered questions
     * @param unanswered number of unanswered questions
     * @param passed indicates whether the user passed the exam
     * @param startTime the timestamp when the exam started
     * @param endTime the timestamp when the exam ended
     * @return the generated attempt ID for the exam attempt
     * @throws Exception if a database error occurs
     */

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
    /**
     * Inserts responses for each question in an exam attempt.
     *
     * @param attemptId the unique ID of the exam attempt
     * @param questions the list of questions included in the exam
     * @param userAnswers a map containing question IDs and selected answer IDs
     * @return void
     * @throws Exception if a database error occurs
     */
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
