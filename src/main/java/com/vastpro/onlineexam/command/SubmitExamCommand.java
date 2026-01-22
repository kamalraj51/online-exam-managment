package com.vastpro.onlineexam.command;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.vastpro.onlineexam.dao.ExamAttemptDAO;
import com.vastpro.onlineexam.dao.ExamResultDAO;
import com.vastpro.onlineexam.dao.StartExamDAO;
import com.vastpro.onlineexam.dto.ExamResponseDTO;
import com.vastpro.onlineexam.dto.QuestionDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SubmitExamCommand implements Command {

    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) {
    		System.out.println("SubmitExamCommand called");
        try {
            HttpSession session = req.getSession();

            int examId = (Integer)(session.getAttribute("examId"));    
            System.out.println("SubmitExamCommand: "+examId);
            int userId = (Integer) session.getAttribute("user_id");
            System.out.println("SubmitExamCommand: "+userId);
            List<QuestionDTO> questions =
                (List<QuestionDTO>) session.getAttribute("questions");

            Map<Integer, Integer> userAnswers =
                (Map<Integer, Integer>) session.getAttribute("userAnswers");

            int total = questions.size();
            int correct = 0;
            int incorrect = 0;
            int unanswered = 0;

            for (QuestionDTO q : questions) {
                Integer selectedAnswerId =
                        (userAnswers != null) ? userAnswers.get(q.getQuestionId()) : null;

                if (selectedAnswerId == null) {
                    unanswered++;
                } else {
                    boolean isCorrect = q.getAnswers().stream()
                        .anyMatch(a -> a.getAnswerId() == selectedAnswerId && a.isCorrect());

                    if (isCorrect) correct++;
                    else incorrect++;
                }
            }

            boolean passed = correct >= 3; 

           
            ExamAttemptDAO dao = new ExamAttemptDAO();
            int attemptId = dao.insertExamAttempt(
                    examId, userId, total, correct, incorrect, unanswered, passed
            );
            dao.insertResponses(attemptId, questions, userAnswers);
            	List<ExamResponseDTO> response= ExamResultDAO.getResponsesByAttempt(attemptId);
            	System.out.println("Submit Exam Command: Exam Response"+response);

      
            session.removeAttribute("questions");
            session.removeAttribute("userAnswers");
            session.removeAttribute("currentIndex");

           
            req.setAttribute("totalQuestions", total);
            req.setAttribute("correct", correct);
            req.setAttribute("incorrect", incorrect);
            req.setAttribute("unanswered", unanswered);
            req.setAttribute("passed", passed);
            req.setAttribute("score", correct);
            req.setAttribute("responses", response);
            System.out.println("SubmitExamCommand end:"+correct);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
