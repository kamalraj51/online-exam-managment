package com.vastpro.onlineexam.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vastpro.onlineexam.dao.StartExamDAO;
import com.vastpro.onlineexam.dto.QuestionDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ShowQuestionCommand implements Command {

    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) {

        try {
            HttpSession session = req.getSession();
            
            
            int examId = Integer.parseInt(req.getParameter("examId"));
            session.setAttribute("examId", examId);
            
            System.out.println("ShowQuestionCommand examId: "+examId);
            String action = req.getParameter("nav"); // next | back | submit
            System.out.println("ShowQuestionCommand action: "+action);
            List<QuestionDTO> questions = (List<QuestionDTO>) session.getAttribute("questions");


            if (questions == null) {
                StartExamDAO dao = new StartExamDAO();
                questions = dao.getQuestionsByExamId(req);

                if (questions.isEmpty()) {
                    req.setAttribute("errorMessage", "No questions found for this exam!");
                    return false;
                }

                session.setAttribute("questions", questions);
                session.setAttribute("currentIndex", 0);
            }

            int currentIndex = (Integer) session.getAttribute("currentIndex");
            System.out.println("ShowQuestionCommand: currentIndex: "+currentIndex);
            
            String answerIdStr = req.getParameter("answerId");
            System.out.println("ShowQuestionCommand: answerIdStr: "+answerIdStr);
            QuestionDTO currentQuestion = questions.get(currentIndex);

            if (answerIdStr != null) {
                int answerId = Integer.parseInt(answerIdStr);

                Map<Integer, Integer> userAnswers =
                    (Map<Integer, Integer>) session.getAttribute("userAnswers");
                		System.out.println("ShowQuestionCommand: userAnswers: "+userAnswers);
                if (userAnswers == null) {
                    userAnswers = new HashMap<>();
                }

                userAnswers.put(currentQuestion.getQuestionId(), answerId);
                session.setAttribute("userAnswers", userAnswers);
                System.out.println("Show Question Command: answer"+userAnswers);
            }

            //end
            
            // navigation
            if ("next".equals(action)) {
                currentIndex = Math.min(currentIndex + 1, questions.size() - 1);
                System.out.println("ShowQuestionCommand currentIndex: "+currentIndex);
            } else if ("back".equals(action)) {
                currentIndex = Math.max(currentIndex - 1, 0);
            }else if ("submit".equals(action)) {
//            		session.removeAttribute("questions");
                session.removeAttribute("currentIndex");
//                res.sendRedirect("controller?action=submitExam&examId=" + examId);
//            	req.setAttribute("action", "submitExam");
//                session.setAttribute("examId", examId);
            	RequestDispatcher rd=req.getRequestDispatcher("controller?action=show_result&examId=" + examId);
            
            	rd.include(req, res);
                //return false;
            }

            /*else if ("submit".equals(action)) {
            	System.out.println("submit called");
                session.removeAttribute("questions");
                session.removeAttribute("currentIndex");
                req.setAttribute("message", "You have successfully completed the exam!");
                return false;
            }*/

            session.setAttribute("currentIndex", currentIndex);

            QuestionDTO question = questions.get(currentIndex);
            req.setAttribute("question", question);

            req.setAttribute("isFirst", currentIndex == 0);
            req.setAttribute("isLast", currentIndex == questions.size() - 1);
            req.setAttribute("currentQNo", currentIndex + 1);
            req.setAttribute("totalQuestions", questions.size());

            
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "Error: " + e.getMessage());
            return false;
        }
    }
}
