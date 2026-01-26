package com.vastpro.onlineexam.dao;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;
import com.vastpro.onlineexam.db.DBConnection;
import com.vastpro.onlineexam.dto.AnswerDTO;
import com.vastpro.onlineexam.dto.ExamDTO;
import com.vastpro.onlineexam.dto.QuestionDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class StartExamDAO {

    public List<QuestionDTO> getQuestionsByExamId(HttpServletRequest request) throws Exception {

        Map<Integer, QuestionDTO> questionMap = new LinkedHashMap<>();
        ExamDTO exam = new ExamDTO();
        
        HttpSession session = request.getSession();
        int examId = (Integer)session.getAttribute("examId");
        System.out.println("StartExamDAO examId: "+examId);
        
        String sql =
            "SELECT q.question_id, q.question_text, a.answer_id, a.option_text, a.is_correct " +
            "FROM question q " +
            "JOIN answers a ON q.question_id = a.question_id " +
            "WHERE q.exam_id = ? " +
            "ORDER BY q.question_id, a.answer_id";

        //kamal added sql for get min pass mark
        String sql_pass = """
        			 SELECT exam_id, exam_name, description, duration_minutes, pass_min_correct 
                  FROM exam WHERE exam_id=?
        		""";
        
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
        		PreparedStatement pstmt = con.prepareStatement(sql_pass)) {

            ps.setInt(1, examId);
            
            pstmt.setInt(1, examId);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int qId = rs.getInt("question_id");

                QuestionDTO question = questionMap.get(qId);
                if (question == null) {
                    question = new QuestionDTO();
                    question.setQuestionId(qId);
                    question.setQuestionText(rs.getString("question_text"));
                    question.setAnswers(new ArrayList<>());
                    questionMap.put(qId, question);
                }
               

                AnswerDTO answer = new AnswerDTO();
                answer.setAnswerId(rs.getInt("answer_id"));
                answer.setOptionText(rs.getString("option_text"));
                answer.setCorrect(rs.getBoolean("is_correct"));     
                System.out.println("startExamDAO is_correct:"+rs.getBoolean("is_correct") );
                question.getAnswers().add(answer);
            }
            
            ResultSet examRs = pstmt.executeQuery(); 
            
            //this while is for get exam detail
            while (examRs.next()) {
               System.out.println("startexamdao exam_id:"+examRs.getInt("exam_id"));
                exam.setExamId(examRs.getInt("exam_id"));
                exam.setExamName(examRs.getString("exam_name"));
                
                exam.setDescription(examRs.getString("description"));
                exam.setDuration(examRs.getInt("duration_minutes"));
                exam.setPassMarks(examRs.getInt("pass_min_correct"));
                
                
            }
            session.setAttribute("ExamObject", exam);
            //  INIT TIMER ONCE
            if (session.getAttribute("examStartTime") == null) {
                session.setAttribute("examStartTime",
                    Timestamp.valueOf(LocalDateTime.now()));
                session.setAttribute("examDurationSeconds",
                    exam.getDuration() * 60);
            }            
            //System.out.println("StartExamDAO start time(TimeStamp): "+startTs);
            //System.out.println("StartExamDAO start time(startTime): "+startTime);
            //System.out.println("StartExamDAO start time(now): "+now);
            
            
            //System.out.println("StartExamDAO exam Duration Seconds: "+session.getAttribute("examDurationSeconds"));
        }
        System.out.println("StartExamDao: question map"+questionMap);
        System.out.println("StartExamDao: exam: "+exam);
        return new ArrayList<>(questionMap.values());
    }
}
