package com.vastpro.onlineexam.dao;

import java.sql.*;
import java.util.*;
import com.vastpro.onlineexam.db.DBConnection;
import com.vastpro.onlineexam.dto.Answer;
import com.vastpro.onlineexam.dto.Question;

public class StartExamDAO {

    public List<Question> getQuestionsByExamId(int examId) throws Exception {

        Map<Integer, Question> questionMap = new LinkedHashMap<>();

        String sql =
            "SELECT q.question_id, q.question_text, a.answer_id, a.option_text, a.is_correct " +
            "FROM question q " +
            "JOIN answers a ON q.question_id = a.question_id " +
            "WHERE q.exam_id = ? " +
            "ORDER BY q.question_id, a.answer_id";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, examId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int qId = rs.getInt("question_id");

                Question question = questionMap.get(qId);
                if (question == null) {
                    question = new Question();
                    question.setQuestionId(qId);
                    question.setQuestionText(rs.getString("question_text"));
                    question.setAnswers(new ArrayList<>());
                    questionMap.put(qId, question);
                }

                Answer answer = new Answer();
                answer.setAnswerId(rs.getInt("answer_id"));
                answer.setOptionText(rs.getString("option_text"));
                answer.setCorrect(rs.getBoolean("is_correct"));     
                System.out.println("startExamDAO is_correct:"+rs.getBoolean("is_correct") );
                question.getAnswers().add(answer);
            }
        }
        System.out.println(questionMap);
        return new ArrayList<>(questionMap.values());
    }
}
