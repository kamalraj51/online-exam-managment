package com.vastpro.onlineexam.command;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vastpro.onlineexam.dao.StartExamDAO;
import com.vastpro.onlineexam.dto.QuestionDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
/**
 * Class Name: ShowQuestionCommand
 *
 * Description:
 * This class is responsible for displaying exam questions one by one.
 * It handles navigation (next, back, submit), saves user answers,
 * and manages exam timer functionality.
 *
 * It implements the Command interface.
 */
public class ShowQuestionCommand implements Command {
	 /**
     * Executes the command to show questions and handle navigation.
     *
     * @param req the HttpServletRequest object containing exam ID,
     *            navigation action, and selected answer
     * @param res the HttpServletResponse object
     * @return true if the question page should be displayed,
     *         false if redirected to result page or an error occurs
     */
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
                //added for timer
                
                
//                res.sendRedirect("controller?action=submitExam&examId=" + examId);
//            	req.setAttribute("action", "submitExam");
//                session.setAttribute("examId", examId);
            	RequestDispatcher rd=req.getRequestDispatcher("controller?action=show_result&examId=" + examId);
            
            	rd.forward(req, res);
                return false;
            }

            
            long remainingSeconds = getRemainingSeconds(session);

            if (remainingSeconds <= 0) {
                RequestDispatcher rd =
                    req.getRequestDispatcher("controller?action=show_result&examId=" + examId);
                rd.forward(req, res);
                return false;
            }

            req.setAttribute("remainingSeconds", remainingSeconds);

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
    /**
     * Calculates remaining time for the exam.
     *
     * @param session the HttpSession containing exam start time
     *                and total exam duration
     * @return remaining time in seconds
     */
    private long getRemainingSeconds(HttpSession session) {

        Timestamp startTs = (Timestamp) session.getAttribute("examStartTime");
        int totalSeconds = (int) session.getAttribute("examDurationSeconds");

        LocalDateTime startTime = startTs.toLocalDateTime();
        LocalDateTime now = LocalDateTime.now();

        long elapsed = Duration.between(startTime, now).getSeconds();
        return totalSeconds - elapsed;
    }
}

